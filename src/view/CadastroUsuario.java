package view;

import java.awt.Color;
import javax.swing.JPasswordField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import model.Usuario;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

class CadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField txtCurso;
	private JTextField txtMatricula;

	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR USUÁRIO");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel.setBounds(198, 11, 308, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 84, 47, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 109, 285, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 168, 47, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 193, 285, 20);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Senha");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 254, 55, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 279, 285, 20);
		contentPane.add(txtSenha);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Curso");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 344, 62, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(10, 369, 285, 20);
		contentPane.add(txtCurso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nome, email, senha, curso, matricula;

					
					nome = txtNome.getText();
					email = txtEmail.getText();
					senha = new String (txtSenha.getPassword());
					curso = txtCurso.getText();
					matricula = txtMatricula.getText(); 
					
					
		            if (nome.isEmpty() ||email.isEmpty() || senha.isEmpty() || curso.isEmpty() || matricula.isEmpty() ) {
		                JOptionPane.showMessageDialog(btnCadastrar, "Por favor, preencha todos os campos para cadastrar.");
		            } else {
		                Usuario usuario = new Usuario(Integer.parseInt(matricula), nome, senha, email, curso);

		               if (UsuarioDAO.cadastrarUsuario(usuario)) {
		                    JOptionPane.showMessageDialog(btnCadastrar, "Cadastrado com Sucesso!");
		                    dispose();
		                    Menu objpaginainicial = new Menu();
		                    objpaginainicial.setVisible(true);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Dados inseridos incorretamente. Tente novamente!");
		                }
		            }
		        } catch (Exception erro) {
		            JOptionPane.showMessageDialog(null, "Erro no frmUsuarioVIEW: " + erro);
		        }
			}
		});
		
		
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrar.setBounds(198, 532, 172, 37);
		btnCadastrar.setForeground(new Color(128, 128, 0));
		btnCadastrar.setBackground(new Color(240,240,240));
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Matrícula");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 425, 62, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(10, 450, 285, 20);
		contentPane.add(txtMatricula);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial objpaginainicial = new PaginaInicial();
				objpaginainicial.setVisible(true);
				
				dispose();
			}
		});
		btnVoltar.setForeground(new Color(128, 128, 0));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVoltar.setBackground(new Color(240,240,240));
		btnVoltar.setBounds(380, 532, 172, 37);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("./img/cadastrar.png"));
		lblNewLabel_2.setBounds(366, 155, 267, 273);
		contentPane.add(lblNewLabel_2);
		
	
	}
}
