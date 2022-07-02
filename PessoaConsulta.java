package br.senac.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import br.senac.model.Pessoa;
import br.senac.dao.PessoaDao;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PessoaConsulta {

	private JFrame frame;
	private JTextField txtNome;
	private JTable tblPessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PessoaConsulta window = new PessoaConsulta();
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
	public PessoaConsulta() {
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
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(41, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 8, 207, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaDao pessoaDao = new PessoaDao();
				List <Pessoa> pessoas = new ArrayList<Pessoa>();
				String nome = txtNome.getText();
				
				try {
					pessoas = pessoaDao.getPessoaByName(nome);
					
					DefaultTableModel modelo = (DefaultTableModel) tblPessoa.getModel();
					modelo.setRowCount(0);
					modelo.addColumn("Código");
					modelo.addColumn("Nome");
					modelo.addColumn("Ano de Nascimento");
					
					for (Pessoa p: pessoas) {
						modelo.addRow(new Object [] {
						p.getid(),
						p.getNome(),
						p.getAnoNascimento()
						});
						}
				}
				catch(SQLException ex) {
					JOptionPane.showConfirmDialog(null, "Error: " + ex.getMessage());
				}
 				
			}
		});
		btnConsulta.setBounds(314, 7, 89, 23);
		frame.getContentPane().add(btnConsulta);
		
		tblPessoa = new JTable();
		tblPessoa.setBounds(10, 36, 414, 203);
		frame.getContentPane().add(tblPessoa);
	}
}
