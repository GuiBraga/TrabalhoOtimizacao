package br.com.pucminas.otimizacao.trabalho_pratico.modelos;

public class Simplex {
	
	private Problema problema;
	
	private Resolucao resolucao;
	
	public Simplex() {
	}

	public Simplex(Problema problema, Resolucao resolucao) {
		super();
		this.problema = problema;
		this.resolucao = resolucao;
	}

	public Problema getProblema() {
		return problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

	public Resolucao getResolucao() {
		return resolucao;
	}

	public void setResolucao(Resolucao resolucao) {
		this.resolucao = resolucao;
	}
	
	
}
