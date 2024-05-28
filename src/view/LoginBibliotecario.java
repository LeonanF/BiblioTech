package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import model.UsuarioDTO;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginBibliotecario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBibliotecario frame = new LoginBibliotecario();
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
	public LoginBibliotecario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginBibliotecrioa = new JLabel("Login Bibliotecário(a)");
		lblLoginBibliotecrioa.setBounds(127, 11, 199, 25);
		lblLoginBibliotecrioa.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		contentPane.add(lblLoginBibliotecrioa);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 73, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(10, 98, 222, 20);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 146, 54, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 171, 222, 20);
		contentPane.add(txtSenha);
		
		JButton btnLogarBibliotecario = new JButton("Logar");
		btnLogarBibliotecario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogarBibliotecario();
			}
		});
		btnLogarBibliotecario.setForeground(new Color(128, 128, 0));
		btnLogarBibliotecario.setBackground(new Color(240,240,240));
		btnLogarBibliotecario.setFocusPainted(false);
		btnLogarBibliotecario.setBounds(10, 227, 89, 23);
		contentPane.add(btnLogarBibliotecario);
		
		JButton btnVoltarAluno = new JButton("Voltar");
		btnVoltarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial objpaginainicial = new PaginaInicial();
				objpaginainicial.setVisible(true);
				
				dispose();
			}
		});
		btnVoltarAluno.setForeground(new Color(128, 128, 0));
		btnVoltarAluno.setBackground(new Color(240,240,240));
		btnVoltarAluno.setFocusPainted(false);
		btnVoltarAluno.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltarAluno);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\leovi\\OneDrive\\Área de Trabalho\\projeto cornisse\\login-bibliotecario.png"));
		lblNewLabel.setBounds(276, 83, 148, 116);
		contentPane.add(lblNewLabel);
	}
	
	
	private void LogarBibliotecario() {
		try {
            String usuario_bibliotecario, senha_bibliotecario;

            usuario_bibliotecario = txtUsuario.getText();
            senha_bibliotecario = new String (txtSenha.getPassword());

            // verifica se algum campo está vazio
            if (usuario_bibliotecario.isEmpty() || senha_bibliotecario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos para fazer login.");
            } else {
                UsuarioDTO objusuariodto = new UsuarioDTO();
                objusuariodto.setUsuario_bibliotecario(usuario_bibliotecario);
                objusuariodto.setSenha_bibliotecario(senha_bibliotecario);

                UsuarioDAO objusuariodao = new UsuarioDAO();
                ResultSet rsusuariodao = objusuariodao.autenticacaoBibliotecario(objusuariodto);

                if (rsusuariodao.next()) {
                    ConfigBibliotecario objconfigbibliotecario = new ConfigBibliotecario();
                    objconfigbibliotecario.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos");
                }
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no LoginBliotecario: " + erro);
        }

    }

}
