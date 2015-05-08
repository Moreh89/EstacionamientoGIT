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
import modelo.Vehiculo;
import controlador.Controlador;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblCocheras;
	private JButton buttonAgregarCocheras;
	private JScrollPane scrollPane_2;
	private JTextArea textAreaCocheras;
	private JLabel lblDnilu;
	private JTextField textFieldDNILU;
	private JLabel lblCuit;
	private JTextField textFieldCUIT;


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
		setBounds(100, 100, 754, 452);
		contentPaneAltaCliente = new JPanel();
		contentPaneAltaCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAltaCliente);
		contentPaneAltaCliente.setLayout(null);


		panelAltaCliente = new JPanel();
		panelAltaCliente.setBounds(6, 6, 730, 400);
		contentPaneAltaCliente.add(panelAltaCliente);
		GridBagLayout gbl_panelAltaCliente = new GridBagLayout();
		gbl_panelAltaCliente.columnWidths = new int[]{124, 227, 0, 0, 253, 0};
		gbl_panelAltaCliente.rowHeights = new int[] {28, 0, 28, 28, 28, 60, 59, 60, 0, 0};
		gbl_panelAltaCliente.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAltaCliente.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_labelApellido.gridx = 3;
		gbc_labelApellido.gridy = 0;
		panelAltaCliente.add(labelApellido, gbc_labelApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.gridx = 4;
		gbc_textFieldApellido.gridy = 0;
		panelAltaCliente.add(textFieldApellido, gbc_textFieldApellido);
		
		lblDnilu = new JLabel("DNI/LU:");
		GridBagConstraints gbc_lblDnilu = new GridBagConstraints();
		gbc_lblDnilu.anchor = GridBagConstraints.WEST;
		gbc_lblDnilu.insets = new Insets(0, 0, 5, 5);
		gbc_lblDnilu.gridx = 0;
		gbc_lblDnilu.gridy = 1;
		panelAltaCliente.add(lblDnilu, gbc_lblDnilu);
		
		textFieldDNILU = new JTextField();
		textFieldDNILU.setColumns(10);
		GridBagConstraints gbc_textFieldDNILU = new GridBagConstraints();
		gbc_textFieldDNILU.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDNILU.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDNILU.gridx = 1;
		gbc_textFieldDNILU.gridy = 1;
		panelAltaCliente.add(textFieldDNILU, gbc_textFieldDNILU);
		
		lblCuit = new JLabel("CUIT:");
		GridBagConstraints gbc_lblCuit = new GridBagConstraints();
		gbc_lblCuit.anchor = GridBagConstraints.WEST;
		gbc_lblCuit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuit.gridx = 3;
		gbc_lblCuit.gridy = 1;
		panelAltaCliente.add(lblCuit, gbc_lblCuit);
		
		textFieldCUIT = new JTextField();
		textFieldCUIT.setColumns(10);
		GridBagConstraints gbc_textFieldCUIT = new GridBagConstraints();
		gbc_textFieldCUIT.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCUIT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCUIT.gridx = 4;
		gbc_textFieldCUIT.gridy = 1;
		panelAltaCliente.add(textFieldCUIT, gbc_textFieldCUIT);

		labelTelefono1 = new JLabel("Telefono 1:");
		GridBagConstraints gbc_labelTelefono1 = new GridBagConstraints();
		gbc_labelTelefono1.fill = GridBagConstraints.VERTICAL;
		gbc_labelTelefono1.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono1.gridx = 0;
		gbc_labelTelefono1.gridy = 2;
		panelAltaCliente.add(labelTelefono1, gbc_labelTelefono1);

		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.fill = GridBagConstraints.BOTH;
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 2;
		panelAltaCliente.add(textFieldTelefono1, gbc_textFieldTelefono1);

		labelTelefono2 = new JLabel("Telefono 2:");
		GridBagConstraints gbc_labelTelefono2 = new GridBagConstraints();
		gbc_labelTelefono2.fill = GridBagConstraints.VERTICAL;
		gbc_labelTelefono2.anchor = GridBagConstraints.WEST;
		gbc_labelTelefono2.insets = new Insets(0, 0, 5, 5);
		gbc_labelTelefono2.gridx = 3;
		gbc_labelTelefono2.gridy = 2;
		panelAltaCliente.add(labelTelefono2, gbc_labelTelefono2);

		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.fill = GridBagConstraints.BOTH;
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.gridx = 4;
		gbc_textFieldTelefono2.gridy = 2;
		panelAltaCliente.add(textFieldTelefono2, gbc_textFieldTelefono2);

		labelDireccion1 = new JLabel("Direccion 1:");
		GridBagConstraints gbc_labelDireccion1 = new GridBagConstraints();
		gbc_labelDireccion1.fill = GridBagConstraints.VERTICAL;
		gbc_labelDireccion1.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion1.gridx = 0;
		gbc_labelDireccion1.gridy = 3;
		panelAltaCliente.add(labelDireccion1, gbc_labelDireccion1);

		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.fill = GridBagConstraints.BOTH;
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 3;
		panelAltaCliente.add(textFieldDireccion1, gbc_textFieldDireccion1);

		labelDireccion2 = new JLabel("Direccion 2:");
		GridBagConstraints gbc_labelDireccion2 = new GridBagConstraints();
		gbc_labelDireccion2.fill = GridBagConstraints.VERTICAL;
		gbc_labelDireccion2.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion2.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion2.gridx = 3;
		gbc_labelDireccion2.gridy = 3;
		panelAltaCliente.add(labelDireccion2, gbc_labelDireccion2);

		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.fill = GridBagConstraints.BOTH;
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.gridx = 4;
		gbc_textFieldDireccion2.gridy = 3;
		panelAltaCliente.add(textFieldDireccion2, gbc_textFieldDireccion2);

		labelEmail = new JLabel("Email:");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.fill = GridBagConstraints.VERTICAL;
		gbc_labelEmail.anchor = GridBagConstraints.WEST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 4;
		panelAltaCliente.add(labelEmail, gbc_labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.BOTH;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 4;
		panelAltaCliente.add(textFieldEmail, gbc_textFieldEmail);

		JLabel labelRazonSocial = new JLabel("Razon Social:");
		GridBagConstraints gbc_labelRazonSocial = new GridBagConstraints();
		gbc_labelRazonSocial.fill = GridBagConstraints.VERTICAL;
		gbc_labelRazonSocial.anchor = GridBagConstraints.WEST;
		gbc_labelRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_labelRazonSocial.gridx = 3;
		gbc_labelRazonSocial.gridy = 4;
		panelAltaCliente.add(labelRazonSocial, gbc_labelRazonSocial);

		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.fill = GridBagConstraints.BOTH;
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.gridx = 4;
		gbc_textFieldRazonSocial.gridy = 4;
		panelAltaCliente.add(textFieldRazonSocial, gbc_textFieldRazonSocial);

		labelVehiculos = new JLabel("Vehiculos:");
		GridBagConstraints gbc_labelVehiculos = new GridBagConstraints();
		gbc_labelVehiculos.fill = GridBagConstraints.VERTICAL;
		gbc_labelVehiculos.insets = new Insets(0, 0, 5, 5);
		gbc_labelVehiculos.anchor = GridBagConstraints.WEST;
		gbc_labelVehiculos.gridx = 0;
		gbc_labelVehiculos.gridy = 5;
		panelAltaCliente.add(labelVehiculos, gbc_labelVehiculos);
				
				scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 5;
				panelAltaCliente.add(scrollPane, gbc_scrollPane);
				
						textAreaVehiculos = new JTextArea();
						scrollPane.setViewportView(textAreaVehiculos);
						textAreaVehiculos.setEnabled(false);
						textAreaVehiculos.setEditable(false);
		
				buttonAgregarVehiculo = new JButton("Agregar");
				buttonAgregarVehiculo.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
				GridBagConstraints gbc_buttonAgregarVehiculo = new GridBagConstraints();
				gbc_buttonAgregarVehiculo.anchor = GridBagConstraints.WEST;
				gbc_buttonAgregarVehiculo.gridwidth = 2;
				gbc_buttonAgregarVehiculo.fill = GridBagConstraints.VERTICAL;
				gbc_buttonAgregarVehiculo.insets = new Insets(0, 0, 5, 0);
				gbc_buttonAgregarVehiculo.gridx = 3;
				gbc_buttonAgregarVehiculo.gridy = 5;
				panelAltaCliente.add(buttonAgregarVehiculo, gbc_buttonAgregarVehiculo);
				buttonAgregarVehiculo.addActionListener(this);


		labelPersonaAutorizada = new JLabel("Autorizados:");
		GridBagConstraints gbc_labelPersonaAutorizada = new GridBagConstraints();
		gbc_labelPersonaAutorizada.fill = GridBagConstraints.VERTICAL;
		gbc_labelPersonaAutorizada.anchor = GridBagConstraints.WEST;
		gbc_labelPersonaAutorizada.insets = new Insets(0, 0, 5, 5);
		gbc_labelPersonaAutorizada.gridx = 0;
		gbc_labelPersonaAutorizada.gridy = 6;
		panelAltaCliente.add(labelPersonaAutorizada, gbc_labelPersonaAutorizada);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 6;
		panelAltaCliente.add(scrollPane_1, gbc_scrollPane_1);
		
				textAreaPersonasAutorizadas = new JTextArea();
				scrollPane_1.setViewportView(textAreaPersonasAutorizadas);
				textAreaPersonasAutorizadas.setEditable(false);
				textAreaPersonasAutorizadas.setEnabled(false);

		buttonAgregarPersonaAutorizada = new JButton("Agregar");
		GridBagConstraints gbc_buttonAgregarPersonaAutorizada = new GridBagConstraints();
		gbc_buttonAgregarPersonaAutorizada.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAgregarPersonaAutorizada.anchor = GridBagConstraints.WEST;
		gbc_buttonAgregarPersonaAutorizada.gridwidth = 2;
		gbc_buttonAgregarPersonaAutorizada.fill = GridBagConstraints.VERTICAL;
		gbc_buttonAgregarPersonaAutorizada.gridx = 3;
		gbc_buttonAgregarPersonaAutorizada.gridy = 6;
		panelAltaCliente.add(buttonAgregarPersonaAutorizada, gbc_buttonAgregarPersonaAutorizada);
		buttonAgregarPersonaAutorizada.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
								
								lblCocheras = new JLabel("Cocheras:");
								GridBagConstraints gbc_lblCocheras = new GridBagConstraints();
								gbc_lblCocheras.anchor = GridBagConstraints.WEST;
								gbc_lblCocheras.fill = GridBagConstraints.VERTICAL;
								gbc_lblCocheras.insets = new Insets(0, 0, 5, 5);
								gbc_lblCocheras.gridx = 0;
								gbc_lblCocheras.gridy = 7;
								panelAltaCliente.add(lblCocheras, gbc_lblCocheras);
								
								scrollPane_2 = new JScrollPane();
								scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
								GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
								gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
								gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
								gbc_scrollPane_2.gridx = 1;
								gbc_scrollPane_2.gridy = 7;
								panelAltaCliente.add(scrollPane_2, gbc_scrollPane_2);
								
								textAreaCocheras = new JTextArea();
								textAreaCocheras.setEnabled(false);
								textAreaCocheras.setEditable(false);
								scrollPane_2.setViewportView(textAreaCocheras);
								
								buttonAgregarCocheras = new JButton("Agregar");
								buttonAgregarCocheras.setIcon(new ImageIcon(AltaCliente.class.getResource("/image/plus.png")));
								GridBagConstraints gbc_buttonAgregarCocheras = new GridBagConstraints();
								gbc_buttonAgregarCocheras.anchor = GridBagConstraints.WEST;
								gbc_buttonAgregarCocheras.gridwidth = 2;
								gbc_buttonAgregarCocheras.fill = GridBagConstraints.VERTICAL;
								gbc_buttonAgregarCocheras.insets = new Insets(0, 0, 5, 0);
								gbc_buttonAgregarCocheras.gridx = 3;
								gbc_buttonAgregarCocheras.gridy = 7;
								panelAltaCliente.add(buttonAgregarCocheras, gbc_buttonAgregarCocheras);
						
								buttonCancelar = new JButton("Cancelar");
								GridBagConstraints gbc_buttonCancelar = new GridBagConstraints();
								gbc_buttonCancelar.fill = GridBagConstraints.HORIZONTAL;
								gbc_buttonCancelar.insets = new Insets(0, 0, 0, 5);
								gbc_buttonCancelar.gridx = 1;
								gbc_buttonCancelar.gridy = 8;
								panelAltaCliente.add(buttonCancelar, gbc_buttonCancelar);
								buttonCancelar.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/cancel.png")));
								buttonCancelar.addActionListener(this);
				
						buttonCrearCliente = new JButton("Crear Cliente");
						GridBagConstraints gbc_buttonCrearCliente = new GridBagConstraints();
						gbc_buttonCrearCliente.fill = GridBagConstraints.HORIZONTAL;
						gbc_buttonCrearCliente.gridx = 4;
						gbc_buttonCrearCliente.gridy = 8;
						panelAltaCliente.add(buttonCrearCliente, gbc_buttonCrearCliente);
						buttonCrearCliente.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							}
						});
						buttonCrearCliente.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/ok.png")));
				buttonCrearCliente.addActionListener(this);
		buttonAgregarPersonaAutorizada.addActionListener(this);

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
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
	public void agregarPersonasAutorizadasAltaCliente(ArrayList<PersonaAutorizada> pA)
	{
		String personasAutorizadas="";

		for (int i=0; i<pA.size();i++) 
		{
			if(personasAutorizadas.isEmpty())
			{
				personasAutorizadas=pA.get(i).getNombre();
				personasAutorizadas= personasAutorizadas+"\r\n";			}
			else{
				personasAutorizadas= personasAutorizadas+pA.get(i).getNombre()+"\r\n";

			}	
		}
		textAreaPersonasAutorizadas.setText(personasAutorizadas);
	}

	public void agregarVehiculosAltaCliente(ArrayList<Vehiculo> vA) 
	{
		String vehiculos="";

		for (int i=0; i<vA.size();i++) 
		{
			if(vehiculos.isEmpty())
			{
				vehiculos=vA.get(i).getPatente();
				vehiculos= vehiculos+"\r\n";			}
			else{
				vehiculos= vehiculos+vA.get(i).getPatente()+"\r\n";

			}	
		}
		textAreaVehiculos.setText(vehiculos);
	}
}

