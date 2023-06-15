import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BaseDatos {
	
	static String url = "jdbc:mysql://localhost/";
	static String bd = "proyecto-gym";
	Connection conn = null;	
	PreparedStatement ps = null;
	ResultSet rs;
	Statement s;
	
	public BaseDatos() throws SQLException {
		conn = DriverManager.getConnection(url + bd, "root","72914630");
		s = (Statement) conn.createStatement();
	}
	
	public void cerrarCONEXION() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Problemas al cerrar la conexion con la Base de Datos: "+e.getMessage());
		}
	}
	
	public ArrayList obtenerNombresClientes() throws SQLException {//REGRESA LOS TODOS LOS NOMBRES EN UNA LISTA
		ResultSet rs = s.executeQuery("SELECT * FROM clientes");
		ArrayList<String> nombres = new ArrayList<>();

		while (rs.next()) {
			//System.out.println(rs.getString("nombre_cli"));
			nombres.add(Integer.toString(rs.getInt("id_cliente"))+" "+rs.getString("nombre_cli"));
		}
		conn.close();
		return nombres;
	}
	
	public ArrayList obtenerNombresTarifas() throws SQLException {//REGRESA LOS TODOS LOS NOMBRES EN UNA LISTA
		ResultSet rs = s.executeQuery("SELECT * FROM tarifas");
		ArrayList<String> nombres = new ArrayList<>();

		while (rs.next()) {
			//System.out.println(rs.getString("nombre_cli"));
			nombres.add("Tarifa " + Integer.toString(rs.getInt("id_tarifa")) + " : " + rs.getString("plan_tr"));
		}
		//conn.close();
		return nombres;
	}
	
	public ArrayList obtenerNombresinstructor() throws SQLException {//REGRESA LOS TODOS LOS NOMBRES EN UNA LISTA
		ResultSet rs = s.executeQuery("SELECT * FROM instructor");
		ArrayList<String> nombres = new ArrayList<>();

		while (rs.next()) {
			//System.out.println(rs.getString("nombre_cli"));
			nombres.add(Integer.toString(rs.getInt("id_instructor"))+" "+rs.getString("nombre_in"));
		}
		conn.close();
		return nombres;
	}
	
	public boolean buscarNombreCliente(String nombre) throws SQLException {
		ResultSet rs = s.executeQuery("SELECT * FROM clientes");
		boolean encontrado = false;
		
		while (rs.next()) {
			
			if (nombre.equals(rs.getString("nombre_cli"))) {
				encontrado = true;
			}
			
		}
		conn.close();
		
		return encontrado;
	}
	
	public boolean buscarIdCliente(int id) throws SQLException {
		ResultSet rs = s.executeQuery("SELECT * FROM clientes");
		boolean encontrado = false;
		
		while (rs.next()) {
			
			if (id == rs.getInt("id_cliente")) {
				encontrado = true;
			}
			
		}
		conn.close();
		
		return encontrado;
	}
	
	public boolean buscarNombreClienteIdCliente(String nombre,int id) throws SQLException {
		ResultSet rs = s.executeQuery("SELECT * FROM clientes");
		boolean encontrado = false;
		
		while (rs.next()) {
			
			if (id == rs.getInt("id_cliente")) {
				if (nombre.equals(rs.getString("nombre_cli"))) {
					encontrado = true;
				}
			}
			
		}
		conn.close();
		
		return encontrado;
	}
	
	public DefaultTableModel buscarClientes(int id) throws SQLException {
		String[]columnas = {"Fecha","Asistencia","Plan","Monto"};
		DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		String[] datosNew = new String[4];
		
		ResultSet rs = s.executeQuery("SELECT * FROM historial_clientes WHERE id_cliente_h = "+id+";");
		
		while(rs.next()) {
			
			datosNew[0] = rs.getString("mes_h");
			datosNew[1] = Integer.toString(rs.getInt("asistencia_h"));
			datosNew[2] = rs.getString("tarifa_h");
			datosNew[3] = Integer.toString(rs.getInt("monto_h"));
			dtm.addRow(datosNew);
		}
		
		conn.close();
		
		return dtm;
	}
	
	public DefaultTableModel buscarIns(int id) throws SQLException {
		String[]columnas = {"Nombre","Correo","Monto"};
		DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		String[] datosNew = new String[4];
		
		ResultSet rs = s.executeQuery("SELECT * FROM clases RIGHT JOIN instructor ON instructor_designado_cla = id_instructor WHERE id_instructor = "+id+";");
		rs.next();
		datosNew[0] = rs.getString("nombre_in");
		datosNew[1] = rs.getString("correo_in");
		if(rs.getString("nombre_cla") != null) {
			rs = s.executeQuery("SELECT * FROM tarifas WHERE clase_tr = '"+rs.getString("nombre_cla")+"';");
			rs.next();
			datosNew[2] = Integer.toString(rs.getInt("costo_tr"));
		}else {
			datosNew[2] = "600";
		}
		
		dtm.addRow(datosNew);
		
		conn.close();
		
		return dtm;
	}
	
	public DefaultTableModel buscarTarifa() throws SQLException {
		String[]columnas = {"Plan","Monto"};
		DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		String[] datosNew = new String[2];
		
		ResultSet rs = s.executeQuery("SELECT * FROM tarifas;");
		
		while(rs.next()) {
			datosNew[0] = rs.getString("plan_tr");
			datosNew[1] = rs.getString("costo_tr");
			dtm.addRow(datosNew);
		}
		return dtm;
	}
	
	public void crearNuevoCliente(String nombre,String apellidoMat,String apellidoPat,String correo,String telefono,String telefonoEmer,String fecha,int asistencia,int edad,String fotoN) throws SQLException {
		try {
			String insertarDatos = "INSERT INTO clientes (nombre_cli, apellidos_cli, correo_cli, telefono_cli, telefono_eme_cli, fecha_inscrito_cli, asistencia_cli, edad_cli) VALUES \r\n"
					+ "(?,?,?,?,?,?,?,?);" ;
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.setString(1, nombre);
			ps.setString(2, apellidoPat);
			ps.setString(3, correo);
			ps.setString(4, telefono);
			ps.setString(5, telefonoEmer);
			ps.setString(6, fecha);
			ps.setInt(7, asistencia);
			ps.setInt(8, edad);
			
			ps.executeUpdate();
			System.out.println("Se subieron los registros");
			
		} catch (SQLException e) {
			System.err.println("Error BD: "+e.getMessage());
		}finally {
			conn.close();
		}
	}
	
	public void crearNuevaTarifa(String duracion, String costo_tr) throws SQLException {
		try {
			String insertarDatos = "INSERT INTO tarifas (plan_tr, costo_tr) VALUES \r\n"
					+ "(?,?);" ;
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.setString(1, duracion);
			ps.setString(2, costo_tr);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error BD: "+e.getMessage());
		}finally {
			conn.close();
		}
	}
	
	public void crearNuevoInstructor(String nombre,String apellido,String correo,String telefono,String telefonoEmer,int sueldo,String fecha,int asistencia,int edad,String fotoN) throws SQLException {
		try {
			String insertarDatos = "INSERT INTO instructor (nombre_in, apellido_in, edad_in, correo_in , telefono_in , telefono_eme_in, sueldo_in) VALUES \r\n"
					+ "(?,?,?,?,?,?,?);" ;
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setInt(3, edad);
			ps.setString(4, correo);
			ps.setString(5, telefono);
			ps.setString(6, telefonoEmer);
			ps.setInt(7, sueldo);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error BD: "+e.getMessage());
		}finally {
			conn.close();
		}
	}
	
    public String[] obtenerTodoDelCliente(int id) {
    	String[] datosCli = new String[8];
    	
    	try {
			ResultSet rs = s.executeQuery("SELECT * FROM clientes WHERE id_cliente = "+Integer.toString(id)+";");
			rs.next();
			
			datosCli[0] = rs.getString("nombre_cli");
			datosCli[1] = rs.getString("apellidos_cli");
			datosCli[2] = rs.getString("correo_cli");
			datosCli[3] = rs.getString("telefono_cli");
			datosCli[4] = rs.getString("telefono_eme_cli");
			datosCli[5] = rs.getString("fecha_inscrito_cli");
			datosCli[6] = Integer.toString(rs.getInt("asistencia_cli"));
			datosCli[7] = Integer.toString(rs.getInt("edad_cli"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return datosCli;
    }
    
    public String[] obtenerTodoDeLaTarifa(int id) {
    	String[] datosTarifa = new String[3];
    	
    	try {
			ResultSet rs = s.executeQuery("SELECT * FROM tarifas WHERE id_tarifa = "+Integer.toString(id)+";");
			rs.next();
			
			datosTarifa[0] = rs.getString("plan_tr");
			datosTarifa[1] = rs.getString("costo_tr");
			datosTarifa[2] = rs.getString("id_tarifa");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return datosTarifa;
    }
    
    public String[] obtenerTodoDelinstructor(int id) {
    	String[] datosInstructor = new String[8];
    	
    	try {
			ResultSet rs = s.executeQuery("SELECT * FROM instructor WHERE id_instructor = "+Integer.toString(id)+";");
			rs.next();
			
			datosInstructor[0] = rs.getString("nombre_in");
			datosInstructor[1] = rs.getString("apellido_in");
			datosInstructor[2] = Integer.toString(rs.getInt("edad_in"));
			datosInstructor[3] = rs.getString("correo_in");
			datosInstructor[4] = rs.getString("telefono_in");
			datosInstructor[5] = rs.getString("telefono_eme_in");
			datosInstructor[6] = rs.getString("sueldo_in");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return datosInstructor;
    }
    
    public void actualizarCliente(int id,String nombre,String apellidos,String correo,String telefono,String telefonoEmer,String edad,String fotoN) throws SQLException {
		try {
			String insertarDatos = "UPDATE clientes SET nombre_cli = ?, apellidos_cli = ?, correo_cli = ?, telefono_cli = ?, telefono_eme_cli = ?, edad_cli = ? WHERE id_cliente = "+id;
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, correo);
			ps.setString(4, telefono);
			ps.setString(5, telefonoEmer);
			ps.setString(6, edad);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error BD en la funcion actualizarCliente: "+e.getMessage());
		}
		conn.close();
	}
    
    public void actualizarTarifa(int id,String duracion, String costo_tr) throws SQLException {
		try {
			String insertarDatos = "UPDATE tarifas SET plan_tr = ?, costo_tr = ? WHERE id_tarifa = "+id;
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.setString(1, duracion);
			ps.setString(2, costo_tr);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error BD en la funcion actualizarCliente: "+e.getMessage());
		}
		conn.close();
	}
    
    public void actualizarInstructor(int id,String nombre,String apellidos,String edad,String correo,String telefono,String telefonoEmer,String fotoN) throws SQLException {
		try {
			String insertarDatos = "UPDATE instructor SET nombre_in = ?, apellido_in = ?,edad_in = ?, correo_in = ?, telefono_in = ?, telefono_eme_in = ? WHERE id_instructor = "+id;
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, edad);
			ps.setString(4, correo);
			ps.setString(5, telefono);
			ps.setString(6, telefonoEmer);
			
			ps.executeUpdate();
			System.out.println("Se subieron los registros");
			
		} catch (SQLException e) {
			System.err.println("Error BD en la funcion actualizarinstructor: "+e.getMessage());
		}
		conn.close();
	}
    
    public void eliminarCliente(int id) {
    	
		try {
			String insertarDatos = "DELETE FROM clientes WHERE id_cliente = "+id+";";
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error BaseDatos en la funcion EliminarCliente: "+e.getMessage());
		}
    }
    public void eliminarTarifa(int id) {
    	
		try {
			String insertarDatos = "DELETE FROM tarifas WHERE id_tarifa = "+id+";";
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			ps.executeUpdate();
			//conn.close();
		} catch (SQLException e) {
			System.err.println("Error BaseDatos en la funcion EliminarCliente: "+e.getMessage());
		}
    }
    
    public void eliminarInstructor(int id) {
    	
		try {
			String insertarDatos = "DELETE FROM instructor WHERE id_instructor = "+id+";";
			ps = (PreparedStatement) conn.prepareStatement(insertarDatos);
			
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Error BaseDatos en la funcion EliminarCliente: "+e.getMessage());
		}
    }
    
    public ArrayList obtenerNombreClases() throws SQLException {//REGRESA LOS TODOS LOS NOMBRES EN UNA LISTA
		ResultSet rs = s.executeQuery("SELECT * FROM clases");
		ArrayList<String> nombres = new ArrayList<>();

		while (rs.next()) {
			nombres.add(rs.getString("nombre_cla"));
		}
		conn.close();
		return nombres;
	}
    
    public String regresarInstructorDeLaClase(String nombre_clase) {    	
		String nombre = "NO ENCONTRO NINGUN NOMBRE";
		try {
			ResultSet rs = s.executeQuery("SELECT * FROM clases WHERE nombre_cla = '"+nombre_clase+"';");
			rs.next();
			nombre = rs.getString("instructor_designado_cla");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nombre;
    }
    
    public DefaultTableModel buscarClasesDatos(String nombre_clase) throws SQLException {
		String[]columnas = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		String[] datosNew = new String[7];
		
		ResultSet rs = s.executeQuery("SELECT * FROM clases WHERE nombre_cla = '"+nombre_clase+"';");
		rs.next();
		
		String diasSemana = rs.getString("dias_cla");
		String[] diasDondeHayClases = diasSemana.split(",");
		
		for (int i=0;i<diasDondeHayClases.length;i++) {
			
			for (int j=0;j<columnas.length;j++) {
				if (diasDondeHayClases[i].equals(columnas[j])) {
					datosNew[j] = rs.getString("horario_cla");
				}
			}
			
		}
		
		for (int i=0;i<datosNew.length;i++) {
			if (datosNew[i] == null) {
				datosNew[i] = "---";
			}
		}
		
		dtm.addRow(datosNew);
		
		return dtm;
	}
    
    public DefaultTableModel buscarClasesClientes(String nombre_clase) throws SQLException {
		String[]columnas = {"ID","Nombre"};
		DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		String[] datosNew = new String[2];
		
		ResultSet rs = s.executeQuery("SELECT * FROM inscripciones_a_clases WHERE clase = '"+nombre_clase+"';");
		
		while (rs.next()) {
			
			datosNew[0] = Integer.toString(rs.getInt("id_cliente_inscrito"));
			datosNew[1] = rs.getString("nombre_cliente_inscrito");
			
			dtm.addRow(datosNew);
		}
		
		
		conn.close();
		
		return dtm;
	}
	
}
