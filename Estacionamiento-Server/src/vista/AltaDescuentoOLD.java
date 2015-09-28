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

public class AltaDescuentoOLD extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JButton limpiarCamposButton;
	private JTextField descripcionTextField;
	private JTextField montoDescuentoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaDescuentoOLD dialog = new AltaDescuentoOLD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaDescuentoOLD() {
		setResizable(false);
		setTitle("Alta Descuento");
		setBounds(100, 100, 363, 178);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNuevaCon = new JLabel("Descripcion:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblNuevaCon.setBounds(5, 16, 144, 14);
		contentPanel.add(lblNuevaCon);

		JLabel lblNuevaCon2 = new JLabel("Porcentaje Descuento:");
		lblNuevaCon2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNuevaCon2.setBounds(5, 54, 190, 14);
		contentPanel.add(lblNuevaCon2);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(206, 102, 139, 32);
		contentPanel.add(aceptarButton);
		aceptarButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(10, 102, 139, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		descripcionTextField = new JTextField();
		descripcionTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		descripcionTextField.setBounds(200, 13, 145, 22);
		contentPanel.add(descripcionTextField);

		montoDescuentoTextField = new JTextField();
		montoDescuentoTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		montoDescuentoTextField.setBounds(200, 51, 145, 22);
		contentPanel.add(montoDescuentoTextField);

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
			long codigoReturn;
			if(!descripcionTextField.getText().isEmpty() && !montoDescuentoTextField.getText().isEmpty() && isNumeric(montoDescuentoTextField.getText()))
			{
				codigoReturn=Controlador.getInstancia().altaDescuento(descripcionTextField.getText(), Double.parseDouble(montoDescuentoTextField.getText()));
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null,  "Existe otro Descuento con la misma descripcion", "Descuento Duplicado",JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Se generó correctamente el alta del descuento", "Alta Descuento exitosa", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if(event.getSource()==limpiarCamposButton)
		{
			descripcionTextField.setText("");
			montoDescuentoTextField.setText("");
		}
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
}
