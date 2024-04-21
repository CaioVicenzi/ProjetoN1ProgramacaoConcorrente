package br.com.loja.modelo;

public class ContaInvestimentos {
	private double dinheiroInvestido;
	
	
	public double getDinheiroInvestido() {
		return dinheiroInvestido;
	}
	
	public void investir (double quantia) {
		this.dinheiroInvestido += quantia;
	}
	
	
	

}
