package vista;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class AltaTarifa extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCostoMinimo;
	private JTextField textTiempoMinimo;
	private JTextField textCostoFraccion;
	private JTextField textTiempoInicioMediaEstadia;
	private JTextField textCostoHora;
	private JTextField textTiempoInicioEstadia;
	private JLabel labelCostoHora;
	private JTextField textCostoMediaEstadia;
	private JTextField textCostoEstadia;
	private JTextField textTiempoFraccion;
	private JButton buttonCancelar;
	private JButton buttonCrearTarifa;
	private JTextField textTiempoFinEstadia;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionTarifa frame = new GestionTarifa();
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
		setBounds(100, 100, 710, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{281, 45, 278, 0};
		gbl_contentPane.rowHeights = new int[]{182, 29, 32, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
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
		comboBoxCategoria = new JComboBox();
		Vector comboBoxCategoriasItems=Controlador.getInstancia().getCategoriasVehiculosActualesString();

		comboBoxCategoria.setModel(new DefaultComboBoxModel(comboBoxCategoriasItems));

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

		textCostoMinimo = new JTextField();
		textCostoMinimo.setColumns(10);
		GridBagConstraints gbc_textCostoMinimo = new GridBagConstraints();
		gbc_textCostoMinimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_textCostoMinimo.gridx = 1;
		gbc_textCostoMinimo.gridy = 1;
		panel.add(textCostoMinimo, gbc_textCostoMinimo);

		JLabel labelTiempoMinimo = new JLabel("Tiempo Minimo:");
		GridBagConstraints gbc_labelTiempoMinimo = new GridBagConstraints();
		gbc_labelTiempoMinimo.anchor = GridBagConstraints.WEST;
		gbc_labelTiempoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_labelTiempoMinimo.gridx = 3;
		gbc_labelTiempoMinimo.gridy = 1;
		panel.add(labelTiempoMinimo, gbc_labelTiempoMinimo);

		textTiempoMinimo = new JTextField();
		textTiempoMinimo.setColumns(10);
		GridBagConstraints gbc_textTiempoMinimo = new GridBagConstraints();
		gbc_textTiempoMinimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTiempoMinimo.insets = new Insets(0, 0, 5, 0);
		gbc_textTiempoMinimo.gridx = 4;
		gbc_textTiempoMinimo.gridy = 1;
		panel.add(textTiempoMinimo, gbc_textTiempoMinimo);

		JLabel labelCostoFraccion = new JLabel("Costo Fraccion:");
		GridBagConstraints gbc_labelCostoFraccion = new GridBagConstraints();
		gbc_labelCostoFraccion.anchor = GridBagConstraints.WEST;
		gbc_labelCostoFraccion.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoFraccion.gridx = 0;
		gbc_labelCostoFraccion.gridy = 2;
		panel.add(labelCostoFraccion, gbc_labelCostoFraccion);

		textCostoFraccion = new JTextField();
		textCostoFraccion.setColumns(10);
		GridBagConstraints gbc_textCostoFraccion = new GridBagConstraints();
		gbc_textCostoFraccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoFraccion.insets = new Insets(0, 0, 5, 5);
		gbc_textCostoFraccion.gridx = 1;
		gbc_textCostoFraccion.gridy = 2;
		panel.add(textCostoFraccion, gbc_textCostoFraccion);

		JLabel labelTiempoMediaEst = new JLabel("Tiempo Inicio Media Est.:");
		GridBagConstraints gbc_labelTiempoMediaEst = new GridBagConstraints();
		gbc_labelTiempoMediaEst.anchor = GridBagConstraints.WEST;
		gbc_labelTiempoMediaEst.insets = new Insets(0, 0, 5, 5);
		gbc_labelTiempoMediaEst.gridx = 3;
		gbc_labelTiempoMediaEst.gridy = 2;
		panel.add(labelTiempoMediaEst, gbc_labelTiempoMediaEst);

		textTiempoInicioMediaEstadia = new JTextField();
		textTiempoInicioMediaEstadia.setColumns(10);
		GridBagConstraints gbc_textTiempoInicioMediaEstadia = new GridBagConstraints();
		gbc_textTiempoInicioMediaEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTiempoInicioMediaEstadia.insets = new Insets(0, 0, 5, 0);
		gbc_textTiempoInicioMediaEstadia.gridx = 4;
		gbc_textTiempoInicioMediaEstadia.gridy = 2;
		panel.add(textTiempoInicioMediaEstadia, gbc_textTiempoInicioMediaEstadia);

		labelCostoHora = new JLabel("Costo Hora:");
		GridBagConstraints gbc_labelCostoHora = new GridBagConstraints();
		gbc_labelCostoHora.anchor = GridBagConstraints.WEST;
		gbc_labelCostoHora.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoHora.gridx = 0;
		gbc_labelCostoHora.gridy = 3;
		panel.add(labelCostoHora, gbc_labelCostoHora);

		textCostoHora = new JTextField();
		textCostoHora.setColumns(10);
		GridBagConstraints gbc_textCostoHora = new GridBagConstraints();
		gbc_textCostoHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoHora.insets = new Insets(0, 0, 5, 5);
		gbc_textCostoHora.gridx = 1;
		gbc_textCostoHora.gridy = 3;
		panel.add(textCostoHora, gbc_textCostoHora);

		JLabel labelTiempoEstadia = new JLabel("Tiempo Inicio Estadia:");
		GridBagConstraints gbc_labelTiempoEstadia = new GridBagConstraints();
		gbc_labelTiempoEstadia.anchor = GridBagConstraints.WEST;
		gbc_labelTiempoEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_labelTiempoEstadia.gridx = 3;
		gbc_labelTiempoEstadia.gridy = 3;
		panel.add(labelTiempoEstadia, gbc_labelTiempoEstadia);

		textTiempoInicioEstadia = new JTextField();
		textTiempoInicioEstadia.setColumns(10);
		GridBagConstraints gbc_textTiempoInicioEstadia = new GridBagConstraints();
		gbc_textTiempoInicioEstadia.insets = new Insets(0, 0, 5, 0);
		gbc_textTiempoInicioEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTiempoInicioEstadia.gridx = 4;
		gbc_textTiempoInicioEstadia.gridy = 3;
		panel.add(textTiempoInicioEstadia, gbc_textTiempoInicioEstadia);

		JLabel lblCostoMediaEstadia = new JLabel("Costo Media Estadia:");
		GridBagConstraints gbc_lblCostoMediaEstadia = new GridBagConstraints();
		gbc_lblCostoMediaEstadia.anchor = GridBagConstraints.WEST;
		gbc_lblCostoMediaEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostoMediaEstadia.gridx = 0;
		gbc_lblCostoMediaEstadia.gridy = 4;
		panel.add(lblCostoMediaEstadia, gbc_lblCostoMediaEstadia);

		textCostoMediaEstadia = new JTextField();
		textCostoMediaEstadia.setColumns(10);
		GridBagConstraints gbc_textCostoMediaEstadia = new GridBagConstraints();
		gbc_textCostoMediaEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_textCostoMediaEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoMediaEstadia.gridx = 1;
		gbc_textCostoMediaEstadia.gridy = 4;
		panel.add(textCostoMediaEstadia, gbc_textCostoMediaEstadia);

		JLabel lblTiempoFinEstadia = new JLabel("Tiempo Fin Estadia:");
		GridBagConstraints gbc_lblTiempoFinEstadia = new GridBagConstraints();
		gbc_lblTiempoFinEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempoFinEstadia.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTiempoFinEstadia.gridx = 3;
		gbc_lblTiempoFinEstadia.gridy = 4;
		panel.add(lblTiempoFinEstadia, gbc_lblTiempoFinEstadia);

		textTiempoFinEstadia = new JTextField();
		textTiempoFinEstadia.setColumns(10);
		GridBagConstraints gbc_textTiempoFinEstadia = new GridBagConstraints();
		gbc_textTiempoFinEstadia.insets = new Insets(0, 0, 5, 0);
		gbc_textTiempoFinEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTiempoFinEstadia.gridx = 4;
		gbc_textTiempoFinEstadia.gridy = 4;
		panel.add(textTiempoFinEstadia, gbc_textTiempoFinEstadia);

		JLabel lblCostoEstadia = new JLabel("Costo Estadia:");
		GridBagConstraints gbc_lblCostoEstadia = new GridBagConstraints();
		gbc_lblCostoEstadia.anchor = GridBagConstraints.WEST;
		gbc_lblCostoEstadia.insets = new Insets(0, 0, 0, 5);
		gbc_lblCostoEstadia.gridx = 0;
		gbc_lblCostoEstadia.gridy = 5;
		panel.add(lblCostoEstadia, gbc_lblCostoEstadia);

		textCostoEstadia = new JTextField();
		textCostoEstadia.setColumns(10);
		GridBagConstraints gbc_textCostoEstadia = new GridBagConstraints();
		gbc_textCostoEstadia.insets = new Insets(0, 0, 0, 5);
		gbc_textCostoEstadia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoEstadia.gridx = 1;
		gbc_textCostoEstadia.gridy = 5;
		panel.add(textCostoEstadia, gbc_textCostoEstadia);

		JLabel lblTiempoFraccion = new JLabel("Tiempo Fraccion:");
		GridBagConstraints gbc_lblTiempoFraccion = new GridBagConstraints();
		gbc_lblTiempoFraccion.anchor = GridBagConstraints.WEST;
		gbc_lblTiempoFraccion.insets = new Insets(0, 0, 0, 5);
		gbc_lblTiempoFraccion.gridx = 3;
		gbc_lblTiempoFraccion.gridy = 5;
		panel.add(lblTiempoFraccion, gbc_lblTiempoFraccion);

		textTiempoFraccion = new JTextField();
		textTiempoFraccion.setColumns(10);
		GridBagConstraints gbc_textTiempoFraccion = new GridBagConstraints();
		gbc_textTiempoFraccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTiempoFraccion.gridx = 4;
		gbc_textTiempoFraccion.gridy = 5;
		panel.add(textTiempoFraccion, gbc_textTiempoFraccion);

		buttonCrearTarifa = new JButton("Crear Tarifa");
		buttonCrearTarifa.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_buttonCrearTarifa = new GridBagConstraints();
		gbc_buttonCrearTarifa.anchor = GridBagConstraints.EAST;
		gbc_buttonCrearTarifa.insets = new Insets(0, 0, 0, 5);
		gbc_buttonCrearTarifa.fill = GridBagConstraints.VERTICAL;
		gbc_buttonCrearTarifa.gridx = 0;
		gbc_buttonCrearTarifa.gridy = 2;
		contentPane.add(buttonCrearTarifa, gbc_buttonCrearTarifa);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_buttonCancelar = new GridBagConstraints();
		gbc_buttonCancelar.anchor = GridBagConstraints.WEST;
		gbc_buttonCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_buttonCancelar.gridx = 2;
		gbc_buttonCancelar.gridy = 2;
		contentPane.add(buttonCancelar, gbc_buttonCancelar);
		buttonCancelar.addActionListener(this);
		buttonCrearTarifa.addActionListener(this);


		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == buttonCancelar){
			dispose();
		}
		if(event.getSource() == buttonCrearTarifa)
		{
			if(isNumeric(textCostoMinimo.getText().toString()) && isNumeric(textCostoFraccion.getText().toString())&& isNumeric(textCostoHora.getText())&& 
					isNumeric(textCostoMediaEstadia.getText())&& isNumeric(textCostoEstadia.getText())&& 
					isNumeric(textCostoFraccion.getText())&& isNumeric(textCostoFraccion.getText())&& 
					isNumeric(textCostoFraccion.getText())&& isNumeric(textTiempoFraccion.getText())&& 
					isNumeric(textTiempoInicioMediaEstadia.getText())&& isNumeric(textTiempoInicioMediaEstadia.getText()))
			{
				long codigoReturn;
				String categoriaVehiculo= (String) comboBoxCategoria.getSelectedItem();
				double costoMinimo=Double.parseDouble(textCostoMinimo.getText()); 
				double costoFraccion=Double.parseDouble(textCostoFraccion.getText()); 
				double costoHora=Double.parseDouble(textCostoHora.getText());
				double costoMediaEstadia=Double.parseDouble(textCostoMediaEstadia.getText()); 
				double costoEstadia=Double.parseDouble(textCostoEstadia.getText());
				double tiempoMinimo=Double.parseDouble(textTiempoMinimo.getText());
				double tiempoFraccion=Double.parseDouble(textTiempoFraccion.getText());
				double tiempoMediaEstadia_minuto=Double.parseDouble(textTiempoInicioMediaEstadia.getText());
				double tiempoEstadia_minuto=Double.parseDouble(textTiempoInicioMediaEstadia.getText());
				//TODO NO SE USA EL TIEMPO_ESTADIA FIN	

				codigoReturn=Controlador.getInstancia().altaTarifa(categoriaVehiculo, costoMinimo, costoFraccion, costoHora, costoMediaEstadia, costoEstadia,
						tiempoMinimo, tiempoFraccion, tiempoMediaEstadia_minuto, tiempoEstadia_minuto);
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null, "No se pudo realizar el alta de tarifa.", "Alta de Tarifa", JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Se generó correctamente el alta de tarifa.", "Alta de Tarifa", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}

			else{
				JOptionPane.showMessageDialog(null, "Alguno/s de los campos ingresados no son válidos.","Error Validación Datos",  JOptionPane.INFORMATION_MESSAGE);
			}
		}


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

