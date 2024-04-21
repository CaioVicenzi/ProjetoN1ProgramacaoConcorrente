package br.com.loja.modelo;

public class ContaInvestimentos {
	private double dinheiroInvestido;
	private Funcionario titular;
	
	
	public ContaInvestimentos(Funcionario titular) {
		this.titular = titular;
	}
	
	public Funcionario getTitular() {
		return titular;
	}
	
	
	public double getDinheiroInvestido() {
		return dinheiroInvestido;
	}
	
	public void investir (double quantia) {
		this.dinheiroInvestido += quantia;
	}
	
	public void extrato() {
		System.out.println(titular.getNome() + " investiu " + this.getDinheiroInvestido() + " reais");
	}
	

}
