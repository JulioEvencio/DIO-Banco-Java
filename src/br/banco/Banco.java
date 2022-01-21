package br.banco;

import java.util.TreeMap;
import java.util.ArrayList;
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
	private static int usuarioLogado = -1;

	public static Cliente getUsuarioLogado() {
		return clientes.get(usuarioLogado);
	}

	public static ArrayList<Integer> getContas() {
		ArrayList<Integer> contas = new ArrayList<>();

		for (Cliente cliente: clientes.values()) {
			if (cliente.getContaPoupanca() != null) {
				contas.add(cliente.getContaPoupanca().getNumero());
			}

			if (cliente.getContaCorrente() != null) {
				contas.add(cliente.getContaCorrente().getNumero());
			}
		}

		return contas;
	}

	public static void cadastrarCliente(int cpf, String nome, String senha) throws CpfInvalidoException {
		if (clientes.containsKey(cpf)) throw new CpfInvalidoException();

		clientes.put(cpf, new Cliente(cpf, nome, senha));
	}

	public static boolean logar(int cpf, String senha) {
		if (!clientes.containsKey(cpf)) return false;

		if (clientes.get(cpf).logar(cpf, senha)) usuarioLogado = cpf;
		else return false;

		return true;
	}

	public static void deslogar() {
		usuarioLogado = -1;
	}

	public static void abrirContaPoupanca() throws AbrirContaException {
		clientes.get(usuarioLogado).abrirConta(new ContaPoupanca(contasAbertasTotal, AGENCIA));

		contasAbertasTotal++;
	}

	public static void abrirContaCorrente() throws AbrirContaException {
		clientes.get(usuarioLogado).abrirConta(new ContaCorrente(contasAbertasTotal, AGENCIA));

		contasAbertasTotal++;
	}

	public static void depositar(double valor, Conta conta) throws ValorInvalidoException {
		clientes.get(usuarioLogado).depositar(valor, conta);
	}

	public static void sacar(double valor, Conta conta) throws ValorInvalidoException, SaldoInsuficienteException {
		clientes.get(usuarioLogado).sacar(valor, conta);
	}

	public static void transferir(double valor, Conta conta, Conta contaDestino) throws SaldoInsuficienteException, ValorInvalidoException {
		clientes.get(usuarioLogado).transferir(valor, conta, contaDestino);
	}

}
