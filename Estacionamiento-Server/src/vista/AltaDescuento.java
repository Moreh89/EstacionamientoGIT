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

public class AltaDescuento extends JDialog implements ActionListener{
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
			AltaDescuento dialog = new AltaDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaDescuento() {
		setResizable(false);
		setTitle("Alta Descuento");
		setBounds(100, 100, 329, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNuevaCon = new JLabel("Descripcion:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNuevaCon.setBounds(10, 36, 144, 14);
		contentPanel.add(lblNuevaCon);

		JLabel lblNuevaCon2 = new JLabel("Monto Descuento:");
		lblNuevaCon2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevaCon2.setBounds(10, 74, 144, 14);
		contentPanel.add(lblNuevaCon2);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(195, 102, 116, 32);
		contentPanel.add(aceptarButton);
		aceptarButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(10, 102, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		descripcionTextField = new JTextField();
		descripcionTextField.setBounds(166, 31, 145, 22);
		contentPanel.add(descripcionTextField);

		montoDescuentoTextField = new JTextField();
		montoDescuentoTextField.setBounds(166, 70, 145, 22);
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
					JOptionPane.showMessageDialog(null, "Descuento Duplicado", "Existe otro Descuento con la misma descripcion", JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Alta Descuento exitosa", "Se generó correctamente el alta del descuento", JOptionPane.INFORMATION_MESSAGE);
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
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
