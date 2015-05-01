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

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("rawtypes")
public class AltaVehiculo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPatente;
	private JTextField textField;
	private JTextField textFieldNumeroTicket;
	private JLabel lblCodigoTicket;
	private JLabel lblCategoria;
	private JComboBox comboBoxTipoVehiculo;
	private JLabel lblPatente;
	private JLabel lblColor;
	private JComboBox comboBoxColor;
	private JLabel lblModelo;
	private JComboBox comboBoxModelo;
	private JLabel lblObservacion;
	private JButton btnBorrar;
	private JButton btnCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaVehiculo frame = new AltaVehiculo();
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
	public AltaVehiculo() {
		setTitle("Alta Vehiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		 lblCodigoTicket = new JLabel("Codigo Ticket:");
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
		
		 lblCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 1;
		contentPane.add(lblCategoria, gbc_lblCategoria);
		
		 comboBoxTipoVehiculo = new JComboBox();
		comboBoxTipoVehiculo.setModel(new DefaultComboBoxModel(new String[] {"1 Auto", "2 Camioneta", "3 Moto", "4 Bicicleta"}));
		GridBagConstraints gbc_comboBoxTipoVehiculo = new GridBagConstraints();
		gbc_comboBoxTipoVehiculo.gridwidth = 2;
		gbc_comboBoxTipoVehiculo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoVehiculo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoVehiculo.gridx = 1;
		gbc_comboBoxTipoVehiculo.gridy = 1;
		contentPane.add(comboBoxTipoVehiculo, gbc_comboBoxTipoVehiculo);
		
		 lblPatente = new JLabel("Patente:");
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
		
		 lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 2;
		contentPane.add(lblColor, gbc_lblColor);
		
		 comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"1 Rojo", "2 Azul", "3 Verde", "4 Negro", "5 Blanco"}));
		GridBagConstraints gbc_comboBoxColor = new GridBagConstraints();
		gbc_comboBoxColor.gridwidth = 2;
		gbc_comboBoxColor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxColor.gridx = 1;
		gbc_comboBoxColor.gridy = 2;
		contentPane.add(comboBoxColor, gbc_comboBoxColor);
		
		 lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 3;
		gbc_lblModelo.gridy = 2;
		contentPane.add(lblModelo, gbc_lblModelo);
		
		 comboBoxModelo = new JComboBox();
		comboBoxModelo.setModel(new DefaultComboBoxModel(new String[] {"1 Mercedes", "2 Fiat Palio", "3 Chevrolet Aveo"}));
		GridBagConstraints gbc_comboBoxModelo = new GridBagConstraints();
		gbc_comboBoxModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxModelo.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxModelo.gridx = 4;
		gbc_comboBoxModelo.gridy = 2;
		contentPane.add(comboBoxModelo, gbc_comboBoxModelo);
		
		 lblObservacion = new JLabel("Observacion:");
		GridBagConstraints gbc_lblObservacion = new GridBagConstraints();
		gbc_lblObservacion.anchor = GridBagConstraints.EAST;
		gbc_lblObservacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservacion.gridx = 0;
		gbc_lblObservacion.gridy = 4;
		contentPane.add(lblObservacion, gbc_lblObservacion);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridheight = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		 
		  btnBorrar = new JButton("Borrar");
		  btnBorrar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
		  GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		  gbc_btnBorrar.gridwidth = 2;
		  gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		  gbc_btnBorrar.gridx = 1;
		  gbc_btnBorrar.gridy = 6;
		  contentPane.add(btnBorrar, gbc_btnBorrar);
		
		 btnCrear = new JButton("Crear Vehiculo");
		btnCrear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCrear.setIcon(new ImageIcon(AltaVehiculo.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.gridheight = 2;
		gbc_btnCrear.fill = GridBagConstraints.BOTH;
		gbc_btnCrear.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrear.gridx = 4;
		gbc_btnCrear.gridy = 6;
		contentPane.add(btnCrear, gbc_btnCrear);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
