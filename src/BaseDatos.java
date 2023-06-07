import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BaseDatos {
	
	String url = "jdbc:mysql://localhost/";
	String bd = "proyecto-gym";
	Connection conn = null;	
	PreparedStatement ps = null;
	ResultSet rs;
	Statement s;
	
	public BaseDatos() throws SQLException {
		conn = DriverManager.getConnection(url + bd, "root","72914630");
		s = (Statement) conn.createStatement();
	}
	
	public ArrayList obtenerNombresClientes() throws SQLException {//REGRESA LOS TODOS LOS NOMBRES EN UNA LISTA
		ResultSet rs = s.executeQuery("SELECT * FROM clientes");
		ArrayList<String> nombres = new ArrayList<>();

		while (rs.next()) {
			System.out.println(rs.getString("nombre_cli"));
			nombres.add(rs.getString("nombre_cli"));
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
	
	public DefaultTableModel buscar(int id) throws SQLException {
		String[]columnas = {"Mes","Asistencia","Clases","Monto"};
		DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		String[] datosNew = new String[4];
		
		ResultSet rs = s.executeQuery("SELECT * FROM clases RIGHT JOIN clientes ON clientes_id_cla = id_cliente WHERE id_cliente = "+id+";");
		rs.next();
		datosNew[0] = rs.getString("fecha_inscrito_cli");
		datosNew[1] = Integer.toString(rs.getInt("asistencia_cli"));
		datosNew[2] = rs.getString("nombre_cla");
		if(rs.getString("nombre_cla") != null) {
			rs = s.executeQuery("SELECT * FROM tarifas WHERE clase_tr = '"+rs.getString("nombre_cla")+"';");
			rs.next();
			datosNew[3] = Integer.toString(rs.getInt("costo_tr"));
		}else {
			datosNew[3] = "600";
		}
		
		dtm.addRow(datosNew);
		
		conn.close();
		
		return dtm;
	}
	
}
