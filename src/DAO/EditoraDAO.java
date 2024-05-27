package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Editora;

public class EditoraDAO {

	public static boolean cadastrarEditora(Editora editora) {
		ConnectionDB db = new ConnectionDB(); 
		Connection conn = db.getConnection();
		boolean worked = false;		
		
		try {
			PreparedStatement psInsert = conn.prepareStatement("INSERT INTO EDITORA VALUES(?,?,?,?)");
			psInsert.setString(1, editora.getNome());
			psInsert.setString(2, editora.getEndereco());
			psInsert.setString(3, editora.getTelefone());
			psInsert.setString(4, editora.getEmail());
			worked = psInsert.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		db.closeConnection();
		
		return worked;
		
	}
	
}
