package controller;

import DAO.LivroDAO;
import model.Editora;
import model.Livro;

public class LivroController {
	public static boolean cadastrarLivro(String nome, String autor, String genero, String isbn, int edicao, Editora editora) {
		return LivroDAO.cadastrarLivro(new Livro(nome, editora, autor, edicao, genero, isbn));
	}
}
