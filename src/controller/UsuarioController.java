package controller;

import java.sql.ResultSet;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	public static boolean cadastrarUsuario(Usuario usuario) {
		return UsuarioDAO.cadastrarUsuario(usuario);
	}
	
	public static ResultSet autenticacaoAluno(String login, String senha) {
		return UsuarioDAO.autenticacaoAluno(login, senha);
	}
	
	public static ResultSet autenticacaoBibliotecario(String login, String senha) {
		return UsuarioDAO.autenticacaoBibliotecario(login, senha);
	}
	
}
