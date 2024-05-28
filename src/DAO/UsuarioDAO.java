package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.UsuarioDTO;

public class UsuarioDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public boolean cadastrarUsuario(UsuarioDTO objusuariodto) {
		String sql = "insert into usuario (nome_usuario, email_usuario, senha_usuario, curso_usuario, matricula_usuario) values (?, ?, ?, ?, ?)";
		
		conn = new ConnectionDB().getConnection();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getNome_usuario());
			pstm.setString(2, objusuariodto.getEmail_usuario());
			pstm.setString(3, objusuariodto.getSenha_usuario());
			pstm.setString(4, objusuariodto.getCurso_usuario());
			pstm.setInt(5, objusuariodto.getMatricula_usuario());
			
			
			pstm.execute();
			pstm.close();
			
			return true;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Erro no UsuarioDAO" + erro);
			
			return false;
		}
	}
	
	
	public ResultSet autenticacaoAluno(UsuarioDTO objusuariodto) {
		conn = new ConnectionDB().getConnection();
		
		try {
			String sql = "select * from usuario where email_usuario = ? and senha_usuario = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getEmail_usuario());
			pstm.setString(2, objusuariodto.getSenha_usuario());
			
			ResultSet rs = pstm.executeQuery();
			
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "erro no UsuarioDAO: "+ erro);
			
			return null;
		}
	}
	
	
	public ResultSet autenticacaoBibliotecario(UsuarioDTO objusuariodto) {
		conn = new ConnectionDB().getConnection();
		
		try {
			String sql = "select * from usuariobibliotecario where usuario_bibliotecario = ? and senha_bibliotecario = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getUsuario_bibliotecario());
			pstm.setString(2, objusuariodto.getSenha_bibliotecario());
			
			ResultSet rs = pstm.executeQuery();
			
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "erro no UsuarioDAO: "+ erro);
			
			return null;
		}
	}
}
