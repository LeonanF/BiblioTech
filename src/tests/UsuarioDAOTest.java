package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Usuario;
import DAO.ConnectionDB;
import DAO.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

class UsuarioDAOTest {
	@BeforeAll 
	static void criarUsuarioTeste() {
        Usuario usuarioTeste = new Usuario(12345, "Leonan Largo", "amojava123", "leonanflash@gmail.com", "BES");
        UsuarioDAO.cadastrarUsuario(usuarioTeste);
    }
	
	@Test
	void TestaCadastrarUsuario() {
		Usuario usuarioTesteCadastro = new Usuario(12346, "João Beleza", "entendi123", "joaodeicoaraci@hotmail.com", "BES");
		
		Assertions.assertEquals(UsuarioDAO.cadastrarUsuario(usuarioTesteCadastro), true);
	}
	
	@Test
	void TestaAutenticacaoAluno() {
		Connection conn;
		ConnectionDB db = new ConnectionDB();
		conn = db.getConnection();
		
		try {
			PreparedStatement psAuth;
			
			psAuth = conn.prepareStatement("SELECT * FROM usuario WHERE email_usuario = ? AND senha_usuario = ?");
			psAuth.setString(1, "leonanflash@gmail.com");
	        psAuth.setString(2, "amojava123");
	        ResultSet result = psAuth.executeQuery();

	        String email = null;
	        String senha = null;
	        
	        if(result.next()) {
	        	email = result.getString("email_usuario");
	        	senha = result.getString("senha_usuario");
	        }
	        
	        ResultSet rs = null;
	        
	        if ("leonanflash@gmail.com".equals(email) && "amojava123".equals(senha)) {
                rs = UsuarioDAO.autenticacaoAluno(email, senha);
            } 
		
			assertNotNull(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
