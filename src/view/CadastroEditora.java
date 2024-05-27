package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.EditoraController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroEditora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEndereco;
	private JTextField campoTelefone;
	private JTextField campoEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEditora frame = new CadastroEditora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroEditora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadastrarTitle = new JLabel("CADASTRAR EDITORA");
		cadastrarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		cadastrarTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		cadastrarTitle.setBounds(200, 20, 300, 30);
		contentPane.add(cadastrarTitle);
		
		campoNome = new JTextField();
		campoNome.setBounds(50, 160, 300, 30);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(50, 280, 300, 30);
		contentPane.add(campoEndereco);
		
		try {
			campoTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(50, 400, 300, 30);
		contentPane.add(campoTelefone);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(50, 520, 300, 30);
		contentPane.add(campoEmail);
		
		JLabel nomeTitle = new JLabel("Nome");
		nomeTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		nomeTitle.setBounds(50, 120, 300, 20);
		contentPane.add(nomeTitle);
		
		JLabel enderecoTitle = new JLabel("Endereço");
		enderecoTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		enderecoTitle.setBounds(50, 240, 300, 20);
		contentPane.add(enderecoTitle);
		
		JLabel telefoneTitle = new JLabel("Telefone");
		telefoneTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		telefoneTitle.setBounds(50, 360, 300, 20);
		contentPane.add(telefoneTitle);
		
		JLabel emailTitle = new JLabel("Email");
		emailTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		emailTitle.setBounds(50, 480, 300, 20);
		contentPane.add(emailTitle);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(EditoraController.cadastrarEditora(campoNome.getText(), campoEndereco.getText(), campoTelefone.getText(), campoEmail.getText())) {
					JOptionPane.showMessageDialog(contentPane, "Editora cadastrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		btnCadastrar.setBounds(150, 600, 125, 20);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setFocusPainted(false);
		btnCadastrar.setForeground(new Color(128, 128, 0));
		btnCadastrar.setBackground(new Color(240,240,240));
		contentPane.add(btnCadastrar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(425, 600, 125, 20);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusPainted(false);
		btnCancelar.setForeground(new Color(128, 128, 0));
		btnCancelar.setBackground(new Color(240,240,240));
		contentPane.add(btnCancelar);
	}
}
