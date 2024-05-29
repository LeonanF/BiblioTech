package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controller.EmprestimoController;
import controller.LivroController;
import model.Emprestimo;
import model.Livro;
import javax.swing.UIManager;


public class ConfigAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeLivro;
	private JTextField autorLivro;
	private JTextField generoLivro;
	private JTextField isbnLivro;
	private JTable table;
	private String selectedIsbn = "";
	@SuppressWarnings("unused")
	private final String matricula;
	private JTextField matriculaField;
	private JTable table_1;


	public ConfigAluno(String matricula) {
		this.matricula = matricula;
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
		tabbedPane.addTab("Consultar Livros e Reservar Livros", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CONSULTA E RESERVA DE LIVROS");
		lblNewLabel_1.setBounds(173, 11, 314, 25);
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


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 639, 251);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Autor", "G\u00EAnero", "ISBN", "Editora", "Disponibilidade", "Reservas"
			}
		) {
			private static final long serialVersionUID = 1L;
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		});
		
        DefaultTableModel model = (DefaultTableModel) table.getModel();
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = nomeLivro.getText().trim();
                String autor = autorLivro.getText().trim();
                String genero = generoLivro.getText().trim();
                String isbn = isbnLivro.getText().trim();

                
                if(titulo.isBlank() && autor.isBlank() && genero.isBlank() && isbn.isBlank()) {
                	JOptionPane.showMessageDialog(contentPane, "Você deve preencher pelo menos um dos campos!", "Informação", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
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

                     
                model.setRowCount(0); 

                for (Livro livro : livros) {
                    model.addRow(new Object[]{
                        livro.getNome(),
                        livro.getAutor(),
                        livro.getGenero(),
                        livro.getISBN(),
                        livro.getEditora().getNome(),
                        livro.getDisponibilidade(),
                        livro.getReservas()
                    });
                    
                    limparCampo();
		}}
			});
		btnConsultar.setForeground(new Color(128, 128, 0));
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBackground(new Color(240,240,240));
		btnConsultar.setBounds(274, 213, 105, 23);
		panel.add(btnConsultar);
		
		
		
		table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1 && table.getSelectedColumn() != -1) {
		
		            Object isbn = table.getValueAt(table.getSelectedRow(), model.findColumn("ISBN"));
		            selectedIsbn = (String) isbn;
		        }
		    }
		});
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LivroController.reservarLivro(selectedIsbn, matricula)) {
					JOptionPane.showMessageDialog(contentPane, "Reserva feita com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
				} else{
					JOptionPane.showMessageDialog(contentPane, "Você já tem reserva para esse livro.", "Informação", JOptionPane.INFORMATION_MESSAGE);
				};
                model.setRowCount(0); 
			}
		});
		btnReservar.setForeground(new Color(128, 128, 0));
		btnReservar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnReservar.setFocusPainted(false);
		btnReservar.setBackground(new Color(240,240,240));
		btnReservar.setBounds(274, 509, 105, 23);
		panel.add(btnReservar);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Renovar Empréstimo", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Verificação de Empréstimos", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VERIFICAR EMPRÉSTIMO DE LIVRO");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel.setBounds(170, 11, 323, 35);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2_3 = new JLabel("Matrícula");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(287, 84, 68, 14);
		panel_1.add(lblNewLabel_2_3);
		
		matriculaField = new JTextField();
		matriculaField.setColumns(10);
		matriculaField.setBounds(185, 109, 268, 20);
		panel_1.add(matriculaField);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = matriculaField.getText().trim();
                if (!matricula.isEmpty()) {
                    List<Emprestimo> emprestimos = EmprestimoController.buscarEmprestimosPorMatricula(matricula);
                    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
                    model.setRowCount(0); 
                    for (Emprestimo emprestimo : emprestimos) {
                        model.addRow(new Object[]{
                            emprestimo.getId(),
                            emprestimo.getIsbn(),
                            emprestimo.getMatricula(),
                            emprestimo.getDataEmprestimo(),
                            emprestimo.getDataDevolucaoEstimada(),
                            emprestimo.getStatusEmprestimo()
                        });
                    }
                    if (emprestimos.isEmpty()) {
                        JOptionPane.showMessageDialog(contentPane, "Nenhum empréstimo encontrado para a matrícula informada.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Por favor, informe uma matrícula.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                matriculaField.setText("");
            }
			}
		);
		btnVerificar.setForeground(new Color(128, 128, 0));
		btnVerificar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerificar.setFocusPainted(false);
		btnVerificar.setBackground(new Color(240,240,240));
		btnVerificar.setBounds(268, 161, 105, 23);
		panel_1.add(btnVerificar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 217, 639, 310);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "ISBN", "Matricula", "Data_Emprestimo", "Data_Devolucao_Estimada", "Status_Emprestimo"
			}
		));
		table_1.getColumnModel().getColumn(3).setPreferredWidth(98);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(140);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(116);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Devolver Livros", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial objpaginainicial = new PaginaInicial();
				objpaginainicial.setVisible(true);
				
				dispose();
			}
		});
		btnDeslogar.setForeground(new Color(128, 128, 0));
		btnDeslogar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDeslogar.setFocusPainted(false);
		btnDeslogar.setBackground(new Color(240,240,240));
		btnDeslogar.setBounds(557, 627, 117, 23);
		contentPane.add(btnDeslogar);
	}
	
	private void limparCampo() {
		nomeLivro.setText("");
		autorLivro.setText("");
		generoLivro.setText("");
		isbnLivro.setText("");
	}
}
