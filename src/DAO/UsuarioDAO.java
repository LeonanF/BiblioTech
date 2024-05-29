package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
	
	
	public static boolean cadastrarUsuario(Usuario usuario) {
		Connection conn;
		ConnectionDB db = new ConnectionDB();
		PreparedStatement pstm;
		
		boolean worked = false;
		
		String sql = "insert into usuario (nome_usuario, email_usuario, senha_usuario, curso_usuario, matricula_usuario) values (?, ?, ?, ?, ?)";
		
		conn = db.getConnection();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome_usuario());
			pstm.setString(2, usuario.getEmail_usuario());
			pstm.setString(3, usuario.getSenha_usuario());
			pstm.setString(4, usuario.getCurso_usuario());
			pstm.setInt(5, usuario.getMatricula_usuario());
			
			
			worked = pstm.executeUpdate()>0;
			pstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		db.closeConnection();
		
		return worked;
		
	}
	
	
	public static ResultSet autenticacaoAluno(String email, String senha) {
		Connection conn;
		ConnectionDB db = new ConnectionDB();
		conn = db.getConnection();
		ResultSet rs = null;

		try {
			String sql = "select * from usuario where email_usuario = ? and senha_usuario = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, senha);
			
			rs = pstm.executeQuery();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	public static ResultSet autenticacaoBibliotecario(String login, String senha) {
		Connection conn;
		ConnectionDB db = new ConnectionDB();
		conn = db.getConnection();
		ResultSet rs = null;
		
		try {
			String sql = "select * from usuariobibliotecario where usuario_bibliotecario = ? and senha_bibliotecario = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, senha);
			
			rs = pstm.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public static boolean buscarUsuario() {
		return true;
	}	
}