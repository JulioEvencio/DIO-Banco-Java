package br.banco.pessoa;

public abstract class Pessoa {

	protected final int cpf;
	protected final String nome;

	public Pessoa(int cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

}
