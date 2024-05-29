package controller;

import DAO.EmprestimoDAO;
import model.Emprestimo;

import java.util.List;

public class EmprestimoController {
	public static boolean fazerEmprestimo(String isbn, String matricula) {
		return EmprestimoDAO.fazerEmprestimo(isbn, matricula);
	}
	

	public static List<Emprestimo> buscarEmprestimosPorMatricula(String matricula) {
        return EmprestimoDAO.buscarEmprestimosPorMatricula(matricula);
    }

	public static boolean devolverLivro(String isbn, String matricula) {
		return EmprestimoDAO.devolverLivro(isbn, matricula);
	}
	
	public static boolean renovarEmprestimo(String isbn, String matricula) {
		return EmprestimoDAO.renovarEmprestimo(isbn, matricula);
	}
	
}
