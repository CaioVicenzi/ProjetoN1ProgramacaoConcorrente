package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contasCadastradas = new ArrayList<Conta>();
	
	public Banco(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void cadastrarNovaConta (Conta c) {
		this.contasCadastradas.add(c);
	}
	
	public List<Conta> getContasCadastradas() {
		return contasCadastradas;
	}
	
	public void realizarCompra (double quantia, Conta origem, ContaLoja destino) {
		if (origem.getSaldo() > quantia) {
			origem.sacarDinheiro(quantia);
			destino.depositarDinheiro(quantia);
			
			// TODO FALTA AINDA COLOCAR A LÓGICA PARA MANDAR O DINHEIRO PARA OS FUNCIONARIOS...
		} else {
			System.out.println("Operação não pode ser concluída com sucesso...");
		}
		
	}
}
