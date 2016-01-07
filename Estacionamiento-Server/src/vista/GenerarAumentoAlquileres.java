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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;





//import reportes.ReporteEjemplo;
import java.awt.Font;

import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GenerarAumentoAlquileres extends JDialog implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	@SuppressWarnings("unused")
	private JButton limpiarCamposButton;
	private JTextField porcentajeAumentoTextField;

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
	public GenerarAumentoAlquileres() {
		setResizable(false);
		setTitle("Generar Aumento Alquieres");
		setBounds(100, 100, 329, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{140, 159, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 20, 58, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblNuevaCon = new JLabel("Porcentaje Aumento:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevaCon = new GridBagConstraints();
		gbc_lblNuevaCon.fill = GridBagConstraints.BOTH;
		gbc_lblNuevaCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaCon.gridx = 0;
		gbc_lblNuevaCon.gridy = 1;
		contentPanel.add(lblNuevaCon, gbc_lblNuevaCon);

		porcentajeAumentoTextField = new JTextField();
		GridBagConstraints gbc_porcentajeAumentoTextField = new GridBagConstraints();
		gbc_porcentajeAumentoTextField.fill = GridBagConstraints.BOTH;
		gbc_porcentajeAumentoTextField.insets = new Insets(0, 0, 5, 0);
		gbc_porcentajeAumentoTextField.gridx = 1;
		gbc_porcentajeAumentoTextField.gridy = 1;
		contentPanel.add(porcentajeAumentoTextField, gbc_porcentajeAumentoTextField);
		porcentajeAumentoTextField.addKeyListener(this);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
		gbc_aceptarButton.gridx = 0;
		gbc_aceptarButton.gridy = 2;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		aceptarButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.gridx = 1;
		gbc_cancelarButton.gridy = 2;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);

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
			int resultado = JOptionPane.showConfirmDialog (null, "¿Está seguro?","Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			UIManager.put("OptionPane.yesButtonText", "Si");
			UIManager.put("OptionPane.noButtonText", "No");
			if(resultado != JOptionPane.CANCEL_OPTION && resultado != JOptionPane.CLOSED_OPTION)
			{
				if (resultado == JOptionPane.OK_OPTION)
				{

					if(!porcentajeAumentoTextField.getText().isEmpty() && isNumeric(porcentajeAumentoTextField.getText().toString()))				
					{
						double porcentajeAumento=Double.parseDouble(porcentajeAumentoTextField.getText().toString());
						if(porcentajeAumento > 0 && porcentajeAumento <= 100)
						{
							codigoReturn=Controlador.getInstancia().generarAumentoAlquieres(porcentajeAumento);	
							if(codigoReturn!=-1)
							{
								JOptionPane.showMessageDialog(null, "Se aumentó un "+porcentajeAumento + " para "+codigoReturn+" cocheras.", "Aumento Alquileres",  JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Se produjo un error en el aumento.", "Aumento Alquileres",  JOptionPane.INFORMATION_MESSAGE);
							}

							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "El porcentaje de Aumento debe ser un valor entre 0 y 100.", "Aumento Alquileres",  JOptionPane.INFORMATION_MESSAGE);

						}

						
					}
				}
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


	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

}
