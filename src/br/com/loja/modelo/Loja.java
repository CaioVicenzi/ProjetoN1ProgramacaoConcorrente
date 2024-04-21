package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class Loja implements ClienteBanco{
	private List <Funcionario> listaFuncionarios = new ArrayList<>();
	private String nome = "";
	
	public Loja(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	
	public void addFuncionario(Funcionario f) {
		this.listaFuncionarios.add(f);
	}
}
