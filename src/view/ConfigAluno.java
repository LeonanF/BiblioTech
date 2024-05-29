package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controller.LivroController;
import model.Livro;

public class ConfigAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeLivro;
	private JTextField autorLivro;
	private JTextField generoLivro;
	private JTextField isbnLivro;
	private JTable table;


	public ConfigAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDooAluno = new JLabel("PAINEL DO ALUNO");
		lblPainelDooAluno.setBounds(227, 11, 247, 35);
		lblPainelDooAluno.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		contentPane.add(lblPainelDooAluno);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 54, 664, 566);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Consultar Livros", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA DE LIVROS");
		lblNewLabel_1.setBounds(216, 11, 209, 25);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(100, 52, 46, 14);
		panel.add(lblNewLabel_2);
		
		nomeLivro = new JTextField();
		nomeLivro.setColumns(10);
		nomeLivro.setBounds(100, 77, 150, 20);
		panel.add(nomeLivro);
		
		JLabel lblNewLabel_2_1 = new JLabel("Autor");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(400, 52, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		autorLivro = new JTextField();
		autorLivro.setColumns(10);
		autorLivro.setBounds(400, 77, 150, 20);
		panel.add(autorLivro);
		
		JLabel lblNewLabel_2_2 = new JLabel("Gênero");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(100, 139, 73, 14);
		panel.add(lblNewLabel_2_2);
		
		generoLivro = new JTextField();
		generoLivro.setColumns(10);
		generoLivro.setBounds(100, 164, 150, 20);
		panel.add(generoLivro);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("ISBN");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(400, 139, 73, 14);
		panel.add(lblNewLabel_2_2_1);
		
		isbnLivro = new JTextField();
		isbnLivro.setColumns(10);
		isbnLivro.setBounds(400, 164, 150, 20);
		panel.add(isbnLivro);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = nomeLivro.getText().trim();
                String autor = autorLivro.getText().trim();
                String genero = generoLivro.getText().trim();
                String isbn = isbnLivro.getText().trim();

              
                List<Livro> livros = LivroController.consultarLivros(
                    titulo.isEmpty() ? null : titulo,
                    autor.isEmpty() ? null : autor,
                    genero.isEmpty() ? null : genero,
                    isbn.isEmpty() ? null : isbn
                );

               
                if (livros.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Nenhum livro encontrado ou não existe.", "Informação", JOptionPane.WARNING_MESSAGE);
                    return;
                }

               
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); 

                for (Livro livro : livros) {
                    model.addRow(new Object[]{
                        livro.getNome(),
                        livro.getAutor(),
                        livro.getGenero(),
                        livro.getISBN(),
                        livro.getEditora().getNome(),
                        "Disponível" 
                    });
                    
                    limparCampo();
		}}
			});
		btnConsultar.setForeground(new Color(128, 128, 0));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBackground(new Color(240,240,240));
		btnConsultar.setBounds(275, 213, 105, 23);
		panel.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 639, 280);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Autor", "G\u00EAnero", "ISBN", "Editora", "Disponibilidade"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Reservar Livros", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Emprestar Livros", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Renovar Empréstimo", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Devolver Livros", null, panel_4, null);
		panel_4.setLayout(null);
	}
	
	private void limparCampo() {
		nomeLivro.setText("");
		autorLivro.setText("");
		generoLivro.setText("");
		isbnLivro.requestFocus();
	}
}
