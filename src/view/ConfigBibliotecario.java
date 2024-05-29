package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.EditoraDAO;
import DAO.UsuarioDAO;
import controller.EditoraController;
import controller.LivroController;
import model.Editora;
import model.Usuario;

import java.awt.Panel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ConfigBibliotecario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField txtCurso;
	private JTextField txtMatricula;
	private JTextField campoNome;
	private JTextField campoEndereco;
	private JTextField campoTelefone;
	private JTextField campoEmail;
	private JTextField nomeLivro;
	private JTextField autorLivro;
	private JTextField editoraLivro;
	
	private JTextField edicaoLivro;
	private JTextField isbnLivro;

	public ConfigBibliotecario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 44, 664, 572);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Cadastrar Aluno", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO DE ALUNO");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(240, 11, 206, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 51, 46, 14);
		panel.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 76, 285, 20);
		panel.add(txtNome);
		
		JLabel lblNewLabel_2_1 = new JLabel("E-mail");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 127, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 152, 285, 20);
		panel.add(txtEmail);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Senha");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(10, 207, 46, 14);
		panel.add(lblNewLabel_2_1_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 232, 285, 20);
		panel.add(txtSenha);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Curso");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 291, 46, 14);
		panel.add(lblNewLabel_2_1_1_1);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(10, 316, 285, 20);
		panel.add(txtCurso);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Matrícula");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(10, 376, 65, 14);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(10, 401, 285, 20);
		panel.add(txtMatricula);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nome, email, senha, curso, matricula;

					
					nome = txtNome.getText();
					email = txtEmail.getText();
					senha = new String (txtSenha.getPassword());
					curso = txtCurso.getText();
					matricula = txtMatricula.getText(); 
					
					
		            if (nome.isEmpty() ||email.isEmpty() || senha.isEmpty() || curso.isEmpty() || matricula.isEmpty() ) {
		            	JOptionPane.showMessageDialog(contentPane, "Todos os campos devem ser preenchidos.", "Alerta", JOptionPane.WARNING_MESSAGE);
		            } else {
		                Usuario usuario = new Usuario(Integer.parseInt(matricula), nome, senha, email, curso);

		               if (UsuarioDAO.cadastrarUsuario(usuario)) {
		            	   JOptionPane.showMessageDialog(contentPane, "Aluno cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                	JOptionPane.showMessageDialog(contentPane, "Dados inseridos incorretamente. Tente novamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
		                }
		            }
		        } catch (Exception erro) {
		            JOptionPane.showMessageDialog(null, "Erro no frmUsuarioVIEW: " + erro);
		        }
				
			}
		});
		btnCadastrarAluno.setForeground(new Color(128, 128, 0));
		btnCadastrarAluno.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrarAluno.setFocusPainted(false);
		btnCadastrarAluno.setBackground(new Color(240,240,240));
		btnCadastrarAluno.setBounds(64, 466, 160, 31);
		panel.add(btnCadastrarAluno);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("./img/cadastrar.png"));
		lblNewLabel_2_2.setBounds(342, 99, 267, 273);
		panel.add(lblNewLabel_2_2);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Cadastrar Livro", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("CADASTRO DE LIVRO");
		lblNewLabel_1_1.setBounds(239, 11, 189, 25);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Nome");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(10, 49, 46, 14);
		panel_1.add(lblNewLabel_2_4);
		
		nomeLivro = new JTextField();
		nomeLivro.setColumns(10);
		nomeLivro.setBounds(10, 74, 285, 20);
		panel_1.add(nomeLivro);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Autor");
		lblNewLabel_2_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_3.setBounds(10, 118, 46, 14);
		panel_1.add(lblNewLabel_2_1_3);
		
		autorLivro = new JTextField();
		autorLivro.setColumns(10);
		autorLivro.setBounds(10, 143, 285, 20);
		panel_1.add(autorLivro);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Editora");
		lblNewLabel_2_1_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_3_1.setBounds(10, 181, 46, 14);
		panel_1.add(lblNewLabel_2_1_3_1);
		
		editoraLivro = new JTextField();
		editoraLivro.setColumns(10);
		editoraLivro.setBounds(10, 206, 285, 20);
		panel_1.add(editoraLivro);
		
		JLabel lblNewLabel_2_1_3_1_1 = new JLabel("Gênero");
		lblNewLabel_2_1_3_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_3_1_1.setBounds(10, 237, 59, 14);
		panel_1.add(lblNewLabel_2_1_3_1_1);
		
		JComboBox generoBox = new JComboBox();
		generoBox.setModel(new DefaultComboBoxModel(new String[] {"", "Ação", "Aventura", "Romance", "Fantasia", "Literatura clássica", "Autoajuda", "Ciência de Dados"}));
		generoBox.setSelectedIndex(0);
		generoBox.setBounds(10, 262, 285, 25);
		panel_1.add(generoBox);
		
		JLabel lblNewLabel_2_1_3_1_1_1 = new JLabel("Edição");
		lblNewLabel_2_1_3_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_3_1_1_1.setBounds(10, 316, 59, 14);
		panel_1.add(lblNewLabel_2_1_3_1_1_1);
		
		edicaoLivro = new JTextField();
		edicaoLivro.setColumns(10);
		edicaoLivro.setBounds(10, 341, 285, 20);
		panel_1.add(edicaoLivro);
		
		JLabel lblNewLabel_2_1_3_1_1_1_1 = new JLabel("ISBN");
		lblNewLabel_2_1_3_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_3_1_1_1_1.setBounds(10, 388, 59, 14);
		panel_1.add(lblNewLabel_2_1_3_1_1_1_1);
		
		isbnLivro = new JTextField();
		isbnLivro.setColumns(10);
		isbnLivro.setBounds(10, 413, 285, 20);
		panel_1.add(isbnLivro);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomeLivro.getText().isBlank()||isbnLivro.getText().isBlank()||autorLivro.getText().isBlank()||editoraLivro.getText().isBlank()||edicaoLivro.getText().isBlank()||generoBox.getSelectedIndex()==-1)
				{
					JOptionPane.showMessageDialog(contentPane, "Todos os campos devem ser preenchidos", "Alerta", JOptionPane.WARNING_MESSAGE);
				    return;
				}
				
				Editora editora = EditoraDAO.buscarEditora(editoraLivro.getText());
				if(editora==null) {
					JOptionPane.showMessageDialog(contentPane, "Cadastre a editora primeiro!", "Alerta", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(LivroController.cadastrarLivro(nomeLivro.getText(), autorLivro.getText(), (String) generoBox.getSelectedItem(), isbnLivro.getText(), Integer.parseInt(edicaoLivro.getText()), editora)) {
					JOptionPane.showMessageDialog(contentPane, "Livro cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Erro ao adicionar ao banco de dados. Verifique os dados para evitar duplicata.", "Alerta", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		btnCadastrarLivro.setForeground(new Color(128, 128, 0));
		btnCadastrarLivro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrarLivro.setFocusPainted(false);
		btnCadastrarLivro.setBackground(UIManager.getColor("Button.background"));
		btnCadastrarLivro.setBounds(69, 478, 160, 31);
		panel_1.add(btnCadastrarLivro);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("./img/cadastrar-livro.png"));
		lblNewLabel_4.setBounds(356, 131, 247, 252);
		panel_1.add(lblNewLabel_4);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Cadastrar Editora", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CADASTRO DE EDITORA");
		lblNewLabel_1_1_1.setBounds(237, 11, 220, 25);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nome");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(10, 58, 46, 14);
		panel_2.add(lblNewLabel_2_3);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(10, 83, 285, 20);
		panel_2.add(campoNome);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Endereço");
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(10, 156, 69, 14);
		panel_2.add(lblNewLabel_2_1_2);
		
		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(10, 181, 285, 20);
		panel_2.add(campoEndereco);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Telefone");
		lblNewLabel_2_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1.setBounds(10, 257, 69, 14);
		panel_2.add(lblNewLabel_2_1_2_1);
		try {
			campoTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			campoTelefone.setBounds(10, 282, 285, 20);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		campoTelefone.setColumns(10);
		panel_2.add(campoTelefone);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("E-mail");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_2_1_1.setBounds(10, 357, 69, 14);
		panel_2.add(lblNewLabel_2_1_2_1_1);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(10, 382, 285, 20);
		panel_2.add(campoEmail);
		
		JButton btnCadastrarEditora = new JButton("Cadastrar");
		btnCadastrarEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (campoNome.getText().isBlank() || campoEndereco.getText().isBlank() || campoTelefone.getText().isBlank() || campoEmail.getText().isBlank()) {
				    JOptionPane.showMessageDialog(contentPane, "Todos os campos devem ser preenchidos.", "Alerta", JOptionPane.WARNING_MESSAGE);
				    return;
				}

				if (EditoraController.cadastrarEditora(campoNome.getText(), campoEndereco.getText(), campoTelefone.getText(), campoEmail.getText())) {
				    JOptionPane.showMessageDialog(contentPane, "Editora cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
				    JOptionPane.showMessageDialog(contentPane, "Erro ao adicionar ao banco de dados. Verifique os dados para evitar duplicata.", "Alerta", JOptionPane.WARNING_MESSAGE);
				}}
		});
		btnCadastrarEditora.setForeground(new Color(128, 128, 0));
		btnCadastrarEditora.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrarEditora.setFocusPainted(false);
		btnCadastrarEditora.setBackground(new Color(240,240,240));
		btnCadastrarEditora.setBounds(70, 462, 160, 31);
		panel_2.add(btnCadastrarEditora);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("./img/editora.png"));
		lblNewLabel_3.setBounds(349, 86, 263, 312);
		panel_2.add(lblNewLabel_3);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Atualizar Livros", null, panel_3, null);
		
		JLabel lblNewLabel = new JLabel("PAINEL DE CONTROLE");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		lblNewLabel.setBounds(195, 11, 291, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial objpaginainicial = new PaginaInicial();
				objpaginainicial.setVisible(true);
				
				dispose();
			}
		});
		btnDeslogar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDeslogar.setBounds(281, 627, 105, 23);
		btnDeslogar.setForeground(new Color(128, 128, 0));
		btnDeslogar.setBackground(new Color(240,240,240));
		btnDeslogar.setFocusPainted(false);
		contentPane.add(btnDeslogar);
	}
}
