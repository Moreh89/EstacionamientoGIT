package vista;

import java.awt.EventQueue;
import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;

import controlador.Controlador;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BuscardorCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField buscarTextField;
	private DefaultTableModel model;
//	private ArrayList <PacienteDTO> pacientes;
	private JComboBox comboBox;
	
	
	private TableRowSorter<TableModel> sorter;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono1;
	private JTextField textFieldTelefono2;
	private JTextField textFieldDireccion1;
	private JTextField textFieldDireccion2;
	private JTextField textFieldEmail;
	private JTextField textFieldRazonSocial;
	private JLabel labelEmail;
	private JTextField textFieldEstadoCuentaCorriente;
	private JTextField textFieldEstadoCliente;
	private JLabel labelEstadoCliente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscardorCliente frame = new BuscardorCliente();
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
	public BuscardorCliente() {
		initGUI();
	}
	
	
	public void initGUI(){
		setTitle("Buscar Clientes");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 19, 46, 14);
		contentPane.add(lblBuscar);
		
		buscarTextField = new JTextField();
		buscarTextField.setBounds(53, 14, 217, 25);
		contentPane.add(buscarTextField);
		buscarTextField.setColumns(10);
		model = new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Tipo Doc.");
		model.addColumn("Numero");
		
		
		JButton buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
				
			}
		});
		buscarButton.setBounds(404, 7, 116, 32);
		contentPane.add(buscarButton);
		buscarButton.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/search.png")));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 510, 6);
		contentPane.add(separator);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LRE", "LU", "Apellido"}));
		comboBox.setBounds(280, 14, 114, 25);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 384, 336);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panel.add(labelNombre, gbc_labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setEnabled(false);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 0;
		gbc_labelApellido.gridy = 1;
		panel.add(labelApellido, gbc_labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEnabled(false);
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 1;
		panel.add(textFieldApellido, gbc_textFieldApellido);
		
		JLabel labelTelefono1 = new JLabel("Telefono 1:");
		GridBagConstraints gbc_labelTelefono1 = new GridBagConstraints();
		gbc_labelTelefono1.anchor = GridBagConstraints.EAST;
		gbc_labelTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono1.gridx = 0;
		gbc_labelTelefono1.gridy = 2;
		panel.add(labelTelefono1, gbc_labelTelefono1);
		
		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setEnabled(false);
		textFieldTelefono1.setEditable(false);
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 2;
		panel.add(textFieldTelefono1, gbc_textFieldTelefono1);
		
		JLabel labelTelefono2 = new JLabel("Telefono 2:");
		GridBagConstraints gbc_labelTelefono2 = new GridBagConstraints();
		gbc_labelTelefono2.anchor = GridBagConstraints.EAST;
		gbc_labelTelefono2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono2.gridx = 0;
		gbc_labelTelefono2.gridy = 3;
		panel.add(labelTelefono2, gbc_labelTelefono2);
		
		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setEnabled(false);
		textFieldTelefono2.setEditable(false);
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono2.gridx = 1;
		gbc_textFieldTelefono2.gridy = 3;
		panel.add(textFieldTelefono2, gbc_textFieldTelefono2);
		
		JLabel labelDireccion1 = new JLabel("Direccion 1:");
		GridBagConstraints gbc_labelDireccion1 = new GridBagConstraints();
		gbc_labelDireccion1.anchor = GridBagConstraints.EAST;
		gbc_labelDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion1.gridx = 0;
		gbc_labelDireccion1.gridy = 4;
		panel.add(labelDireccion1, gbc_labelDireccion1);
		
		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setEnabled(false);
		textFieldDireccion1.setEditable(false);
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 4;
		panel.add(textFieldDireccion1, gbc_textFieldDireccion1);
		
		JLabel labelDireccion2 = new JLabel("Direccion 2:");
		GridBagConstraints gbc_labelDireccion2 = new GridBagConstraints();
		gbc_labelDireccion2.anchor = GridBagConstraints.EAST;
		gbc_labelDireccion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion2.gridx = 0;
		gbc_labelDireccion2.gridy = 5;
		panel.add(labelDireccion2, gbc_labelDireccion2);
		
		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setEnabled(false);
		textFieldDireccion2.setEditable(false);
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion2.gridx = 1;
		gbc_textFieldDireccion2.gridy = 5;
		panel.add(textFieldDireccion2, gbc_textFieldDireccion2);
		
		labelEmail = new JLabel("Email:");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.EAST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 6;
		panel.add(labelEmail, gbc_labelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEnabled(false);
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 6;
		panel.add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel labelRazonSocial = new JLabel("Razon Social:");
		GridBagConstraints gbc_labelRazonSocial = new GridBagConstraints();
		gbc_labelRazonSocial.anchor = GridBagConstraints.EAST;
		gbc_labelRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_labelRazonSocial.gridx = 0;
		gbc_labelRazonSocial.gridy = 7;
		panel.add(labelRazonSocial, gbc_labelRazonSocial);
		
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setEnabled(false);
		textFieldRazonSocial.setEditable(false);
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazonSocial.gridx = 1;
		gbc_textFieldRazonSocial.gridy = 7;
		panel.add(textFieldRazonSocial, gbc_textFieldRazonSocial);
		
		JLabel labelEstadoCuentaCorriente = new JLabel("Estado Cuenta:");
		GridBagConstraints gbc_labelEstadoCuentaCorriente = new GridBagConstraints();
		gbc_labelEstadoCuentaCorriente.anchor = GridBagConstraints.EAST;
		gbc_labelEstadoCuentaCorriente.insets = new Insets(0, 0, 5, 5);
		gbc_labelEstadoCuentaCorriente.gridx = 0;
		gbc_labelEstadoCuentaCorriente.gridy = 8;
		panel.add(labelEstadoCuentaCorriente, gbc_labelEstadoCuentaCorriente);
		
		textFieldEstadoCuentaCorriente = new JTextField();
		textFieldEstadoCuentaCorriente.setEnabled(false);
		textFieldEstadoCuentaCorriente.setEditable(false);
		textFieldEstadoCuentaCorriente.setColumns(10);
		GridBagConstraints gbc_textFieldEstadoCuentaCorriente = new GridBagConstraints();
		gbc_textFieldEstadoCuentaCorriente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEstadoCuentaCorriente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEstadoCuentaCorriente.gridx = 1;
		gbc_textFieldEstadoCuentaCorriente.gridy = 8;
		panel.add(textFieldEstadoCuentaCorriente, gbc_textFieldEstadoCuentaCorriente);
		
		labelEstadoCliente = new JLabel("Estado Cliente:");
		GridBagConstraints gbc_labelEstadoCliente = new GridBagConstraints();
		gbc_labelEstadoCliente.insets = new Insets(0, 0, 0, 5);
		gbc_labelEstadoCliente.anchor = GridBagConstraints.EAST;
		gbc_labelEstadoCliente.gridx = 0;
		gbc_labelEstadoCliente.gridy = 9;
		panel.add(labelEstadoCliente, gbc_labelEstadoCliente);
		
		textFieldEstadoCliente = new JTextField();
		textFieldEstadoCliente.setEnabled(false);
		textFieldEstadoCliente.setEditable(false);
		textFieldEstadoCliente.setColumns(10);
		GridBagConstraints gbc_textFieldEstadoCliente = new GridBagConstraints();
		gbc_textFieldEstadoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEstadoCliente.gridx = 1;
		gbc_textFieldEstadoCliente.gridy = 9;
		panel.add(textFieldEstadoCliente, gbc_textFieldEstadoCliente);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(404, 223, 116, 32);
		contentPane.add(buttonCancelar);
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/ok.png")));
		buttonAceptar.setBounds(404, 279, 116, 86);
		contentPane.add(buttonAceptar);
		
		llenarTabla();
		
		this.setLocationRelativeTo(null);
		//setAlwaysOnTop(true);
		setModal(true);
	}
	
	@SuppressWarnings("unused")
	private void filtrar() {
		ArrayList<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		RowFilter<TableModel, Object> rf = null;
		int indiceColumnaTabla = 2;
		switch (comboBox.getSelectedIndex()) {
		case 0: indiceColumnaTabla = 3;break;//DNI
		case 1: indiceColumnaTabla = 4;break;//Apellido
		case 2: indiceColumnaTabla = 2;break;//Nombre
		}
		try {
			String text = buscarTextField.getText();
		    String[] textArray = text.split(" ");

		    for (int i = 0; i < textArray.length; i++) {
		        rfs.add(RowFilter.regexFilter("(?i)" + textArray[i], 0, 1, 2, 4));
		    }	
			
		    rf = RowFilter.andFilter(rfs);	
		} catch (java.util.regex.PatternSyntaxException e) {
		}
		sorter.setRowFilter(rf);
		}
	
	public void llenarTabla()
	{
//		pacientes = Sistema.getInstancia().getPacientes();
//
//		model.setNumRows(pacientes.size());
//		for (int i = 0; i < pacientes.size(); i++) {
//			model.setValueAt(pacientes.get(i).getNombre(), i, 0);
//			model.setValueAt(pacientes.get(i).getApellido(), i,1);
//			model.setValueAt(pacientes.get(i).getTipoDoc(), i, 2);	
//			model.setValueAt(pacientes.get(i).getDni(), i, 3);		
//		}
//		
//		table.setModel(model);
//		sorter = new TableRowSorter<TableModel>(model);
//		table.setRowSorter(sorter);
		
	}
}

