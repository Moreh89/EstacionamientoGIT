package vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

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
import modelo.Usuario;
import controlador.Controlador;



@SuppressWarnings("rawtypes")
public class GestionUsuario extends JDialog implements ActionListener, KeyListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField buscarTextField;
	private DefaultTableModel model;
	private JComboBox tipoComboBox;
	@SuppressWarnings("unused")
	private CobroExtraordinario cobroExtraordinario;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldUserName;
	private JTextField textFieldDNILU;
	private JComboBox comboBoxTipoUsuario;
	private JComboBox comboBoxTipoDoc;

	private JLabel lblDnilu;
	private JLabel lblTipoUsuario;


	private JButton buscarButton;
	private JPanel panelClientes;
	private JScrollPane scrollPaneClientes;
	private JList listUsuarios;
	private DefaultListModel<Usuario> listModel;
	private JLabel labelUserName;
	private JLabel labelApellido;
	private JLabel labelNombre;
	private JPanel panelAtributos;
	private JLabel lblTipodocumento;
	private JButton btnCancelar;
	private JButton btnCrearUsuarioOperador;
	private JButton btnCrearUsuarioAdministrador;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscadorCliente frame = new BuscadorCliente();
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

	public GestionUsuario() {
		initGUI();
	}



	@SuppressWarnings("unchecked")
	public void initGUI(){
		setTitle("Gestión Usuarios");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 19, 46, 14);
		contentPane.add(lblBuscar);

		buscarTextField = new JTextField();
		buscarTextField.setBounds(55, 14, 217, 25);
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
		buscarButton.addActionListener(this);
		buscarButton.setBounds(404, 7, 116, 32);
		contentPane.add(buscarButton);
		buscarButton.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/search.png")));

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 510, 6);
		contentPane.add(separator);

		tipoComboBox = new JComboBox();
		tipoComboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "NOMBRE", "APELLIDO"}));
		tipoComboBox.setBounds(280, 14, 114, 25);
		contentPane.add(tipoComboBox);

		panelAtributos = new JPanel();
		panelAtributos.setBounds(10, 140, 503, 192);
		contentPane.add(panelAtributos);
		GridBagLayout gbl_panelAtributos = new GridBagLayout();
		gbl_panelAtributos.columnWidths = new int[]{0, 0, 0};
		gbl_panelAtributos.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 0};
		gbl_panelAtributos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAtributos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAtributos.setLayout(gbl_panelAtributos);

		labelUserName = new JLabel("User Name:");
		GridBagConstraints gbc_labelUserName = new GridBagConstraints();
		gbc_labelUserName.anchor = GridBagConstraints.EAST;
		gbc_labelUserName.insets = new Insets(0, 0, 5, 5);
		gbc_labelUserName.gridx = 0;
		gbc_labelUserName.gridy = 0;
		panelAtributos.add(labelUserName, gbc_labelUserName);

		textFieldUserName = new JTextField();
		textFieldUserName.setEditable(false);
		textFieldUserName.setEnabled(false);
		textFieldUserName.setColumns(10);
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 0;
		panelAtributos.add(textFieldUserName, gbc_textFieldUserName);

		labelNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 1;
		panelAtributos.add(labelNombre, gbc_labelNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		panelAtributos.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		labelApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 0;
		gbc_labelApellido.gridy = 2;
		panelAtributos.add(labelApellido, gbc_labelApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 2;
		panelAtributos.add(textFieldApellido, gbc_textFieldApellido);

		lblTipodocumento = new JLabel("Tipo Doc:");
		GridBagConstraints gbc_lblTipodocumento = new GridBagConstraints();
		gbc_lblTipodocumento.anchor = GridBagConstraints.EAST;
		gbc_lblTipodocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipodocumento.gridx = 0;
		gbc_lblTipodocumento.gridy = 3;
		panelAtributos.add(lblTipodocumento, gbc_lblTipodocumento);

		comboBoxTipoDoc = new JComboBox();
		comboBoxTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LU", "PASAPORTE", "OTRO"}));
		GridBagConstraints gbc_comboBoxTipoDoc = new GridBagConstraints();
		gbc_comboBoxTipoDoc.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoDoc.gridx = 1;
		gbc_comboBoxTipoDoc.gridy = 3;
		panelAtributos.add(comboBoxTipoDoc, gbc_comboBoxTipoDoc);

		lblDnilu = new JLabel("Nro. Doc:");
		GridBagConstraints gbc_lblDnilu = new GridBagConstraints();
		gbc_lblDnilu.fill = GridBagConstraints.VERTICAL;
		gbc_lblDnilu.anchor = GridBagConstraints.EAST;
		gbc_lblDnilu.insets = new Insets(0, 0, 5, 5);
		gbc_lblDnilu.gridx = 0;
		gbc_lblDnilu.gridy = 4;
		panelAtributos.add(lblDnilu, gbc_lblDnilu);

		textFieldDNILU = new JTextField();
		textFieldDNILU.setColumns(10);
		GridBagConstraints gbc_textFieldDNILU = new GridBagConstraints();
		gbc_textFieldDNILU.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDNILU.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDNILU.gridx = 1;
		gbc_textFieldDNILU.gridy = 4;
		panelAtributos.add(textFieldDNILU, gbc_textFieldDNILU);

		lblTipoUsuario = new JLabel("Tipo Usuario:");
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblTipoUsuario.gridx = 0;
		gbc_lblTipoUsuario.gridy = 5;
		panelAtributos.add(lblTipoUsuario, gbc_lblTipoUsuario);

		comboBoxTipoUsuario = new JComboBox();
		Vector comboBoxTipoUsuarioItems=new Vector<String>();
		comboBoxTipoUsuarioItems.add(modelo.Usuario.PERMISOS.ADMIN.toString());
		comboBoxTipoUsuarioItems.add(modelo.Usuario.PERMISOS.CAJA.toString());
		comboBoxTipoUsuario.setModel(new DefaultComboBoxModel(comboBoxTipoUsuarioItems));
		GridBagConstraints gbc_comboBoxTipoUsuario = new GridBagConstraints();
		gbc_comboBoxTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoUsuario.gridx = 1;
		gbc_comboBoxTipoUsuario.gridy = 5;
		panelAtributos.add(comboBoxTipoUsuario, gbc_comboBoxTipoUsuario);

		panelClientes = new JPanel();
		panelClientes.setBounds(10, 46, 503, 88);
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

		listModel = new DefaultListModel<modelo.Usuario>();
		for (Usuario usuarioTemp : Controlador.getInstancia().getUsuarios()) {
			listModel.addElement(usuarioTemp);
		} 
		listUsuarios = new JList(listModel);
		listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPaneClientes.setViewportView(listUsuarios);

		btnCrearUsuarioAdministrador = new JButton("Crear Usuario Administrador");
		btnCrearUsuarioAdministrador.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/plus.png")));
		btnCrearUsuarioAdministrador.setBounds(10, 360, 200, 40);
		contentPane.add(btnCrearUsuarioAdministrador);
		btnCrearUsuarioAdministrador.addActionListener(this);

		btnCrearUsuarioOperador = new JButton("Crear Usuario Operador");
		btnCrearUsuarioOperador.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/plus.png")));
		btnCrearUsuarioOperador.addActionListener(this);
		btnCrearUsuarioOperador.setBounds(10, 410, 200, 40);
		contentPane.add(btnCrearUsuarioOperador);

		btnModificar = new JButton("Modificar Usuario");
		btnModificar.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(225, 360, 155, 90);
		contentPane.add(btnModificar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		btnCancelar.setBounds(393, 360, 120, 90);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		listUsuarios.addListSelectionListener(this);

		this.setLocationRelativeTo(null);
		setModal(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.buscarButton){
			listModel.clear();
			for (Usuario usuarioTemp : Controlador.getInstancia().getUsuarios()) {
				listModel.addElement(usuarioTemp);
			} 
			if(!buscarTextField.getText().isEmpty())
			{
				ArrayList<Usuario> listaABorrar = new ArrayList<Usuario>();
				if(tipoComboBox.getSelectedItem().toString().equals("DNI")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Usuario usuarioTemp = listModel.getElementAt(i);
						if(!usuarioTemp.getNumeroDocumento().contains(this.buscarTextField.getText())){
							listaABorrar.add(usuarioTemp);
						}
					}
				}
				if(tipoComboBox.getSelectedItem().toString().equals("NOMBRE")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Usuario usuarioTemp = listModel.getElementAt(i);
						if(!usuarioTemp.getNombre().toLowerCase().contains(this.buscarTextField.getText().toLowerCase())){
							listaABorrar.add(usuarioTemp);
						}
					}
				}
				if(tipoComboBox.getSelectedItem().toString().equals("APELLIDO")){
					for (int i = 0; i < listModel.getSize(); i++) {
						Usuario clienteTemp = listModel.getElementAt(i);
						if(!clienteTemp.getApellido().toLowerCase().contains(this.buscarTextField.getText().toLowerCase())){
							listaABorrar.add(clienteTemp);

						}
					}
				}
				for (Usuario usuarioABorrar : listaABorrar) {
					listModel.removeElement(usuarioABorrar);
				}
			}
		}
		if(e.getSource()==btnCancelar)
		{
			dispose();
		}

		if(e.getSource()==btnCrearUsuarioAdministrador)
		{

		}
		if(e.getSource()==btnCrearUsuarioOperador)
		{

		}
		if(e.getSource()==btnModificar)
		{
			if(!textFieldApellido.getText().isEmpty() && !textFieldDNILU.getText().isEmpty() && !textFieldNombre.getText().isEmpty()
					&& !textFieldUserName.getText().isEmpty())
			{
				long codigoReturn=-1;
				modelo.Usuario usuarioSeleccionado = (Usuario) this.listUsuarios.getSelectedValue();
				codigoReturn=Controlador.getInstancia().modificarUsuario(textFieldApellido.getText(),textFieldDNILU.getText(),textFieldNombre.getText()
						,comboBoxTipoDoc.getSelectedItem().toString(), comboBoxTipoUsuario.getSelectedItem().toString(), usuarioSeleccionado);
				
				dispose();
			}
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
		if(e.getSource() == this.listUsuarios){
			modelo.Usuario usuarioSeleccionado = (Usuario) this.listUsuarios.getSelectedValue();
			this.textFieldApellido.setText(usuarioSeleccionado.getApellido());
			this.textFieldDNILU.setText(usuarioSeleccionado.getNumeroDocumento());
			this.textFieldNombre.setText(usuarioSeleccionado.getNombre());
			this.textFieldUserName.setText(usuarioSeleccionado.getUserName());
			this.comboBoxTipoDoc.setSelectedItem(usuarioSeleccionado.getTipoDocumento());
			this.comboBoxTipoUsuario.setSelectedItem(usuarioSeleccionado.getPermisos().toString());	
		}
	}
}

