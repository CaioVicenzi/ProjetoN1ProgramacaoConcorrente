package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class ContaLoja extends Conta {
	private List<Conta> contaFuncionarios = new ArrayList<>();
	private List<ContaInvestimentos> contaInvestimentoFuncionarios = new ArrayList<>();

	public ContaLoja(ClienteBanco titular) {
		super(titular);
	}
	
	public void addFuncionario (Conta f, ContaInvestimentos contaInvestimentos) {
		contaFuncionarios.add(f);
		this.contaInvestimentoFuncionarios.add(contaInvestimentos);
	}
	
	public List<Conta> getContaFuncionarios() {
		return contaFuncionarios;
	}
	
	public List<ContaInvestimentos> getContaInvestimentoFuncionarios() {
		return contaInvestimentoFuncionarios;
	}
	
	public void pagarFuncionarios () {
		for (int i = 0; i < contaFuncionarios.size(); i++) {
			contaFuncionarios.get(i).depositarDinheiro(1400 * 0.8);
			contaInvestimentoFuncionarios.get(i).investir(1400 * 0.2);
		}
	}
	
}
