package controller;

import java.util.List;

import DAO.LivroDAO;
import model.Editora;
import model.Livro;

public class LivroController {
	public static boolean cadastrarLivro(String nome, String autor, String genero, String isbn, int edicao, Editora editora) {
		return LivroDAO.cadastrarLivro(new Livro(nome, editora, autor, edicao, genero, isbn));
	}
	
	public static List<Livro> consultarLivros(String titulo, String autor, String genero, String isbn) {
        return LivroDAO.consultarLivros( titulo, autor, genero, isbn);
    }
}
