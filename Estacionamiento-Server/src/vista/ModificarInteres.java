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
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JTextField;

import controlador.Controlador;

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
	private JLabel label;

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
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(155, 104, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		
		textFieldInteres = new JTextField();
		textFieldInteres.setEditable(false);
		textFieldInteres.setBounds(137, 28, 45, 28);
		contentPanel.add(textFieldInteres);
		textFieldInteres.setColumns(10);
		textFieldInteres.setText(String.valueOf(Controlador.getInstancia().getTasaInteres()));
		
		textFieldnuevoInteres = new JTextField();
		textFieldnuevoInteres.setColumns(10);
		textFieldnuevoInteres.setBounds(137, 67, 45, 28);
		contentPanel.add(textFieldnuevoInteres);
		
		JLabel porcentaje = new JLabel("%");
		porcentaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		porcentaje.setBounds(192, 33, 20, 20);
		contentPanel.add(porcentaje);
		
		label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(192, 72, 20, 20);
		contentPanel.add(label);
		
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
				if(!textFieldnuevoInteres.getText().isEmpty())
				{
					codigoReturn=Controlador.getInstancia().modificarTasaInteres(Double.parseDouble(textFieldnuevoInteres.getText()));
					if(codigoReturn == -1)
						{
							JOptionPane.showMessageDialog(null, "Se produjo un error. Vuelva a intentar en unos instantes. En caso de presentarse nuevamente el error, comunicarse con el desarrollador del sistema", "Tasa Interes", JOptionPane.INFORMATION_MESSAGE);
						}
						if(codigoReturn >= 0)
						{
							JOptionPane.showMessageDialog(null,  "Se actualizó correctamente la tasa de interés", "Tasa Interes",JOptionPane.INFORMATION_MESSAGE);
						}
				
				}
		}
		
	}
}
