package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import modelo.Cochera;
import modelo.PersonaAutorizada;
import modelo.Vehiculo;
import controlador.Controlador;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class AltaCliente extends JFrame implements ActionListener{


	private static final long serialVersionUID = 1L;
	public static JPanel contentPaneAltaCliente;


	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono1;
	private JTextField textFieldTelefono2;
	private JTextField textFieldDireccion1;
	private JTextField textFieldDireccion2;
	private JTextField textFieldEmail;
	private JLabel labelEmail;
	private JButton buttonAgregarPersonaAutorizada;
	private JPanel panelAltaCliente;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelTelefono1;
	private JLabel labelTelefono2;
	private JLabel labelDireccion1;
	private JLabel labelDireccion2;
	private JLabel labelVehiculos;
	private JButton buttonAgregarVehiculo;
	private JLabel labelPersonaAutorizada;
	private JButton buttonCancelar;
	private JButton buttonCrearCliente;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblCocheras;
	private JButton buttonAgregarCocheras;
	private JScrollPane scrollPane_2;
	private JLabel lblCuit;
	private JTextField textFieldCUIT;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipoFactura;
	private ArrayList<modelo.PersonaAutorizada> ListPersonasAutorizadas=new ArrayList<modelo.PersonaAutorizada>();
	private ArrayList<modelo.Vehiculo> ListPatentesVehiculos=new ArrayList<modelo.Vehiculo>();
	private ArrayList<modelo.Cochera> ListCocheras=new ArrayList<modelo.Cochera>();
	private JLabel lblNroDocumentacion;
	private JTextField textFieldNumeroDoc;
	private JLabel Tipo_Doc;
	private JLabel label_2;
	private JTextField textFieldRazonSocial;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipoDoc;
	private JLabel labelTipoCliente;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipoCliente;
	private JLabel lblTipoFactura;
	private JList<modelo.PersonaAutorizada> listPersonasAutorizadas;
	private DefaultListModel<modelo.PersonaAutorizada> listModelPersonas;
	private JList<modelo.Vehiculo> listVehiculos;
	private DefaultListModel<modelo.Vehiculo> listModelVehiculos;
	private JList<modelo.Cochera> listCocheras;
	private DefaultListModel<modelo.Cochera> listModelCocheras;
	private JLabel lblObservacion;
	private JTextField textFieldObservacion;
	private JButton btnEliminarVehiculo;
	private JButton btnEliminarPersona;
	private JButton btnEliminarCochera;
	private JPanel panel;
	private JButton buttonModificarVehiculo;
	private JPanel panel_1;
	private JButton buttonModificarPersona;
	private JPanel panel_2;
	private JButton buttonModificarCochera;
	/**
	 * Create the frame.
	 */
	public AltaCliente() {
		initGUI();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI(){
		setTitle("Alta Cliente");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 560);
		contentPaneAltaCliente = new JPanel();
		contentPaneAltaCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAltaCliente);
		contentPaneAltaCliente.setLayout(null);


		panelAltaCliente = new JPanel();
		panelAltaCliente.setBounds(12, 0, 730, 512);
		contentPaneAltaCliente.add(panelAltaCliente);
		GridBagLayout gbl_panelAltaCliente = new GridBagLayout();
		gbl_panelAltaCliente.columnWidths = new int[]{124, 217, 98, 253, 0};
		gbl_panelAltaCliente.rowHeights = new int[] {28, 28, 28, 28, 28, 28, 28, 60, 59, 60, 0, 28, 0};
		gbl_panelAltaCliente.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelAltaCliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAltaCliente.setLayout(gbl_panelAltaCliente);

		labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.fill = GridBagConstraints.VERTICAL;
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panelAltaCliente.add(labelNombre, gbc_labelNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		panelAltaCliente.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		labelApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.fill = GridBagConstraints.VERTICAL;
		gbc_labelApellido.anchor = GridBagConstraints.WEST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 2;
		gbc_labelApellido.gridy = 0;
		panelAltaCliente.add(labelApellido, gbc_labelApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.gridx = 3;
		gbc_textFieldApellido.gridy = 0;
		panelAltaCliente.add(textFieldApellido, gbc_textFieldApellido);

		Tipo_Doc = new JLabel("Tipo Documentacion:");
		GridBagConstraints gbc_Tipo_Doc = new GridBagConstraints();
		gbc_Tipo_Doc.anchor = GridBagConstraints.WEST;
		gbc_Tipo_Doc.insets = new Insets(0, 0, 5, 5);
		gbc_Tipo_Doc.gridx = 0;
		gbc_Tipo_Doc.gridy = 1;
		panelAltaCliente.add(Tipo_Doc, gbc_Tipo_Doc);

		comboBoxTipoDoc = new JComboBox();
		comboBoxTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"1. DNI", "2. LU", "3. PASAPORTE", "4. OTRO"}));

		GridBagConstraints gbc_comboBoxTipoDoc = new GridBagConstraints();
		gbc_comboBoxTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoDoc.gridx = 1;
		gbc_comboBoxTipoDoc.gridy = 1;
		panelAltaCliente.add(comboBoxTipoDoc, gbc_comboBoxTipoDoc);

		lblNroDocumentacion = new JLabel("Nro. Doc:");
		GridBagConstraints gbc_lblNroDocumentacion = new GridBagConstraints();
		gbc_lblNroDocumentacion.anchor = GridBagConstraints.WEST;
		gbc_lblNroDocumentacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDocumentacion.gridx = 2;
		gbc_lblNroDocumentacion.gridy = 1;
		panelAltaCliente.add(lblNroDocumentacion, gbc_lblNroDocumentacion);

		textFieldNumeroDoc = new JTextField();
		textFieldNumeroDoc.setColumns(10);
		GridBagConstraints gbc_textFieldNumeroDoc = new GridBagConstraints();
		gbc_textFieldNumeroDoc.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNumeroDoc.fill = GridBagConstraints.BOTH;
		gbc_textFieldNumeroDoc.gridx = 3;
		gbc_textFieldNumeroDoc.gridy = 1;
		panelAltaCliente.add(textFieldNumeroDoc, gbc_textFieldNumeroDoc);

		labelTipoCliente = new JLabel("Tipo Cliente:");
		GridBagConstraints gbc_labelTipoCliente = new GridBagConstraints();
		gbc_labelTipoCliente.anchor = GridBagConstraints.WEST;
		gbc_labelTipoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_labelTipoCliente.gridx = 0;
		gbc_labelTipoCliente.gridy = 2;
		panelAltaCliente.add(labelTipoCliente, gbc_labelTipoCliente);

		comboBoxTipoCliente = new JComboBox();
		comboBoxTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"1. PARTICULAR_PROPIETARIO", "2. PARTICULAR_INQUILINO", "3. PARTICULAR_FRECUENTE", "4. EMPRESA_PROPIETARIO", "5. EMPRESA_INQUILINO", "6. EMPRESA_FRECUENTE"}));
		GridBagConstraints gbc_comboBoxTipoCliente = new GridBagConstraints();
		gbc_comboBoxTipoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoCliente.gridx = 1;
		gbc_comboBoxTipoCliente.gridy = 2;
		panelAltaCliente.add(comboBoxTipoCliente, gbc_comboBoxTipoCliente);

		lblCuit = new JLabel("CUIT:");
		GridBagConstraints gbc_lblCuit = new GridBagConstraints();
		gbc_lblCuit.anchor = GridBagConstraints.WEST;
		gbc_lblCuit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuit.gridx = 2;
		gbc_lblCuit.gridy = 2;
		panelAltaCliente.add(lblCuit, gbc_lblCuit);

		textFieldCUIT = new JTextField();
		textFieldCUIT.setColumns(10);
		GridBagConstraints gbc_textFieldCUIT = new GridBagConstraints();
		gbc_textFieldCUIT.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCUIT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCUIT.gridx = 3;
		gbc_textFieldCUIT.gridy = 2;
		panelAltaCliente.add(textFieldCUIT, gbc_textFieldCUIT);

		lblTipoFactura = new JLabel("Tipo Factura:");
		GridBagConstraints gbc_lblTipoFactura = new GridBagConstraints();
		gbc_lblTipoFactura.anchor = GridBagConstraints.WEST;
		gbc_lblTipoFactura.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoFactura.gridx = 0;
		gbc_lblTipoFactura.gridy = 3;
		panelAltaCliente.add(lblTipoFactura, gbc_lblTipoFactura);

		comboBoxTipoFactura = new JComboBox();
		comboBoxTipoFactura.setModel(new DefaultComboBoxModel(new String[] {"1. NO APLICA", "2. A", "3. B", "4. C"}));
		GridBagConstraints gbc_comboBoxTipoFactura = new GridBagConstraints();
		gbc_comboBoxTipoFactura.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoFactura.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoFactura.gridx = 1;
		gbc_comboBoxTipoFactura.gridy = 3;
		panelAltaCliente.add(comboBoxTipoFactura, gbc_comboBoxTipoFactura);

		label_2 = new JLabel("Razon Social:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 3;
		panelAltaCliente.add(label_2, gbc_label_2);

		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.fill = GridBagConstraints.BOTH;
		gbc_textFieldRazonSocial.gridx = 3;
		gbc_textFieldRazonSocial.gridy = 3;
		panelAltaCliente.add(textFieldRazonSocial, gbc_textFieldRazonSocial);

		labelTelefono1 = new JLabel("Telefono 1:");
		GridBagConstraints gbc_labelTelefono1 = new GridBagConstraints();
		gbc_labelTelefono1.fill = GridBagConstraints.VERTICAL;
		gbc_labelTelefono1.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono1.gridx = 0;
		gbc_labelTelefono1.gridy = 4;
		panelAltaCliente.add(labelTelefono1, gbc_labelTelefono1);

		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.fill = GridBagConstraints.BOTH;
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 4;
		panelAltaCliente.add(textFieldTelefono1, gbc_textFieldTelefono1);

		labelTelefono2 = new JLabel("Telefono 2:");
		GridBagConstraints gbc_labelTelefono2 = new GridBagConstraints();
		gbc_labelTelefono2.fill = GridBagConstraints.VERTICAL;
		gbc_labelTelefono2.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono2.gridx = 2;
		gbc_labelTelefono2.gridy = 4;
		panelAltaCliente.add(labelTelefono2, gbc_labelTelefono2);

		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.fill = GridBagConstraints.BOTH;
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.gridx = 3;
		gbc_textFieldTelefono2.gridy = 4;
		panelAltaCliente.add(textFieldTelefono2, gbc_textFieldTelefono2);

		labelDireccion1 = new JLabel("Direccion 1:");
		GridBagConstraints gbc_labelDireccion1 = new GridBagConstraints();
		gbc_labelDireccion1.fill = GridBagConstraints.VERTICAL;
		gbc_labelDireccion1.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion1.gridx = 0;
		gbc_labelDireccion1.gridy = 5;
		panelAltaCliente.add(labelDireccion1, gbc_labelDireccion1);

		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.fill = GridBagConstraints.BOTH;
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 5;
		panelAltaCliente.add(textFieldDireccion1, gbc_textFieldDireccion1);

		labelDireccion2 = new JLabel("Direccion 2:");
		GridBagConstraints gbc_labelDireccion2 = new GridBagConstraints();
		gbc_labelDireccion2.fill = GridBagConstraints.VERTICAL;
		gbc_labelDireccion2.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion2.gridx = 2;
		gbc_labelDireccion2.gridy = 5;
		panelAltaCliente.add(labelDireccion2, gbc_labelDireccion2);

		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.fill = GridBagConstraints.BOTH;
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.gridx = 3;
		gbc_textFieldDireccion2.gridy = 5;
		panelAltaCliente.add(textFieldDireccion2, gbc_textFieldDireccion2);

		labelEmail = new JLabel("Email:");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.VERTICAL;
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 6;
		panelAltaCliente.add(labelEmail, gbc_labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.BOTH;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 6;
		panelAltaCliente.add(textFieldEmail, gbc_textFieldEmail);
		
		lblObservacion = new JLabel("Observacion:");
		GridBagConstraints gbc_lblObservacion = new GridBagConstraints();
		gbc_lblObservacion.anchor = GridBagConstraints.WEST;
		gbc_lblObservacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservacion.gridx = 2;
		gbc_lblObservacion.gridy = 6;
		panelAltaCliente.add(lblObservacion, gbc_lblObservacion);
		
		textFieldObservacion = new JTextField();
		textFieldObservacion.setColumns(10);
		GridBagConstraints gbc_textFieldObservacion = new GridBagConstraints();
		gbc_textFieldObservacion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldObservacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldObservacion.gridx = 3;
		gbc_textFieldObservacion.gridy = 6;
		panelAltaCliente.add(textFieldObservacion, gbc_textFieldObservacion);

		labelVehiculos = new JLabel("Vehiculos:");
		GridBagConstraints gbc_labelVehiculos = new GridBagConstraints();
		gbc_labelVehiculos.fill = GridBagConstraints.VERTICAL;
		gbc_labelVehiculos.insets = new Insets(0, 0, 5, 5);
		gbc_labelVehiculos.anchor = GridBagConstraints.WEST;
		gbc_labelVehiculos.gridx = 0;
		gbc_labelVehiculos.gridy = 7;
		panelAltaCliente.add(labelVehiculos, gbc_labelVehiculos);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		panelAltaCliente.add(scrollPane, gbc_scrollPane);
		listModelVehiculos = new DefaultListModel<Vehiculo>();
		listVehiculos = new JList(listModelVehiculos);
		listVehiculos.setVisibleRowCount(3);
		listVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listVehiculos);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 7;
		panelAltaCliente.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 0};
		gbl_panel.rowHeights = new int[]{20, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnEliminarVehiculo = new JButton("");
		GridBagConstraints gbc_btnEliminarVehiculo = new GridBagConstraints();
		gbc_btnEliminarVehiculo.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarVehiculo.gridx = 0;
		gbc_btnEliminarVehiculo.gridy = 0;
		panel.add(btnEliminarVehiculo, gbc_btnEliminarVehiculo);
		btnEliminarVehiculo.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/cancel.png")));
		
		buttonModificarVehiculo = new JButton("");
		buttonModificarVehiculo.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/modificar.png")));
		buttonModificarVehiculo.addActionListener(this);
		
		GridBagConstraints gbc_buttonModificarvehiculo = new GridBagConstraints();
		gbc_buttonModificarvehiculo.gridx = 0;
		gbc_buttonModificarvehiculo.gridy = 1;
		panel.add(buttonModificarVehiculo, gbc_buttonModificarvehiculo);
		btnEliminarVehiculo.addActionListener(this);

		buttonAgregarVehiculo = new JButton("Agregar Vehiculo");
		buttonAgregarVehiculo.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
		GridBagConstraints gbc_buttonAgregarVehiculo = new GridBagConstraints();
		gbc_buttonAgregarVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonAgregarVehiculo.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAgregarVehiculo.gridx = 3;
		gbc_buttonAgregarVehiculo.gridy = 7;
		panelAltaCliente.add(buttonAgregarVehiculo, gbc_buttonAgregarVehiculo);
		buttonAgregarVehiculo.addActionListener(this);


		labelPersonaAutorizada = new JLabel("Autorizados:");
		GridBagConstraints gbc_labelPersonaAutorizada = new GridBagConstraints();
		gbc_labelPersonaAutorizada.fill = GridBagConstraints.VERTICAL;
		gbc_labelPersonaAutorizada.anchor = GridBagConstraints.WEST;
		gbc_labelPersonaAutorizada.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonaAutorizada.gridx = 0;
		gbc_labelPersonaAutorizada.gridy = 8;
		panelAltaCliente.add(labelPersonaAutorizada, gbc_labelPersonaAutorizada);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 8;
		panelAltaCliente.add(scrollPane_1, gbc_scrollPane_1);
		listModelPersonas = new DefaultListModel<PersonaAutorizada>();
		listPersonasAutorizadas = new JList(listModelPersonas);
		listPersonasAutorizadas.setVisibleRowCount(3);
		listPersonasAutorizadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listPersonasAutorizadas);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 8;
		panelAltaCliente.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{100, 0};
		gbl_panel_1.rowHeights = new int[]{20, 20, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnEliminarPersona = new JButton("");
		GridBagConstraints gbc_btnEliminarPersona = new GridBagConstraints();
		gbc_btnEliminarPersona.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarPersona.gridx = 0;
		gbc_btnEliminarPersona.gridy = 0;
		panel_1.add(btnEliminarPersona, gbc_btnEliminarPersona);
		btnEliminarPersona.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/cancel.png")));
		
		buttonModificarPersona = new JButton("");
		buttonModificarPersona.addActionListener(this);
		buttonModificarPersona.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/modificar.png")));
		GridBagConstraints gbc_buttonModificarPersona = new GridBagConstraints();
		gbc_buttonModificarPersona.gridx = 0;
		gbc_buttonModificarPersona.gridy = 1;
		panel_1.add(buttonModificarPersona, gbc_buttonModificarPersona);
		btnEliminarPersona.addActionListener(this);

		buttonAgregarPersonaAutorizada = new JButton("Agregar Persona Autorizada");
		GridBagConstraints gbc_buttonAgregarPersonaAutorizada = new GridBagConstraints();
		gbc_buttonAgregarPersonaAutorizada.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonAgregarPersonaAutorizada.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAgregarPersonaAutorizada.gridx = 3;
		gbc_buttonAgregarPersonaAutorizada.gridy = 8;
		panelAltaCliente.add(buttonAgregarPersonaAutorizada, gbc_buttonAgregarPersonaAutorizada);
		buttonAgregarPersonaAutorizada.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));

		lblCocheras = new JLabel("Cocheras:");
		GridBagConstraints gbc_lblCocheras = new GridBagConstraints();
		gbc_lblCocheras.anchor = GridBagConstraints.WEST;
		gbc_lblCocheras.fill = GridBagConstraints.VERTICAL;
		gbc_lblCocheras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCocheras.gridx = 0;
		gbc_lblCocheras.gridy = 9;
		panelAltaCliente.add(lblCocheras, gbc_lblCocheras);


		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 9;
		panelAltaCliente.add(scrollPane_2, gbc_scrollPane_2);
		listModelCocheras = new DefaultListModel<Cochera>();
		listCocheras = new JList(listModelCocheras);
		listCocheras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCocheras.setVisibleRowCount(3);
		scrollPane_2.setViewportView(listCocheras);
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 9;
		panelAltaCliente.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{100, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnEliminarCochera = new JButton("");
		GridBagConstraints gbc_btnEliminarCochera = new GridBagConstraints();
		gbc_btnEliminarCochera.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarCochera.gridx = 0;
		gbc_btnEliminarCochera.gridy = 0;
		panel_2.add(btnEliminarCochera, gbc_btnEliminarCochera);
		btnEliminarCochera.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/cancel.png")));
		
		buttonModificarCochera = new JButton("");
		buttonModificarCochera.addActionListener(this);
		buttonModificarCochera.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/modificar.png")));
		GridBagConstraints gbc_buttonModificarCochera = new GridBagConstraints();
		gbc_buttonModificarCochera.gridx = 0;
		gbc_buttonModificarCochera.gridy = 1;
		panel_2.add(buttonModificarCochera, gbc_buttonModificarCochera);
		btnEliminarCochera.addActionListener(this);

		buttonAgregarCocheras = new JButton("Agregar Cochera");
		buttonAgregarCocheras.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
		GridBagConstraints gbc_buttonAgregarCocheras = new GridBagConstraints();
		gbc_buttonAgregarCocheras.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonAgregarCocheras.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAgregarCocheras.gridx = 3;
		gbc_buttonAgregarCocheras.gridy = 9;
		panelAltaCliente.add(buttonAgregarCocheras, gbc_buttonAgregarCocheras);
		buttonAgregarCocheras.addActionListener(this);
				
				
		buttonCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_buttonCancelar = new GridBagConstraints();
		gbc_buttonCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonCancelar.gridx = 1;
		gbc_buttonCancelar.gridy = 11;
		panelAltaCliente.add(buttonCancelar, gbc_buttonCancelar);
		buttonCancelar.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.addActionListener(this);
		
		buttonCrearCliente = new JButton("Crear Cliente");
		GridBagConstraints gbc_buttonCrearCliente = new GridBagConstraints();
		gbc_buttonCrearCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonCrearCliente.gridx = 3;
		gbc_buttonCrearCliente.gridy = 11;
		panelAltaCliente.add(buttonCrearCliente, gbc_buttonCrearCliente);
		buttonCrearCliente.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/ok.png")));
		buttonCrearCliente.addActionListener(this);
		buttonAgregarPersonaAutorizada.addActionListener(this);

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==buttonModificarCochera){
			if (listCocheras.getSelectedValue() != null){
			new ModificarCochera(this).setVisible(true);
			}
		}
		if(event.getSource()==buttonModificarPersona){
			if (listPersonasAutorizadas.getSelectedValue() != null){
			new ModificarPersonaAutorizada(this).setVisible(true);
			}
		}
		if(event.getSource()==buttonModificarVehiculo){
			if (listVehiculos.getSelectedValue() != null){
				new ModificarVehiculo(this).setVisible(true);
				}
		}
		
		if(event.getSource()==btnEliminarCochera){
			if (listCocheras.getSelectedValue() != null){
				Cochera cocheraT1  = listCocheras.getSelectedValue();
				for (Cochera cocheraT2 : ListCocheras){
					if(cocheraT2.toString().equals(cocheraT1.toString())){
						ListCocheras.remove(cocheraT2);
						break;
					}
				}
				listModelCocheras.clear();
				for (Cochera cochera : ListCocheras) {
					listModelCocheras.addElement(cochera);
				}
			}
				
		}
		if(event.getSource()==btnEliminarPersona){
			if (listPersonasAutorizadas.getSelectedValue() != null){
				PersonaAutorizada personaT1  = listPersonasAutorizadas.getSelectedValue();
				for (PersonaAutorizada personaT2 : ListPersonasAutorizadas){
					if(personaT2.toString().equals(personaT1.toString())){
						ListPersonasAutorizadas.remove(personaT2);
						break;
					}
				}
				listModelPersonas.clear();
				for (PersonaAutorizada personaAutorizada : ListPersonasAutorizadas) {
					listModelPersonas.addElement(personaAutorizada);
				}
			}
		}
		if(event.getSource()==btnEliminarVehiculo){
			if (listVehiculos.getSelectedValue() != null){
				Vehiculo vehiculoT1  = listVehiculos.getSelectedValue();
				for (Vehiculo vehiculoT2 : ListPatentesVehiculos){
					if(vehiculoT2.toString().equals(vehiculoT1.toString())){
						ListPatentesVehiculos.remove(vehiculoT2);
						break;
					}
				}
				listModelVehiculos.clear();
				for (Vehiculo vehiculo : ListPatentesVehiculos) {
					listModelVehiculos.addElement(vehiculo);
				}
			}
		}
		
		if(event.getSource()==buttonAgregarVehiculo)
		{
			AgregarVehiculo altaVehiculo=new AgregarVehiculo(this);
			altaVehiculo.setVisible(true);

		}
		if(event.getSource()==buttonAgregarPersonaAutorizada)
		{
			AgregarPersonaAutorizada altaPersonaAutorizada=new AgregarPersonaAutorizada(this);
			altaPersonaAutorizada.setVisible(true);
		}
		if(event.getSource()==buttonAgregarCocheras)
		{
			AgregarCochera altaCochera=new AgregarCochera(this);
			altaCochera.setVisible(true);
		}

		if(event.getSource()==buttonCancelar)
		{
			dispose();
		}
		if(event.getSource()==buttonCrearCliente)
		{
			if(textFieldCUIT.getText().length()==11 || textFieldCUIT.getText().length()==0)
			{
				Controlador.getInstancia().altaCliente(textFieldNombre.getText(), textFieldApellido.getText(), textFieldTelefono1.getText(), textFieldTelefono2.getText(),
						textFieldDireccion1.getText(), textFieldDireccion2.getText(), textFieldEmail.getText(), textFieldRazonSocial.getText()
						,ListPersonasAutorizadas, ListPatentesVehiculos, ListCocheras, comboBoxTipoDoc.getSelectedItem().toString(), textFieldNumeroDoc.getText(), comboBoxTipoCliente.getSelectedItem().toString(), textFieldCUIT.getText(), comboBoxTipoFactura.getSelectedItem().toString(), textFieldObservacion.getText());
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "El CUIT debe estár compuesto por 11 campos numéricos.", "Error Validación Datos.", JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}

	public void agregarPersonasAutorizadasAltaCliente(PersonaAutorizada pA)
	{
		ListPersonasAutorizadas.add(pA);
		
		listModelPersonas.clear();
		for (PersonaAutorizada personaAutorizada : ListPersonasAutorizadas) {
			listModelPersonas.addElement(personaAutorizada);
		}
	}

	public void agregarVehiculosAltaCliente(Vehiculo vA) 
	{

		ListPatentesVehiculos.add(vA);
		
		listModelVehiculos.clear();
		for (Vehiculo vehiculo : ListPatentesVehiculos) {
			listModelVehiculos.addElement(vehiculo);
		}
	}
	
	public void agregarCocheraAltaCliente(modelo.Cochera cA) 
	{
		ListCocheras.add(cA);
		
		listModelCocheras.clear();
		for (Cochera cochera : ListCocheras) {
			listModelCocheras.addElement(cochera);
		}
	}


	public Cochera getSelectedCochera() {
		if (listCocheras.getSelectedValue() != null){
			 return listCocheras.getSelectedValue();
		}
		return null;
	}


	public void actualizarCochera(Cochera c) {
		Cochera cocheraT1  = listCocheras.getSelectedValue();
		for (Cochera cocheraT2 : ListCocheras){
			if(cocheraT2.toString().equals(cocheraT1.toString())){
				cocheraT2.setCostoCochera(c.getCostoCochera());
				cocheraT2.setPorcentajeExpensas(c.getPorcentajeExpensas());
				cocheraT2.setUbicacion(c.getUbicacion());
				break;
			}
		}
		listModelCocheras.clear();
		for (Cochera cochera : ListCocheras) {
			listModelCocheras.addElement(cochera);
		}
		
	}


	public PersonaAutorizada getSelectedPersona() {
		if (listPersonasAutorizadas.getSelectedValue() != null){
			 return listPersonasAutorizadas.getSelectedValue();
		}
		return null;
	}


	public void actualizarPersonaAutorizada(PersonaAutorizada p) {
		if (listPersonasAutorizadas.getSelectedValue() != null){
			PersonaAutorizada personaT1  = listPersonasAutorizadas.getSelectedValue();
			for (PersonaAutorizada personaT2 : ListPersonasAutorizadas){
				if(personaT2.toString().equals(personaT1.toString())){
					personaT2.setNombre(p.getNombre());
					break;
				}
			}
			listModelPersonas.clear();
			for (PersonaAutorizada personaAutorizada : ListPersonasAutorizadas) {
				listModelPersonas.addElement(personaAutorizada);
			}
		}
	}


	public Vehiculo getSelectedVehiuclo() {
		if (listVehiculos.getSelectedValue() != null){
			 return listVehiculos.getSelectedValue();
		}
		return null;
	}


	public void actualizarVehiculo(Vehiculo v) {
		if (listVehiculos.getSelectedValue() != null){
			Vehiculo vehiculoT1  = listVehiculos.getSelectedValue();
			for (Vehiculo vehiculoT2 : ListPatentesVehiculos){
				if(vehiculoT2.toString().equals(vehiculoT1.toString())){
					vehiculoT2.setCategoria(v.getCategoria());
					vehiculoT2.setColor(v.getColor());
					vehiculoT2.setComentario(v.getComentario());
					vehiculoT2.setModelo(v.getModelo());
					vehiculoT2.setPatente(v.getPatente());
					break;
				}
			}
			listModelVehiculos.clear();
			for (Vehiculo vehiculo : ListPatentesVehiculos) {
				listModelVehiculos.addElement(vehiculo);
			}
		}
		
	}
}

