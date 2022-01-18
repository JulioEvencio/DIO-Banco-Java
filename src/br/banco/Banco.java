package br.banco;

import java.util.TreeMap;
import br.banco.pessoa.Cliente;
import br.exception.AbrirContaException;
import br.banco.conta.Conta;
import br.banco.conta.ContaPoupanca;
import br.banco.conta.ContaCorrente;
import br.exception.ValorInvalidoException;
import br.exception.SaldoInsuficienteException;
import br.exception.CpfInvalidoException;

public class Banco {

	private static final int AGENCIA = 123;
	private static int contasAbertasTotal = 0;
	private static final TreeMap<Integer, Cliente> clientes = new TreeMap<>();

	public static Cliente getCliente(int cpf) {
		return clientes.get(cpf);
	}

	public static TreeMap<Integer, Cliente> getClientes() {
		return clientes;
	}

	public static void adicionarCliente(int cpf, String nome) throws CpfInvalidoException {
		if (clientes.containsKey(cpf)) throw new CpfInvalidoException();

		clientes.put(cpf, new Cliente(cpf, nome));
	}

	public static void abrirContaPoupanca(int cpf) throws AbrirContaException {
		clientes.get(cpf).abrirConta(new ContaPoupanca(contasAbertasTotal, AGENCIA));

		contasAbertasTotal++;
	}

	public static void abrirContaCorrente(int cpf) throws AbrirContaException {
		clientes.get(cpf).abrirConta(new ContaCorrente(contasAbertasTotal, AGENCIA));

		contasAbertasTotal++;
	}

	public static void depositar(int cpf, double valor, Conta conta) throws ValorInvalidoException {
		clientes.get(cpf).depositar(valor, conta);
	}

	public static void sacar(int cpf, double valor, Conta conta) throws SaldoInsuficienteException {
		clientes.get(cpf).sacar(valor, conta);
	}

	public static void transferir(int cpf, double valor, Conta conta, Conta contaDestino) throws SaldoInsuficienteException, ValorInvalidoException {
		clientes.get(cpf).transferir(valor, conta, contaDestino);
	}

}
