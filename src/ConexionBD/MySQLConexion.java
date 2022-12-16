package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	
	public static Connection getConexion() {
		
		Connection conexion  =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/bd_loginusuario?characterEncoding=utf8";
			String usuario = "root";
			String contraseña = "root";
			
			
			conexion = DriverManager.getConnection(url, usuario, contraseña);
			
			System.out.print("conexion ok");
			
		} catch (ClassNotFoundException e) {
			System.out.print("Erro al cargar el controlador");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.print("error en la conexion  ");
			e.printStackTrace();
		}
		
		
		return conexion;
	}

}
