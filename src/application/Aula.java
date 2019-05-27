package application;

import java.util.List;

public class Aula {
	private String cpf_professor;
	private int id_aula;
	private String materia;
	private List<String> alunos;
	
	public String getCpf_professor() {
		return cpf_professor;
	}
	public void setCpf_professor(String cpf_professor) {
		this.cpf_professor = cpf_professor;
	}
	
	public int getId_aula() {
		return id_aula;
	}
	public void setId_aula(int id_aula) {
		this.id_aula = id_aula;
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public List<String> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<String> alunos) {
		this.alunos = alunos;
	}
	
}
