package model;

public class Usuario {
	
	private int matricula_usuario;
	private String nome_usuario, senha_usuario, email_usuario, curso_usuario, usuario_bibliotecario, senha_bibliotecario;
	
	public Usuario(int matricula_usuario, String nome_usuario, String senha_usuario, String email_usuario,
			String curso_usuario) {
		super();
		this.matricula_usuario = matricula_usuario;
		this.nome_usuario = nome_usuario;
		this.senha_usuario = senha_usuario;
		this.email_usuario = email_usuario;
		this.curso_usuario = curso_usuario;
	}

	public int getMatricula_usuario() {
		return matricula_usuario;
	}
	
	public String getNome_usuario() {
		return nome_usuario;
	}
	
	public String getSenha_usuario() {
		return senha_usuario;
	}
	
	public String getEmail_usuario() {
		return email_usuario;
	}
	
	public String getCurso_usuario() {
		return curso_usuario;
	}
	
	public String getUsuario_bibliotecario() {
		return usuario_bibliotecario;
	}
	
	
	public String getSenha_bibliotecario() {
		return senha_bibliotecario;
	}
	
	
	
}
