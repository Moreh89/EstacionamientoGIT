package vista;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

import org.jdesktop.swingx.JXDatePicker;

import modelo.Cliente;
import modelo.Usuario;
import controlador.Controlador;
import java.awt.Panel;



@SuppressWarnings("rawtypes")
public class VerMovimientosCC extends JDialog implements ActionListener, KeyListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	@SuppressWarnings("unused")
	private CobroExtraordinario cobroExtraordinario;


	private JButton buscarButton;
	private JPanel panelClientes;
	private JScrollPane scrollPaneClientes;
	private JList listUsuarios;
	private DefaultListModel<Usuario> listModel;
	private JPanel panelAtributos;
	private JButton btnCancelar;
	private JXDatePicker fechaDesde;
	private JLabel lblFechaHasta;
	private JXDatePicker fechaHasta;
	private JLabel lblFecha;
	private JLabel lblDescripcin;
	private JLabel lblMonto;
	private JLabel lblUsuario;
	private JLabel lblTicket;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerMovimientosCC frame = new VerMovimientosCC();
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

	public VerMovimientosCC() {
		initGUI();
	}



	@SuppressWarnings("unchecked")
	public void initGUI(){
		setTitle("Movimientos Cuenta Corriente");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 614);
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 90, 510, 6);
		contentPane.add(separator);

		panelAtributos = new JPanel();
		panelAtributos.setBounds(17, 259, 503, 275);
		contentPane.add(panelAtributos);
		GridBagLayout gbl_panelAtributos = new GridBagLayout();
		gbl_panelAtributos.columnWidths = new int[]{0, 0, 0};
		gbl_panelAtributos.rowHeights = new int[]{30, 30, 30, 30, 0, 30, 0, 30, 0};
		gbl_panelAtributos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAtributos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAtributos.setLayout(gbl_panelAtributos);
		
		lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 0;
		panelAtributos.add(lblFecha, gbc_lblFecha);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 1;
		panelAtributos.add(lblDescripcin, gbc_lblDescripcin);
		
		lblMonto = new JLabel("Monto:");
		GridBagConstraints gbc_lblMonto = new GridBagConstraints();
		gbc_lblMonto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonto.gridx = 0;
		gbc_lblMonto.gridy = 2;
		panelAtributos.add(lblMonto, gbc_lblMonto);
		
		lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 3;
		panelAtributos.add(lblUsuario, gbc_lblUsuario);
		
		lblTicket = new JLabel("Ticket:");
		GridBagConstraints gbc_lblTicket = new GridBagConstraints();
		gbc_lblTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblTicket.gridx = 0;
		gbc_lblTicket.gridy = 4;
		panelAtributos.add(lblTicket, gbc_lblTicket);
		Vector comboBoxTipoUsuarioItems=new Vector<String>();
		comboBoxTipoUsuarioItems.add(modelo.Usuario.PERMISOS.ADMIN.toString());
		comboBoxTipoUsuarioItems.add(modelo.Usuario.PERMISOS.CAJA.toString());

		panelClientes = new JPanel();
		panelClientes.setBounds(10, 96, 503, 135);
		contentPane.add(panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{240, 0};
		gbl_panelClientes.rowHeights = new int[]{125, 0};
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

		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		btnCancelar.setBounds(395, 545, 120, 29);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		Panel panel = new Panel();
		panel.setBounds(10, 0, 503, 84);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 126, 55, 93, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
						GridBagConstraints gbc_fechaDesde_1_1 = new GridBagConstraints();
						gbc_fechaDesde_1_1.anchor = GridBagConstraints.WEST;
						gbc_fechaDesde_1_1.gridx = 2;
						gbc_fechaDesde_1_1.gridy = 1;
						gbc_fechaDesde_1_1.fill = GridBagConstraints.BOTH;
						gbc_fechaDesde_1_1.insets = new Insets(0, 0, 0, 5);
						
						JLabel lblFechaDesde = new JLabel("Fecha Desde:");
						GridBagConstraints gbc_lblFechaDesde = new GridBagConstraints();
						gbc_lblFechaDesde.anchor = GridBagConstraints.WEST;
						gbc_lblFechaDesde.insets = new Insets(0, 0, 5, 5);
						gbc_lblFechaDesde.gridx = 0;
						gbc_lblFechaDesde.gridy = 0;
						panel.add(lblFechaDesde, gbc_lblFechaDesde);
				
						fechaDesde = new JXDatePicker();
						GridBagConstraints gbc_fechaDesde_1_1 = new GridBagConstraints();
						gbc_fechaDesde_1_1.fill = GridBagConstraints.HORIZONTAL;
						gbc_fechaDesde_1_1.insets = new Insets(0, 0, 5, 5);
						gbc_fechaDesde_1_1.gridx = 1;
						gbc_fechaDesde_1_1.gridy = 0;
						panel.add(fechaDesde, gbc_fechaDesde_1_1);
						fechaDesde.setDate(Calendar.getInstance().getTime());
						fechaDesde.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		
		
				buscarButton = new JButton("Buscar");
				GridBagConstraints gbc_buscarButton = new GridBagConstraints();
				gbc_buscarButton.fill = GridBagConstraints.BOTH;
				gbc_buscarButton.gridheight = 2;
				gbc_buscarButton.gridx = 3;
				gbc_buscarButton.gridy = 0;
				panel.add(buscarButton, gbc_buscarButton);
				buscarButton.addActionListener(this);
				buscarButton.setIcon(new ImageIcon(VerMovimientosCC.class.getResource("/image/search.png")));
				
				lblFechaHasta = new JLabel("Fecha Hasta:");
				GridBagConstraints gbc_lblFechaHasta = new GridBagConstraints();
				gbc_lblFechaHasta.anchor = GridBagConstraints.WEST;
				gbc_lblFechaHasta.insets = new Insets(0, 0, 0, 5);
				gbc_lblFechaHasta.gridx = 0;
				gbc_lblFechaHasta.gridy = 1;
				panel.add(lblFechaHasta, gbc_lblFechaHasta);
				
				fechaHasta = new JXDatePicker();
				GridBagConstraints gbc_fechaHasta = new GridBagConstraints();
				gbc_fechaHasta.fill = GridBagConstraints.HORIZONTAL;
				gbc_fechaHasta.insets = new Insets(0, 0, 0, 5);
				gbc_fechaHasta.gridx = 1;
				gbc_fechaHasta.gridy = 1;
				panel.add(fechaHasta, gbc_fechaHasta);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(10, 242, 510, 6);
				contentPane.add(separator_1);
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

