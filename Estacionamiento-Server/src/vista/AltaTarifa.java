package vista;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AltaTarifa extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTelefono1;
	private JTextField textFieldTelefono2;
	private JTextField textFieldDireccion1;
	private JTextField textFieldDireccion2;
	private JTextField textFieldEmail;
	private JTextField textFieldRazonSocial;
	private JLabel labelCostoHora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldFraccion;
	private JButton buttonCancelar;
	private JTextField textFieldTiempoFinEstadia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaTarifa frame = new AltaTarifa();
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
	public AltaTarifa() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initGUI();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI(){
		setTitle("Alta Tarifa");
		setResizable(false);
		setBounds(100, 100, 617, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 604, 219);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{124, 200, 0, 0, 200, 0};
		gbl_panel.rowHeights = new int[] {28, 28, 28, 28, 20, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel labelCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_labelCategoria = new GridBagConstraints();
		gbc_labelCategoria.anchor = GridBagConstraints.WEST;
		gbc_labelCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_labelCategoria.gridx = 0;
		gbc_labelCategoria.gridy = 0;
		panel.add(labelCategoria, gbc_labelCategoria);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"1 Auto", "2 4X4", "3 Moto", "4 Bicicleta"}));
		GridBagConstraints gbc_comboBoxCategoria = new GridBagConstraints();
		gbc_comboBoxCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCategoria.gridx = 1;
		gbc_comboBoxCategoria.gridy = 0;
		panel.add(comboBoxCategoria, gbc_comboBoxCategoria);
		
		JLabel labelCostoMinimo = new JLabel("Costo Minimo:");
		GridBagConstraints gbc_labelCostoMinimo = new GridBagConstraints();
		gbc_labelCostoMinimo.anchor = GridBagConstraints.WEST;
		gbc_labelCostoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoMinimo.gridx = 0;
		gbc_labelCostoMinimo.gridy = 1;
		panel.add(labelCostoMinimo, gbc_labelCostoMinimo);
		
		textFieldTelefono1 = new JTextField();
		textFieldTelefono1.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono1 = new GridBagConstraints();
		gbc_textFieldTelefono1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono1.gridx = 1;
		gbc_textFieldTelefono1.gridy = 1;
		panel.add(textFieldTelefono1, gbc_textFieldTelefono1);
		
		JLabel labelTiempoMinimo = new JLabel("Tiempo Minimo:");
		GridBagConstraints gbc_labelTiempoMinimo = new GridBagConstraints();
		gbc_labelTiempoMinimo.anchor = GridBagConstraints.WEST;
		gbc_labelTiempoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_labelTiempoMinimo.gridx = 3;
		gbc_labelTiempoMinimo.gridy = 1;
		panel.add(labelTiempoMinimo, gbc_labelTiempoMinimo);
		
		textFieldTelefono2 = new JTextField();
		textFieldTelefono2.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono2 = new GridBagConstraints();
		gbc_textFieldTelefono2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono2.gridx = 4;
		gbc_textFieldTelefono2.gridy = 1;
		panel.add(textFieldTelefono2, gbc_textFieldTelefono2);
		
		JLabel labelCostoFraccion = new JLabel("Costo Fraccion:");
		GridBagConstraints gbc_labelCostoFraccion = new GridBagConstraints();
		gbc_labelCostoFraccion.anchor = GridBagConstraints.WEST;
		gbc_labelCostoFraccion.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoFraccion.gridx = 0;
		gbc_labelCostoFraccion.gridy = 2;
		panel.add(labelCostoFraccion, gbc_labelCostoFraccion);
		
		textFieldDireccion1 = new JTextField();
		textFieldDireccion1.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion1 = new GridBagConstraints();
		gbc_textFieldDireccion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDireccion1.gridx = 1;
		gbc_textFieldDireccion1.gridy = 2;
		panel.add(textFieldDireccion1, gbc_textFieldDireccion1);
		
		JLabel labelTiempoMediaEst = new JLabel("Tiempo Inicio Media Est.:");
		GridBagConstraints gbc_labelTiempoMediaEst = new GridBagConstraints();
		gbc_labelTiempoMediaEst.anchor = GridBagConstraints.WEST;
		gbc_labelTiempoMediaEst.insets = new Insets(0, 0, 5, 5);
		gbc_labelTiempoMediaEst.gridx = 3;
		gbc_labelTiempoMediaEst.gridy = 2;
		panel.add(labelTiempoMediaEst, gbc_labelTiempoMediaEst);
		
		textFieldDireccion2 = new JTextField();
		textFieldDireccion2.setColumns(10);
		GridBagConstraints gbc_textFieldDireccion2 = new GridBagConstraints();
		gbc_textFieldDireccion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDireccion2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDireccion2.gridx = 4;
		gbc_textFieldDireccion2.gridy = 2;
		panel.add(textFieldDireccion2, gbc_textFieldDireccion2);
		
		labelCostoHora = new JLabel("Costo Hora:");
		GridBagConstraints gbc_labelCostoHora = new GridBagConstraints();
		gbc_labelCostoHora.anchor = GridBagConstraints.WEST;
		gbc_labelCostoHora.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoHora.gridx = 0;
		gbc_labelCostoHora.gridy = 3;
		panel.add(labelCostoHora, gbc_labelCostoHora);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 3;
		panel.add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel labelTiempoEstadia = new JLabel("Tiempo Inicio Estadia:");
		GridBagConstraints gbc_labelTiempoEstadia = new GridBagConstraints();
		gbc_labelTiempoEstadia.anchor = GridBagConstraints.WEST;
		gbc_labelTiempoEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_labelTiempoEstadia.gridx = 3;
		gbc_labelTiempoEstadia.gridy = 3;
		panel.add(labelTiempoEstadia, gbc_labelTiempoEstadia);
		
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);
		GridBagConstraints gbc_textFieldRazonSocial = new GridBagConstraints();
		gbc_textFieldRazonSocial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRazonSocial.gridx = 4;
		gbc_textFieldRazonSocial.gridy = 3;
		panel.add(textFieldRazonSocial, gbc_textFieldRazonSocial);
		
		JLabel lblCostoMediaEstadia = new JLabel("Costo Media Estadia:");
		GridBagConstraints gbc_lblCostoMediaEstadia = new GridBagConstraints();
		gbc_lblCostoMediaEstadia.anchor = GridBagConstraints.WEST;
		gbc_lblCostoMediaEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostoMediaEstadia.gridx = 0;
		gbc_lblCostoMediaEstadia.gridy = 4;
		panel.add(lblCostoMediaEstadia, gbc_lblCostoMediaEstadia);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		panel.add(textField, gbc_textField);
		
		JLabel lblTiempoFinEstadia = new JLabel("Tiempo Fin Estadia:");
		GridBagConstraints gbc_lblTiempoFinEstadia = new GridBagConstraints();
		gbc_lblTiempoFinEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempoFinEstadia.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTiempoFinEstadia.gridx = 3;
		gbc_lblTiempoFinEstadia.gridy = 4;
		panel.add(lblTiempoFinEstadia, gbc_lblTiempoFinEstadia);
		
		textFieldTiempoFinEstadia = new JTextField();
		textFieldTiempoFinEstadia.setColumns(10);
		GridBagConstraints gbc_textFieldTiempoFinEstadia = new GridBagConstraints();
		gbc_textFieldTiempoFinEstadia.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTiempoFinEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTiempoFinEstadia.gridx = 4;
		gbc_textFieldTiempoFinEstadia.gridy = 4;
		panel.add(textFieldTiempoFinEstadia, gbc_textFieldTiempoFinEstadia);
		
		JLabel lblCostoEstadia = new JLabel("Costo Estadia:");
		GridBagConstraints gbc_lblCostoEstadia = new GridBagConstraints();
		gbc_lblCostoEstadia.anchor = GridBagConstraints.WEST;
		gbc_lblCostoEstadia.insets = new Insets(0, 0, 0, 5);
		gbc_lblCostoEstadia.gridx = 0;
		gbc_lblCostoEstadia.gridy = 5;
		panel.add(lblCostoEstadia, gbc_lblCostoEstadia);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);
		
		JLabel lblTiempoFraccion = new JLabel("Tiempo Fraccion:");
		GridBagConstraints gbc_lblTiempoFraccion = new GridBagConstraints();
		gbc_lblTiempoFraccion.anchor = GridBagConstraints.WEST;
		gbc_lblTiempoFraccion.insets = new Insets(0, 0, 0, 5);
		gbc_lblTiempoFraccion.gridx = 3;
		gbc_lblTiempoFraccion.gridy = 5;
		panel.add(lblTiempoFraccion, gbc_lblTiempoFraccion);
		
		textFieldFraccion = new JTextField();
		textFieldFraccion.setColumns(10);
		GridBagConstraints gbc_textFieldFraccion = new GridBagConstraints();
		gbc_textFieldFraccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFraccion.gridx = 4;
		gbc_textFieldFraccion.gridy = 5;
		panel.add(textFieldFraccion, gbc_textFieldFraccion);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(139, 237, 148, 56);
		contentPane.add(buttonCancelar);
		buttonCancelar.addActionListener(this);
		
		JButton buttonCrearTarifa = new JButton("Crear Tarifa");
		buttonCrearTarifa.setIcon(new ImageIcon(BuscardorCliente.class.getResource("/image/ok.png")));
		buttonCrearTarifa.setBounds(332, 237, 148, 56);
		contentPane.add(buttonCrearTarifa);
		
		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == buttonCancelar){
			dispose();
		}
		
	}
	

	
}

