package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Livro;

public class LivroDAO {
	public static boolean cadastrarLivro(Livro livro) {
		ConnectionDB db = new ConnectionDB(); 
		Connection conn = db.getConnection();
		boolean worked = false;		
		
		try {
			PreparedStatement psInsert = conn.prepareStatement("INSERT INTO LIVROS VALUES(?,?,?,?,?,?)");
			psInsert.setString(1, livro.getNome());
			psInsert.setString(2, livro.getAutor());
			psInsert.setString(3, livro.getGenero());
			psInsert.setString(4, livro.getISBN());
			psInsert.setInt(5, livro.getEdicao());
			psInsert.setString(6, livro.getEditora().getNome());
			worked = psInsert.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		db.closeConnection();
		
		return worked;
		
	}
}
