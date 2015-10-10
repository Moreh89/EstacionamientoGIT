package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PersonaAutorizada;

public class AgregarPersonaAutorizada extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNombre;
	private JButton btnCancelar;
	private JLabel labelApellido;
	private JTextField textFieldApellido;
	private JButton buttonAgregar;
	private AltaCliente altaCliente;

	public AgregarPersonaAutorizada(AltaCliente altaCliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarPersonaAutorizada.class.getResource("/image/printer.png")));
		setResizable(false);
		this.altaCliente=altaCliente;
		setTitle("Agregar Persona Autorizada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 38, 40, 40, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);
		

		labelApellido = new JLabel("Apellido:");
		labelApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 0;
		gbc_labelApellido.gridy = 2;
		contentPane.add(labelApellido, gbc_labelApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 2;
		contentPane.add(textFieldApellido, gbc_textFieldApellido);
				
						btnCancelar = new JButton("Cancelar");
						btnCancelar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
						GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
						gbc_btnBorrar.fill = GridBagConstraints.BOTH;
						gbc_btnBorrar.insets = new Insets(0, 0, 0, 5);
						gbc_btnBorrar.gridx = 0;
						gbc_btnBorrar.gridy = 3;
						contentPane.add(btnCancelar, gbc_btnBorrar);
						btnCancelar.addActionListener(this);
				
						buttonAgregar = new JButton("Agregar");
						buttonAgregar.setIcon(new ImageIcon(AgregarPersonaAutorizada.class.getResource("/image/plus.png")));
						buttonAgregar.setFont(new Font("Dialog", Font.PLAIN, 16));
						GridBagConstraints gbc_buttonAgregar = new GridBagConstraints();
						gbc_buttonAgregar.fill = GridBagConstraints.BOTH;
						gbc_buttonAgregar.gridx = 1;
						gbc_buttonAgregar.gridy = 3;
						contentPane.add(buttonAgregar, gbc_buttonAgregar);
				buttonAgregar.addActionListener(this);

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnCancelar){
			dispose();
		}
		if(event.getSource()==buttonAgregar)
		{
			if(!textFieldNombre.getText().isEmpty() || !textFieldApellido.getText().isEmpty())
			{
				altaCliente.agregarPersonasAutorizadasAltaCliente(new PersonaAutorizada(0, textFieldNombre.getText()+ " "+ textFieldApellido.getText()));
				dispose();
			}
		}

	}

}
