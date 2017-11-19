package br.com.pucminas.otimizacao.trabalho_pratico.modelos;

public class Resolucao {

	private Double Z;

	private Double x1;

	private Double x2;

	public Resolucao() {
	}

	public Resolucao(Double z, Double x1, Double x2) {
		super();
		Z = z;
		this.x1 = x1;
		this.x2 = x2;
	}

	public Double getZ() {
		return Z;
	}

	public void setZ(Double z) {
		Z = z;
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
