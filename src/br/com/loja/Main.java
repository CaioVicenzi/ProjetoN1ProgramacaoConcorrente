package br.com.loja;

import br.com.loja.modelo.Banco;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Conta;
import br.com.loja.modelo.Funcionario;
import br.com.loja.modelo.Loja;

public class Main {
	public static void main(String[] args) {
		//Deve conter um total de 1 banco
		Banco bancoPrincipal = new Banco("Banco do Caio");
		
		// 2 lojas
		Loja lojaSapatos = new Loja("Caio Sapatos");
		Loja lojaRoupas = new Loja("Caio Roupas");
		
		
		// 4 funcionarios (2 por loja)
		Funcionario caio = new Funcionario();
		Funcionario giovanni = new Funcionario();
		Funcionario eduardo = new Funcionario();
		Funcionario raquel  = new Funcionario();
		
		// adicionando os funcionários nas lojas
		lojaSapatos.addFuncionario(caio);
		lojaSapatos.addFuncionario(giovanni);
		lojaRoupas.addFuncionario(eduardo);
		lojaRoupas.addFuncionario(raquel);		
		
		// 5 clientes
		Cliente thiago = new Cliente("Thiago");
		Cliente pedro = new Cliente("Pedro");
		Cliente joao = new Cliente("João");
		Cliente mateus = new Cliente("Mateus");
		Cliente paulo = new Cliente("Paulo");
		
		// criando uma conta para os clientes e para as lojas:
		Conta contaThiago = new Conta(thiago);
		Conta contaPedro = new Conta(pedro);
		Conta contaJoao = new Conta(joao);
		Conta contaMateus = new Conta(mateus);
		Conta contaPaulo = new Conta(paulo);
		
		// adicionando as contas no banco
		bancoPrincipal.cadastrarNovaConta(contaThiago);
		bancoPrincipal.cadastrarNovaConta(contaPedro);
		bancoPrincipal.cadastrarNovaConta(contaJoao);
		bancoPrincipal.cadastrarNovaConta(contaMateus);
		bancoPrincipal.cadastrarNovaConta(contaPaulo);
		
		
	}
}
