package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class ContaLoja extends Conta {
	private List<Conta> contaFuncionarios = new ArrayList<>();

	public ContaLoja(ClienteBanco titular) {
		super(titular);
	}
	
	public void addFuncionario (Conta f) {
		contaFuncionarios.add(f);
	}
	
	public List<Conta> getContaFuncionarios() {
		return contaFuncionarios;
	}
	
	public void pagarFuncionarios () {
		for (Conta conta : contaFuncionarios) {
			conta.depositarDinheiro(1400);
		}
	}
	
}
