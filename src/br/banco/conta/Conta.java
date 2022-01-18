package br.banco.conta;

import br.exception.SaldoInsuficienteException;
import br.exception.ValorInvalidoException;

public abstract class Conta {
	
	protected final int numero;
	protected int agencia;
	protected double saldo;

	public Conta(int numero, int agencia) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = 0.00;
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double valor) throws ValorInvalidoException {
		if (valor <= 0) throw new ValorInvalidoException();

		saldo += valor;
	}

	public void sacar(double valor) throws SaldoInsuficienteException {
		if (valor > saldo) throw new SaldoInsuficienteException();

		saldo -= valor;
	}

	public void transferirDinheiro(double valor, Conta conta) throws SaldoInsuficienteException, ValorInvalidoException {
		if (valor > saldo) throw new SaldoInsuficienteException();
		if (valor <= 0) throw new ValorInvalidoException();

		this.saldo -= valor;
		conta.saldo += valor;
	}

}
