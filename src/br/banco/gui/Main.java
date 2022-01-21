package br.banco.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel panel;
	private JPanel panelBorda;

	private JMenuBar menuBar;

	private JMenu menuContas;
	private JMenuItem menuCriarConta;

	private JMenu menuSobre;
	private JMenuItem menuInfo;

	private JPanel panelTitulo;
	private JLabel lblTitulo;

	private JPanel panelBotao;
	private JButton btnDepositar;
	private JButton btnSacar;
	private JButton btnTransferir;

	public Main() {
		this.iniciarComponentes();
	}

	private void iniciarComponentes() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Banco Java");
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Font fontTitulo = new Font("Sans Serif", Font.BOLD, 25);
		Font fontBotao = new Font("Sans Serif", Font.BOLD, 15);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(panel);

		panelBorda = new JPanel();
		panelBorda.setLayout(new BoxLayout(panelBorda, BoxLayout.Y_AXIS));
		panelBorda.setBorder(new LineBorder(Color.black));
		panel.add(panelBorda);

		menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(0, 10, 0, 10));
		this.setJMenuBar(menuBar);

		menuContas = new JMenu("Contas");
		menuBar.add(menuContas);

		menuCriarConta = new JMenuItem("Criar Conta");
		menuCriarConta.addActionListener((ActionEvent) -> {
			this.criarConta();
		});
		menuContas.add(menuCriarConta);

		menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);

		menuInfo = new  JMenuItem("Info");
		menuInfo.addActionListener((ActionEvent) -> {
			this.exibirInfo();
		});
		menuSobre.add(menuInfo);

		panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorda.add(panelTitulo);

		lblTitulo = new JLabel("Bem vindo, Fulano!");
		lblTitulo.setFont(fontTitulo);
		panelTitulo.add(lblTitulo);

		panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorda.add(panelBotao);

		btnDepositar = new JButton("Depositar");
		btnDepositar.setFont(fontBotao);
		btnDepositar.addActionListener((ActionEvent) -> {
			this.depositar();
		});
		panelBotao.add(btnDepositar);

		btnSacar = new JButton("Sacar");
		btnSacar.setFont(fontBotao);
		btnSacar.addActionListener((ActionEvent) -> {
			this.sacar();
		});
		panelBotao.add(btnSacar);

		btnTransferir = new JButton("Transferir");
		btnTransferir.setFont(fontBotao);
		btnTransferir.addActionListener((ActionEvent) -> {
			this.transferir();
		});
		panelBotao.add(btnTransferir);
	}

	private void criarConta() {
		// Code
	}

	private void exibirInfo() {
		// Code
	}

	private void depositar() {
		new Depositar(this).setVisible(true);
	}

	private void sacar() {
		new Sacar(this).setVisible(true);
	}

	private void transferir() {
		new Transferir(this).setVisible(true);
	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}
