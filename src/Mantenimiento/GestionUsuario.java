package Mantenimiento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import ConexionBD.MySQLConexion;
import bean.Usuario;

public class GestionUsuario {

	public Usuario obtenerUsuario(Usuario u) {

		Usuario usuario = null;
		Connection con = null;
		PreparedStatement pst =null;
		ResultSet rs = null;

		try {
			
			
			con = MySQLConexion.getConexion();
			String sql = "select* from lg_usuario where usuario =? and clave =?";
			
			pst =  con.prepareStatement(sql);
			pst.setString(1, u.getUsuario());
			pst.setString(2, u.getClave());
			

			rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println(" error al obtener usuario");
		}
		return usuario;
	}

}
