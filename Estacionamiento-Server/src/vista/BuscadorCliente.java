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
import javax.swing.JTextArea;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import modelo.Cliente;
import controlador.Controlador;
import java.awt.Font;



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
	private JLabel labelPersonasAutorizadas;
	private JScrollPane scrollPane;
	private JLabel lblVehiculos;
	private JLabel lblCocheras;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextArea textAreaVehiculos;
	private JTextArea textAreaCocheras;
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
		
	public BuscadorCliente() {
		initGUI();
	}

	public BuscadorCliente(CobroExtraordinario cobroExtraordinario) {
		this.cobroExtraordinario=cobroExtraordinario;
		initGUI();
//TODO HAY QUE SETTEAR AL CLIENTE ELEGIDO
		cobroExtraordinario.cobroExtraOrdinarioSetCliente(cliente);
	}
	

	@SuppressWarnings("unchecked")
	public void initGUI(){
		setTitle("Buscar Clientes");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBuscar.setBounds(10, 19, 105, 14);
		contentPane.add(lblBuscar);

		buscarTextField = new JTextField();
		buscarTextField.setBounds(78, 15, 302, 25);
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


		buscarButton = new JButton("Buscar");
		buscarButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		buscarButton.addActionListener(this);
		buscarButton.setBounds(518, 11, 116, 32);
		contentPane.add(buscarButton);
		buscarButton.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/search.png")));

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 510, 6);
		contentPane.add(separator);

		tipoComboBox = new JComboBox();
		tipoComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		tipoComboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI/LU", "CUIT", "NOMBRE", "APELLIDO"}));
		tipoComboBox.setBounds(392, 14, 114, 25);
		contentPane.add(tipoComboBox);

		panelAtributos = new JPanel();
		panelAtributos.setBounds(518, 52, 503, 554);
		contentPane.add(panelAtributos);
		GridBagLayout gbl_panelAtributos = new GridBagLayout();
		gbl_panelAtributos.columnWidths = new int[]{0, 327, 0};
		gbl_panelAtributos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 40, 40, 0};
		gbl_panelAtributos.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAtributos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		panelAtributos.add(labelEstadoCuentaCorriente, gbc_labelEstadoCuentaCorriente);

		textFieldEstadoCuentaCorriente = new JTextField();
		textFieldEstadoCuentaCorriente.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldEstadoCuentaCorriente.setEnabled(false);
		textFieldEstadoCuentaCorriente.setEditable(false);
		textFieldEstadoCuentaCorriente.setColumns(10);
		GridBagConstraints gbc_textFieldEstadoCuentaCorriente = new GridBagConstraints();
		gbc_textFieldEstadoCuentaCorriente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEstadoCuentaCorriente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEstadoCuentaCorriente.gridx = 1;
		gbc_textFieldEstadoCuentaCorriente.gridy = 10;
		panelAtributos.add(textFieldEstadoCuentaCorriente, gbc_textFieldEstadoCuentaCorriente);

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

		labelPersonasAutorizadas = new JLabel("Personas Autorizadas:");
		labelPersonasAutorizadas.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelPersonasAutorizadas = new GridBagConstraints();
		gbc_labelPersonasAutorizadas.fill = GridBagConstraints.VERTICAL;
		gbc_labelPersonasAutorizadas.anchor = GridBagConstraints.EAST;
		gbc_labelPersonasAutorizadas.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonasAutorizadas.gridx = 0;
		gbc_labelPersonasAutorizadas.gridy = 12;
		panelAtributos.add(labelPersonasAutorizadas, gbc_labelPersonasAutorizadas);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 12;
		panelAtributos.add(scrollPane, gbc_scrollPane);

		JTextArea textAreaPersonasAutorizadas = new JTextArea();
		scrollPane.setViewportView(textAreaPersonasAutorizadas);
		textAreaPersonasAutorizadas.setEnabled(false);
		textAreaPersonasAutorizadas.setEditable(false);

		lblVehiculos = new JLabel("Vehiculos:");
		lblVehiculos.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblVehiculos = new GridBagConstraints();
		gbc_lblVehiculos.fill = GridBagConstraints.VERTICAL;
		gbc_lblVehiculos.anchor = GridBagConstraints.EAST;
		gbc_lblVehiculos.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehiculos.gridx = 0;
		gbc_lblVehiculos.gridy = 13;
		panelAtributos.add(lblVehiculos, gbc_lblVehiculos);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 13;
		panelAtributos.add(scrollPane_1, gbc_scrollPane_1);

		textAreaVehiculos = new JTextArea();
		textAreaVehiculos.setEnabled(false);
		textAreaVehiculos.setEditable(false);
		scrollPane_1.setViewportView(textAreaVehiculos);

		lblCocheras = new JLabel("Cocheras:");
		lblCocheras.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCocheras = new GridBagConstraints();
		gbc_lblCocheras.fill = GridBagConstraints.VERTICAL;
		gbc_lblCocheras.anchor = GridBagConstraints.EAST;
		gbc_lblCocheras.insets = new Insets(0, 0, 0, 5);
		gbc_lblCocheras.gridx = 0;
		gbc_lblCocheras.gridy = 14;
		panelAtributos.add(lblCocheras, gbc_lblCocheras);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 14;
		panelAtributos.add(scrollPane_2, gbc_scrollPane_2);

		textAreaCocheras = new JTextArea();
		textAreaCocheras.setEnabled(false);
		textAreaCocheras.setEditable(false);
		scrollPane_2.setViewportView(textAreaCocheras);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonCancelar.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(103, 637, 159, 42);
		contentPane.add(buttonCancelar);
		buttonCancelar.addActionListener(this);

		buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonAceptar.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/ok.png")));
		buttonAceptar.setBounds(307, 637, 166, 42);
		contentPane.add(buttonAceptar);
		buttonAceptar.addActionListener(this);
		
		panelClientes = new JPanel();
		panelClientes.setBounds(10, 46, 503, 560);
		contentPane.add(panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{240, 0};
		gbl_panelClientes.rowHeights = new int[]{2, 0};
		gbl_panelClientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelClientes.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelClientes.setLayout(gbl_panelClientes);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneClientes = new GridBagConstraints();
		gbc_scrollPaneClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClientes.gridx = 0;
		gbc_scrollPaneClientes.gridy = 0;
		panelClientes.add(scrollPaneClientes, gbc_scrollPaneClientes);

		listModel = new DefaultListModel<Cliente>();
		for (Cliente clienteTemp : Controlador.getInstancia().getClientes()) {
			listModel.addElement(clienteTemp);
		} 
		listClientes = new JList(listModel);
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPaneClientes.setViewportView(listClientes);
		listClientes.addListSelectionListener(this);

		btnVerCuentaCorriente = new JButton("Ver Cuenta Corriente");
		btnVerCuentaCorriente.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVerCuentaCorriente.setBounds(800, 637, 221, 43);
		contentPane.add(btnVerCuentaCorriente);
		btnVerCuentaCorriente.addActionListener(this);

		this.setLocationRelativeTo(null);
		setModal(true);
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.buscarButton){
			listModel.clear();
			for (Cliente clienteTemp : Controlador.getInstancia().getClientes()) {
				listModel.addElement(clienteTemp);
			} 
			if(!buscarTextField.getText().isEmpty())
			{
				ArrayList<Cliente> listaABorrar = new ArrayList<Cliente>();
				if(tipoComboBox.getSelectedItem().toString().equals("DNI/LU")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if(!clienteTemp.getNumeroDocumento().contains(this.buscarTextField.getText())){
							listaABorrar.add(clienteTemp);
						}
					}
				}
				if(tipoComboBox.getSelectedItem().toString().equals("CUIT")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if(!clienteTemp.getCuil().contains(this.buscarTextField.getText())){
							listaABorrar.add(clienteTemp);
						}
					}
				}
				if(tipoComboBox.getSelectedItem().toString().equals("NOMBRE")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if(!clienteTemp.getNombre().toLowerCase().contains(this.buscarTextField.getText().toLowerCase())){
							listaABorrar.add(clienteTemp);
						}
					}
				}
				if(tipoComboBox.getSelectedItem().toString().equals("APELLIDO")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Cliente clienteTemp = listModel.getElementAt(i);
						if(!clienteTemp.getApellido().toLowerCase().contains(this.buscarTextField.getText().toLowerCase())){
							listaABorrar.add(clienteTemp);
							
						}
					}
				}
				for (Cliente clienteABorrar : listaABorrar) {
					listModel.removeElement(clienteABorrar);
				}
			}
		}
		if(e.getSource() == this.buttonAceptar){
			Controlador.getInstancia().setClienteActual((Cliente) listClientes.getSelectedValue());
			dispose();
		}
		if(e.getSource() == this.buttonCancelar){
			Controlador.getInstancia().setClienteActual(null);
			dispose();
		}
		if(e.getSource()==this.btnVerCuentaCorriente)
		{
			Controlador.getInstancia().setClienteActual((Cliente) listClientes.getSelectedValue());
			VerMovimientosCC verMovimientoCC = new VerMovimientosCC();
			verMovimientoCC.setVisible(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listClientes){
			Cliente clienteSeleccionado = (Cliente) this.listClientes.getSelectedValue();
			this.textFieldApellido.setText(clienteSeleccionado.getApellido());
			this.textFieldCUIT.setText(clienteSeleccionado.getCuil());
			this.textFieldDireccion1.setText(clienteSeleccionado.getDescripcion());
			this.textFieldDireccion2.setText(clienteSeleccionado.getDireccion2());
			this.textFieldDNILU.setText(clienteSeleccionado.getNumeroDocumento());
			this.textFieldEmail.setText(clienteSeleccionado.getCorreoElectronico());
			this.textFieldNombre.setText(clienteSeleccionado.getNombre());
			this.textFieldRazonSocial.setText(clienteSeleccionado.getRazonSocial());
			this.textFieldTelefono1.setText(clienteSeleccionado.getTelefono1());
			this.textFieldTelefono2.setText(clienteSeleccionado.getTelefono2());
			//TODO completar listas
		}
		
	}
}

