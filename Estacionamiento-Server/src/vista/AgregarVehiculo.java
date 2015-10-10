package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import controlador.Controlador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.CategoriaVehiculo;
import modelo.ColorVehiculo;
import modelo.ModeloVehiculo;


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
	private JComboBox<ColorVehiculo> comboBoxColor;
	private JLabel lblModelo;
	private JComboBox<ModeloVehiculo> comboBoxModelo;
	private JLabel lblObservacion;
	private JButton btnCancelar;
	private JButton btnCrearVehiculo;
	private AltaCliente altaCliente;


	@SuppressWarnings("unchecked")
	public AgregarVehiculo(AltaCliente altaCliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AltaCliente.class.getResource("/image/printer.png")));
		this.altaCliente=altaCliente;
		setTitle("Agregar Vehiculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.toFront();
		this.repaint();
		this.setFocusable(true);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{78, 122, 45, 206, 0};
		gbl_contentPane.rowHeights = new int[]{28, 26, 35, 46, 45, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblCategoria = new JLabel("Categoria:");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 0;
		contentPane.add(lblCategoria, gbc_lblCategoria);

		comboBoxCategoriaVehiculo = new JComboBox();
		DefaultComboBoxModel categoriasComboBox = new DefaultComboBoxModel();
		comboBoxCategoriaVehiculo.setModel(categoriasComboBox);
		ArrayList<CategoriaVehiculo> comboBoxCategoriasItems=Controlador.getInstancia().getCategoriasVehiculosActuales();
		for (CategoriaVehiculo categoriaVehiculo : comboBoxCategoriasItems) {
			categoriasComboBox.addElement(categoriaVehiculo);
		}
		
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

		comboBoxColor = new JComboBox<ColorVehiculo>();
		DefaultComboBoxModel coloresComboBox = new DefaultComboBoxModel();
		comboBoxColor.setModel(coloresComboBox);
		ArrayList<ColorVehiculo> comboBoxColorItems=Controlador.getInstancia().getColoresActuales();
		for (ColorVehiculo colorVehiculo : comboBoxColorItems) {
			coloresComboBox.addElement(colorVehiculo);
		}

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
		
		comboBoxModelo = new JComboBox<ModeloVehiculo>();
		DefaultComboBoxModel modelosComboBox = new DefaultComboBoxModel();
		comboBoxModelo.setModel(modelosComboBox);
		ArrayList<ModeloVehiculo> comboBoxModeloItems=Controlador.getInstancia().getModelosActuales();
		for (ModeloVehiculo modeloVehiculo : comboBoxModeloItems) {
			modelosComboBox.addElement(modeloVehiculo);
		}
		
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
		
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
				GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
				gbc_btnCancelar.fill = GridBagConstraints.BOTH;
				gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
				gbc_btnCancelar.gridwidth = 2;
				gbc_btnCancelar.gridx = 0;
				gbc_btnCancelar.gridy = 4;
				contentPane.add(btnCancelar, gbc_btnCancelar);
				btnCancelar.addActionListener(this);

		btnCrearVehiculo = new JButton("Agregar Vehiculo");
		btnCrearVehiculo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCrearVehiculo.setIcon(new ImageIcon(AgregarVehiculo.class.getResource("/image/plus.png")));
		GridBagConstraints gbc_btnCrearVehiculo = new GridBagConstraints();
		gbc_btnCrearVehiculo.fill = GridBagConstraints.BOTH;
		gbc_btnCrearVehiculo.gridx = 3;
		gbc_btnCrearVehiculo.gridy = 4;
		contentPane.add(btnCrearVehiculo, gbc_btnCrearVehiculo);
		btnCrearVehiculo.addActionListener(this);

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
			
			altaCliente.agregarVehiculosAltaCliente(new modelo.Vehiculo(
					textFieldPatente.getText(), 
					(CategoriaVehiculo)comboBoxCategoriaVehiculo.getSelectedItem(), 
					(ModeloVehiculo)comboBoxModelo.getSelectedItem(), 
					(ColorVehiculo)comboBoxColor.getSelectedItem(), 
					textFieldObservacion.getText()));
			dispose();

		}


	}


}
