package vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

import modelo.Cliente;
import modelo.Cochera;
import modelo.PersonaAutorizada;
import modelo.Vehiculo;
import controlador.Controlador;

import java.awt.Font;
import javax.swing.SwingConstants;




@SuppressWarnings("rawtypes")
public class BuscadorCliente extends JDialog implements ActionListener, KeyListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField buscarTextField;
	private DefaultTableModel model;
	private JComboBox tipoComboBox;
	@SuppressWarnings("unused")
	private CobroExtraordinario cobroExtraordinario;
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
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JLabel lblDnilu;
	private JLabel lblCuit;
	private JTextField textFieldDNILU;
	private JTextField textFieldCUIT;
	private modelo.Cliente cliente = null;
	private JButton buscarButton;
	private JPanel panelClientes;
	private JScrollPane scrollPaneClientes;
	private JList listClientes;
	private DefaultListModel<Cliente> listModel;
	private JButton buttonCancelar;
	private JButton buttonAceptar;
	private JLabel labelEstadoCuentaCorriente;
	private JLabel labelRazonSocial;
	private JLabel labelDireccion2;
	private JLabel labelDireccion1;
	private JLabel labelTelefono2;
	private JLabel labelTelefono1;
	private JLabel labelApellido;
	private JLabel labelNombre;
	private JPanel panelAtributos;
	private JButton btnVerCuentaCorriente;
	private JList<PersonaAutorizada> listPersonas;
	private DefaultListModel<PersonaAutorizada> listModelPersonas;
	private JList<Vehiculo> listVehiculos;
	private DefaultListModel<Vehiculo> listModelVehiculos;
	private JList<Cochera> listCocheras;
	private DefaultListModel<Cochera> listModelCocheras;
	private JLabel lblTipoCliente;
	private JTextField textFieldTipoCliente;
	private JLabel lblDescripcion;
	private JTextField textFieldDescripcion;
	private JButton btnPersonasAutorizadas;
	private JButton btnVehiculos;
	private JButton btnCocheras;
	private JPanel panelElementos;
	private JLabel lblFechaAlta;
	private JTextField textFieldFechaAlta;
		
	public BuscadorCliente() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initGUI();
	}

	public BuscadorCliente(CobroExtraordinario cobroExtraordinario) {
		this.cobroExtraordinario=cobroExtraordinario;
		initGUI();
		// HAY QUE SETTEAR AL CLIENTE ELEGIDO
		cobroExtraordinario.cobroExtraOrdinarioSetCliente(cliente);
	}
	

	@SuppressWarnings("unchecked")
	public void initGUI(){
	
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				BuscadorCliente.class.getResource("/image/printer.png")));
		setTitle("Buscar Clientes");
		setResizable(true);
		setBounds(100, 100, 1372, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 252, 45, 73, 121, 116, 166,
				221, 0 };
		gbl_contentPane.rowHeights = new int[] { 32, 560, 43, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		buscarTextField = new JTextField();
		GridBagConstraints gbc_buscarTextField = new GridBagConstraints();
		gbc_buscarTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarTextField.insets = new Insets(0, 0, 5, 5);
		gbc_buscarTextField.gridwidth = 3;
		gbc_buscarTextField.gridx = 0;
		gbc_buscarTextField.gridy = 0;
		contentPane.add(buscarTextField, gbc_buscarTextField);
		buscarTextField.setColumns(10);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblBuscar = new GridBagConstraints();
		gbc_lblBuscar.anchor = GridBagConstraints.WEST;
		gbc_lblBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscar.gridx = 0;
		gbc_lblBuscar.gridy = 0;
		contentPane.add(lblBuscar, gbc_lblBuscar);

		tipoComboBox = new JComboBox();
		tipoComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		tipoComboBox.setModel(new DefaultComboBoxModel(new String[] {"APELLIDO", "NOMBRE", "DNI/LU", "CUIT"}));
		GridBagConstraints gbc_tipoComboBox = new GridBagConstraints();
		gbc_tipoComboBox.anchor = GridBagConstraints.WEST;
		gbc_tipoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_tipoComboBox.gridx = 3;
		gbc_tipoComboBox.gridy = 0;
		contentPane.add(tipoComboBox, gbc_tipoComboBox);

		buscarButton = new JButton("Buscar");
		buscarButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		buscarButton.addActionListener(this);
		GridBagConstraints gbc_buscarButton = new GridBagConstraints();
		gbc_buscarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarButton.insets = new Insets(0, 0, 5, 5);
		gbc_buscarButton.gridx = 4;
		gbc_buscarButton.gridy = 0;
		contentPane.add(buscarButton, gbc_buscarButton);
		buscarButton.setIcon(new ImageIcon(BuscadorCliente.class
				.getResource("/image/search.png")));

		panelClientes = new JPanel();
		GridBagConstraints gbc_panelClientes = new GridBagConstraints();
		gbc_panelClientes.fill = GridBagConstraints.BOTH;
		gbc_panelClientes.insets = new Insets(0, 0, 5, 5);
		gbc_panelClientes.gridwidth = 4;
		gbc_panelClientes.gridx = 0;
		gbc_panelClientes.gridy = 1;
		contentPane.add(panelClientes, gbc_panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[] { 240, 0 };
		gbl_panelClientes.rowHeights = new int[] { 2, 0 };
		gbl_panelClientes.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelClientes.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelClientes.setLayout(gbl_panelClientes);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneClientes = new GridBagConstraints();
		gbc_scrollPaneClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClientes.gridx = 0;
		gbc_scrollPaneClientes.gridy = 0;
		panelClientes.add(scrollPaneClientes, gbc_scrollPaneClientes);
		listModel = new DefaultListModel<Cliente>();
		listClientes = new JList(listModel);
		listClientes
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneClientes.setViewportView(listClientes);
		listClientes.addListSelectionListener(this);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridwidth = 5;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);

		panelAtributos = new JPanel();
		GridBagConstraints gbc_panelAtributos = new GridBagConstraints();
		gbc_panelAtributos.fill = GridBagConstraints.BOTH;
		gbc_panelAtributos.insets = new Insets(0, 0, 5, 5);
		gbc_panelAtributos.gridwidth = 2;
		gbc_panelAtributos.gridx = 4;
		gbc_panelAtributos.gridy = 1;
		contentPane.add(panelAtributos, gbc_panelAtributos);
		GridBagLayout gbl_panelAtributos = new GridBagLayout();
		gbl_panelAtributos.columnWidths = new int[] { 0, 327, 0 };
		gbl_panelAtributos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 40, 40, 0 };
		gbl_panelAtributos.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelAtributos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		panelAtributos.setLayout(gbl_panelAtributos);

		labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panelAtributos.add(labelNombre, gbc_labelNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldNombre.setEditable(false);
		textFieldNombre.setEnabled(false);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		panelAtributos.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		labelApellido = new JLabel("Apellido:");
		labelApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 0;
		gbc_labelApellido.gridy = 1;
		panelAtributos.add(labelApellido, gbc_labelApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldApellido.setEnabled(false);
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 1;
		panelAtributos.add(textFieldApellido, gbc_textFieldApellido);

		lblDnilu = new JLabel("DNI/LU:");
		lblDnilu.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDnilu = new GridBagConstraints();
		gbc_lblDnilu.fill = GridBagConstraints.VERTICAL;
		gbc_lblDnilu.anchor = GridBagConstraints.EAST;
		gbc_lblDnilu.insets = new Insets(0, 0, 5, 5);
		gbc_lblDnilu.gridx = 0;
		gbc_lblDnilu.gridy = 2;
		panelAtributos.add(lblDnilu, gbc_lblDnilu);

		textFieldDNILU = new JTextField();
		textFieldDNILU.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldDNILU.setEnabled(false);
		textFieldDNILU.setEditable(false);
		textFieldDNILU.setColumns(10);
		GridBagConstraints gbc_textFieldDNILU = new GridBagConstraints();
		gbc_textFieldDNILU.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDNILU.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDNILU.gridx = 1;
		gbc_textFieldDNILU.gridy = 2;
		panelAtributos.add(textFieldDNILU, gbc_textFieldDNILU);

		lblCuit = new JLabel("CUIT:");
		lblCuit.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCuit = new GridBagConstraints();
		gbc_lblCuit.anchor = GridBagConstraints.EAST;
		gbc_lblCuit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuit.gridx = 0;
		gbc_lblCuit.gridy = 3;
		panelAtributos.add(lblCuit, gbc_lblCuit);

		textFieldCUIT = new JTextField();
		textFieldCUIT.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldCUIT.setEnabled(false);
		textFieldCUIT.setEditable(false);
		textFieldCUIT.setColumns(10);
		GridBagConstraints gbc_textFieldCUIT = new GridBagConstraints();
		gbc_textFieldCUIT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCUIT.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCUIT.gridx = 1;
		gbc_textFieldCUIT.gridy = 3;
		panelAtributos.add(textFieldCUIT, gbc_textFieldCUIT);

		labelTelefono1 = new JLabel("Telefono 1:");
		labelTelefono1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelTelefono1 = new GridBagConstraints();
		gbc_labelTelefono1.anchor = GridBagConstraints.EAST;
		gbc_labelTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono1.gridx = 0;
		gbc_labelTelefono1.gridy = 4;
		panelAtributos.add(labelTelefono1, gbc_labelTelefono1);

		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldTelefono1.setEnabled(false);
		textFieldTelefono1.setEditable(false);
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 4;
		panelAtributos.add(textFieldTelefono1, gbc_textFieldTelefono1);

		labelTelefono2 = new JLabel("Telefono 2:");
		labelTelefono2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelTelefono2 = new GridBagConstraints();
		gbc_labelTelefono2.anchor = GridBagConstraints.EAST;
		gbc_labelTelefono2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono2.gridx = 0;
		gbc_labelTelefono2.gridy = 5;
		panelAtributos.add(labelTelefono2, gbc_labelTelefono2);

		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldTelefono2.setEnabled(false);
		textFieldTelefono2.setEditable(false);
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.gridx = 1;
		gbc_textFieldTelefono2.gridy = 5;
		panelAtributos.add(textFieldTelefono2, gbc_textFieldTelefono2);

		labelDireccion1 = new JLabel("Direccion 1:");
		labelDireccion1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelDireccion1 = new GridBagConstraints();
		gbc_labelDireccion1.anchor = GridBagConstraints.EAST;
		gbc_labelDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion1.gridx = 0;
		gbc_labelDireccion1.gridy = 6;
		panelAtributos.add(labelDireccion1, gbc_labelDireccion1);

		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldDireccion1.setEnabled(false);
		textFieldDireccion1.setEditable(false);
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 6;
		panelAtributos.add(textFieldDireccion1, gbc_textFieldDireccion1);

		labelDireccion2 = new JLabel("Direccion 2:");
		labelDireccion2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelDireccion2 = new GridBagConstraints();
		gbc_labelDireccion2.anchor = GridBagConstraints.EAST;
		gbc_labelDireccion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion2.gridx = 0;
		gbc_labelDireccion2.gridy = 7;
		panelAtributos.add(labelDireccion2, gbc_labelDireccion2);

		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldDireccion2.setEnabled(false);
		textFieldDireccion2.setEditable(false);
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.gridx = 1;
		gbc_textFieldDireccion2.gridy = 7;
		panelAtributos.add(textFieldDireccion2, gbc_textFieldDireccion2);

		labelEmail = new JLabel("Email:");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.EAST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 8;
		panelAtributos.add(labelEmail, gbc_labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldEmail.setEnabled(false);
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 8;
		panelAtributos.add(textFieldEmail, gbc_textFieldEmail);

		labelRazonSocial = new JLabel("Razon Social:");
		labelRazonSocial.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelRazonSocial = new GridBagConstraints();
		gbc_labelRazonSocial.anchor = GridBagConstraints.EAST;
		gbc_labelRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_labelRazonSocial.gridx = 0;
		gbc_labelRazonSocial.gridy = 9;
		panelAtributos.add(labelRazonSocial, gbc_labelRazonSocial);

		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldRazonSocial.setEnabled(false);
		textFieldRazonSocial.setEditable(false);
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.gridx = 1;
		gbc_textFieldRazonSocial.gridy = 9;
		panelAtributos.add(textFieldRazonSocial, gbc_textFieldRazonSocial);

		labelEstadoCuentaCorriente = new JLabel("Estado Cuenta:");
		labelEstadoCuentaCorriente.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelEstadoCuentaCorriente = new GridBagConstraints();
		gbc_labelEstadoCuentaCorriente.anchor = GridBagConstraints.EAST;
		gbc_labelEstadoCuentaCorriente.insets = new Insets(0, 0, 5, 5);
		gbc_labelEstadoCuentaCorriente.gridx = 0;
		gbc_labelEstadoCuentaCorriente.gridy = 10;
		panelAtributos.add(labelEstadoCuentaCorriente,
				gbc_labelEstadoCuentaCorriente);

		textFieldEstadoCuentaCorriente = new JTextField();
		textFieldEstadoCuentaCorriente.setEnabled(false);
		textFieldEstadoCuentaCorriente
				.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldEstadoCuentaCorriente.setEditable(false);
		textFieldEstadoCuentaCorriente.setColumns(10);
		GridBagConstraints gbc_textFieldEstadoCuentaCorriente = new GridBagConstraints();
		gbc_textFieldEstadoCuentaCorriente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEstadoCuentaCorriente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEstadoCuentaCorriente.gridx = 1;
		gbc_textFieldEstadoCuentaCorriente.gridy = 10;
		panelAtributos.add(textFieldEstadoCuentaCorriente,
				gbc_textFieldEstadoCuentaCorriente);

		labelEstadoCliente = new JLabel("Estado Cliente:");
		labelEstadoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelEstadoCliente = new GridBagConstraints();
		gbc_labelEstadoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_labelEstadoCliente.anchor = GridBagConstraints.EAST;
		gbc_labelEstadoCliente.gridx = 0;
		gbc_labelEstadoCliente.gridy = 11;
		panelAtributos.add(labelEstadoCliente, gbc_labelEstadoCliente);

		textFieldEstadoCliente = new JTextField();
		textFieldEstadoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldEstadoCliente.setEnabled(false);
		textFieldEstadoCliente.setEditable(false);
		textFieldEstadoCliente.setColumns(10);
		GridBagConstraints gbc_textFieldEstadoCliente = new GridBagConstraints();
		gbc_textFieldEstadoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEstadoCliente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEstadoCliente.gridx = 1;
		gbc_textFieldEstadoCliente.gridy = 11;
		panelAtributos.add(textFieldEstadoCliente, gbc_textFieldEstadoCliente);

		lblTipoCliente = new JLabel("Tipo Cliente:");
		lblTipoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblTipoCliente = new GridBagConstraints();
		gbc_lblTipoCliente.anchor = GridBagConstraints.EAST;
		gbc_lblTipoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoCliente.gridx = 0;
		gbc_lblTipoCliente.gridy = 12;
		panelAtributos.add(lblTipoCliente, gbc_lblTipoCliente);

		textFieldTipoCliente = new JTextField();
		textFieldTipoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldTipoCliente.setEnabled(false);
		textFieldTipoCliente.setEditable(false);
		textFieldTipoCliente.setColumns(10);
		GridBagConstraints gbc_textFieldTipoCliente = new GridBagConstraints();
		gbc_textFieldTipoCliente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTipoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTipoCliente.gridx = 1;
		gbc_textFieldTipoCliente.gridy = 12;
		panelAtributos.add(textFieldTipoCliente, gbc_textFieldTipoCliente);

		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 13;
		panelAtributos.add(lblDescripcion, gbc_lblDescripcion);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldDescripcion.setEnabled(false);
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setColumns(10);
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcion.gridx = 1;
		gbc_textFieldDescripcion.gridy = 13;
		panelAtributos.add(textFieldDescripcion, gbc_textFieldDescripcion);
		
		lblFechaAlta = new JLabel("Fecha Alta:");
		lblFechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
		gbc_lblFechaAlta.anchor = GridBagConstraints.EAST;
		gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaAlta.gridx = 0;
		gbc_lblFechaAlta.gridy = 14;
		panelAtributos.add(lblFechaAlta, gbc_lblFechaAlta);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setEditable(false);
		textFieldFechaAlta.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldFechaAlta.setColumns(10);
		GridBagConstraints gbc_textFieldFechaAlta = new GridBagConstraints();
		gbc_textFieldFechaAlta.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFechaAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaAlta.gridx = 1;
		gbc_textFieldFechaAlta.gridy = 14;
		panelAtributos.add(textFieldFechaAlta, gbc_textFieldFechaAlta);
		listModelPersonas = new DefaultListModel<PersonaAutorizada>();
		listModelVehiculos = new DefaultListModel<Vehiculo>();
		listModelCocheras = new DefaultListModel<Cochera>();
		
		panelElementos = new JPanel();
		GridBagConstraints gbc_panelElementos = new GridBagConstraints();
		gbc_panelElementos.insets = new Insets(0, 0, 5, 0);
		gbc_panelElementos.fill = GridBagConstraints.BOTH;
		gbc_panelElementos.gridx = 6;
		gbc_panelElementos.gridy = 1;
		contentPane.add(panelElementos, gbc_panelElementos);
		GridBagLayout gbl_panelElementos = new GridBagLayout();
		gbl_panelElementos.columnWidths = new int[]{404, 0};
		gbl_panelElementos.rowHeights = new int[]{96, 0, 96, 0, 96, 0, 0};
		gbl_panelElementos.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelElementos.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelElementos.setLayout(gbl_panelElementos);
				
						scrollPane = new JScrollPane();
						GridBagConstraints gbc_scrollPane = new GridBagConstraints();
						gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane.fill = GridBagConstraints.BOTH;
						gbc_scrollPane.gridx = 0;
						gbc_scrollPane.gridy = 0;
						panelElementos.add(scrollPane, gbc_scrollPane);
						scrollPane
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						listPersonas = new JList(listModelPersonas);
						listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(listPersonas);
				
				btnPersonasAutorizadas = new JButton("Personas Autorizadas");
				GridBagConstraints gbc_btnPersonasAutorizadas = new GridBagConstraints();
				gbc_btnPersonasAutorizadas.insets = new Insets(0, 0, 5, 0);
				gbc_btnPersonasAutorizadas.fill = GridBagConstraints.BOTH;
				gbc_btnPersonasAutorizadas.gridx = 0;
				gbc_btnPersonasAutorizadas.gridy = 1;
				panelElementos.add(btnPersonasAutorizadas, gbc_btnPersonasAutorizadas);
				btnPersonasAutorizadas.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/search.png")));
				btnPersonasAutorizadas.addActionListener(this);
				btnPersonasAutorizadas.setFont(new Font("Tahoma", Font.BOLD, 16));
				
						scrollPane_1 = new JScrollPane();
						GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
						gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
						gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane_1.gridx = 0;
						gbc_scrollPane_1.gridy = 2;
						panelElementos.add(scrollPane_1, gbc_scrollPane_1);
						scrollPane_1
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						listVehiculos = new JList(listModelVehiculos);
						listVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane_1.setViewportView(listVehiculos);
				
				btnVehiculos = new JButton("Vehiculos");
				GridBagConstraints gbc_btnVehiculos = new GridBagConstraints();
				gbc_btnVehiculos.insets = new Insets(0, 0, 5, 0);
				gbc_btnVehiculos.fill = GridBagConstraints.BOTH;
				gbc_btnVehiculos.gridx = 0;
				gbc_btnVehiculos.gridy = 3;
				panelElementos.add(btnVehiculos, gbc_btnVehiculos);
				btnVehiculos.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/search.png")));
				btnVehiculos.addActionListener(this);
				btnVehiculos.setFont(new Font("Tahoma", Font.BOLD, 16));
				
						scrollPane_2 = new JScrollPane();
						GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
						gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
						gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane_2.gridx = 0;
						gbc_scrollPane_2.gridy = 4;
						panelElementos.add(scrollPane_2, gbc_scrollPane_2);
						scrollPane_2
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						listCocheras = new JList(listModelCocheras);
						listCocheras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane_2.setViewportView(listCocheras);
						
						btnCocheras = new JButton("Cocheras");
						GridBagConstraints gbc_btnCocheras = new GridBagConstraints();
						gbc_btnCocheras.fill = GridBagConstraints.BOTH;
						gbc_btnCocheras.gridx = 0;
						gbc_btnCocheras.gridy = 5;
						panelElementos.add(btnCocheras, gbc_btnCocheras);
						btnCocheras.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/search.png")));
						btnCocheras.addActionListener(this);
						btnCocheras.setFont(new Font("Tahoma", Font.BOLD, 16));

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonCancelar.setIcon(new ImageIcon(BuscadorCliente.class
				.getResource("/image/cancel.png")));
		GridBagConstraints gbc_buttonCancelar = new GridBagConstraints();
		gbc_buttonCancelar.fill = GridBagConstraints.BOTH;
		gbc_buttonCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonCancelar.gridx = 0;
		gbc_buttonCancelar.gridy = 2;
		contentPane.add(buttonCancelar, gbc_buttonCancelar);
		buttonCancelar.addActionListener(this);

		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonAceptar.setIcon(new ImageIcon(BuscadorCliente.class
				.getResource("/image/ok.png")));
		GridBagConstraints gbc_buttonAceptar = new GridBagConstraints();
		gbc_buttonAceptar.fill = GridBagConstraints.BOTH;
		gbc_buttonAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonAceptar.gridwidth = 3;
		gbc_buttonAceptar.gridx = 1;
		gbc_buttonAceptar.gridy = 2;
		contentPane.add(buttonAceptar, gbc_buttonAceptar);
		buttonAceptar.addActionListener(this);
		model = new DefaultTableModel() {
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

		btnVerCuentaCorriente = new JButton("Ver Cuenta Corriente");
		btnVerCuentaCorriente.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnVerCuentaCorriente = new GridBagConstraints();
		gbc_btnVerCuentaCorriente.fill = GridBagConstraints.BOTH;
		gbc_btnVerCuentaCorriente.gridx = 6;
		gbc_btnVerCuentaCorriente.gridy = 2;
		contentPane.add(btnVerCuentaCorriente, gbc_btnVerCuentaCorriente);
		btnVerCuentaCorriente.addActionListener(this);

		Controlador.getInstancia().actualizarClientes();
		
		listModel.clear();
		for (Cliente clienteTemp : Controlador.getInstancia().getClientes()) {
			listModel.addElement(clienteTemp);
		}

		this.setLocationRelativeTo(null);
		//Hace que esperes a que se cierre para seguir con lo demas
		this.setModal(true); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.btnCocheras) {
			if (listCocheras.getSelectedValue() != null){
				new VerCochera(listCocheras.getSelectedValue()).setVisible(true);
				}
		}
		if (e.getSource() == this.btnPersonasAutorizadas) {
			if (listPersonas.getSelectedValue() != null){
				new VerPersonaAutorizada(listPersonas.getSelectedValue()).setVisible(true);
				}
		}
		if (e.getSource() == this.btnVehiculos) {
			if (listVehiculos.getSelectedValue() != null){
				new VerVehiculo(listVehiculos.getSelectedValue()).setVisible(true);
				}
		}

		if (e.getSource() == this.buscarButton) {
			limpiarCampos();
			listModel.clear();
			for (Cliente clienteTemp : Controlador.getInstancia().getClientes()) {
				listModel.addElement(clienteTemp);
			}
			if (!buscarTextField.getText().isEmpty()) {
				ArrayList<Cliente> listaABorrar = new ArrayList<Cliente>();
				if (tipoComboBox.getSelectedItem().toString().equals("DNI/LU")) {
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if (!clienteTemp.getNumeroDocumento().contains(
								this.buscarTextField.getText())) {
							listaABorrar.add(clienteTemp);
						}
					}
				}
				if (tipoComboBox.getSelectedItem().toString().equals("CUIT")) {
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if (!clienteTemp.getCuil().contains(
								this.buscarTextField.getText())) {
							listaABorrar.add(clienteTemp);
						}
					}
				}
				if (tipoComboBox.getSelectedItem().toString().equals("NOMBRE")) {
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if (!clienteTemp
								.getNombre()
								.toLowerCase()
								.contains(
										this.buscarTextField.getText()
												.toLowerCase())) {
							listaABorrar.add(clienteTemp);
						}
					}
				}
				if (tipoComboBox.getSelectedItem().toString()
						.equals("APELLIDO")) {
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if (!clienteTemp
								.getApellido()
								.toLowerCase()
								.contains(
										this.buscarTextField.getText()
												.toLowerCase())) {
							listaABorrar.add(clienteTemp);

						}
					}
				}
				for (Cliente clienteABorrar : listaABorrar) {
					listModel.removeElement(clienteABorrar);
				}
			}
		}
		if (e.getSource() == this.buttonAceptar) {
			Controlador.getInstancia().setClienteActual(
					(Cliente) listClientes.getSelectedValue());
			dispose();
		}
		if (e.getSource() == this.buttonCancelar) {
			Controlador.getInstancia().setClienteActual(null);
			dispose();
		}
		if(e.getSource()==this.btnVerCuentaCorriente)
		{
			Controlador.getInstancia().setClienteActual((Cliente) listClientes.getSelectedValue());
			if(Controlador.getInstancia().getClienteActual()!=null)
			new VerMovimientosCC().setVisible(true);
		}
	}

	private void limpiarCampos() {
		this.textFieldApellido.setText("");
		this.textFieldCUIT.setText("");
		this.textFieldDireccion1.setText("");
		this.textFieldDireccion2.setText("");
		this.textFieldDNILU.setText("");
		this.textFieldEmail.setText("");
		this.textFieldNombre.setText("");
		this.textFieldRazonSocial.setText("");
		this.textFieldTelefono1.setText("");
		this.textFieldTelefono2.setText("");
		this.textFieldEstadoCliente.setText("");
		this.textFieldDescripcion.setText("");
		this.textFieldTipoCliente.setText("");
		this.textFieldEstadoCuentaCorriente.setText("");
		this.listModelCocheras.clear();
		this.listModelPersonas.clear();
		this.listModelVehiculos.clear();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listClientes && (Cliente) this.listClientes.getSelectedValue() != null){
			Cliente clienteSeleccionado = (Cliente) this.listClientes.getSelectedValue();
			this.textFieldApellido.setText(clienteSeleccionado.getApellido());
			this.textFieldCUIT.setText(clienteSeleccionado.getCuil());
			this.textFieldDireccion1.setText(clienteSeleccionado.getDireccion());
			this.textFieldDireccion2.setText(clienteSeleccionado.getDireccion2());
			this.textFieldDNILU.setText(clienteSeleccionado.getNumeroDocumento());
			this.textFieldEmail.setText(clienteSeleccionado.getCorreoElectronico());
			this.textFieldNombre.setText(clienteSeleccionado.getNombre());
			this.textFieldRazonSocial.setText(clienteSeleccionado.getRazonSocial());
			this.textFieldTelefono1.setText(clienteSeleccionado.getTelefono1());
			this.textFieldTelefono2.setText(clienteSeleccionado.getTelefono2());
			this.textFieldEstadoCliente.setText(clienteSeleccionado.getEstado().toString());
			this.textFieldDescripcion.setText(clienteSeleccionado.getDescripcion());
			this.textFieldTipoCliente.setText(clienteSeleccionado.getTipoCliente().toString());
			double estadoCrediticio=clienteSeleccionado.getEstadoCrediticio(clienteSeleccionado);
			if(estadoCrediticio<0)
			{
				textFieldEstadoCuentaCorriente.setDisabledTextColor(Color.RED);

			}
			else
			{
				textFieldEstadoCuentaCorriente.setDisabledTextColor(Color.GREEN);

			}
			this.textFieldEstadoCuentaCorriente.setText(String.valueOf(Math.round(estadoCrediticio)));
			this.listModelCocheras.clear();
			this.listModelPersonas.clear();
			this.listModelVehiculos.clear();
			for(Cochera cochera : clienteSeleccionado.getCocheras()){
				this.listModelCocheras.addElement(cochera);
			}
			for(PersonaAutorizada persona : clienteSeleccionado.getPersonasAutorizadasARetirar()){
				this.listModelPersonas.addElement(persona);
			}
			for(Vehiculo vehiculo : clienteSeleccionado.getVehiculos()){
				this.listModelVehiculos.addElement(vehiculo);
			}
		}
		
	}
}

