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

import modelo.PersonaAutorizada;
import controlador.Controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgregarPersonaAutorizada extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNombre;
	private JButton btnCancelar;
	private JButton btnCrear;
	private JLabel labelApellido;
	private JTextField textFieldApellido;
	private JButton buttonAgregar;
	private AltaCliente altaCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPersonaAutorizada frame = new AgregarPersonaAutorizada(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param altaCliente 
	 */

	public AgregarPersonaAutorizada(AltaCliente altaCliente) {
		this.altaCliente=altaCliente;
		setTitle("Alta Persona Autorizada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
						
								lblNombre = new JLabel("Nombre:");
								GridBagConstraints gbc_lblNombre = new GridBagConstraints();
								gbc_lblNombre.anchor = GridBagConstraints.EAST;
								gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
								gbc_lblNombre.gridx = 0;
								gbc_lblNombre.gridy = 1;
								contentPane.add(lblNombre, gbc_lblNombre);
				
						textFieldNombre = new JTextField();
						textFieldNombre.setColumns(10);
						GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
						gbc_textFieldNombre.gridwidth = 3;
						gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
						gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
						gbc_textFieldNombre.gridx = 1;
						gbc_textFieldNombre.gridy = 1;
						contentPane.add(textFieldNombre, gbc_textFieldNombre);
						
								buttonAgregar = new JButton("Agregar");
								buttonAgregar.setIcon(new ImageIcon(AgregarPersonaAutorizada.class.getResource("/image/plus.png")));
								buttonAgregar.setFont(new Font("Dialog", Font.PLAIN, 16));
								GridBagConstraints gbc_buttonAgregar = new GridBagConstraints();
								gbc_buttonAgregar.fill = GridBagConstraints.HORIZONTAL;
								gbc_buttonAgregar.insets = new Insets(0, 0, 5, 0);
								gbc_buttonAgregar.gridx = 4;
								gbc_buttonAgregar.gridy = 1;
								contentPane.add(buttonAgregar, gbc_buttonAgregar);
								buttonAgregar.addActionListener(this);
				
						labelApellido = new JLabel("Apellido:");
						GridBagConstraints gbc_labelApellido = new GridBagConstraints();
						gbc_labelApellido.anchor = GridBagConstraints.EAST;
						gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
						gbc_labelApellido.gridx = 0;
						gbc_labelApellido.gridy = 2;
						contentPane.add(labelApellido, gbc_labelApellido);
		
				textFieldApellido = new JTextField();
				textFieldApellido.setColumns(10);
				GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
				gbc_textFieldApellido.gridwidth = 3;
				gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldApellido.gridx = 1;
				gbc_textFieldApellido.gridy = 2;
				contentPane.add(textFieldApellido, gbc_textFieldApellido);
		
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
				GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
				gbc_btnBorrar.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnBorrar.gridwidth = 2;
				gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
				gbc_btnBorrar.gridx = 0;
				gbc_btnBorrar.gridy = 4;
				contentPane.add(btnCancelar, gbc_btnBorrar);
				btnCancelar.addActionListener(this);


		btnCrear = new JButton("Finalizar");
		btnCrear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCrear.setIcon(new ImageIcon(AgregarPersonaAutorizada.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.gridheight = 2;
		gbc_btnCrear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrear.gridx = 4;
		gbc_btnCrear.gridy = 4;
		contentPane.add(btnCrear, gbc_btnCrear);
		btnCrear.addActionListener(this);

		this.setLocationRelativeTo(null);
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCancelar){
			dispose();
		}
		if(event.getSource()==buttonAgregar)
		{
			Controlador.getInstancia().agregarPersonaAutorizada(textFieldNombre.getText(), textFieldApellido.getText());
			limpiarCampos();
		}
		if(event.getSource()==btnCrear)
		{
			altaCliente.agregarPersonasAutorizadasAltaCliente(Controlador.getInstancia().personasAutorizadasActuales);
			dispose();
		}

	}

	private void limpiarCampos()
	{
		textFieldApellido.setText("");
		textFieldNombre.setText("");
	}

}
