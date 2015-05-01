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
import java.awt.Font;
import javax.swing.JTextField;

public class ModificarInteres extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JTextField textFieldInteres;
	private JTextField textFieldnuevoInteres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarInteres dialog = new ModificarInteres();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarInteres() {
		setResizable(false);
		setTitle("Modificacion Interes");
		setBounds(100, 100, 289, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInteresActual = new JLabel("Interes Actual:");
		lblInteresActual.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblInteresActual.setBounds(10, 36, 116, 14);
		contentPanel.add(lblInteresActual);
		
		JLabel lblNuevaInteres = new JLabel("Nuevo Interes:");
		lblNuevaInteres.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevaInteres.setBounds(10, 75, 116, 14);
		contentPanel.add(lblNuevaInteres);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(ModificarInteres.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(29, 104, 116, 32);
		contentPanel.add(aceptarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(BuscardorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(155, 104, 116, 32);
		contentPanel.add(cancelarButton);
		
		textFieldInteres = new JTextField();
		textFieldInteres.setBounds(137, 28, 134, 28);
		contentPanel.add(textFieldInteres);
		textFieldInteres.setColumns(10);
		
		textFieldnuevoInteres = new JTextField();
		textFieldnuevoInteres.setColumns(10);
		textFieldnuevoInteres.setBounds(137, 67, 134, 28);
		contentPanel.add(textFieldnuevoInteres);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}
}