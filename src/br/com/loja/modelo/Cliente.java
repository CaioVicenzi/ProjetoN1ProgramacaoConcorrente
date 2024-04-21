package br.com.loja.modelo;

public class Cliente implements ClienteBanco{
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
