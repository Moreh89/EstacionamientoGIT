package vista;

import java.awt.BorderLayout;
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
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;

public class MenuOperador extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPatente;
	private JTextField textFieldCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldIngreso;
	private JTextField textFieldEgreso;
	private JTextField textField_2;
	private JTextField textFieldNumeroTicket;

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
	public MenuOperador() {
		setTitle("Gertor Ingresos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 420);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAltas = new JMenu("Altas");
		mnAltas.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/plus.png")));
		menuBar.add(mnAltas);
		
		JMenuItem mntmModelo = new JMenuItem("Modelo");
		mnAltas.add(mntmModelo);
		
		JMenuItem mntmColor = new JMenuItem("Color");
		mnAltas.add(mntmColor);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/buscar.png")));
		menuBar.add(mnConsultas);
		
		JMenuItem mntmArqueoDeCaja = new JMenuItem("Arqueo de Caja");
		mnConsultas.add(mntmArqueoDeCaja);
		
		JMenu mnMiCuenta = new JMenu("Mi Cuenta");
		mnMiCuenta.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/users.png")));
		menuBar.add(mnMiCuenta);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contraseña");
		mnMiCuenta.add(mntmCambiarContrasea);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCodigoTicket = new JLabel("Codigo Ticket:");
		GridBagConstraints gbc_lblCodigoTicket = new GridBagConstraints();
		gbc_lblCodigoTicket.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoTicket.gridx = 0;
		gbc_lblCodigoTicket.gridy = 0;
		contentPane.add(lblCodigoTicket, gbc_lblCodigoTicket);
		
		textFieldNumeroTicket = new JTextField();
		textFieldNumeroTicket.setColumns(10);
		GridBagConstraints gbc_textFieldNumeroTicket = new GridBagConstraints();
		gbc_textFieldNumeroTicket.gridwidth = 2;
		gbc_textFieldNumeroTicket.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumeroTicket.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumeroTicket.gridx = 1;
		gbc_textFieldNumeroTicket.gridy = 0;
		contentPane.add(textFieldNumeroTicket, gbc_textFieldNumeroTicket);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 1;
		contentPane.add(lblCategoria, gbc_lblCategoria);
		
		JComboBox comboBoxTipoVehiculo = new JComboBox();
		comboBoxTipoVehiculo.setModel(new DefaultComboBoxModel(new String[] {"1 Auto", "2 Camioneta", "3 Moto", "4 Bicicleta"}));
		GridBagConstraints gbc_comboBoxTipoVehiculo = new GridBagConstraints();
		gbc_comboBoxTipoVehiculo.gridwidth = 2;
		gbc_comboBoxTipoVehiculo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoVehiculo.gridx = 1;
		gbc_comboBoxTipoVehiculo.gridy = 1;
		contentPane.add(comboBoxTipoVehiculo, gbc_comboBoxTipoVehiculo);
		
		JLabel lblPatente = new JLabel("Patente:");
		GridBagConstraints gbc_lblPatente = new GridBagConstraints();
		gbc_lblPatente.anchor = GridBagConstraints.EAST;
		gbc_lblPatente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPatente.gridx = 3;
		gbc_lblPatente.gridy = 1;
		contentPane.add(lblPatente, gbc_lblPatente);
		
		textFieldPatente = new JTextField();
		GridBagConstraints gbc_textFieldPatente = new GridBagConstraints();
		gbc_textFieldPatente.fill = GridBagConstraints.BOTH;
		gbc_textFieldPatente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPatente.gridx = 4;
		gbc_textFieldPatente.gridy = 1;
		contentPane.add(textFieldPatente, gbc_textFieldPatente);
		textFieldPatente.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 2;
		contentPane.add(lblColor, gbc_lblColor);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"1 Rojo", "2 Azul", "3 Verde", "4 Negro", "5 Blanco"}));
		GridBagConstraints gbc_comboBoxColor = new GridBagConstraints();
		gbc_comboBoxColor.gridwidth = 2;
		gbc_comboBoxColor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxColor.gridx = 1;
		gbc_comboBoxColor.gridy = 2;
		contentPane.add(comboBoxColor, gbc_comboBoxColor);
		
		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 3;
		gbc_lblModelo.gridy = 2;
		contentPane.add(lblModelo, gbc_lblModelo);
		
		JComboBox comboBoxModelo = new JComboBox();
		comboBoxModelo.setModel(new DefaultComboBoxModel(new String[] {"1 Mercedes", "2 Fiat Palio", "3 Chevrolet Aveo"}));
		GridBagConstraints gbc_comboBoxModelo = new GridBagConstraints();
		gbc_comboBoxModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxModelo.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxModelo.gridx = 4;
		gbc_comboBoxModelo.gridy = 2;
		contentPane.add(comboBoxModelo, gbc_comboBoxModelo);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.anchor = GridBagConstraints.EAST;
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 0;
		gbc_lblDescuento.gridy = 3;
		contentPane.add(lblDescuento, gbc_lblDescuento);
		
		JComboBox comboBoxDescuento = new JComboBox();
		comboBoxDescuento.setModel(new DefaultComboBoxModel(new String[] {"0 N/A", "1 Farmacia 10%", "2 Socio 20%"}));
		GridBagConstraints gbc_comboBoxDescuento = new GridBagConstraints();
		gbc_comboBoxDescuento.gridwidth = 2;
		gbc_comboBoxDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDescuento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDescuento.gridx = 1;
		gbc_comboBoxDescuento.gridy = 3;
		contentPane.add(comboBoxDescuento, gbc_comboBoxDescuento);
		
		JLabel lblEstadia = new JLabel("Estadia:");
		GridBagConstraints gbc_lblEstadia = new GridBagConstraints();
		gbc_lblEstadia.anchor = GridBagConstraints.EAST;
		gbc_lblEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadia.gridx = 3;
		gbc_lblEstadia.gridy = 3;
		contentPane.add(lblEstadia, gbc_lblEstadia);
		
		JComboBox comboBoxEstadia = new JComboBox();
		comboBoxEstadia.setModel(new DefaultComboBoxModel(new String[] {"1 No", "2 Si"}));
		GridBagConstraints gbc_comboBoxEstadia = new GridBagConstraints();
		gbc_comboBoxEstadia.anchor = GridBagConstraints.WEST;
		gbc_comboBoxEstadia.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxEstadia.gridx = 4;
		gbc_comboBoxEstadia.gridy = 3;
		contentPane.add(comboBoxEstadia, gbc_comboBoxEstadia);
		
		JLabel lblCliente = new JLabel("Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 4;
		contentPane.add(lblCliente, gbc_lblCliente);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setEnabled(false);
		textFieldCliente.setEditable(false);
		GridBagConstraints gbc_textFieldCliente = new GridBagConstraints();
		gbc_textFieldCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCliente.gridx = 1;
		gbc_textFieldCliente.gridy = 4;
		contentPane.add(textFieldCliente, gbc_textFieldCliente);
		textFieldCliente.setColumns(10);
		
		JButton btnButtonBuscarCliente = new JButton("");
		btnButtonBuscarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnButtonBuscarCliente.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/search.png")));
		GridBagConstraints gbc_btnButtonBuscarCliente = new GridBagConstraints();
		gbc_btnButtonBuscarCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnButtonBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnButtonBuscarCliente.gridx = 2;
		gbc_btnButtonBuscarCliente.gridy = 4;
		contentPane.add(btnButtonBuscarCliente, gbc_btnButtonBuscarCliente);
		
		JLabel lblPerdidaTicket = new JLabel("Perdida Ticket:");
		GridBagConstraints gbc_lblPerdidaTicket = new GridBagConstraints();
		gbc_lblPerdidaTicket.anchor = GridBagConstraints.EAST;
		gbc_lblPerdidaTicket.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerdidaTicket.gridx = 3;
		gbc_lblPerdidaTicket.gridy = 4;
		contentPane.add(lblPerdidaTicket, gbc_lblPerdidaTicket);
		
		JComboBox comboBoxPerdidaTicket = new JComboBox();
		comboBoxPerdidaTicket.setModel(new DefaultComboBoxModel(new String[] {"1 No", "2 Si"}));
		GridBagConstraints gbc_comboBoxPerdidaTicket = new GridBagConstraints();
		gbc_comboBoxPerdidaTicket.anchor = GridBagConstraints.WEST;
		gbc_comboBoxPerdidaTicket.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxPerdidaTicket.gridx = 4;
		gbc_comboBoxPerdidaTicket.gridy = 4;
		contentPane.add(comboBoxPerdidaTicket, gbc_comboBoxPerdidaTicket);
		
		JLabel lblObservacion = new JLabel("Observacion:");
		GridBagConstraints gbc_lblObservacion = new GridBagConstraints();
		gbc_lblObservacion.anchor = GridBagConstraints.EAST;
		gbc_lblObservacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservacion.gridx = 0;
		gbc_lblObservacion.gridy = 5;
		contentPane.add(lblObservacion, gbc_lblObservacion);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnCanelarF = new JButton("Canelar F2");
		btnCanelarF.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_btnCanelarF = new GridBagConstraints();
		gbc_btnCanelarF.insets = new Insets(0, 0, 5, 5);
		gbc_btnCanelarF.gridx = 0;
		gbc_btnCanelarF.gridy = 7;
		contentPane.add(btnCanelarF, gbc_btnCanelarF);
		
		JButton btnGuardarF = new JButton("Guardar F5");
		btnGuardarF.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/modificar.png")));
		GridBagConstraints gbc_btnGuardarF = new GridBagConstraints();
		gbc_btnGuardarF.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarF.gridx = 1;
		gbc_btnGuardarF.gridy = 7;
		contentPane.add(btnGuardarF, gbc_btnGuardarF);
		
		JButton btnTicketF = new JButton("Ticket F7");
		GridBagConstraints gbc_btnTicketF = new GridBagConstraints();
		gbc_btnTicketF.gridheight = 2;
		gbc_btnTicketF.fill = GridBagConstraints.BOTH;
		gbc_btnTicketF.insets = new Insets(0, 0, 5, 0);
		gbc_btnTicketF.gridx = 4;
		gbc_btnTicketF.gridy = 7;
		contentPane.add(btnTicketF, gbc_btnTicketF);
		
		JLabel lblTotalAPagar = new JLabel("Total a Pagar:");
		lblTotalAPagar.setForeground(Color.BLUE);
		lblTotalAPagar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTotalAPagar = new GridBagConstraints();
		gbc_lblTotalAPagar.gridwidth = 4;
		gbc_lblTotalAPagar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotalAPagar.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalAPagar.gridx = 0;
		gbc_lblTotalAPagar.gridy = 8;
		contentPane.add(lblTotalAPagar, gbc_lblTotalAPagar);
		
		textField_1 = new JTextField();
		textField_1.setText("250");
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		textField_1.setForeground(Color.RED);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridheight = 2;
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 9;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnCobrarF = new JButton("Cobrar F8");
		btnCobrarF.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCobrarF.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cash.png")));
		GridBagConstraints gbc_btnCobrarF = new GridBagConstraints();
		gbc_btnCobrarF.gridheight = 2;
		gbc_btnCobrarF.insets = new Insets(0, 0, 5, 0);
		gbc_btnCobrarF.fill = GridBagConstraints.BOTH;
		gbc_btnCobrarF.gridx = 4;
		gbc_btnCobrarF.gridy = 9;
		contentPane.add(btnCobrarF, gbc_btnCobrarF);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 11;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIngreso = new JLabel("Ingreso:");
		GridBagConstraints gbc_lblIngreso = new GridBagConstraints();
		gbc_lblIngreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngreso.insets = new Insets(0, 0, 0, 5);
		gbc_lblIngreso.gridx = 0;
		gbc_lblIngreso.gridy = 0;
		panel.add(lblIngreso, gbc_lblIngreso);
		
		textFieldIngreso = new JTextField();
		textFieldIngreso.setText("10/01/2015 10:20");
		textFieldIngreso.setEnabled(false);
		textFieldIngreso.setEditable(false);
		GridBagConstraints gbc_textFieldIngreso = new GridBagConstraints();
		gbc_textFieldIngreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIngreso.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldIngreso.gridx = 1;
		gbc_textFieldIngreso.gridy = 0;
		panel.add(textFieldIngreso, gbc_textFieldIngreso);
		textFieldIngreso.setColumns(10);
		
		JLabel lblEgreso = new JLabel("Egreso:");
		GridBagConstraints gbc_lblEgreso = new GridBagConstraints();
		gbc_lblEgreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEgreso.insets = new Insets(0, 0, 0, 5);
		gbc_lblEgreso.gridx = 2;
		gbc_lblEgreso.gridy = 0;
		panel.add(lblEgreso, gbc_lblEgreso);
		
		textFieldEgreso = new JTextField();
		textFieldEgreso.setText("10/01/2015 10:25");
		textFieldEgreso.setEnabled(false);
		textFieldEgreso.setEditable(false);
		GridBagConstraints gbc_textFieldEgreso = new GridBagConstraints();
		gbc_textFieldEgreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEgreso.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldEgreso.gridx = 3;
		gbc_textFieldEgreso.gridy = 0;
		panel.add(textFieldEgreso, gbc_textFieldEgreso);
		textFieldEgreso.setColumns(10);
		
		JLabel lblEstadia_1 = new JLabel("Estadia:");
		GridBagConstraints gbc_lblEstadia_1 = new GridBagConstraints();
		gbc_lblEstadia_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEstadia_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstadia_1.gridx = 4;
		gbc_lblEstadia_1.gridy = 0;
		panel.add(lblEstadia_1, gbc_lblEstadia_1);
		
		textField_2 = new JTextField();
		textField_2.setText("00:05");
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 0;
		panel.add(textField_2, gbc_textField_2);
	}

}
