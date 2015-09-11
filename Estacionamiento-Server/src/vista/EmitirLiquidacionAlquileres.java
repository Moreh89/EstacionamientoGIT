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

public class EmitirLiquidacionAlquileres extends JDialog implements ActionListener{
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
	private JTextField textFieldPeriodoLiquidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EmitirLiquidacionAlquileres dialog = new EmitirLiquidacionAlquileres();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EmitirLiquidacionAlquileres() {
		setResizable(false);
		setTitle("Alta Liquidación Alquileres");
		setBounds(100, 100, 329, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{140, 159, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 20, 20, 58, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelarButton.gridx = 0;
		gbc_cancelarButton.gridy = 3;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.gridx = 1;
		gbc_aceptarButton.gridy = 3;
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
			double codigoReturn=-1;

			codigoReturn=Controlador.getInstancia().liquidarAlquileres(descripcionTextField.getText());

			JOptionPane.showMessageDialog(null, "Se liquidaron correctamente "+codigoReturn+" cocheras.", "Liquidación de Alquileres",  JOptionPane.INFORMATION_MESSAGE);

			dispose();

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
