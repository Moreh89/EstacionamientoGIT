package vista;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import modelo.Cochera;



public class ModificarCochera extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCostoMensual;
	private JTextField textFieldPorcentajeExpensas;
	private JButton buttonCancelar;
	private JTextField textFieldUbicacion;
	private JButton buttonAgregarCochera;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPiso;
	private AltaCliente altaCliente;

	
	public ModificarCochera(AltaCliente altaCliente) {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.altaCliente=altaCliente;
		initGUI();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI(){
		setTitle("Modificar Cochera");
		setResizable(false);
		setBounds(100, 100, 377, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 353, 116);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{181, 170, 0};
		gbl_panel.rowHeights = new int[] {28, 28, 28, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel labelPiso = new JLabel("Piso:");
		GridBagConstraints gbc_labelPiso = new GridBagConstraints();
		gbc_labelPiso.anchor = GridBagConstraints.WEST;
		gbc_labelPiso.insets = new Insets(0, 0, 5, 5);
		gbc_labelPiso.gridx = 0;
		gbc_labelPiso.gridy = 0;
		panel.add(labelPiso, gbc_labelPiso);

		comboBoxPiso = new JComboBox();
		comboBoxPiso.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		GridBagConstraints gbc_comboBoxPiso = new GridBagConstraints();
		gbc_comboBoxPiso.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPiso.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxPiso.gridx = 1;
		gbc_comboBoxPiso.gridy = 0;
		panel.add(comboBoxPiso, gbc_comboBoxPiso);

		JLabel labelCostoMensual = new JLabel("Costo Mensual:");
		GridBagConstraints gbc_labelCostoMensual = new GridBagConstraints();
		gbc_labelCostoMensual.anchor = GridBagConstraints.WEST;
		gbc_labelCostoMensual.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoMensual.gridx = 0;
		gbc_labelCostoMensual.gridy = 1;
		panel.add(labelCostoMensual, gbc_labelCostoMensual);

		textCostoMensual = new JTextField(String.valueOf(altaCliente.getSelectedCochera().getCostoCochera()));
		textCostoMensual.setColumns(10);
		GridBagConstraints gbc_textCostoMensual = new GridBagConstraints();
		gbc_textCostoMensual.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoMensual.insets = new Insets(0, 0, 5, 0);
		gbc_textCostoMensual.gridx = 1;
		gbc_textCostoMensual.gridy = 1;
		panel.add(textCostoMensual, gbc_textCostoMensual);

		JLabel labelUbicacion = new JLabel("Ubicacion:");
		GridBagConstraints gbc_labelUbicacion = new GridBagConstraints();
		gbc_labelUbicacion.anchor = GridBagConstraints.WEST;
		gbc_labelUbicacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelUbicacion.gridx = 0;
		gbc_labelUbicacion.gridy = 2;
		panel.add(labelUbicacion, gbc_labelUbicacion);

		textFieldUbicacion = new JTextField(altaCliente.getSelectedCochera().getUbicacion());
		textFieldUbicacion.setColumns(10);
		GridBagConstraints gbc_textFieldUbicacion = new GridBagConstraints();
		gbc_textFieldUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUbicacion.gridx = 1;
		gbc_textFieldUbicacion.gridy = 2;
		panel.add(textFieldUbicacion, gbc_textFieldUbicacion);

		JLabel labelPorcentajeExpensas = new JLabel("Porcentaje Expensas:");
		GridBagConstraints gbc_labelPorcentajeExpensas = new GridBagConstraints();
		gbc_labelPorcentajeExpensas.anchor = GridBagConstraints.WEST;
		gbc_labelPorcentajeExpensas.insets = new Insets(0, 0, 0, 5);
		gbc_labelPorcentajeExpensas.gridx = 0;
		gbc_labelPorcentajeExpensas.gridy = 3;
		panel.add(labelPorcentajeExpensas, gbc_labelPorcentajeExpensas);

		textFieldPorcentajeExpensas = new JTextField(String.valueOf(altaCliente.getSelectedCochera().getPorcentajeExpensas()));
		textFieldPorcentajeExpensas.setColumns(10);
		GridBagConstraints gbc_textFieldPorcentajeExpensas = new GridBagConstraints();
		gbc_textFieldPorcentajeExpensas.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPorcentajeExpensas.gridx = 1;
		gbc_textFieldPorcentajeExpensas.gridy = 3;
		panel.add(textFieldPorcentajeExpensas, gbc_textFieldPorcentajeExpensas);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(6, 146, 172, 56);
		contentPane.add(buttonCancelar);
		buttonCancelar.addActionListener(this);

		buttonAgregarCochera = new JButton("Actualizar");
		buttonAgregarCochera.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/ok.png")));
		buttonAgregarCochera.setBounds(199, 146, 160, 56);
		contentPane.add(buttonAgregarCochera);
		buttonAgregarCochera.addActionListener(this);

		JSeparator separator = new JSeparator();
		separator.setBounds(128, 133, 1, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 133, 306, 2);
		contentPane.add(separator_1);

		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == buttonCancelar){
			dispose();
		}
		if(event.getSource()==buttonAgregarCochera)
		{
			if(!textCostoMensual.getText().isEmpty() 
					&& !textFieldPorcentajeExpensas.getText().isEmpty() 
					&& !textFieldUbicacion.getText().isEmpty() 
					&& !textFieldPorcentajeExpensas.getText().toString().isEmpty() 
					&& isNumeric(textFieldPorcentajeExpensas.getText().toString()))
			{
				double porcentajeExp=Double.parseDouble(textFieldPorcentajeExpensas.getText().toString());
				if((porcentajeExp<=100 || porcentajeExp>0))
				{
					Cochera c = altaCliente.getSelectedCochera();
					c.setCostoCochera(Double.parseDouble(textCostoMensual.getText()));
					c.setPorcentajeExpensas(Float.parseFloat(textFieldPorcentajeExpensas.getText()));
					c.setEstado(modelo.Cochera.ESTADO.ACTIVO);
					c.setUbicacion(textFieldUbicacion.getText());
					altaCliente.actualizarCochera(c);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Porcentaje Expensas debe ser un valor entre 0 y 100.", "Validación Datos",  JOptionPane.INFORMATION_MESSAGE);
				}

			}
			else
			{
				JOptionPane.showMessageDialog(null,"Alguno/s de los campos ingresados no son válidos.", "Validación Datos",  JOptionPane.INFORMATION_MESSAGE);
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

