package application;

public class Disponibilidade {
	//PORFAVOR SE NAO QUISER SE DECEPCIONAR NAO LEIA O CODIGO SAO 2AM E TO COM PREGUICA
	private String cpf_profesor;
	private String cpf_aluno;
	private Boolean segunda;
	private Boolean terca;
	private Boolean quarta;
	private Boolean quinta;
	private Boolean sexta;
	private Boolean manha;
	private Boolean tarde;
	private Boolean noite;
	
	public Disponibilidade(String cpf, Boolean type) {
		if (type) {
			this.cpf_profesor = cpf;
		} else
			this.cpf_aluno = cpf;
	}
	
	public Disponibilidade(String cpf_profesor, String cpf_aluno, Boolean segunda, Boolean terca, Boolean quarta, Boolean quinta, Boolean sexta, Boolean manha, Boolean tarde, Boolean noite) {
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
		this.cpf_aluno = cpf_aluno;
		this.cpf_profesor = cpf_profesor;
	}
	
	public String getCPF() {
		if (this.cpf_profesor == "") {
			return this.cpf_aluno;
		}
		else { 
			return this.cpf_profesor;
		}
	}
	
	public String getType() {
		if (this.cpf_profesor == "") {
			return "A";
		}
		else { 
			return "P";
		}
	}
	
	public Boolean getSegunda() {
		return segunda;
	}
	public void setSegunda(Boolean segunda) {
		this.segunda = segunda;
	}
	public Boolean getTerca() {
		return terca;
	}
	public void setTerca(Boolean terca) {
		this.terca = terca;
	}
	public Boolean getQuarta() {
		return quarta;
	}
	public void setQuarta(Boolean quarta) {
		this.quarta = quarta;
	}
	public Boolean getQuinta() {
		return quinta;
	}
	public void setQuinta(Boolean quinta) {
		this.quinta = quinta;
	}
	public Boolean getSexta() {
		return sexta;
	}
	public void setSexta(Boolean sexta) {
		this.sexta = sexta;
	}
	public Boolean getManha() {
		return manha;
	}
	public void setManha(Boolean manha) {
		this.manha = manha;
	}
	public Boolean getTarde() {
		return tarde;
	}
	public void setTarde(Boolean tarde) {
		this.tarde = tarde;
	}
	public Boolean getNoite() {
		return noite;
	}
	public void setNoite(Boolean noite) {
		this.noite = noite;
	}

	public String getCpf_profesor() {
		return cpf_profesor;
	}

	public void setCpf_profesor(String cpf_profesor) {
		this.cpf_profesor = cpf_profesor;
	}

	public String getCpf_aluno() {
		return cpf_aluno;
	}

	public void setCpf_aluno(String cpf_aluno) {
		this.cpf_aluno = cpf_aluno;
	}
	
}
