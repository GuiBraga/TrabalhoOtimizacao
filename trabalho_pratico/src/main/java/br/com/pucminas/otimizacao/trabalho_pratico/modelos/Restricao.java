package br.com.pucminas.otimizacao.trabalho_pratico.modelos;

public class Restricao {
	
	private Double x1;
	
	private Double x2;
	
	private String operador;
	
	private Double total;

	
	public Restricao() {
	}

	public Restricao(Double x1, Double x2, String operador, Double total) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.operador = operador;
		this.total = total;
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

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
