package application;

import java.util.List;

public class Aula {
	private String cpf_professor;
	private int id_aula;
	private String materia;
	private List<String> alunos;
	private String dia_semana;
	private String hora;
	private int max_alunos;
	private int min_alunos;
	
	
	public Aula(String cpf_professor, int id_aula, String dia_semana, String hora) {
		this.cpf_professor = cpf_professor;
		this.id_aula = id_aula;
		this.dia_semana = dia_semana;
		this.hora = hora;
		this.max_alunos = 40;
		this.min_alunos = 5;
		
	}
	
	public Aula() {
		
	}
	
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
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getMin_alunos() {
		return min_alunos;
	}

	public void setMin_alunos(int min_alunos) {
		this.min_alunos = min_alunos;
	}

	public int getMax_alunos() {
		return max_alunos;
	}

	public void setMax_alunos(int max_alunos) {
		this.max_alunos = max_alunos;
	}
	
}
