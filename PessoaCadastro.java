package br.senac.application;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import br.senac.model.Pessoa;
import br.senac.dao.PessoaDao;
import java.sql.SQLException;

public class PessoaCadastro {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtAnoNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PessoaCadastro window = new PessoaCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PessoaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(40, 66, 195, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtAnoNascimento = new JTextField();
		txtAnoNascimento.setBounds(40, 162, 195, 20);
		frame.getContentPane().add(txtAnoNascimento);
		txtAnoNascimento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome.");
		lblNewLabel.setBounds(40, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ano de Nascimento");
		lblNewLabel_1.setBounds(40, 147, 113, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(txtNome.getText());
					pessoa.setAnoNascimento(Integer.valueOf(txtAnoNascimento.getText()));
					
					PessoaDao pessoaDao = new PessoaDao();
					pessoaDao.create(pessoa);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
				}
				catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage(), "Pessoa", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(209, 193, 89, 23);
		frame.getContentPane().add(btnCadastrar);
	}
}
