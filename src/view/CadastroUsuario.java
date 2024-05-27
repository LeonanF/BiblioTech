package view;

import java.awt.EventQueue;
import javax.swing.JPasswordField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import model.UsuarioDTO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField txtCurso;
	private JTextField txtMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Usuário");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel.setBounds(212, 11, 285, 37);
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
					
					
					// verifica se algum campo está vazio
		            if (nome.isEmpty() ||email.isEmpty() || senha.isEmpty() || curso.isEmpty() || matricula.isEmpty() ) {
		                JOptionPane.showMessageDialog(btnCadastrar, "Por favor, preencha todos os campos para cadastrar.");
		            } else {
		                UsuarioDTO objusuariodto = new UsuarioDTO();
		                objusuariodto.setNome_usuario(nome);
		                objusuariodto.setEmail_usuario(email);
		                objusuariodto.setSenha_usuario(senha);
		                objusuariodto.setCurso_usuario(curso);
		                objusuariodto.setMatricula_usuario(Integer.parseInt(matricula));
		                

		                UsuarioDAO objusuariodao = new UsuarioDAO();

		                if (objusuariodao.cadastrarUsuario(objusuariodto)) {
		                    JOptionPane.showMessageDialog(btnCadastrar, "Cadastrado com Sucesso!");
		                    dispose();
		                    PaginaInicial objpaginainicial = new PaginaInicial();
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
		btnCadastrar.setBounds(244, 532, 126, 37);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVoltar.setBounds(380, 532, 126, 37);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Matrícula");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(10, 425, 62, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(10, 450, 285, 20);
		contentPane.add(txtMatricula);
	}
}
