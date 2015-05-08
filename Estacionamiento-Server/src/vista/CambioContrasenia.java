package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import reportes.ReporteEjemplo;
import java.awt.Font;
import javax.swing.JPasswordField;

public class CambioContrasenia extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JPasswordField passwordFieldCon1;
	private JPasswordField passwordFieldCon2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CambioContrasenia dialog = new CambioContrasenia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CambioContrasenia() {
		setResizable(false);
		setTitle("Cambio Contrase\u00F1a");
		setBounds(100, 100, 329, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNuevaCon = new JLabel("Nueva Contrase\u00F1a:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblNuevaCon.setBounds(10, 36, 144, 14);
		contentPanel.add(lblNuevaCon);
		
		JLabel lblNuevaCon2 = new JLabel("Repetir Contrase\u00F1a:");
		lblNuevaCon2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevaCon2.setBounds(10, 75, 144, 14);
		contentPanel.add(lblNuevaCon2);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(195, 102, 116, 32);
		contentPanel.add(aceptarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(10, 102, 116, 32);
		contentPanel.add(cancelarButton);
		
		passwordFieldCon1 = new JPasswordField();
		passwordFieldCon1.setBounds(166, 31, 145, 22);
		contentPanel.add(passwordFieldCon1);
		
		passwordFieldCon2 = new JPasswordField();
		passwordFieldCon2.setBounds(166, 70, 145, 22);
		contentPanel.add(passwordFieldCon2);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}
}
