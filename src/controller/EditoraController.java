package controller;

import DAO.EditoraDAO;
import model.Editora;

public class EditoraController {
	public static boolean cadastrarEditora(String nome, String endereco, String telefone, String email) {
		return EditoraDAO.cadastrarEditora(new Editora(nome, endereco, telefone.replaceAll("[^0-9]", ""), email));
	}
}
