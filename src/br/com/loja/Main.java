package br.com.loja;

import java.util.ArrayList;

import br.com.loja.modelo.Banco;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Conta;
import br.com.loja.modelo.ContaInvestimentos;
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
		
		// criando uma conta de investimentos para cada um dos funcionários
		ContaInvestimentos contaInvestimentosCaio = new ContaInvestimentos(caio);
		ContaInvestimentos contaInvestimentosGiovanni = new ContaInvestimentos(giovanni);
		ContaInvestimentos contaInvestimentosEduardo = new ContaInvestimentos(eduardo);
		ContaInvestimentos contaInvestimentosRaquel = new ContaInvestimentos(raquel);
		
		// adicionando as contas dentro do corpo de funcionarios das empresas
		contaLojaRoupas.addFuncionario(contaRaquel, contaInvestimentosRaquel);
		contaLojaRoupas.addFuncionario(contaEduardo, contaInvestimentosEduardo);
		contaLojaSapatos.addFuncionario(contaCaio, contaInvestimentosCaio);
		contaLojaSapatos.addFuncionario(contaGiovanni, contaInvestimentosGiovanni);

		
		// adicionando as contas no banco
		bancoPrincipal.cadastrarNovaConta(contaThiago);
		bancoPrincipal.cadastrarNovaConta(contaPedro);
		bancoPrincipal.cadastrarNovaConta(contaJoao);
		bancoPrincipal.cadastrarNovaConta(contaMateus);
		bancoPrincipal.cadastrarNovaConta(contaPaulo);
		bancoPrincipal.cadastrarNovaConta(contaPaulo);
		
		// depositando 1000 para cada conta
		contaThiago.depositarDinheiro(1000.01);
		contaPedro.depositarDinheiro(1000.01);
		contaJoao.depositarDinheiro(1000.01);
		contaMateus.depositarDinheiro(1000.01);
		contaPaulo.depositarDinheiro(1000.01);
		
		
		
		
		// criando uma thread para cada um dos clientes que vão comprar nas lojas
		Executavel.passarBanco(bancoPrincipal);
		Executavel.contasEnviadasLoja.add(contaLojaSapatos);
		Executavel.contasEnviadasLoja.add(contaLojaRoupas);
		
		Executavel executavelThiago = new Executavel(contaThiago);
		Thread threadThiago = new Thread(executavelThiago);
		
		Executavel executavelPedro = new Executavel(contaPedro);
		Thread threadPedro = new Thread(executavelPedro);
		
		Executavel executavelJoao = new Executavel(contaJoao);
		Thread threadJoao = new Thread(executavelJoao);
		
		Executavel executavelMateus = new Executavel(contaMateus);
		Thread threadMateus = new Thread(executavelMateus);
		
		Executavel executavelPaulo = new Executavel(contaPaulo);
		Thread threadPaulo = new Thread(executavelPaulo);
		
		// executar as threads
		threadJoao.start();
		threadThiago.start();
		threadPedro.start();
		threadMateus.start();
		threadPaulo.start();
		
		
		try {
			// eu dei um tempo de dois segundos para o código assíncrono terminar de rodar antes de exibir os resultados
			Thread.sleep(2000);
			System.out.println("==== RESULTADO FINAL ====");
			
			contaCaio.extrato();
			contaEduardo.extrato();
			contaGiovanni.extrato();
			contaRaquel.extrato();
			
			contaLojaRoupas.extrato();
			contaLojaSapatos.extrato();
			
			contaMateus.extrato();
			contaPaulo.extrato();
			contaPedro.extrato();
			contaThiago.extrato();
			contaJoao.extrato();
			
			System.out.println("==== CONTAS DE INVESTIMENTO ====");
			contaInvestimentosCaio.extrato();
			contaInvestimentosEduardo.extrato();
			contaInvestimentosGiovanni.extrato();
			contaInvestimentosRaquel.extrato();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void executarCompras (Conta c, ContaLoja cLoja1, ContaLoja cLoja2) {
		
	}
}
