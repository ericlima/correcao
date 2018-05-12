package br.edu.cruzeirodosul.model;

public class ResultadosProvaDTO {

	private String prova;
	private String nomeAluno;
	private String ausente;
	private String respostas;
	private Integer questoes;
	
	public String getProva() {
		return prova;
	}
	public void setProva(String prova) {
		this.prova = prova;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getAusente() {
		return ausente;
	}
	public void setAusente(String ausente) {
		this.ausente = ausente;
	}
	public String getRespostas() {
		return respostas;
	}
	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}
	public Integer getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Integer questoes) {
		this.questoes = questoes;
	}	
	
}
