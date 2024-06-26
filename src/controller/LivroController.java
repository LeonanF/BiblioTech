package controller;

import java.util.List;

import DAO.LivroDAO;
import model.Editora;
import model.Livro;

public class LivroController {
	public static boolean cadastrarLivro(String nome, String autor, String genero, String isbn, int edicao, Editora editora) {
		return LivroDAO.cadastrarLivro(new Livro(nome, editora, autor, edicao, genero, isbn,"", 0));
	}
	
	public static List<Livro> consultarLivros(String titulo, String autor, String genero, String isbn) {
        return LivroDAO.consultarLivros( titulo, autor, genero, isbn);
    }
	

	 public static Livro buscarLivroPorISBN(String isbn) {
	        return LivroDAO.buscarLivroPorISBN(isbn);
	    }
	
	 public static boolean atualizarLivro(String isbnOriginal, Livro livroAtualizado) {
	        return LivroDAO.atualizarLivro(isbnOriginal, livroAtualizado);
	    }

	public static boolean reservarLivro(String isbn, String matricula) {
		return LivroDAO.reservarLivro(isbn, matricula);
	}
	

}
