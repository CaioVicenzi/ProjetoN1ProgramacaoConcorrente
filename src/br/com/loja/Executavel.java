package br.com.loja;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.modelo.Banco;
import br.com.loja.modelo.Conta;
import br.com.loja.modelo.ContaLoja;

public class Executavel implements Runnable {
	static List<ContaLoja> contasEnviadasLoja = new ArrayList<ContaLoja>();
	static Banco banco;
	
	private Conta contaUser;
	
	
	public Executavel(Conta contaUser) {
		this.contaUser = contaUser;
	}
	
	static void passarBanco (Banco b) {
		banco = b;
	}
	
	@Override
	public synchronized void  run() {
		ContaLoja cLoja1 = contasEnviadasLoja.get(0);
		ContaLoja cLoja2 = contasEnviadasLoja.get(1);
		
		banco.realizarCompra(100, contaUser, cLoja1);
		banco.realizarCompra(200, contaUser, cLoja2);
		banco.realizarCompra(100, contaUser, cLoja1);
		banco.realizarCompra(200, contaUser, cLoja2);
		banco.realizarCompra(100, contaUser, cLoja1);
		banco.realizarCompra(200, contaUser, cLoja2);
		banco.realizarCompra(100, contaUser, cLoja1);
	}

}
