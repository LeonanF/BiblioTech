package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class PaginaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial frame = new PaginaInicial();
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
	public PaginaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PÁGINA INICIAL");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 40));
		lblNewLabel.setBounds(210, 11, 288, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha uma das opções");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(268, 66, 184, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSouAluno = new JButton("Sou Aluno(a)");
		btnSouAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAluno objloginaluno = new LoginAluno();
				objloginaluno.setVisible(true);
				
				dispose();
			}
		});
		btnSouAluno.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSouAluno.setForeground(new Color(128, 128, 0));
		btnSouAluno.setBackground(new Color(240,240,240));
		btnSouAluno.setBounds(228, 144, 242, 61);
		btnSouAluno.setFocusPainted(false);
		contentPane.add(btnSouAluno);
		
		JLabel imagemLivro = new JLabel("");
		imagemLivro.setIcon(new ImageIcon("C:\\Users\\leovi\\OneDrive\\Área de Trabalho\\projeto cornisse\\biblioteca.png"));
		imagemLivro.setBounds(-132, 181, 684, 506);
		contentPane.add(imagemLivro);
		
		JLabel lblNewLabel_3 = new JLabel("By Equipe JLLP");
		lblNewLabel_3.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
		lblNewLabel_3.setBounds(562, 616, 112, 34);
		contentPane.add(lblNewLabel_3);
		
		JButton btnSouBibliotecario = new JButton("Sou Bibliotecário(a)");
		btnSouBibliotecario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginBibliotecario objloginbibliotecario = new LoginBibliotecario();
				objloginbibliotecario.setVisible(true);
				
				dispose();
			}
		});
		btnSouBibliotecario.setForeground(new Color(128, 128, 0));
		btnSouBibliotecario.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSouBibliotecario.setBackground(new Color(240,240,240));
		btnSouBibliotecario.setBounds(228, 243, 242, 61);
		contentPane.add(btnSouBibliotecario);
	}
}
