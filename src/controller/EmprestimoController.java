package controller;

import DAO.EmprestimoDAO;

public class EmprestimoController {
	public static boolean fazerEmprestimo(String isbn, String matricula) {
		return EmprestimoDAO.fazerEmprestimo(isbn, matricula);
	}
}
