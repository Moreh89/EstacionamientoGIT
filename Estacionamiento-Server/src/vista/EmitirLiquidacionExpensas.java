package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



//import reportes.ReporteEjemplo;
import java.awt.Font;

import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class EmitirLiquidacionExpensas extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	@SuppressWarnings("unused")
	private JButton limpiarCamposButton;
	private JTextField descripcionTextField;
	private JTextField textFieldImporteLiquidar;
	private JTextField textFieldPeriodoLiquidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmitirLiquidacionExpensas dialog = new EmitirLiquidacionExpensas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmitirLiquidacionExpensas() {
		setResizable(false);
		setTitle("Alta Liquidación Expensas");
		setBounds(100, 100, 329, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{140, 159, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 20, 20, 20, 58, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblPeriodoALiquidar = new JLabel("Periodo a Liquidar:");
		lblPeriodoALiquidar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPeriodoALiquidar = new GridBagConstraints();
		gbc_lblPeriodoALiquidar.fill = GridBagConstraints.BOTH;
		gbc_lblPeriodoALiquidar.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeriodoALiquidar.gridx = 0;
		gbc_lblPeriodoALiquidar.gridy = 1;
		contentPanel.add(lblPeriodoALiquidar, gbc_lblPeriodoALiquidar);

		textFieldPeriodoLiquidar = new JTextField();
		textFieldPeriodoLiquidar.setEnabled(false);
		GridBagConstraints gbc_textFieldPeriodoLiquidar = new GridBagConstraints();
		gbc_textFieldPeriodoLiquidar.fill = GridBagConstraints.BOTH;
		gbc_textFieldPeriodoLiquidar.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPeriodoLiquidar.gridx = 1;
		gbc_textFieldPeriodoLiquidar.gridy = 1;
		contentPanel.add(textFieldPeriodoLiquidar, gbc_textFieldPeriodoLiquidar);
		textFieldPeriodoLiquidar.setEditable(false);
		textFieldPeriodoLiquidar.setText(new SimpleDateFormat("MM-dd-yyyy").format(GregorianCalendar.getInstance().getTime()));

		JLabel lblNuevaCon = new JLabel("Descripcion:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevaCon = new GridBagConstraints();
		gbc_lblNuevaCon.fill = GridBagConstraints.BOTH;
		gbc_lblNuevaCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaCon.gridx = 0;
		gbc_lblNuevaCon.gridy = 2;
		contentPanel.add(lblNuevaCon, gbc_lblNuevaCon);

		descripcionTextField = new JTextField();
		GridBagConstraints gbc_descripcionTextField = new GridBagConstraints();
		gbc_descripcionTextField.fill = GridBagConstraints.BOTH;
		gbc_descripcionTextField.insets = new Insets(0, 0, 5, 0);
		gbc_descripcionTextField.gridx = 1;
		gbc_descripcionTextField.gridy = 2;
		contentPanel.add(descripcionTextField, gbc_descripcionTextField);

		JLabel lblNuevaCon2 = new JLabel("Importe Total a Liquidar:");
		lblNuevaCon2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevaCon2 = new GridBagConstraints();
		gbc_lblNuevaCon2.fill = GridBagConstraints.BOTH;
		gbc_lblNuevaCon2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaCon2.gridx = 0;
		gbc_lblNuevaCon2.gridy = 3;
		contentPanel.add(lblNuevaCon2, gbc_lblNuevaCon2);

		textFieldImporteLiquidar = new JTextField();
		GridBagConstraints gbc_textFieldImporteLiquidar = new GridBagConstraints();
		gbc_textFieldImporteLiquidar.fill = GridBagConstraints.BOTH;
		gbc_textFieldImporteLiquidar.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldImporteLiquidar.gridx = 1;
		gbc_textFieldImporteLiquidar.gridy = 3;
		contentPanel.add(textFieldImporteLiquidar, gbc_textFieldImporteLiquidar);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelarButton.gridx = 0;
		gbc_cancelarButton.gridy = 4;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.gridx = 1;
		gbc_aceptarButton.gridy = 4;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		aceptarButton.addActionListener(this);

		this.setLocationRelativeTo(null);
		setModal(true);




	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==aceptarButton)
		{
			long codigoReturn=-1;
			if(!textFieldImporteLiquidar.getText().isEmpty() && isNumeric(textFieldImporteLiquidar.getText()))
			{
				codigoReturn=Controlador.getInstancia().liquidarExpensas(Double.parseDouble(textFieldImporteLiquidar.getText()), textFieldPeriodoLiquidar.getText(), descripcionTextField.getText());
				if(codigoReturn == 0)
				{
					JOptionPane.showMessageDialog(null, "No se pudo realizar la Liquidación de Expensas.","Liquidación de Expensas",  JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn == 100)
				{
					JOptionPane.showMessageDialog(null, "Se liquidaron correctamente el 100% de las expensas.", "Liquidación de Expensas",  JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn > 0)
				{
					JOptionPane.showMessageDialog(null, "Expensas parcialmente liquidadas. Se liquidó el "+codigoReturn +"% de las expensas. \n La sumatoria de porcentajes asignado a las cochera no alcanza o lo supera el 100% .", "Liquidación de Expensas",  JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El campo Importe a Liquidar no es válido.","Liquidación de Expensas",  JOptionPane.INFORMATION_MESSAGE);
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
