package application;

import java.util.List;

public class Aula {
	private String cpf_professor;
	private int id_aula;
	private String materia;
	private List<String> alunos;
	private String dia_semana;
	private int hora;
	
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
	public String getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
}
