package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import modelo.Ticket;
import controlador.Controlador;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("rawtypes")
public class MenuOperador extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPatente;
	private JTextField textFieldCliente;
	private JTextField textFieldObsevacion;
	private JTextField textFieldTotalAPagar;
	private JTextField textFieldIngreso;
	private JTextField textFieldEgreso;
	private JTextField textFieldTiempoEstadia;
	private JTextField textFieldNumeroTicket;
	private JMenuBar menuBar;
	private JMenu mnAltas;
	private JMenuItem mntmModelo;
	private JMenuItem mntmColor;
	private JMenu mnConsultas;
	private JMenuItem mntmArqueoDeCaja;
	private JMenu mnMiCuenta;
	private JMenuItem mntmCambiarContrasea;
	private JLabel lblCodigoTicket;
	private JLabel lblCategoria;
	private JComboBox comboBoxTipoVehiculo;
	private JLabel lblPatente;
	private JLabel lblColor;
	private JComboBox comboBoxColor;
	private JLabel lblModelo;
	private JComboBox comboBoxModelo;
	private JLabel lblDescuento;
	private JComboBox comboBoxDescuento;
	private JLabel lblPrePago;
	private JLabel lblCliente;
	private JButton btnButtonBuscarCliente;
	private JLabel lblPerdidaTicket;
	private JLabel lblObservacion;
	private JButton btnCanelarF;
	private JButton btnGuardarF;
	private JButton btnTicketF;
	private JLabel lblTotalAPagar;
	private JButton btnCobrarF;
	private JPanel panel;
	private JLabel lblIngreso;
	private JLabel lblEgreso;
	private JLabel lblEstadia;
	private JTextField textFieldPrepago;
	private JLabel labelUsuario;
	private JMenuItem mntmTicketsAbiertos;
	private JMenuItem mntmCerrarSesion;
	private JButton btnBuscarPorTicketAbierto;
	private JButton btnLimpiarCampos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOperador frame = new MenuOperador();
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
	@SuppressWarnings("unchecked")
	public MenuOperador() {
		setFont(new Font("Dialog", Font.BOLD, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MenuOperador.class.getResource("/image/printer.png")));
		setResizable(false);
		setTitle("Gertor Ingresos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 775);

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setJMenuBar(menuBar);

		mnAltas = new JMenu("Altas");
		mnAltas.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnAltas.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/plus.png")));
		menuBar.add(mnAltas);

		mntmModelo = new JMenuItem("Modelo F8");
		mntmModelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnAltas.add(mntmModelo);
		mntmModelo.addActionListener(this);


		mntmColor = new JMenuItem("Color F9");
		mntmColor.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnAltas.add(mntmColor);
		mntmColor.addActionListener(this);


		mnConsultas = new JMenu("Consultas");
		mnConsultas.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnConsultas.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/buscar.png")));
		menuBar.add(mnConsultas);


		mntmTicketsAbiertos = new JMenuItem("Tickets abiertos");
		mntmTicketsAbiertos.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnConsultas.add(mntmTicketsAbiertos);
		mntmTicketsAbiertos.addActionListener(this);


		mntmArqueoDeCaja = new JMenuItem("Arqueo de Caja");
		mntmArqueoDeCaja.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnConsultas.add(mntmArqueoDeCaja);
		mntmArqueoDeCaja.addActionListener(this);



		mnMiCuenta = new JMenu("Mi Cuenta");
		mnMiCuenta.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnMiCuenta.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/users.png")));
		menuBar.add(mnMiCuenta);

		mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
		mntmCambiarContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnMiCuenta.add(mntmCambiarContrasea);
		mntmCambiarContrasea.addActionListener(this);


		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnMiCuenta.add(mntmCerrarSesion);
		mntmCerrarSesion.addActionListener(this);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 200, 250, 67, 200, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 70, 69, 70, 70, 70, 70, 0, 0,
				60, 70, 0, 50, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);



		lblCodigoTicket = new JLabel("Codigo Ticket:");
		lblCodigoTicket.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCodigoTicket = new GridBagConstraints();
		gbc_lblCodigoTicket.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoTicket.gridx = 0;
		gbc_lblCodigoTicket.gridy = 0;
		contentPane.add(lblCodigoTicket, gbc_lblCodigoTicket);

		textFieldNumeroTicket = new JTextField();
		textFieldNumeroTicket.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textFieldNumeroTicket.setColumns(10);
		GridBagConstraints gbc_textFieldNumeroTicket = new GridBagConstraints();
		gbc_textFieldNumeroTicket.gridwidth = 2;
		gbc_textFieldNumeroTicket.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumeroTicket.fill = GridBagConstraints.BOTH;
		gbc_textFieldNumeroTicket.gridx = 1;
		gbc_textFieldNumeroTicket.gridy = 0;
		contentPane.add(textFieldNumeroTicket, gbc_textFieldNumeroTicket);
		textFieldNumeroTicket.addKeyListener(this);
		
		btnLimpiarCampos = new JButton("Limpiar Campos F6");
		btnLimpiarCampos.setFont(new Font("Dialog", Font.PLAIN, 30));
		GridBagConstraints gbc_btnLimpiarCampos = new GridBagConstraints();
		gbc_btnLimpiarCampos.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiarCampos.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiarCampos.gridx = 3;
		gbc_btnLimpiarCampos.gridy = 0;
		contentPane.add(btnLimpiarCampos, gbc_btnLimpiarCampos);
		btnLimpiarCampos.addActionListener(this);
		
		labelUsuario = new JLabel();
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setForeground(Color.BLUE);
		labelUsuario.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_labelUsuario.gridx = 4;
		gbc_labelUsuario.gridy = 0;
		contentPane.add(labelUsuario, gbc_labelUsuario);
		labelUsuario.setText(Controlador.getInstancia().getUsuarioActual().getNombre() + " " + Controlador.getInstancia().getUsuarioActual().getApellido());

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 1;
		contentPane.add(lblCategoria, gbc_lblCategoria);

		comboBoxTipoVehiculo = new JComboBox();
		comboBoxTipoVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBoxTipoVehiculo.setModel(new DefaultComboBoxModel());
		for (String catString : Controlador.getInstancia().getCategoriasVehiculosActuales()) {
			comboBoxTipoVehiculo.addItem(catString);
		}
		GridBagConstraints gbc_comboBoxTipoVehiculo = new GridBagConstraints();
		gbc_comboBoxTipoVehiculo.gridwidth = 2;
		gbc_comboBoxTipoVehiculo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoVehiculo.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTipoVehiculo.gridx = 1;
		gbc_comboBoxTipoVehiculo.gridy = 1;
		contentPane.add(comboBoxTipoVehiculo, gbc_comboBoxTipoVehiculo);

		lblPatente = new JLabel("Patente:");
		lblPatente.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblPatente = new GridBagConstraints();
		gbc_lblPatente.anchor = GridBagConstraints.EAST;
		gbc_lblPatente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatente.gridx = 3;
		gbc_lblPatente.gridy = 1;
		contentPane.add(lblPatente, gbc_lblPatente);

		textFieldPatente = new JTextField();
		textFieldPatente.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_textFieldPatente = new GridBagConstraints();
		gbc_textFieldPatente.fill = GridBagConstraints.BOTH;
		gbc_textFieldPatente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPatente.gridx = 4;
		gbc_textFieldPatente.gridy = 1;
		contentPane.add(textFieldPatente, gbc_textFieldPatente);
		textFieldPatente.setColumns(10);
		textFieldPatente.addKeyListener(this);

		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 2;
		contentPane.add(lblColor, gbc_lblColor);

		comboBoxColor = new JComboBox();
		comboBoxColor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBoxColor.setModel(new DefaultComboBoxModel());
		for (String colString : Controlador.getInstancia().getColoresActuales()) {
			comboBoxColor.addItem(colString);
		}
		
		GridBagConstraints gbc_comboBoxColor = new GridBagConstraints();
		gbc_comboBoxColor.gridwidth = 2;
		gbc_comboBoxColor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxColor.fill = GridBagConstraints.BOTH;
		gbc_comboBoxColor.gridx = 1;
		gbc_comboBoxColor.gridy = 2;
		contentPane.add(comboBoxColor, gbc_comboBoxColor);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 3;
		gbc_lblModelo.gridy = 2;
		contentPane.add(lblModelo, gbc_lblModelo);

		comboBoxModelo = new JComboBox();
		comboBoxModelo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBoxModelo.setModel(new DefaultComboBoxModel());
		for (String modString : Controlador.getInstancia().getModelosActuales()) {
			comboBoxModelo.addItem(modString);
		}
		
		GridBagConstraints gbc_comboBoxModelo = new GridBagConstraints();
		gbc_comboBoxModelo.fill = GridBagConstraints.BOTH;
		gbc_comboBoxModelo.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxModelo.gridx = 4;
		gbc_comboBoxModelo.gridy = 2;
		contentPane.add(comboBoxModelo, gbc_comboBoxModelo);

		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.EAST;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 0;
		gbc_lblDescuento.gridy = 3;
		contentPane.add(lblDescuento, gbc_lblDescuento);

		comboBoxDescuento = new JComboBox();
		comboBoxDescuento.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBoxDescuento.setModel(new DefaultComboBoxModel());
		for (String descString : Controlador.getInstancia().getDescuentosActuales()) {
			comboBoxDescuento.addItem(descString);
		}
		GridBagConstraints gbc_comboBoxDescuento = new GridBagConstraints();
		gbc_comboBoxDescuento.gridwidth = 2;
		gbc_comboBoxDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDescuento.fill = GridBagConstraints.BOTH;
		gbc_comboBoxDescuento.gridx = 1;
		gbc_comboBoxDescuento.gridy = 3;
		contentPane.add(comboBoxDescuento, gbc_comboBoxDescuento);

		lblPrePago = new JLabel("PrePago:");
		lblPrePago.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblEstadia = new GridBagConstraints();
		gbc_lblEstadia.anchor = GridBagConstraints.EAST;
		gbc_lblEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadia.gridx = 3;
		gbc_lblEstadia.gridy = 3;
		contentPane.add(lblPrePago, gbc_lblEstadia);

		textFieldPrepago = new JTextField();
		textFieldPrepago.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textFieldPrepago.setColumns(10);
		GridBagConstraints gbc_textFieldPrepado = new GridBagConstraints();
		gbc_textFieldPrepado.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrepado.fill = GridBagConstraints.BOTH;
		gbc_textFieldPrepado.gridx = 4;
		gbc_textFieldPrepado.gridy = 3;
		contentPane.add(textFieldPrepago, gbc_textFieldPrepado);
		textFieldPrepago.addKeyListener(this);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 4;
		contentPane.add(lblCliente, gbc_lblCliente);

		textFieldCliente = new JTextField();
		textFieldCliente.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textFieldCliente.setEnabled(false);
		textFieldCliente.setEditable(false);
		GridBagConstraints gbc_textFieldCliente = new GridBagConstraints();
		gbc_textFieldCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCliente.fill = GridBagConstraints.BOTH;
		gbc_textFieldCliente.gridx = 1;
		gbc_textFieldCliente.gridy = 4;
		contentPane.add(textFieldCliente, gbc_textFieldCliente);
		textFieldCliente.setColumns(10);

		btnButtonBuscarCliente = new JButton("");
		btnButtonBuscarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnButtonBuscarCliente.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/search.png")));
		GridBagConstraints gbc_btnButtonBuscarCliente = new GridBagConstraints();
		gbc_btnButtonBuscarCliente.fill = GridBagConstraints.BOTH;
		gbc_btnButtonBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnButtonBuscarCliente.gridx = 2;
		gbc_btnButtonBuscarCliente.gridy = 4;
		contentPane.add(btnButtonBuscarCliente, gbc_btnButtonBuscarCliente);
		btnButtonBuscarCliente.addActionListener(this);
		
		lblPerdidaTicket = new JLabel("Perdida Ticket:");
		lblPerdidaTicket.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblPerdidaTicket = new GridBagConstraints();
		gbc_lblPerdidaTicket.anchor = GridBagConstraints.EAST;
		gbc_lblPerdidaTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerdidaTicket.gridx = 3;
		gbc_lblPerdidaTicket.gridy = 4;
		contentPane.add(lblPerdidaTicket, gbc_lblPerdidaTicket);
		
		btnBuscarPorTicketAbierto = new JButton("Buscar Ticket");
		btnBuscarPorTicketAbierto.setFont(new Font("Dialog", Font.PLAIN, 30));
		btnBuscarPorTicketAbierto.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/search.png")));
		GridBagConstraints gbc_buttonBuscarPorTicketAbierto = new GridBagConstraints();
		gbc_buttonBuscarPorTicketAbierto.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonBuscarPorTicketAbierto.insets = new Insets(0, 0, 5, 0);
		gbc_buttonBuscarPorTicketAbierto.gridx = 4;
		gbc_buttonBuscarPorTicketAbierto.gridy = 4;
		contentPane.add(btnBuscarPorTicketAbierto, gbc_buttonBuscarPorTicketAbierto);
		btnBuscarPorTicketAbierto.addActionListener(this);
		
		lblObservacion = new JLabel("Observacion:");
		lblObservacion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblObservacion = new GridBagConstraints();
		gbc_lblObservacion.anchor = GridBagConstraints.EAST;
		gbc_lblObservacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservacion.gridx = 0;
		gbc_lblObservacion.gridy = 5;
		contentPane.add(lblObservacion, gbc_lblObservacion);

		textFieldObsevacion = new JTextField();
		textFieldObsevacion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		contentPane.add(textFieldObsevacion, gbc_textField);
		textFieldObsevacion.setColumns(10);
		textFieldObsevacion.addKeyListener(this);

		btnCanelarF = new JButton("Canelar F4");
		btnCanelarF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCanelarF.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/cancel.png")));
		GridBagConstraints gbc_btnCanelarF = new GridBagConstraints();
		gbc_btnCanelarF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCanelarF.insets = new Insets(0, 0, 5, 5);
		gbc_btnCanelarF.gridx = 0;
		gbc_btnCanelarF.gridy = 7;
		contentPane.add(btnCanelarF, gbc_btnCanelarF);
		btnCanelarF.addActionListener(this);

		btnGuardarF = new JButton("Guardar F2");
		btnGuardarF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardarF.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/modificar.png")));
		GridBagConstraints gbc_btnGuardarF = new GridBagConstraints();
		gbc_btnGuardarF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarF.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarF.gridx = 1;
		gbc_btnGuardarF.gridy = 7;
		contentPane.add(btnGuardarF, gbc_btnGuardarF);
		btnGuardarF.addActionListener(this);

		btnTicketF = new JButton("Ticket F5");
		btnTicketF.setFont(new Font("Dialog", Font.PLAIN, 30));
		btnTicketF.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/printer.png")));
		GridBagConstraints gbc_btnTicketF = new GridBagConstraints();
		gbc_btnTicketF.gridheight = 2;
		gbc_btnTicketF.fill = GridBagConstraints.BOTH;
		gbc_btnTicketF.insets = new Insets(0, 0, 5, 0);
		gbc_btnTicketF.gridx = 4;
		gbc_btnTicketF.gridy = 7;
		contentPane.add(btnTicketF, gbc_btnTicketF);
		btnTicketF.addActionListener(this);

		lblTotalAPagar = new JLabel("Total a Pagar:");
		lblTotalAPagar.setForeground(Color.BLUE);
		lblTotalAPagar.setFont(new Font("Dialog", Font.BOLD, 30));
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTotalAPagar = new GridBagConstraints();
		gbc_lblTotalAPagar.gridwidth = 4;
		gbc_lblTotalAPagar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotalAPagar.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalAPagar.gridx = 0;
		gbc_lblTotalAPagar.gridy = 8;
		contentPane.add(lblTotalAPagar, gbc_lblTotalAPagar);

		textFieldTotalAPagar = new JTextField();
		textFieldTotalAPagar.setEditable(false);
		textFieldTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalAPagar.setFont(new Font("Dialog", Font.BOLD, 40));
		textFieldTotalAPagar.setForeground(Color.RED);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridheight = 2;
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 9;
		contentPane.add(textFieldTotalAPagar, gbc_textField_1);
		textFieldTotalAPagar.setColumns(10);

		btnCobrarF = new JButton("Cobrar F7");
		btnCobrarF.setFont(new Font("Dialog", Font.PLAIN, 30));
		btnCobrarF.setIcon(new ImageIcon(MenuOperador.class
				.getResource("/image/cash.png")));
		GridBagConstraints gbc_btnCobrarF = new GridBagConstraints();
		gbc_btnCobrarF.gridheight = 2;
		gbc_btnCobrarF.insets = new Insets(0, 0, 5, 0);
		gbc_btnCobrarF.fill = GridBagConstraints.BOTH;
		gbc_btnCobrarF.gridx = 4;
		gbc_btnCobrarF.gridy = 9;
		contentPane.add(btnCobrarF, gbc_btnCobrarF);
		btnCobrarF.addActionListener(this);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 11;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 188, 202, 159, 207, 239, 202, 0 };
		gbl_panel.rowHeights = new int[] { 22, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblIngreso = new JLabel("Ingreso:");
		lblIngreso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblIngreso = new GridBagConstraints();
		gbc_lblIngreso.anchor = GridBagConstraints.EAST;
		gbc_lblIngreso.insets = new Insets(0, 0, 0, 5);
		gbc_lblIngreso.gridx = 0;
		gbc_lblIngreso.gridy = 0;
		panel.add(lblIngreso, gbc_lblIngreso);

		textFieldIngreso = new JTextField();
		textFieldIngreso.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldIngreso.setEnabled(false);
		textFieldIngreso.setEditable(false);
		GridBagConstraints gbc_textFieldIngreso = new GridBagConstraints();
		gbc_textFieldIngreso.fill = GridBagConstraints.BOTH;
		gbc_textFieldIngreso.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldIngreso.gridx = 1;
		gbc_textFieldIngreso.gridy = 0;
		panel.add(textFieldIngreso, gbc_textFieldIngreso);
		textFieldIngreso.setColumns(10);

		lblEgreso = new JLabel("Egreso:");
		lblEgreso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblEgreso = new GridBagConstraints();
		gbc_lblEgreso.anchor = GridBagConstraints.EAST;
		gbc_lblEgreso.insets = new Insets(0, 0, 0, 5);
		gbc_lblEgreso.gridx = 2;
		gbc_lblEgreso.gridy = 0;
		panel.add(lblEgreso, gbc_lblEgreso);

		textFieldEgreso = new JTextField();
		textFieldEgreso.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldEgreso.setEnabled(false);
		textFieldEgreso.setEditable(false);
		GridBagConstraints gbc_textFieldEgreso = new GridBagConstraints();
		gbc_textFieldEgreso.fill = GridBagConstraints.BOTH;
		gbc_textFieldEgreso.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldEgreso.gridx = 3;
		gbc_textFieldEgreso.gridy = 0;
		panel.add(textFieldEgreso, gbc_textFieldEgreso);
		textFieldEgreso.setColumns(10);

		lblEstadia = new JLabel("Estadia:");
		lblEstadia.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblEstadia_1 = new GridBagConstraints();
		gbc_lblEstadia_1.anchor = GridBagConstraints.EAST;
		gbc_lblEstadia_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstadia_1.gridx = 4;
		gbc_lblEstadia_1.gridy = 0;
		panel.add(lblEstadia, gbc_lblEstadia_1);

		textFieldTiempoEstadia = new JTextField();
		textFieldTiempoEstadia.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldTiempoEstadia.setEnabled(false);
		textFieldTiempoEstadia.setEditable(false);
		textFieldTiempoEstadia.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 0;
		panel.add(textFieldTiempoEstadia, gbc_textField_2);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == btnCobrarF) {
			if(!Controlador.getInstancia().cobrarTicket()){
				//TODO Imprimir error, ticket ya cobrado
			}
			
		}
		if (event.getSource() == btnGuardarF) {
			
			//TODO si pasaron 5 min desde q se creo bloquear los campos correspondientes
			Controlador.getInstancia()
			.actualizarTicket(
					(String) comboBoxTipoVehiculo.getSelectedItem(),
					(String) comboBoxModelo.getSelectedItem(),
					(String) comboBoxColor.getSelectedItem(),
					(String) comboBoxDescuento.getSelectedItem(),
					textFieldPatente.getText(),
					textFieldCliente.getText(),
					textFieldPrepago.getText(),
					textFieldObsevacion.getText());
		}
		
		if (event.getSource() == btnCanelarF) {
			if(isNumeric(textFieldNumeroTicket.getText()) && (textFieldPrepago.getText().equals("")||isNumeric(textFieldPrepago.getText()))){
				Ticket tck = Controlador.getInstancia().buscarTicket(textFieldNumeroTicket.getText());
					if (tck!=null){
						this.textFieldNumeroTicket.setBackground(new Color(Color.WHITE.getRGB()));
						textFieldPrepago.setBackground(new Color(Color.WHITE.getRGB()));
						
						Date horaCreado = tck.getFechaLlegada();
						Date horaActual = Calendar.getInstance().getTime();
						long diff  = horaActual.getTime() - horaCreado.getTime();
						long diffMinutes = diff / (60 * 1000);
						//Solo acepto 5 min de tiempo para cancelar
						if(diffMinutes <= 5){
							if(!Controlador.getInstancia().cancelarTicket(tck)){
								//TODO Cartel error
							}
						}else{
							//TODO Cartel error
						}
						
						
					}else{
						textFieldNumeroTicket.setBackground(new Color(Color.ORANGE.getRGB()));
					}
				}else{
					if(!isNumeric(textFieldNumeroTicket.getText()))
					textFieldNumeroTicket.setBackground(new Color(Color.PINK.getRGB()));
					if(textFieldPrepago.getText().equals("")||isNumeric(textFieldPrepago.getText())) textFieldPrepago.setBackground(new Color(Color.PINK.getRGB()));
				}
		}	
		
		if (event.getSource() == btnButtonBuscarCliente) {
			new BuscadorCliente().setVisible(true);
			//TODO
		}
		if (event.getSource() == btnBuscarPorTicketAbierto) {
			//TODO
		}
		if (event.getSource() == btnLimpiarCampos) {
			this.textFieldNumeroTicket.setBackground(new Color(Color.WHITE.getRGB()));
			this.textFieldPrepago.setBackground(new Color(Color.WHITE.getRGB()));
			this.textFieldPatente.setBackground(new Color(Color.WHITE.getRGB()));
			this.textFieldIngreso.setText("");
			this.comboBoxTipoVehiculo.setSelectedIndex(0);
			this.comboBoxTipoVehiculo.setEditable(true);
			this.comboBoxColor.setSelectedIndex(0);
			this.comboBoxModelo.setSelectedIndex(0);
			this.comboBoxDescuento.setSelectedIndex(0);
			this.textFieldPatente.setText("");
			this.textFieldEgreso.setText("");
			this.textFieldObsevacion.setText("");
			this.textFieldPrepago.setText("");
			this.textFieldPrepago.setEditable(true);
			this.textFieldTiempoEstadia.setText("");
			this.textFieldTotalAPagar.setText("");
			this.textFieldCliente.setText("");
			this.textFieldNumeroTicket.setText("");
		}
		if (event.getSource() == btnTicketF) {
			
			if(!this.textFieldPatente.getText().equals("")) {
			
			Ticket tck= Controlador.getInstancia()
					.generarTicket(
							(String) comboBoxTipoVehiculo.getSelectedItem(),
							(String) comboBoxModelo.getSelectedItem(),
							(String) comboBoxColor.getSelectedItem(),
							(String) comboBoxDescuento.getSelectedItem(),
							textFieldPatente.getText(),
							textFieldCliente.getText(),
							textFieldPrepago.getText(),
							textFieldObsevacion.getText());

			this.textFieldNumeroTicket.setBackground(new Color(Color.WHITE.getRGB()));
			this.textFieldPatente.setBackground(new Color(Color.WHITE.getRGB()));
			this.textFieldPatente.setBackground(new Color(Color.WHITE.getRGB()));
			String numeroTck = String.valueOf(tck.getIdTicket());
			while (numeroTck.length() < 10) {
				numeroTck = "0"+numeroTck; 
			}
			this.textFieldNumeroTicket.setText(numeroTck);
			this.textFieldIngreso.setText(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(tck.getFechaLlegada()));
			this.comboBoxTipoVehiculo.setSelectedItem(tck.getCatergoriaVehiculo().getDescripcion());
			this.comboBoxColor.setSelectedItem(tck.getColor().getDescripcion());
			this.comboBoxModelo.setSelectedItem(tck.getModeloVehiculo().getDescripcion());
			this.comboBoxDescuento.setSelectedItem(tck.getDescuento().getDescripcion());
			this.textFieldPatente.setText(tck.getPatente());
			if (tck.getFechaSalida() != null) this.textFieldEgreso.setText(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(tck.getFechaSalida()));
			this.textFieldObsevacion.setText(tck.getObservacion());
			this.textFieldPrepago.setText(String.valueOf(tck.getPrepago()));
			this.textFieldPrepago.setEditable(true);
			this.textFieldTiempoEstadia.setText(tck.getTiempoEstadia());
			
			//TODO bloquear botones y demas hasta que elija nuevo
			}else{
				this.textFieldPatente.setBackground(new Color(Color.PINK.getRGB()));
			}

		}

		if (event.getSource() == mntmCerrarSesion){
			new Login().setVisible(true);
			dispose();			
		}
		if (event.getSource() == mntmArqueoDeCaja){
			new ArqueoDeCaja().setVisible(true);
		}	
		if (event.getSource() == mntmModelo){
			new GestionColor().setVisible(true);
		}
		if (event.getSource() == mntmColor){
			new GestionModelo().setVisible(true);
		}
		if (event.getSource() == mntmCambiarContrasea){
			new CambioContrasenia().setVisible(true);
		}	
		


	}

	@Override
	public void keyPressed(KeyEvent event) {
		
		if (event.getKeyCode()== KeyEvent.VK_ENTER && this.textFieldNumeroTicket.isFocusOwner()){
			//TODO Bloquear resto de cosas
			if(isNumeric(textFieldNumeroTicket.getText()) && (textFieldPrepago.getText().equals("")||isNumeric(textFieldPrepago.getText()))){
			Ticket tck = Controlador.getInstancia().buscarTicket(textFieldNumeroTicket.getText());
				if (tck!=null){
					this.textFieldNumeroTicket.setBackground(new Color(Color.WHITE.getRGB()));
					this.textFieldPrepago.setBackground(new Color(Color.WHITE.getRGB()));
					this.textFieldPatente.setBackground(new Color(Color.WHITE.getRGB()));
					String numeroTck = String.valueOf(tck.getIdTicket());
					while (numeroTck.length() < 10) {
						numeroTck = "0"+numeroTck; 
					}
					this.textFieldNumeroTicket.setText(numeroTck);
					this.textFieldIngreso.setText(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(tck.getFechaLlegada()));
					this.comboBoxTipoVehiculo.setSelectedItem(tck.getCatergoriaVehiculo().getDescripcion());
					this.comboBoxColor.setSelectedItem(tck.getColor().getDescripcion());
					this.comboBoxModelo.setSelectedItem(tck.getModeloVehiculo().getDescripcion());
					this.comboBoxDescuento.setSelectedItem(tck.getDescuento().getDescripcion());
					this.textFieldPatente.setText(tck.getPatente());
					if (tck.getFechaSalida() != null) this.textFieldEgreso.setText(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(tck.getFechaSalida()));
					this.textFieldObsevacion.setText(tck.getObservacion());
					this.textFieldPrepago.setText(String.valueOf(tck.getPrepago()));
					this.textFieldPrepago.setEditable(false);
					this.textFieldTiempoEstadia.setText(tck.getTiempoEstadia());
					if(tck.getEstado() == Ticket.Estado.CERRADO){
						this.textFieldTotalAPagar.setText("(PAGADO) " + String.valueOf(tck.getMontoCobrado()));
					}else if (tck.getEstado() == Ticket.Estado.PREPAGO){
						this.textFieldTotalAPagar.setText("Pregago " + String.valueOf(tck.getPrepago()) + " restan: "+ String.valueOf(tck.getMontoCobrado()));
					} else this.textFieldTotalAPagar.setText(String.valueOf(tck.getMontoCobrado()));
					if (tck.getCliente() != null) this.textFieldCliente.setText(tck.getCliente().getApellido() + " " +tck.getCliente().getNombre());
				}else{
					String numeroTck = textFieldNumeroTicket.getText();
					while (numeroTck.length() < 10) {
						numeroTck = "0"+numeroTck; 
					}
					this.textFieldNumeroTicket.setText(numeroTck);
					this.textFieldNumeroTicket.setBackground(new Color(Color.ORANGE.getRGB()));
					this.textFieldPrepago.setBackground(new Color(Color.WHITE.getRGB()));
					this.textFieldPatente.setBackground(new Color(Color.WHITE.getRGB()));
					this.textFieldIngreso.setText("");
					this.comboBoxTipoVehiculo.setSelectedIndex(0);
					this.comboBoxColor.setSelectedIndex(0);
					this.comboBoxModelo.setSelectedIndex(0);
					this.comboBoxDescuento.setSelectedIndex(0);
					this.textFieldPatente.setText("");
					this.textFieldEgreso.setText("");
					this.textFieldObsevacion.setText("");
					this.textFieldPrepago.setText("");
					this.textFieldPrepago.setEditable(true);
					this.textFieldTiempoEstadia.setText("");
					this.textFieldTotalAPagar.setText("");
					this.textFieldCliente.setText("");
				}
			}else{
				if(!isNumeric(textFieldNumeroTicket.getText()))
				textFieldNumeroTicket.setBackground(new Color(Color.PINK.getRGB()));
				if(textFieldPrepago.getText().equals("")||isNumeric(textFieldPrepago.getText())) textFieldPrepago.setBackground(new Color(Color.PINK.getRGB()));
			}
		}
		if (event.getKeyCode()== KeyEvent.VK_F2 ){
			this.btnGuardarF.doClick();
		}
		if (event.getKeyCode()== KeyEvent.VK_F4 ){
			this.btnCanelarF.doClick();
		}
		if (event.getKeyCode()== KeyEvent.VK_F5 ){
			this.btnTicketF.doClick();
		}
		if (event.getKeyCode()== KeyEvent.VK_F7 ){
			this.btnCanelarF.doClick();
		}
		if (event.getKeyCode()== KeyEvent.VK_F6 ){
			this.btnLimpiarCampos.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
		
		
	}
	
	@SuppressWarnings("unused")
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	
}
