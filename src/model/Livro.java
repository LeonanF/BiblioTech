package model;

public class Livro {
	private String nome;
	private Editora editora;
	private String autor;
	private int edicao;
	private String genero;
	private String isbn;
	private String disponibilidade;
	private int reservas;
	
	public Livro(String nome, Editora editora, String autor, int edicao, String genero, String isbn, String disponibilidade, int reservas) {
		super();
		this.nome = nome;
		this.editora = editora;
		this.autor = autor;
		this.edicao = edicao;
		this.genero = genero;
		this.isbn = isbn;
		this.disponibilidade = disponibilidade;
		this.reservas = reservas;
	}

	public String getNome() {
		return nome;
	}

	public Editora getEditora() {
		return editora;
	}

	public String getAutor() {
		return autor;
	}

	public int getEdicao() {
		return edicao;
	}

	public String getGenero() {
		return genero;
	}

	public String getISBN() {
		return isbn;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}
	
	public int getReservas() {
		return reservas;
	}
	
	
}
