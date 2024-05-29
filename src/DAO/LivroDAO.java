package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Editora;
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
	
	public static List<Livro> consultarLivros(String titulo, String autor, String genero, String isbn) {
        List<Livro> livros = new ArrayList<>();
        ConnectionDB db = new ConnectionDB(); 
        Connection conn = db.getConnection();
        
        try {
            String query = "SELECT * FROM LIVROS WHERE (nome LIKE ? OR ? IS NULL) AND (autor LIKE ? OR ? IS NULL) AND (genero LIKE ? OR ? IS NULL) AND (isbn LIKE ? OR ? IS NULL)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, titulo != null ? "%" + titulo + "%" : null);
            ps.setString(2, titulo);
            ps.setString(3, autor != null ? "%" + autor + "%" : null);
            ps.setString(4, autor);
            ps.setString(5, genero != null ? "%" + genero + "%" : null);
            ps.setString(6, genero);
            ps.setString(7, isbn != null ? "%" + isbn + "%" : null);
            ps.setString(8, isbn);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String nomeEditora = rs.getString("editora");
                Editora editora = EditoraDAO.buscarEditora(nomeEditora);
                
                if (editora != null) {
                    Livro livro = new Livro(
                        rs.getString("nome"), 
                        editora, 
                        rs.getString("autor"), 
                        rs.getInt("edicao"), 
                        rs.getString("genero"), 
                        rs.getString("isbn")
                    );
                    livros.add(livro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        db.closeConnection();
        return livros;
    }
	
	public static Livro buscarLivroPorISBN(String isbn) {
	    ConnectionDB db = new ConnectionDB(); 
	    Connection conn = db.getConnection();
	    Livro livro = null;

	    try {
	        String query = "SELECT * FROM LIVROS WHERE isbn = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, isbn);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            String nomeEditora = rs.getString("editora");
	            Editora editora = EditoraDAO.buscarEditora(nomeEditora);
	            
	            if (editora != null) {
	                livro = new Livro(
	                    rs.getString("nome"), 
	                    editora, 
	                    rs.getString("autor"), 
	                    rs.getInt("edicao"), 
	                    rs.getString("genero"), 
	                    rs.getString("isbn")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.closeConnection();
	    }

	    return livro;
	}

	public static boolean atualizarLivro(String isbnOriginal, Livro livroAtualizado) {
	    ConnectionDB db = new ConnectionDB(); 
	    Connection conn = db.getConnection();
	    boolean atualizado = false;

	    try {
	        
	        Editora editora = EditoraDAO.buscarEditora(livroAtualizado.getEditora().getNome());
	        if (editora == null) {
	            System.out.println("Editora não encontrada.");
	            return false;
	        }

	        String query = "UPDATE LIVROS SET nome = ?, autor = ?, genero = ?, isbn = ?, edicao = ?, editora = ? WHERE isbn = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, livroAtualizado.getNome());
	        ps.setString(2, livroAtualizado.getAutor());
	        ps.setString(3, livroAtualizado.getGenero());
	        ps.setString(4, livroAtualizado.getISBN());
	        ps.setInt(5, livroAtualizado.getEdicao());
	        ps.setString(6, livroAtualizado.getEditora().getNome());
	        ps.setString(7, isbnOriginal);
	        
	        atualizado = ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.closeConnection();
	    }

	    return atualizado;
}
	}
