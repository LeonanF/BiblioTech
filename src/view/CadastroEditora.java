package view;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class CadastroEditora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEndereco;
	private JTextField campoTelefone;
	private JTextField campoEmail;

	public CadastroEditora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel cadastrarTitle = new JLabel("CADASTRAR EDITORA");
		cadastrarTitle.setBounds(200, 20, 300, 30);
		cadastrarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		cadastrarTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		contentPane.add(cadastrarTitle);
		
		campoNome = new JTextField();
		campoNome.setBounds(50, 114, 300, 30);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(50, 211, 300, 30);
		campoEndereco.setColumns(10);
		contentPane.add(campoEndereco);
		
		try {
			campoTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			campoTelefone.setBounds(50, 308, 300, 30);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		campoTelefone.setColumns(10);
		contentPane.add(campoTelefone);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(50, 407, 300, 30);
		campoEmail.setColumns(10);
		contentPane.add(campoEmail);
		
		JLabel nomeTitle = new JLabel("Nome");
		nomeTitle.setBounds(50, 83, 300, 20);
		nomeTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(nomeTitle);
		
		JLabel enderecoTitle = new JLabel("Endereço");
		enderecoTitle.setBounds(50, 180, 300, 20);
		enderecoTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(enderecoTitle);
		
		JLabel telefoneTitle = new JLabel("Telefone");
		telefoneTitle.setBounds(50, 277, 300, 20);
		telefoneTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(telefoneTitle);
		
		JLabel emailTitle = new JLabel("E-mail");
		emailTitle.setBounds(50, 376, 300, 20);
		emailTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(emailTitle);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(128, 128, 0));
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCadastrar.setBackground(UIManager.getColor("Button.background"));
		btnCadastrar.setBounds(178, 519, 172, 37);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setForeground(new Color(128, 128, 0));
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCancelar.setBackground(UIManager.getColor("Button.background"));
		btnCancelar.setBounds(359, 519, 172, 37);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./img/editora.png"));
		lblNewLabel.setBounds(393, 125, 263, 312);
		contentPane.add(lblNewLabel);
	}
}
