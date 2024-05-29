package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Emprestimo;

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
	
	
	public static List<Emprestimo> buscarEmprestimosPorMatricula(String matricula) {
        List<Emprestimo> emprestimos = new ArrayList<>();
        ConnectionDB db = new ConnectionDB();
        Connection conn = db.getConnection();
        
        try {
            String query = "SELECT * FROM EMPRESTIMOS WHERE MATRICULA = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, matricula);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo(
                    rs.getInt("id"),
                    rs.getString("isbn"),
                    rs.getString("matricula"),
                    rs.getDate("data_emprestimo"),
                    rs.getDate("data_devolucao_estimada"),
                    rs.getString("status_emprestimo")
                );
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        
        return emprestimos;
    }
}
