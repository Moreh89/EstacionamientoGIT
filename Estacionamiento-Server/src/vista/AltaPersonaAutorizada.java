package vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaPersonaAutorizada extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumeroTicket;
	private JLabel lblNombre;
	private JButton btnCancelar;
	private JButton btnCrear;
	private JLabel labelApellido;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPersonaAutorizada frame = new AltaPersonaAutorizada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public AltaPersonaAutorizada() {
		setTitle("Alta Persona Autorizada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		 lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textFieldNumeroTicket = new JTextField();
		textFieldNumeroTicket.setColumns(10);
		GridBagConstraints gbc_textFieldNumeroTicket = new GridBagConstraints();
		gbc_textFieldNumeroTicket.gridwidth = 3;
		gbc_textFieldNumeroTicket.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumeroTicket.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumeroTicket.gridx = 1;
		gbc_textFieldNumeroTicket.gridy = 0;
		contentPane.add(textFieldNumeroTicket, gbc_textFieldNumeroTicket);
		  
		  labelApellido = new JLabel("Apellido:");
		  GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		  gbc_labelApellido.anchor = GridBagConstraints.EAST;
		  gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		  gbc_labelApellido.gridx = 0;
		  gbc_labelApellido.gridy = 1;
		  contentPane.add(labelApellido, gbc_labelApellido);
		  
		  textField = new JTextField();
		  textField.setColumns(10);
		  GridBagConstraints gbc_textField = new GridBagConstraints();
		  gbc_textField.gridwidth = 3;
		  gbc_textField.insets = new Insets(0, 0, 5, 5);
		  gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		  gbc_textField.gridx = 1;
		  gbc_textField.gridy = 1;
		  contentPane.add(textField, gbc_textField);
		  
		   btnCrear = new JButton("Agregar");
		   btnCrear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		   btnCrear.setIcon(new ImageIcon(AltaPersonaAutorizada.class.getResource("/image/plus.png")));
		   GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		   gbc_btnCrear.gridheight = 2;
		   gbc_btnCrear.fill = GridBagConstraints.BOTH;
		   gbc_btnCrear.gridx = 4;
		   gbc_btnCrear.gridy = 1;
		   contentPane.add(btnCrear, gbc_btnCrear);
		 
		  btnCancelar = new JButton("Cancelar");
		  btnCancelar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
		  GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		  gbc_btnBorrar.gridwidth = 2;
		  gbc_btnBorrar.insets = new Insets(0, 0, 0, 5);
		  gbc_btnBorrar.gridx = 1;
		  gbc_btnBorrar.gridy = 2;
		  contentPane.add(btnCancelar, gbc_btnBorrar);
		  btnCancelar.addActionListener(this);
		  
		  this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCancelar){
			dispose();
		}
		
	}

}
