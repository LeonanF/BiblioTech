package model;

public class UsuarioDTO {
	
	private int matricula_usuario;
	private String nome_usuario, senha_usuario, email_usuario, curso_usuario, usuario_bibliotecario, senha_bibliotecario;
	
	public int getMatricula_usuario() {
		return matricula_usuario;
	}
	public void setMatricula_usuario(int matricula_usuario) {
		this.matricula_usuario = matricula_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getCurso_usuario() {
		return curso_usuario;
	}
	public void setCurso_usuario(String curso_usuario) {
		this.curso_usuario = curso_usuario;
	}
	
	public String getUsuario_bibliotecario() {
		return usuario_bibliotecario;
	}
	
	public void setUsuario_bibliotecario(String usuario_bibliotecario) {
		this.usuario_bibliotecario = usuario_bibliotecario;
	}
	
	public String getSenha_bibliotecario() {
		return senha_bibliotecario;
	}
	public void setSenha_bibliotecario(String senha_bibliotecario) {
		this.senha_bibliotecario = senha_bibliotecario;
	}
	
	
	
	
}
