package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.UsuarioController;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	public LoginAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Aluno(a)");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel.setBounds(165, 11, 140, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 74, 54, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 99, 222, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 145, 54, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 170, 222, 20);
		contentPane.add(txtSenha);
		
		JButton btnLogarAluno = new JButton("Logar");
		btnLogarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogarAluno();
			}
		});
		btnLogarAluno.setBounds(10, 227, 89, 23);
		btnLogarAluno.setForeground(new Color(128, 128, 0));
		btnLogarAluno.setBackground(new Color(240,240,240));
		btnLogarAluno.setFocusPainted(false);
		contentPane.add(btnLogarAluno);
		
		JButton btnVoltarAluno = new JButton("Voltar");
		btnVoltarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial objpaginainicial = new PaginaInicial();
				objpaginainicial.setVisible(true);
				
				dispose();
			}
		});
		btnVoltarAluno.setBounds(335, 227, 89, 23);
		btnVoltarAluno.setForeground(new Color(128, 128, 0));
		btnVoltarAluno.setBackground(new Color(240,240,240));
		btnVoltarAluno.setFocusPainted(false);
		contentPane.add(btnVoltarAluno);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("./img/login-aluno.png"));
		lblNewLabel_2.setBounds(288, 84, 113, 116);
		contentPane.add(lblNewLabel_2);
	}
	
	private void LogarAluno() {

            String email_usuario, senha_usuario;

            email_usuario = txtEmail.getText();
            senha_usuario = new String (txtSenha.getPassword());


            if (email_usuario.isEmpty() || senha_usuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos para fazer login.");
            } else 
            	 try {    ResultSet rs = UsuarioController.autenticacaoAluno(email_usuario, senha_usuario);	
                 if (rs!=null) {
                 	if(rs.next()){
                         ConfigAluno objconfigaluno = new ConfigAluno();
                         objconfigaluno.setVisible(true);
                         dispose();
                     }
                 else {
                         JOptionPane.showMessageDialog(null, "E-mail ou Senha Inválidos");
                 }}
                 }catch(SQLException erro){
                 		erro.printStackTrace();
                 }
        

    }
}

