package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JTextField;

import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GestionTasaInteres extends JDialog implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JTextField textFieldInteres;
	private JTextField textFieldnuevoInteres;
	private JLabel label;
	private JLabel labelDiaVencimiento;
	private JTextField textFieldDiaVencimiento;
	private JTextField textFieldDiaActual;
	private JLabel lblDiaActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionTasaInteres dialog = new GestionTasaInteres();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionTasaInteres() {
		setResizable(false);
		setTitle("Modificacion Interes");
		setBounds(100, 100, 289, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{116, 8, 27, 79, 0};
		gbl_contentPanel.rowHeights = new int[]{28, 28, 0, 0, 0, 32, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblInteresActual = new JLabel("Interes Actual:");
		lblInteresActual.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblInteresActual = new GridBagConstraints();
		gbc_lblInteresActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInteresActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblInteresActual.gridx = 0;
		gbc_lblInteresActual.gridy = 0;
		contentPanel.add(lblInteresActual, gbc_lblInteresActual);


		textFieldInteres = new JTextField();
		textFieldInteres.setEnabled(false);
		textFieldInteres.setEditable(false);
		GridBagConstraints gbc_textFieldInteres = new GridBagConstraints();
		gbc_textFieldInteres.fill = GridBagConstraints.BOTH;
		gbc_textFieldInteres.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldInteres.gridwidth = 2;
		gbc_textFieldInteres.gridx = 1;
		gbc_textFieldInteres.gridy = 0;
		contentPanel.add(textFieldInteres, gbc_textFieldInteres);
		textFieldInteres.setColumns(10);
		textFieldInteres.setText(String.valueOf(Controlador.getInstancia().getPorcentajeTasaInteres()));

		JLabel porcentaje = new JLabel("%");
		porcentaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_porcentaje = new GridBagConstraints();
		gbc_porcentaje.anchor = GridBagConstraints.WEST;
		gbc_porcentaje.insets = new Insets(0, 0, 5, 0);
		gbc_porcentaje.gridx = 3;
		gbc_porcentaje.gridy = 0;
		contentPanel.add(porcentaje, gbc_porcentaje);

		JLabel lblNuevaInteres = new JLabel("Nuevo Interes:");
		lblNuevaInteres.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevaInteres = new GridBagConstraints();
		gbc_lblNuevaInteres.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNuevaInteres.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaInteres.gridx = 0;
		gbc_lblNuevaInteres.gridy = 1;
		contentPanel.add(lblNuevaInteres, gbc_lblNuevaInteres);

		textFieldnuevoInteres = new JTextField();
		textFieldnuevoInteres.setColumns(10);
		GridBagConstraints gbc_textFieldnuevoInteres = new GridBagConstraints();
		gbc_textFieldnuevoInteres.fill = GridBagConstraints.BOTH;
		gbc_textFieldnuevoInteres.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldnuevoInteres.gridwidth = 2;
		gbc_textFieldnuevoInteres.gridx = 1;
		gbc_textFieldnuevoInteres.gridy = 1;
		contentPanel.add(textFieldnuevoInteres, gbc_textFieldnuevoInteres);
		textFieldnuevoInteres.addKeyListener(this);

		
		label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		contentPanel.add(label, gbc_label);
		
		lblDiaActual = new JLabel("Dia Vencimiento Actual:");
		lblDiaActual.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDiaActual = new GridBagConstraints();
		gbc_lblDiaActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaActual.anchor = GridBagConstraints.EAST;
		gbc_lblDiaActual.gridx = 0;
		gbc_lblDiaActual.gridy = 2;
		contentPanel.add(lblDiaActual, gbc_lblDiaActual);
		
		
		textFieldDiaActual = new JTextField();
		textFieldDiaActual.setEnabled(false);
		textFieldDiaActual.setEditable(false);
		GridBagConstraints gbc_textFieldDiaActual = new GridBagConstraints();
		gbc_textFieldDiaActual.gridwidth = 2;
		gbc_textFieldDiaActual.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDiaActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDiaActual.gridx = 1;
		gbc_textFieldDiaActual.gridy = 2;
		contentPanel.add(textFieldDiaActual, gbc_textFieldDiaActual);
		textFieldDiaActual.setColumns(10);
		textFieldDiaActual.setText((String.valueOf(Controlador.getInstancia().getDiaVencimientoInteres())));
		
		labelDiaVencimiento = new JLabel("Dia de Vencimiento:");
		labelDiaVencimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelDiaVencimiento = new GridBagConstraints();
		gbc_labelDiaVencimiento.anchor = GridBagConstraints.WEST;
		gbc_labelDiaVencimiento.insets = new Insets(0, 0, 5, 5);
		gbc_labelDiaVencimiento.gridx = 0;
		gbc_labelDiaVencimiento.gridy = 3;
		contentPanel.add(labelDiaVencimiento, gbc_labelDiaVencimiento);

		textFieldDiaVencimiento = new JTextField();
		GridBagConstraints gbc_textFieldDiaVencimiento = new GridBagConstraints();
		gbc_textFieldDiaVencimiento.gridwidth = 2;
		gbc_textFieldDiaVencimiento.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDiaVencimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDiaVencimiento.gridx = 1;
		gbc_textFieldDiaVencimiento.gridy = 3;
		contentPanel.add(textFieldDiaVencimiento, gbc_textFieldDiaVencimiento);
		textFieldDiaVencimiento.setColumns(10);
		textFieldDiaVencimiento.addKeyListener(this);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionTasaInteres.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
		gbc_aceptarButton.gridx = 0;
		gbc_aceptarButton.gridy = 5;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		aceptarButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.gridwidth = 3;
		gbc_cancelarButton.gridx = 1;
		gbc_cancelarButton.gridy = 5;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);

		this.setLocationRelativeTo(null);
		setModal(true);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==aceptarButton)
		{
			long codigoReturn=-1;
			if(!textFieldnuevoInteres.getText().isEmpty() && 
					!textFieldDiaVencimiento.getText().isEmpty() && 
					isPercentile(textFieldnuevoInteres.getText()) &&
					isDay(textFieldDiaVencimiento.getText()))
			{
				codigoReturn=Controlador.getInstancia().modificarTasaInteres(Double.parseDouble(textFieldnuevoInteres.getText()), Integer.parseInt(textFieldDiaVencimiento.getText()));
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null, "Se produjo un error. Vuelva a intentar en unos instantes. En caso de presentarse nuevamente el error, comunicarse con el desarrollador del sistema", "Tasa Interes", JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null,  "Se actualizó correctamente la tasa de interés", "Tasa Interes",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}

			}
			else
			{
				JOptionPane.showMessageDialog(null,  "Uno o más campos ingresados no son válidos.", "Tasa Interes",JOptionPane.INFORMATION_MESSAGE);

			}
			
		}

	}

	private static boolean isDay(String str)
	{
		try
		{
			int day = Integer.parseInt(str);
			if(day<1 || day>28)
			{
				return false;
			}

		}	
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}
	private static boolean isPercentile(String str)
	{
		try
		{
			int percentile = Integer.parseInt(str);
			if(percentile<0 || percentile>100)
			{
				return false;
			}

		}	
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

	private static boolean isNumeric(String str)  
	{  
		try  
		{  
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

	@Override
	public void keyPressed(KeyEvent event) {

		{
			if (event.getKeyCode()== KeyEvent.VK_ENTER){
				this.aceptarButton.doClick();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
