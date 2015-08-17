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

public class ModificarInteres extends JDialog implements ActionListener{

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
		aceptarButton.addActionListener(this);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(155, 104, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		
		textFieldInteres = new JTextField();
		textFieldInteres.setText("10%");
		textFieldInteres.setEditable(false);
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
	
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==cancelarButton)
			{
				dispose();
			}
			if(event.getSource()==aceptarButton)
			{
//				long codigoReturn;
//				if(!descripcionTextField.getText().isEmpty() && !montoDescuentoTextField.getText().isEmpty())
//				{
//					codigoReturn=Controlador.getInstancia().altaDescuento(descripcionTextField.getText(), Double.parseDouble(montoDescuentoTextField.getText()));
//					if(codigoReturn == -1)
//					{
//						JOptionPane.showMessageDialog(null, "Descuento Duplicado", "Existe otro Descuento con la misma descripcion", JOptionPane.INFORMATION_MESSAGE);
//					}
//					if(codigoReturn >= 0)
//					{
//						JOptionPane.showMessageDialog(null, "Alta Descuento exitosa", "Se generó correctamente el alta del descuento", JOptionPane.INFORMATION_MESSAGE);
//					}
//				}

		}
		
	}
}
