package br.univel.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import br.univel.enums.Sexo;
import br.univel.model.ModeloClientes;
import br.univel.persistencia.HibernateUtil;
import br.univel.pojo.Cliente;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfSobrenome;
	private JTextField txfIdade;
	private JComboBox cbSexo;
	private JTable table;
	private JButton btnNovo;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private int idCliente = 0;
	private List<Cliente> lista = new ArrayList<Cliente>();
	private ModeloClientes modeloClientes = new ModeloClientes(getClientes());
	private Session session;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Cadastro de Clientes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 569);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCadastroDeClientes);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 236, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);
		
		txfNome = new JTextField();
		txfNome.setEnabled(false);
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 0;
		panel_1.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		GridBagConstraints gbc_lblSobrenome = new GridBagConstraints();
		gbc_lblSobrenome.anchor = GridBagConstraints.EAST;
		gbc_lblSobrenome.insets = new Insets(0, 0, 5, 5);
		gbc_lblSobrenome.gridx = 0;
		gbc_lblSobrenome.gridy = 1;
		panel_1.add(lblSobrenome, gbc_lblSobrenome);
		
		txfSobrenome = new JTextField();
		txfSobrenome.setEnabled(false);
		GridBagConstraints gbc_txfSobrenome = new GridBagConstraints();
		gbc_txfSobrenome.insets = new Insets(0, 0, 5, 0);
		gbc_txfSobrenome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfSobrenome.gridx = 1;
		gbc_txfSobrenome.gridy = 1;
		panel_1.add(txfSobrenome, gbc_txfSobrenome);
		txfSobrenome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		GridBagConstraints gbc_lblIdade = new GridBagConstraints();
		gbc_lblIdade.anchor = GridBagConstraints.EAST;
		gbc_lblIdade.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdade.gridx = 0;
		gbc_lblIdade.gridy = 2;
		panel_1.add(lblIdade, gbc_lblIdade);
		
		txfIdade = new JTextField();
		txfIdade.setEnabled(false);
		GridBagConstraints gbc_txfIdade = new GridBagConstraints();
		gbc_txfIdade.insets = new Insets(0, 0, 5, 0);
		gbc_txfIdade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIdade.gridx = 1;
		gbc_txfIdade.gridy = 2;
		panel_1.add(txfIdade, gbc_txfIdade);
		txfIdade.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 3;
		panel_1.add(lblSexo, gbc_lblSexo);
		
		cbSexo = new JComboBox();
		cbSexo.setEnabled(false);
		cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
		GridBagConstraints gbc_cbSexo = new GridBagConstraints();
		gbc_cbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_cbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSexo.gridx = 1;
		gbc_cbSexo.gridy = 3;
		panel_1.add(cbSexo, gbc_cbSexo);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configurarFields(true);
				table.getSelectionModel().clearSelection();
			}
		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 0;
		panel_2.add(btnNovo, gbc_btnNovo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configurarFields(true);
				preencherDados();
			}
		});
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 1;
		gbc_btnEditar.gridy = 0;
		panel_2.add(btnEditar, gbc_btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0){
					deleteCliente((Integer) table.getValueAt(table.getSelectedRow(), 0));
				}
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 0;
		panel_2.add(btnExcluir, gbc_btnExcluir);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoSalvar();
				configurarFields(false);
			}
		});
		btnSalvar.setEnabled(false);
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 3;
		gbc_btnSalvar.gridy = 0;
		panel_2.add(btnSalvar, gbc_btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configurarFields(false);
			}
		});
		btnCancelar.setEnabled(false);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 0;
		panel_2.add(btnCancelar, gbc_btnCancelar);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		table = new JTable();
		table.setModel(this.modeloClientes);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		
		
		panel_3.add(new JScrollPane(table), gbc_table);
		
	}
	

	public void configurarFields(boolean op){
		if(op){
			txfNome.setText("");
			txfNome.setEnabled(true);
			txfSobrenome.setText("");
			txfSobrenome.setEnabled(true);
			txfIdade.setText("");
			txfIdade.setEnabled(true);
			cbSexo.setEnabled(true);
			btnNovo.setEnabled(false);
			btnEditar.setEnabled(false);
			btnExcluir.setEnabled(false);
			btnSalvar.setEnabled(true);
			btnCancelar.setEnabled(true);
		}else{
			txfNome.setText("");
			txfSobrenome.setText("");
			txfIdade.setText("");
			txfNome.setEnabled(false);
			txfSobrenome.setEnabled(false);
			txfIdade.setEnabled(false);
			cbSexo.setEnabled(false);
			btnNovo.setEnabled(true);
			btnEditar.setEnabled(true);
			btnExcluir.setEnabled(true);
			btnSalvar.setEnabled(false);
			btnCancelar.setEnabled(false);
		}
	}	
	
	public void preencherDados() {
		
		if(table.getSelectedRow() >= 0){
			this.idCliente = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			Cliente c = findCliente(this.idCliente);
			System.out.println(c.getNome());
			txfNome.setText(c.getNome());
			txfSobrenome.setText(c.getSobrenome());
			txfIdade.setText(String.valueOf(c.getIdade()));
			cbSexo.setSelectedItem(c.getSexo());
		}else{
			JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada");
			configurarFields(false);
		}
		
	}
	
	public void acaoSalvar(){
		Cliente c = new Cliente();
		c.setNome(txfNome.getText());
		c.setSobrenome(txfSobrenome.getText());
		c.setIdade(Integer.parseInt(txfIdade.getText()));
		c.setSexo((Sexo) cbSexo.getSelectedItem());
		
		if(this.idCliente == 0){
			insertCliente(c);
		}else{
			updateCliente(c);
		}
		modeloClientes.refresh(getClientes());
	}
	
	public void insertCliente(Cliente c){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(c);
		session.getTransaction().commit();  
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		session.close();
	}
	
	public void updateCliente(Cliente c){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Cliente cl = session.get(Cliente.class, this.idCliente);
		cl.setNome(c.getNome());
		cl.setSobrenome(c.getSobrenome());
		cl.setIdade(c.getIdade());
		cl.setSexo(c.getSexo());
		session.getTransaction().commit();
		session.close();
		this.idCliente = 0;
	}
	
	public Cliente findCliente(int id){
		session = HibernateUtil.getSessionFactory().openSession();
		Cliente cl = session.get(Cliente.class, id);
		session.close();
		return cl;
	}
	
	public void deleteCliente(int id){
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Cliente cl = session.get(Cliente.class, id);
		session.delete(cl);
		session.getTransaction().commit();
		session.close();
		JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
		modeloClientes.refresh(getClientes());
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(){
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Cliente.class);
		this.lista = crit.list();
		session.close();
		return lista;
	}
}
