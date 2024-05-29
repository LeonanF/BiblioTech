package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmprestimoDAO {
	public static boolean fazerEmprestimo(String isbn, String matricula) {
		ConnectionDB db = new ConnectionDB(); 
		Connection conn = db.getConnection();
		boolean worked = false;
		
		try {
			String query = "INSERT INTO EMPRESTIMOS(ISBN, MATRICULA) VALUES(?, ?)";
			PreparedStatement psInsert = conn.prepareStatement(query);
			
			psInsert.setString(1, isbn);
			psInsert.setString(2, matricula);
			
			worked = psInsert.executeUpdate()>0;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return worked;
	}
}
