package model;

import java.sql.Date;

public class Emprestimo {
	 private int id;
	    private String isbn;
	    private String matricula;
	    private Date dataEmprestimo;
	    private Date dataDevolucaoEstimada;
	    private String statusEmprestimo;

	    public Emprestimo(int id, String isbn, String matricula, Date dataEmprestimo, Date dataDevolucaoEstimada, String statusEmprestimo) {
	        this.id = id;
	        this.isbn = isbn;
	        this.matricula = matricula;
	        this.dataEmprestimo = dataEmprestimo;
	        this.dataDevolucaoEstimada = dataDevolucaoEstimada;
	        this.statusEmprestimo = statusEmprestimo;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public Date getDataEmprestimo() {
			return dataEmprestimo;
		}

		public void setDataEmprestimo(Date dataEmprestimo) {
			this.dataEmprestimo = dataEmprestimo;
		}

		public Date getDataDevolucaoEstimada() {
			return dataDevolucaoEstimada;
		}

		public void setDataDevolucaoEstimada(Date dataDevolucaoEstimada) {
			this.dataDevolucaoEstimada = dataDevolucaoEstimada;
		}

		public String getStatusEmprestimo() {
			return statusEmprestimo;
		}

		public void setStatusEmprestimo(String statusEmprestimo) {
			this.statusEmprestimo = statusEmprestimo;
		}
}
