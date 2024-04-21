package br.com.loja;

import br.com.loja.modelo.Banco;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Conta;
import br.com.loja.modelo.ContaLoja;
import br.com.loja.modelo.Funcionario;
import br.com.loja.modelo.Loja;

public class Main {
	static Banco bancoPrincipal = new Banco("Banco do Caio");

	public static void main(String[] args) {
		//Deve conter um total de 1 banco
		
		// 2 lojas
		Loja lojaSapatos = new Loja("Caio Sapatos");
		Loja lojaRoupas = new Loja("Caio Roupas");
		
		
		// 4 funcionarios (2 por loja)
		Funcionario caio = new Funcionario("Caio");
		Funcionario giovanni = new Funcionario("Giovanni");
		Funcionario eduardo = new Funcionario("Eduardo");
		Funcionario raquel  = new Funcionario("Raquel");
		
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
		ContaLoja contaLojaRoupas = new ContaLoja(lojaRoupas);
		ContaLoja contaLojaSapatos = new ContaLoja(lojaSapatos);
		
		// criando contas para cada um dos funcionários de cada uma das lojas
		Conta contaCaio = new Conta(caio);
		Conta contaGiovanni = new Conta(giovanni);
		Conta contaEduardo = new Conta (eduardo);
		Conta contaRaquel = new Conta(raquel);
		
		// adicionando as contas dentro do corpo de funcionarios das empresas
		contaLojaRoupas.addFuncionario(contaRaquel);
		contaLojaRoupas.addFuncionario(contaEduardo);
		contaLojaSapatos.addFuncionario(contaCaio);
		contaLojaSapatos.addFuncionario(contaGiovanni);

		
		// adicionando as contas no banco
		bancoPrincipal.cadastrarNovaConta(contaThiago);
		bancoPrincipal.cadastrarNovaConta(contaPedro);
		bancoPrincipal.cadastrarNovaConta(contaJoao);
		bancoPrincipal.cadastrarNovaConta(contaMateus);
		bancoPrincipal.cadastrarNovaConta(contaPaulo);
		bancoPrincipal.cadastrarNovaConta(contaPaulo);
		
		// depositando 1000 para cada conta
		contaThiago.depositarDinheiro(1000);
		contaPedro.depositarDinheiro(1000);
		contaJoao.depositarDinheiro(1000);
		contaMateus.depositarDinheiro(1000);
		contaPaulo.depositarDinheiro(1000);
		
		
		
		
		// criando uma thread para cada um dos clientes que vão comprar nas lojas
		Thread threadThiago = new Thread(() -> {
			executarCompras(contaThiago, contaLojaRoupas, contaLojaSapatos);
		});
		
		Thread threadPedro = new Thread(() -> {
			executarCompras(contaPedro, contaLojaRoupas, contaLojaSapatos);
		});
		
		Thread threadJoao = new Thread(() -> {
			executarCompras(contaJoao, contaLojaRoupas, contaLojaSapatos);
		});
		
		Thread threadMateus = new Thread(() -> {
			executarCompras(contaMateus, contaLojaRoupas, contaLojaSapatos);
		});
		
		Thread threadPaulo = new Thread(() -> {
			executarCompras(contaPaulo, contaLojaRoupas, contaLojaSapatos);
		});
		
		// executar as threads
		threadJoao.run();
		threadThiago.run();
		threadPedro.run();
		threadMateus.run();
		threadPaulo.run();
		
	}
	
	
	private static void executarCompras (Conta c, ContaLoja cLoja1, ContaLoja cLoja2) {
		bancoPrincipal.realizarCompra(100, c, cLoja1);
		bancoPrincipal.realizarCompra(200, c, cLoja2);
		bancoPrincipal.realizarCompra(100, c, cLoja1);
		bancoPrincipal.realizarCompra(200, c, cLoja2);
		bancoPrincipal.realizarCompra(100, c, cLoja1);
		bancoPrincipal.realizarCompra(200, c, cLoja2);
		bancoPrincipal.realizarCompra(100, c, cLoja1);
	}
}
