package application;

 import java.util.Date;

 public class Aluno {
	private String cpf;
	private String nome;
	private String email;
	private String nivelConhecimento;
	private String telefone;
	private String materia;
	private Date disponibilidade;
	private String descricao;

 	public Aluno(String cpf, String nome, String email, String nivelConhecimento, String telefone, String materia, Date disponibilidade, String descricao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.nivelConhecimento = nivelConhecimento;
		this.telefone = telefone;
		this.materia = materia;
		this.disponibilidade = disponibilidade;
		this.descricao = descricao;		
	}

	public Aluno() {

	}

 	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

 	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

 	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

 	public String getNivelConhecimento() {
		return nivelConhecimento;
	}
	public void setNivelConhecimento(String nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}

 	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

 	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}

 	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

 	public Date getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(Date disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}