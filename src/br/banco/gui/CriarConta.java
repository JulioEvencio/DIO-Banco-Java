package br.banco.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CriarConta extends JDialog {

	private JPanel panel;
	private JPanel panelBorda;

	private JPanel panelTitulo;
	private JLabel lblTitulo;
	
	private JPanel panelConta;
	private JLabel lblConta;
	private ButtonGroup grupoConta;
	private JRadioButton txtContaPoupanca;
	private JRadioButton txtContaCorrente;

	private JPanel panelBotao;
	private JButton btnCadastrar;

	public CriarConta(JFrame frame) {
		super(frame, true);
		this.iniciarComponentes();
	}

	private void iniciarComponentes() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Banco Java");
		this.setSize(400, 260);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		Font fontTitulo = new Font("Sans Serif", Font.BOLD, 25);
		Font fontTexto = new Font("Sans Serif", Font.BOLD, 15);
		Font fontCampo = new Font("Sans Serif", Font.PLAIN, 15);
		Font fontBotao = new Font("Sans Serif", Font.BOLD, 15);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.add(panel);

		panelBorda = new JPanel();
		panelBorda.setLayout(new BoxLayout(panelBorda, BoxLayout.Y_AXIS));
		panelBorda.setBorder(new LineBorder(Color.black));
		panel.add(panelBorda);

		panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorda.add(panelTitulo);

		lblTitulo = new JLabel("Criar Conta");
		lblTitulo.setFont(fontTitulo);
		panelTitulo.add(lblTitulo);

		panelConta = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorda.add(panelConta);

		lblConta = new JLabel("Tipo:");
		lblConta.setFont(fontTexto);
		panelConta.add(lblConta);

		txtContaPoupanca = new JRadioButton("Conta Poupança");
		txtContaPoupanca.setSelected(true);
		txtContaPoupanca.setFont(fontCampo);
		panelConta.add(txtContaPoupanca);

		txtContaCorrente = new JRadioButton("Conta Corrente");
		txtContaCorrente.setFont(fontCampo);
		panelConta.add(txtContaCorrente);

		grupoConta = new ButtonGroup();
		grupoConta.add(txtContaPoupanca);
		grupoConta.add(txtContaCorrente);

		panelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBorda.add(panelBotao);

		btnCadastrar = new JButton("Criar Conta");
		btnCadastrar.setFont(fontBotao);
		btnCadastrar.addActionListener((ActionEvent) -> {
			this.criar();
		});
		panelBotao.add(btnCadastrar);
	}

	private void criar() {
		// Code
	}

}
