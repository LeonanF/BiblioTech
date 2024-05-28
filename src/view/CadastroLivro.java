package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.EditoraDAO;
import controller.LivroController;
import model.Editora;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastroLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEditora;
	private JTextField campoEdicao;
	private JTextField campoAutor;
	private JTextField campoISBN;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadastrarTitle = new JLabel("CADASTRAR LIVRO");
		cadastrarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		cadastrarTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		cadastrarTitle.setBounds(200, 20, 300, 30);
		contentPane.add(cadastrarTitle);
		
		campoNome = new JTextField();
		campoNome.setBounds(50, 160, 300, 30);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoEditora = new JTextField();
		campoEditora.setColumns(10);
		campoEditora.setBounds(50, 260, 300, 30);
		contentPane.add(campoEditora);

		campoEdicao = new JTextField();
		campoEdicao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c))
					e.consume();
			}
		});
		campoEdicao.setColumns(10);
		campoEdicao.setBounds(50, 360, 300, 30);
		contentPane.add(campoEdicao);
		
		campoAutor = new JTextField();
		campoAutor.setColumns(10);
		campoAutor.setBounds(360, 160, 300, 30);
		contentPane.add(campoAutor);
		
		
		JLabel nomeTitle = new JLabel("Nome");
		nomeTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		nomeTitle.setBounds(50, 120, 300, 20);
		contentPane.add(nomeTitle);
		
		JLabel editoraTitle = new JLabel("Editora");
		editoraTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		editoraTitle.setBounds(50, 220, 300, 20);
		contentPane.add(editoraTitle);
		
		JLabel edicaoTitle = new JLabel("Edição");
		edicaoTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		edicaoTitle.setBounds(50, 320, 300, 20);
		contentPane.add(edicaoTitle);
		
		JLabel isbnTitle = new JLabel("ISBN");
		isbnTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		isbnTitle.setBounds(360, 320, 300, 20);
		contentPane.add(isbnTitle);
		
		
		JLabel generoTitle = new JLabel("Gênero");
		generoTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		generoTitle.setBounds(360, 220, 300, 20);
		contentPane.add(generoTitle);
		
		campoISBN = new JTextField();
		campoISBN.setColumns(10);
		campoISBN.setBounds(360, 360, 300, 30);
		contentPane.add(campoISBN);
		
		JLabel autorTitle = new JLabel("Autor");
		autorTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		autorTitle.setBounds(360, 120, 300, 20);
		contentPane.add(autorTitle);
		
		JComboBox generoBox = new JComboBox();
		generoBox.setModel(new DefaultComboBoxModel(new String[] {"", "Ação", "Aventura", "Romance", "Fantasia", "Literatura clássica", "Autoajuda", "Ciência de Dados"}));
		generoBox.setSelectedIndex(0);
		generoBox.setBounds(360, 260, 300, 30);
		contentPane.add(generoBox);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campoNome.getText().isBlank()||campoISBN.getText().isBlank()||campoAutor.getText().isBlank()||campoEditora.getText().isBlank()||campoEdicao.getText().isBlank()||generoBox.getSelectedIndex()==-1)
				{
					JOptionPane.showMessageDialog(contentPane, "Todos os campos devem ser preenchidos", "Alerta", JOptionPane.WARNING_MESSAGE);
				    return;
				}
				
				Editora editora = EditoraDAO.buscarEditora(campoEditora.getText());
				if(editora==null) {
					JOptionPane.showMessageDialog(contentPane, "Cadastre a editora primeiro!", "Alerta", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(LivroController.cadastrarLivro(campoNome.getText(), campoAutor.getText(), (String) generoBox.getSelectedItem(), campoISBN.getText(), Integer.parseInt(campoEdicao.getText()), editora)) {
					JOptionPane.showMessageDialog(contentPane, "Livro cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Erro ao adicionar ao banco de dados. Verifique os dados para evitar duplicata.", "Alerta", JOptionPane.WARNING_MESSAGE);
					return;
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
