package br.com.loja.modelo;

public class Funcionario implements ClienteBanco {
	private String nome;
	
	public Funcionario(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
