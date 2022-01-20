package br.banco.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel panel;
	private JPanel panelBorda;

	private JPanel panelTitulo;
	private JLabel lblTitulo;

	private JPanel panelCpf;
	private JLabel lblCpf;
	private JTextField txtCpf;

	private JPanel panelSenha;
	private JLabel lblSenha;
	private JPasswordField txtSenha;

	private JPanel panelBotao;
	private JButton btnEntrar;
	private JButton btnRegistrar;

	public Login() {
		this.iniciarComponentes();
	}

	private void iniciarComponentes() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		lblTitulo = new JLabel("Login");
		lblTitulo.setFont(fontTitulo);
		panelTitulo.add(lblTitulo);

		panelCpf = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorda.add(panelCpf);

		lblCpf = new JLabel("CPF:");
		lblCpf.setFont(fontTexto);
		panelCpf.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(fontCampo);
		txtCpf.setPreferredSize(new Dimension(300, 20));
		panelCpf.add(txtCpf);

		panelSenha = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBorda.add(panelSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(fontTexto);
		panelSenha.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setFont(fontCampo);
		txtSenha.setPreferredSize(new Dimension(300, 20));
		panelSenha.add(txtSenha);

		panelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBorda.add(panelBotao);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(fontBotao);
		btnEntrar.addActionListener((ActionEvent) -> {
			this.entrar();
		});
		panelBotao.add(btnEntrar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(fontBotao);
		btnRegistrar.addActionListener((ActionEvent) -> {
			this.registrar();
		});
		panelBotao.add(btnRegistrar);
	}

	private void entrar() {
		// Code
	}

	private void registrar() {
		// Code
	}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}

}
