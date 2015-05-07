package vista;


import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import controlador.Controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("rawtypes")
public class AgregarVehiculo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPatente;
	private JTextField textFieldObservacion;
	private JLabel lblCategoria;
	private JComboBox comboBoxCategoriaVehiculo;
	private JLabel lblPatente;
	private JLabel lblColor;
	private JComboBox comboBoxColor;
	private JLabel lblModelo;
	private JComboBox comboBoxModelo;
	private JLabel lblObservacion;
	private JButton btnCancelar;
	private JButton btnCrearVehiculo;
	private JButton btnFinalizarAlta;
	private AltaCliente altaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarVehiculo frame = new AgregarVehiculo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param altaCliente 
	 */
	@SuppressWarnings("unchecked")
	public AgregarVehiculo(AltaCliente altaCliente) {
		this.altaCliente=altaCliente;
		setTitle("Alta Vehiculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.toFront();
		this.repaint();
		this.setFocusable(true);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{78, 122, 45, 206, 0};
		gbl_contentPane.rowHeights = new int[]{28, 26, 35, 46, 45, 36, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		 
		  lblCategoria = new JLabel("Categoria:");
		  GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		  gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		  gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		  gbc_lblCategoria.gridx = 0;
		  gbc_lblCategoria.gridy = 0;
		  contentPane.add(lblCategoria, gbc_lblCategoria);
		 
		  comboBoxCategoriaVehiculo = new JComboBox();
		  comboBoxCategoriaVehiculo.setModel(new DefaultComboBoxModel(new String[] {"1 Auto", "2 Camioneta", "3 Moto", "4 Bicicleta"}));
		  GridBagConstraints gbc_comboBoxCategoriaVehiculo = new GridBagConstraints();
		  gbc_comboBoxCategoriaVehiculo.fill = GridBagConstraints.HORIZONTAL;
		  gbc_comboBoxCategoriaVehiculo.insets = new Insets(0, 0, 5, 5);
		  gbc_comboBoxCategoriaVehiculo.gridx = 1;
		  gbc_comboBoxCategoriaVehiculo.gridy = 0;
		  contentPane.add(comboBoxCategoriaVehiculo, gbc_comboBoxCategoriaVehiculo);
		
		 lblPatente = new JLabel("Patente:");
		 GridBagConstraints gbc_lblPatente = new GridBagConstraints();
		 gbc_lblPatente.anchor = GridBagConstraints.EAST;
		 gbc_lblPatente.insets = new Insets(0, 0, 5, 5);
		 gbc_lblPatente.gridx = 2;
		 gbc_lblPatente.gridy = 0;
		 contentPane.add(lblPatente, gbc_lblPatente);
		  
		  textFieldPatente = new JTextField();
		  GridBagConstraints gbc_textFieldPatente = new GridBagConstraints();
		  gbc_textFieldPatente.fill = GridBagConstraints.BOTH;
		  gbc_textFieldPatente.insets = new Insets(0, 0, 5, 0);
		  gbc_textFieldPatente.gridx = 3;
		  gbc_textFieldPatente.gridy = 0;
		  contentPane.add(textFieldPatente, gbc_textFieldPatente);
		  textFieldPatente.setColumns(10);
		 
		  lblColor = new JLabel("Color:");
		  GridBagConstraints gbc_lblColor = new GridBagConstraints();
		  gbc_lblColor.anchor = GridBagConstraints.EAST;
		  gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		  gbc_lblColor.gridx = 0;
		  gbc_lblColor.gridy = 1;
		  contentPane.add(lblColor, gbc_lblColor);
		 
		  comboBoxColor = new JComboBox();
		  comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"1 Rojo", "2 Azul", "3 Verde", "4 Negro", "5 Blanco"}));
		  GridBagConstraints gbc_comboBoxColor = new GridBagConstraints();
		  gbc_comboBoxColor.fill = GridBagConstraints.HORIZONTAL;
		  gbc_comboBoxColor.insets = new Insets(0, 0, 5, 5);
		  gbc_comboBoxColor.gridx = 1;
		  gbc_comboBoxColor.gridy = 1;
		  contentPane.add(comboBoxColor, gbc_comboBoxColor);
		
		 lblModelo = new JLabel("Modelo:");
		 GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		 gbc_lblModelo.anchor = GridBagConstraints.EAST;
		 gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		 gbc_lblModelo.gridx = 2;
		 gbc_lblModelo.gridy = 1;
		 contentPane.add(lblModelo, gbc_lblModelo);
		 
		  comboBoxModelo = new JComboBox();
		  comboBoxModelo.setModel(new DefaultComboBoxModel(new String[] {"1 Mercedes", "2 Fiat Palio", "3 Chevrolet Aveo"}));
		  GridBagConstraints gbc_comboBoxModelo = new GridBagConstraints();
		  gbc_comboBoxModelo.fill = GridBagConstraints.HORIZONTAL;
		  gbc_comboBoxModelo.insets = new Insets(0, 0, 5, 0);
		  gbc_comboBoxModelo.gridx = 3;
		  gbc_comboBoxModelo.gridy = 1;
		  contentPane.add(comboBoxModelo, gbc_comboBoxModelo);
		
		 lblObservacion = new JLabel("Observacion:");
		 GridBagConstraints gbc_lblObservacion = new GridBagConstraints();
		 gbc_lblObservacion.anchor = GridBagConstraints.EAST;
		 gbc_lblObservacion.insets = new Insets(0, 0, 5, 5);
		 gbc_lblObservacion.gridx = 0;
		 gbc_lblObservacion.gridy = 3;
		 contentPane.add(lblObservacion, gbc_lblObservacion);
		 
		 textFieldObservacion = new JTextField();
		 GridBagConstraints gbc_textFieldObservacion = new GridBagConstraints();
		 gbc_textFieldObservacion.fill = GridBagConstraints.BOTH;
		 gbc_textFieldObservacion.insets = new Insets(0, 0, 5, 0);
		 gbc_textFieldObservacion.gridwidth = 3;
		 gbc_textFieldObservacion.gridx = 1;
		 gbc_textFieldObservacion.gridy = 3;
		 contentPane.add(textFieldObservacion, gbc_textFieldObservacion);
		 textFieldObservacion.setColumns(10);
		  
		   btnCrearVehiculo = new JButton("Agregar Vehiculo");
		   btnCrearVehiculo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		   btnCrearVehiculo.setIcon(new ImageIcon(AgregarVehiculo.class.getResource("/image/plus.png")));
		   GridBagConstraints gbc_btnCrearVehiculo = new GridBagConstraints();
		   gbc_btnCrearVehiculo.fill = GridBagConstraints.BOTH;
		   gbc_btnCrearVehiculo.insets = new Insets(0, 0, 5, 0);
		   gbc_btnCrearVehiculo.gridx = 3;
		   gbc_btnCrearVehiculo.gridy = 4;
		   contentPane.add(btnCrearVehiculo, gbc_btnCrearVehiculo);
		   btnCrearVehiculo.addActionListener(this);
		   
		  btnFinalizarAlta = new JButton("Finalizar Alta");
		  btnFinalizarAlta.setIcon(new ImageIcon(AgregarVehiculo.class.getResource("/image/ok.png")));
		  btnFinalizarAlta.setFont(new Font("Dialog", Font.PLAIN, 16));
		  GridBagConstraints gbc_btnFinalizarAlta = new GridBagConstraints();
		  gbc_btnFinalizarAlta.fill = GridBagConstraints.BOTH;
		  gbc_btnFinalizarAlta.gridx = 3;
		  gbc_btnFinalizarAlta.gridy = 6;
		  contentPane.add(btnFinalizarAlta, gbc_btnFinalizarAlta);
		  
		   btnCancelar = new JButton("Cancelar");
		   btnCancelar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
		   GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		   gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		   gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		   gbc_btnCancelar.gridwidth = 2;
		   gbc_btnCancelar.gridx = 0;
		   gbc_btnCancelar.gridy = 6;
		   contentPane.add(btnCancelar, gbc_btnCancelar);
		   btnCancelar.addActionListener(this);
		  btnFinalizarAlta.addActionListener(this);
		  
		 this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCancelar)
		{
			dispose();
		}
		if(event.getSource()==btnCrearVehiculo)
		{
			Controlador.getInstancia().agregarVehiculo(comboBoxCategoriaVehiculo.getSelectedIndex(), textFieldPatente.getText(),
					comboBoxColor.getSelectedIndex(), comboBoxModelo.getSelectedIndex(),textFieldObservacion.getText());
			limpiarCampos();
		}
		if(event.getSource()==btnFinalizarAlta)
		{
			altaCliente.agregarVehiculosAltaCliente(Controlador.getInstancia().vehiculosActuales);
			dispose();
		}
		

	}
	
	private void limpiarCampos()
	{
		comboBoxCategoriaVehiculo.setSelectedIndex(0);
		textFieldPatente.setText("");
		comboBoxColor.setSelectedIndex(0);
		comboBoxModelo.setSelectedIndex(0);
		textFieldObservacion.setText("");
	}

}
