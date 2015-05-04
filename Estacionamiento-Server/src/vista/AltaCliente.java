package vista;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextArea;

import modelo.PersonaAutorizada;
import controlador.Controlador;

public class AltaCliente extends JDialog implements ActionListener{


	private static final long serialVersionUID = 1L;
	public static JPanel contentPaneAltaCliente;


	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono1;
	private JTextField textFieldTelefono2;
	private JTextField textFieldDireccion1;
	private JTextField textFieldDireccion2;
	private JTextField textFieldEmail;
	private JTextField textFieldRazonSocial;
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
	private JTextArea textAreaVehiculos;
	private JButton buttonAgregarVehiculo;
	private JLabel labelPersonaAutorizada;
	private JTextArea textAreaPersonasAutorizadas;
	private JButton buttonCancelar;
	private JButton buttonCrearCliente;
	
	
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
		setBounds(100, 100, 661, 318);
		contentPaneAltaCliente = new JPanel();
		contentPaneAltaCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAltaCliente);
		contentPaneAltaCliente.setLayout(null);

		
		panelAltaCliente = new JPanel();
		panelAltaCliente.setBounds(6, 6, 627, 215);
		contentPaneAltaCliente.add(panelAltaCliente);
		GridBagLayout gbl_panelAltaCliente = new GridBagLayout();
		gbl_panelAltaCliente.columnWidths = new int[]{124, 200, 0, 0, 200, 0};
		gbl_panelAltaCliente.rowHeights = new int[] {28, 28, 28, 28, 35, 35, 0};
		gbl_panelAltaCliente.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAltaCliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAltaCliente.setLayout(gbl_panelAltaCliente);
		
		labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		panelAltaCliente.add(labelNombre, gbc_labelNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 0;
		panelAltaCliente.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		labelApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.WEST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 3;
		gbc_labelApellido.gridy = 0;
		panelAltaCliente.add(labelApellido, gbc_labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.gridx = 4;
		gbc_textFieldApellido.gridy = 0;
		panelAltaCliente.add(textFieldApellido, gbc_textFieldApellido);
		
		labelTelefono1 = new JLabel("Telefono 1:");
		GridBagConstraints gbc_labelTelefono1 = new GridBagConstraints();
		gbc_labelTelefono1.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono1.gridx = 0;
		gbc_labelTelefono1.gridy = 1;
		panelAltaCliente.add(labelTelefono1, gbc_labelTelefono1);
		
		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 1;
		panelAltaCliente.add(textFieldTelefono1, gbc_textFieldTelefono1);
		
		labelTelefono2 = new JLabel("Telefono 2:");
		GridBagConstraints gbc_labelTelefono2 = new GridBagConstraints();
		gbc_labelTelefono2.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono2.gridx = 3;
		gbc_labelTelefono2.gridy = 1;
		panelAltaCliente.add(labelTelefono2, gbc_labelTelefono2);
		
		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.gridx = 4;
		gbc_textFieldTelefono2.gridy = 1;
		panelAltaCliente.add(textFieldTelefono2, gbc_textFieldTelefono2);
		
		labelDireccion1 = new JLabel("Direccion 1:");
		GridBagConstraints gbc_labelDireccion1 = new GridBagConstraints();
		gbc_labelDireccion1.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion1.gridx = 0;
		gbc_labelDireccion1.gridy = 2;
		panelAltaCliente.add(labelDireccion1, gbc_labelDireccion1);
		
		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 2;
		panelAltaCliente.add(textFieldDireccion1, gbc_textFieldDireccion1);
		
		labelDireccion2 = new JLabel("Direccion 2:");
		GridBagConstraints gbc_labelDireccion2 = new GridBagConstraints();
		gbc_labelDireccion2.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion2.gridx = 3;
		gbc_labelDireccion2.gridy = 2;
		panelAltaCliente.add(labelDireccion2, gbc_labelDireccion2);
		
		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.gridx = 4;
		gbc_textFieldDireccion2.gridy = 2;
		panelAltaCliente.add(textFieldDireccion2, gbc_textFieldDireccion2);
		
		labelEmail = new JLabel("Email:");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 3;
		panelAltaCliente.add(labelEmail, gbc_labelEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 3;
		panelAltaCliente.add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel labelRazonSocial = new JLabel("Razon Social:");
		GridBagConstraints gbc_labelRazonSocial = new GridBagConstraints();
		gbc_labelRazonSocial.anchor = GridBagConstraints.WEST;
		gbc_labelRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_labelRazonSocial.gridx = 3;
		gbc_labelRazonSocial.gridy = 3;
		panelAltaCliente.add(labelRazonSocial, gbc_labelRazonSocial);
		
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.gridx = 4;
		gbc_textFieldRazonSocial.gridy = 3;
		panelAltaCliente.add(textFieldRazonSocial, gbc_textFieldRazonSocial);
		
		labelVehiculos = new JLabel("Vehiculos:");
		GridBagConstraints gbc_labelVehiculos = new GridBagConstraints();
		gbc_labelVehiculos.fill = GridBagConstraints.VERTICAL;
		gbc_labelVehiculos.insets = new Insets(0, 0, 5, 5);
		gbc_labelVehiculos.anchor = GridBagConstraints.WEST;
		gbc_labelVehiculos.gridx = 0;
		gbc_labelVehiculos.gridy = 4;
		panelAltaCliente.add(labelVehiculos, gbc_labelVehiculos);
		
		textAreaVehiculos = new JTextArea();
		textAreaVehiculos.setEnabled(false);
		textAreaVehiculos.setEditable(false);
		GridBagConstraints gbc_textAreaVehiculos = new GridBagConstraints();
		gbc_textAreaVehiculos.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaVehiculos.fill = GridBagConstraints.BOTH;
		gbc_textAreaVehiculos.gridx = 1;
		gbc_textAreaVehiculos.gridy = 4;
		panelAltaCliente.add(textAreaVehiculos, gbc_textAreaVehiculos);
		
		buttonAgregarVehiculo = new JButton("Agregar");
		buttonAgregarVehiculo.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
		GridBagConstraints gbc_buttonAgregarVehiculo = new GridBagConstraints();
		gbc_buttonAgregarVehiculo.fill = GridBagConstraints.BOTH;
		gbc_buttonAgregarVehiculo.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAgregarVehiculo.gridx = 4;
		gbc_buttonAgregarVehiculo.gridy = 4;
		panelAltaCliente.add(buttonAgregarVehiculo, gbc_buttonAgregarVehiculo);
		buttonAgregarVehiculo.addActionListener(this);

		
		labelPersonaAutorizada = new JLabel("Autorizados:");
		GridBagConstraints gbc_labelPersonaAutorizada = new GridBagConstraints();
		gbc_labelPersonaAutorizada.fill = GridBagConstraints.VERTICAL;
		gbc_labelPersonaAutorizada.anchor = GridBagConstraints.WEST;
		gbc_labelPersonaAutorizada.insets = new Insets(0, 0, 0, 5);
		gbc_labelPersonaAutorizada.gridx = 0;
		gbc_labelPersonaAutorizada.gridy = 5;
		panelAltaCliente.add(labelPersonaAutorizada, gbc_labelPersonaAutorizada);
		
		textAreaPersonasAutorizadas = new JTextArea();
		textAreaPersonasAutorizadas.setEditable(false);
		textAreaPersonasAutorizadas.setEnabled(false);
		GridBagConstraints gbc_textAreaPersonasAutorizadas = new GridBagConstraints();
		gbc_textAreaPersonasAutorizadas.insets = new Insets(0, 0, 0, 5);
		gbc_textAreaPersonasAutorizadas.fill = GridBagConstraints.BOTH;
		gbc_textAreaPersonasAutorizadas.gridx = 1;
		gbc_textAreaPersonasAutorizadas.gridy = 5;
		panelAltaCliente.add(textAreaPersonasAutorizadas, gbc_textAreaPersonasAutorizadas);
		
		buttonAgregarPersonaAutorizada = new JButton("Agregar");
		GridBagConstraints gbc_buttonAgregarPersonaAutorizada = new GridBagConstraints();
		gbc_buttonAgregarPersonaAutorizada.fill = GridBagConstraints.BOTH;
		gbc_buttonAgregarPersonaAutorizada.gridx = 4;
		gbc_buttonAgregarPersonaAutorizada.gridy = 5;
		panelAltaCliente.add(buttonAgregarPersonaAutorizada, gbc_buttonAgregarPersonaAutorizada);
		buttonAgregarPersonaAutorizada.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
		buttonAgregarPersonaAutorizada.addActionListener(this);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(202, 233, 116, 32);
		contentPaneAltaCliente.add(buttonCancelar);
		buttonCancelar.addActionListener(this);
		
		buttonCrearCliente = new JButton("Crear Cliente");
		buttonCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonCrearCliente.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/ok.png")));
		buttonCrearCliente.setBounds(485, 227, 148, 56);
		contentPaneAltaCliente.add(buttonCrearCliente);
		buttonCrearCliente.addActionListener(this);
		
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==buttonAgregarVehiculo)
		{
			AgregarVehiculo altaVehiculo=new AgregarVehiculo();
			altaVehiculo.setVisible(true);
			
		}
		if(event.getSource()==buttonAgregarPersonaAutorizada)
		{
			AltaPersonaAutorizada altaPersonaAutorizada=new AltaPersonaAutorizada();
			altaPersonaAutorizada.setVisible(true);

			String personasAutorizadas="";
			ArrayList<PersonaAutorizada> pAA= Controlador.getInstancia().personasAutorizadasActuales;
			
			for (int i=0; i<pAA.size();i++) 
			{
				personasAutorizadas.concat(pAA.get(i).getNombre());
				personasAutorizadas.concat("\r\n");
			}		
			textAreaPersonasAutorizadas.setText(personasAutorizadas);
		}
		if(event.getSource()==buttonCancelar)
		{
			dispose();
		}
		if(event.getSource()==buttonCrearCliente)
		{
			Controlador.getInstancia().altaCliente(textFieldNombre.getText(), textFieldApellido.getText(), textFieldTelefono1.getText(), textFieldTelefono2.getText(),
					textFieldDireccion1.getText(), textFieldDireccion2.getText(), textFieldEmail.getText(), textFieldRazonSocial.getText()
					,textAreaPersonasAutorizadas.getText(), textAreaVehiculos.getText());
			dispose();
			
		}
	}
}

