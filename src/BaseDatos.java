import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
}
