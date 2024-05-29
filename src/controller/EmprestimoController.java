package controller;

import DAO.EmprestimoDAO;

public class EmprestimoController {
	public static boolean fazerEmprestimo(String isbn, String matricula) {
		return EmprestimoDAO.fazerEmprestimo(isbn, matricula);
	}
	
	public static boolean devolverLivro(String isbn, String matricula) {
		return EmprestimoDAO.devolverLivro(isbn, matricula);
	}
	
}
