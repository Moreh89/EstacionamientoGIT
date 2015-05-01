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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

public class AltaCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	
	
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
	private JButton btnAgregarPersonaAutorizada;
	private JTextField textFieldCuentaCorriente;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCliente frame = new AltaCliente();
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
	public AltaCliente() {
		initGUI();
	}
	
	
	public void initGUI(){
		setTitle("Alta Cliente");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 604, 287);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{124, 200, 0, 200, 0};
		gbl_panel.rowHeights = new int[] {28, 28, 28, 28, 30, 35, 35, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panel.add(labelNombre, gbc_labelNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.WEST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 2;
		gbc_labelApellido.gridy = 0;
		panel.add(labelApellido, gbc_labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.gridx = 3;
		gbc_textFieldApellido.gridy = 0;
		panel.add(textFieldApellido, gbc_textFieldApellido);
		
		JLabel labelTelefono1 = new JLabel("Telefono 1:");
		GridBagConstraints gbc_labelTelefono1 = new GridBagConstraints();
		gbc_labelTelefono1.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono1.gridx = 0;
		gbc_labelTelefono1.gridy = 1;
		panel.add(labelTelefono1, gbc_labelTelefono1);
		
		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 1;
		panel.add(textFieldTelefono1, gbc_textFieldTelefono1);
		
		JLabel labelTelefono2 = new JLabel("Telefono 2:");
		GridBagConstraints gbc_labelTelefono2 = new GridBagConstraints();
		gbc_labelTelefono2.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono2.gridx = 2;
		gbc_labelTelefono2.gridy = 1;
		panel.add(labelTelefono2, gbc_labelTelefono2);
		
		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.gridx = 3;
		gbc_textFieldTelefono2.gridy = 1;
		panel.add(textFieldTelefono2, gbc_textFieldTelefono2);
		
		JLabel labelDireccion1 = new JLabel("Direccion 1:");
		GridBagConstraints gbc_labelDireccion1 = new GridBagConstraints();
		gbc_labelDireccion1.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion1.gridx = 0;
		gbc_labelDireccion1.gridy = 2;
		panel.add(labelDireccion1, gbc_labelDireccion1);
		
		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 2;
		panel.add(textFieldDireccion1, gbc_textFieldDireccion1);
		
		JLabel labelDireccion2 = new JLabel("Direccion 2:");
		GridBagConstraints gbc_labelDireccion2 = new GridBagConstraints();
		gbc_labelDireccion2.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion2.gridx = 2;
		gbc_labelDireccion2.gridy = 2;
		panel.add(labelDireccion2, gbc_labelDireccion2);
		
		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.gridx = 3;
		gbc_textFieldDireccion2.gridy = 2;
		panel.add(textFieldDireccion2, gbc_textFieldDireccion2);
		
		labelEmail = new JLabel("Email:");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 3;
		panel.add(labelEmail, gbc_labelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 3;
		panel.add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel labelRazonSocial = new JLabel("Razon Social:");
		GridBagConstraints gbc_labelRazonSocial = new GridBagConstraints();
		gbc_labelRazonSocial.anchor = GridBagConstraints.WEST;
		gbc_labelRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_labelRazonSocial.gridx = 2;
		gbc_labelRazonSocial.gridy = 3;
		panel.add(labelRazonSocial, gbc_labelRazonSocial);
		
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.gridx = 3;
		gbc_textFieldRazonSocial.gridy = 3;
		panel.add(textFieldRazonSocial, gbc_textFieldRazonSocial);
		
		JLabel labelCuentaCorriente = new JLabel("Cuenta Corriente:");
		GridBagConstraints gbc_labelCuentaCorriente = new GridBagConstraints();
		gbc_labelCuentaCorriente.fill = GridBagConstraints.VERTICAL;
		gbc_labelCuentaCorriente.insets = new Insets(0, 0, 5, 5);
		gbc_labelCuentaCorriente.anchor = GridBagConstraints.WEST;
		gbc_labelCuentaCorriente.gridx = 0;
		gbc_labelCuentaCorriente.gridy = 5;
		panel.add(labelCuentaCorriente, gbc_labelCuentaCorriente);
		
		textFieldCuentaCorriente = new JTextField();
		textFieldCuentaCorriente.setEnabled(false);
		textFieldCuentaCorriente.setEditable(false);
		textFieldCuentaCorriente.setColumns(10);
		GridBagConstraints gbc_textFieldCuentaCorriente = new GridBagConstraints();
		gbc_textFieldCuentaCorriente.fill = GridBagConstraints.BOTH;
		gbc_textFieldCuentaCorriente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCuentaCorriente.gridx = 1;
		gbc_textFieldCuentaCorriente.gridy = 5;
		panel.add(textFieldCuentaCorriente, gbc_textFieldCuentaCorriente);
		
		JButton btnAltaCuentaCorriente = new JButton("Alta");
		GridBagConstraints gbc_btnAltaCuentaCorriente = new GridBagConstraints();
		gbc_btnAltaCuentaCorriente.fill = GridBagConstraints.BOTH;
		gbc_btnAltaCuentaCorriente.insets = new Insets(0, 0, 5, 0);
		gbc_btnAltaCuentaCorriente.gridx = 3;
		gbc_btnAltaCuentaCorriente.gridy = 5;
		panel.add(btnAltaCuentaCorriente, gbc_btnAltaCuentaCorriente);
		btnAltaCuentaCorriente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel labelVehiculos = new JLabel("Vehiculos:");
		GridBagConstraints gbc_labelVehiculos = new GridBagConstraints();
		gbc_labelVehiculos.fill = GridBagConstraints.VERTICAL;
		gbc_labelVehiculos.insets = new Insets(0, 0, 5, 5);
		gbc_labelVehiculos.anchor = GridBagConstraints.WEST;
		gbc_labelVehiculos.gridx = 0;
		gbc_labelVehiculos.gridy = 6;
		panel.add(labelVehiculos, gbc_labelVehiculos);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 6;
		panel.add(textArea, gbc_textArea);
		
		JButton button = new JButton("Agregar");
		button.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 3;
		gbc_button.gridy = 6;
		panel.add(button, gbc_button);
		
		JLabel labelPersonaAutorizada = new JLabel("Autorizados:");
		GridBagConstraints gbc_labelPersonaAutorizada = new GridBagConstraints();
		gbc_labelPersonaAutorizada.fill = GridBagConstraints.VERTICAL;
		gbc_labelPersonaAutorizada.anchor = GridBagConstraints.WEST;
		gbc_labelPersonaAutorizada.insets = new Insets(0, 0, 0, 5);
		gbc_labelPersonaAutorizada.gridx = 0;
		gbc_labelPersonaAutorizada.gridy = 7;
		panel.add(labelPersonaAutorizada, gbc_labelPersonaAutorizada);
		
		JTextArea textAreaPersonasAutorizadas = new JTextArea();
		textAreaPersonasAutorizadas.setEditable(false);
		textAreaPersonasAutorizadas.setEnabled(false);
		GridBagConstraints gbc_textAreaPersonasAutorizadas = new GridBagConstraints();
		gbc_textAreaPersonasAutorizadas.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaPersonasAutorizadas.fill = GridBagConstraints.BOTH;
		gbc_textAreaPersonasAutorizadas.gridx = 1;
		gbc_textAreaPersonasAutorizadas.gridy = 7;
		panel.add(textAreaPersonasAutorizadas, gbc_textAreaPersonasAutorizadas);
		
		btnAgregarPersonaAutorizada = new JButton("Agregar");
		GridBagConstraints gbc_btnAgregarPersonaAutorizada = new GridBagConstraints();
		gbc_btnAgregarPersonaAutorizada.fill = GridBagConstraints.BOTH;
		gbc_btnAgregarPersonaAutorizada.gridx = 3;
		gbc_btnAgregarPersonaAutorizada.gridy = 7;
		panel.add(btnAgregarPersonaAutorizada, gbc_btnAgregarPersonaAutorizada);
		btnAgregarPersonaAutorizada.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(212, 305, 116, 32);
		contentPane.add(buttonCancelar);
		
		JButton buttonCrearCliente = new JButton("Crear Cliente");
		buttonCrearCliente.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/ok.png")));
		buttonCrearCliente.setBounds(462, 305, 148, 56);
		contentPane.add(buttonCrearCliente);
		
		llenarTabla();
		
		this.setLocationRelativeTo(null);
		//setAlwaysOnTop(true);
		setModal(true);
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

