package br.com.loja.modelo;

public class Conta {
	private ClienteBanco titular;
	private double saldo;
	
	public Conta(ClienteBanco titular) {
		this.titular = titular;
		// saldo inicial vai ser de 0
		this.saldo = 0.0;
	}
	
	public ClienteBanco getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void depositarDinheiro (double deposito) {
		this.saldo += deposito;
	}
	
	public boolean sacarDinheiro (double quantia) {
		if (this.saldo < quantia) {
			this.saldo -= quantia;
			return true;
		} else {
			System.out.println("Operação não pode ser feita...");
			return false;
		}
	}
	
	// literalmente uma função para imprimir os dados do saldo do usuário
	public void extrato () {
		System.out.println("Conta do titular: " + titular.getNome() + " com o saldo: " + this.getSaldo());
	}
	
	public void transferirDinheiro (Conta c, double quantia) {
		if (sacarDinheiro(quantia)) {
			c.depositarDinheiro(quantia);
		} else {
			System.out.println("Operação não pôde ser concluída...");
		}
		
	}
}
