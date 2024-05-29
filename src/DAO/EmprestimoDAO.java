package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

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
	
	public static boolean devolverLivro(String isbn, String matricula) {
	    boolean worked = false;
	    ConnectionDB db = new ConnectionDB(); 
	    Connection conn = db.getConnection();
	        
	    try {
	        String query = "UPDATE EMPRESTIMOS SET STATUS_EMPRESTIMO = 'DEVOLVIDO' WHERE ISBN = ? AND MATRICULA = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, isbn);
	        ps.setString(2, matricula);
	            
	        worked = ps.executeUpdate() > 0;
	            
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	        
	    return worked;
	}



	public static boolean renovarEmprestimo(String isbn, String matricula) {
	    boolean worked = false;
	    ConnectionDB db = new ConnectionDB(); 
	    Connection conn = db.getConnection();
	        
	    try {
	        String querySelect = "SELECT DATA_DEVOLUCAO_ESTIMADA FROM EMPRESTIMOS WHERE ISBN = ? AND MATRICULA = ?";
	        PreparedStatement psSelect = conn.prepareStatement(querySelect);
	        psSelect.setString(1, isbn);
	        psSelect.setString(2, matricula);
	        ResultSet rs = psSelect.executeQuery();
	        
	        if (rs.next()) {
	            Timestamp dataEstimada = rs.getTimestamp("DATA_DEVOLUCAO_ESTIMADA");
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTimeInMillis(dataEstimada.getTime());
	            calendar.add(Calendar.DAY_OF_MONTH, 7);
	            
	            String queryUpdate = "UPDATE EMPRESTIMOS SET DATA_DEVOLUCAO_ESTIMADA = ? WHERE ISBN = ? AND MATRICULA = ?";
	            PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
	            psUpdate.setTimestamp(1, new Timestamp(calendar.getTimeInMillis()));
	            psUpdate.setString(2, isbn);
	            psUpdate.setString(3, matricula);
	            
	            worked = psUpdate.executeUpdate() > 0;
	        }
	            
	    } catch(SQLException e) {
	        e.printStackTrace();
	    }
	        
	    return worked;
	}

	
}
