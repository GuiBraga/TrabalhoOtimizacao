package br.com.pucminas.otimizacao.trabalho_pratico.modelos;

public class Funcao {

	private String objetivo;
	
	private Double x1;
	
	private Double x2;

	public Funcao() {
	}

	public Funcao(String objetivo, Double x1, Double x2) {
		super();
		this.objetivo = objetivo;
		this.x1 = x1;
		this.x2 = x2;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Double getX1() {
		return x1;
	}

	public void setX1(Double x1) {
		this.x1 = x1;
	}

	public Double getX2() {
		return x2;
	}

	public void setX2(Double x2) {
		this.x2 = x2;
	}
	
}
