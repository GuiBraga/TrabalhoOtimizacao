package br.com.pucminas.otimizacao.trabalho_pratico.modelos;

public class Problema {				
	
	private Funcao funcaoObjetiva;
	
	private Restricao restricao1;
	
	private Restricao restricao2;
	
	private Restricao restricao3;

	public Problema() {
	}
	
	public Problema(Funcao funcaoObjetiva, Restricao restricao1, Restricao restricao2, Restricao restricao3) {
		super();
		this.funcaoObjetiva = funcaoObjetiva;
		this.restricao1 = restricao1;
		this.restricao2 = restricao2;
		this.restricao3 = restricao3;
	}

	public Funcao getFuncaoObjetiva() {
		return funcaoObjetiva;
	}

	public void setFuncaoObjetiva(Funcao funcaoObjetiva) {
		this.funcaoObjetiva = funcaoObjetiva;
	}

	public Restricao getRestricao1() {
		return restricao1;
	}

	public void setRestricao1(Restricao restricao1) {
		this.restricao1 = restricao1;
	}

	public Restricao getRestricao2() {
		return restricao2;
	}

	public void setRestricao2(Restricao restricao2) {
		this.restricao2 = restricao2;
	}

	public Restricao getRestricao3() {
		return restricao3;
	}

	public void setRestricao3(Restricao restricao3) {
		this.restricao3 = restricao3;
	}
	
}
