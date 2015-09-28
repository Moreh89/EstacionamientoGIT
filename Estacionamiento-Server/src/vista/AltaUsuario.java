package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;

public class AltaUsuario extends JDialog implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JLabel lblPassword2;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTipoUsuario;
	private JLabel lblTipoDoc;
	private JLabel lblNroDoc;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword1;
	private JTextField textFieldPassword2;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNroDoc;
	private JTextField textFieldTipoUsuario;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxTipoDoc;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaUsuario dialog = new AltaUsuario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AltaUsuario(String tipoUsuario) {
		setResizable(false);
		setTitle("Alta Usuario");
		setBounds(100, 100, 329, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 97, 72, 80, 0};
		gbl_contentPanel.rowHeights = new int[]{22, 22, 0, 0, 0, 0, 0, 0, 10, 32, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.WEST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 0;
		contentPanel.add(lblUserName, gbc_lblUserName);

		textFieldUserName = new JTextField();
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.gridwidth = 3;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 0;
		contentPanel.add(textFieldUserName, gbc_textFieldUserName);
		textFieldUserName.setColumns(10);
		textFieldUserName.addKeyListener(this);
		
		JLabel lblPassword1 = new JLabel("Contrase\u00F1a:");
		lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPassword1 = new GridBagConstraints();
		gbc_lblPassword1.anchor = GridBagConstraints.WEST;
		gbc_lblPassword1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword1.gridx = 0;
		gbc_lblPassword1.gridy = 1;
		contentPanel.add(lblPassword1, gbc_lblPassword1);

		textFieldPassword1 = new JPasswordField();
		GridBagConstraints gbc_textFieldPassword1 = new GridBagConstraints();
		gbc_textFieldPassword1.gridwidth = 3;
		gbc_textFieldPassword1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPassword1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword1.gridx = 1;
		gbc_textFieldPassword1.gridy = 1;
		contentPanel.add(textFieldPassword1, gbc_textFieldPassword1);
		textFieldPassword1.setColumns(10);
		textFieldPassword1.addKeyListener(this);


		lblPassword2 = new JLabel("Repita Contrase\u00F1a:");
		GridBagConstraints gbc_lblPassword2 = new GridBagConstraints();
		gbc_lblPassword2.anchor = GridBagConstraints.WEST;
		gbc_lblPassword2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword2.gridx = 0;
		gbc_lblPassword2.gridy = 2;
		contentPanel.add(lblPassword2, gbc_lblPassword2);

		textFieldPassword2 = new JPasswordField();
		GridBagConstraints gbc_textFieldPassword2 = new GridBagConstraints();
		gbc_textFieldPassword2.gridwidth = 3;
		gbc_textFieldPassword2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPassword2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword2.gridx = 1;
		gbc_textFieldPassword2.gridy = 2;
		contentPanel.add(textFieldPassword2, gbc_textFieldPassword2);
		textFieldPassword2.setColumns(10);
		textFieldPassword2.addKeyListener(this);

		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		contentPanel.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 3;
		contentPanel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.addKeyListener(this);

		
		lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 4;
		contentPanel.add(lblApellido, gbc_lblApellido);

		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.gridwidth = 3;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 4;
		contentPanel.add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.addKeyListener(this);

		
		lblTipoDoc = new JLabel("Tipo Doc:");
		GridBagConstraints gbc_lblTipoDoc = new GridBagConstraints();
		gbc_lblTipoDoc.anchor = GridBagConstraints.WEST;
		gbc_lblTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDoc.gridx = 0;
		gbc_lblTipoDoc.gridy = 5;
		contentPanel.add(lblTipoDoc, gbc_lblTipoDoc);

		comboBoxTipoDoc = new JComboBox();
		comboBoxTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LU", "PASAPORTE", "OTRO"}));
		GridBagConstraints gbc_comboBoxTipoDoc = new GridBagConstraints();
		gbc_comboBoxTipoDoc.gridwidth = 3;
		gbc_comboBoxTipoDoc.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoDoc.gridx = 1;
		gbc_comboBoxTipoDoc.gridy = 5;
		contentPanel.add(comboBoxTipoDoc, gbc_comboBoxTipoDoc);

		lblNroDoc = new JLabel("Nro. Doc:");
		GridBagConstraints gbc_lblNroDoc = new GridBagConstraints();
		gbc_lblNroDoc.anchor = GridBagConstraints.WEST;
		gbc_lblNroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDoc.gridx = 0;
		gbc_lblNroDoc.gridy = 6;
		contentPanel.add(lblNroDoc, gbc_lblNroDoc);

		textFieldNroDoc = new JTextField();
		GridBagConstraints gbc_textFieldNroDoc = new GridBagConstraints();
		gbc_textFieldNroDoc.gridwidth = 3;
		gbc_textFieldNroDoc.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNroDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNroDoc.gridx = 1;
		gbc_textFieldNroDoc.gridy = 6;
		contentPanel.add(textFieldNroDoc, gbc_textFieldNroDoc);
		textFieldNroDoc.setColumns(10);
		textFieldNroDoc.addKeyListener(this);
		
		lblTipoUsuario = new JLabel("Tipo Usuario:");
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 0;
		gbc_lblTipoUsuario.gridy = 7;
		contentPanel.add(lblTipoUsuario, gbc_lblTipoUsuario);

		textFieldTipoUsuario = new JTextField();
		textFieldTipoUsuario.setEnabled(false);
		textFieldTipoUsuario.setEditable(false);
		GridBagConstraints gbc_textFieldTipoUsuario = new GridBagConstraints();
		gbc_textFieldTipoUsuario.gridwidth = 3;
		gbc_textFieldTipoUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTipoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTipoUsuario.gridx = 1;
		gbc_textFieldTipoUsuario.gridy = 7;
		contentPanel.add(textFieldTipoUsuario, gbc_textFieldTipoUsuario);
		textFieldTipoUsuario.setColumns(10);
		textFieldTipoUsuario.setText(tipoUsuario);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.gridwidth = 2;
		gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
		gbc_aceptarButton.gridx = 0;
		gbc_aceptarButton.gridy = 9;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		aceptarButton.addActionListener(this);

		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(AltaUsuario.class.getResource("/image/izq.png")));
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.fill = GridBagConstraints.VERTICAL;
		gbc_btnVolver.gridwidth = 2;
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.gridx = 2;
		gbc_btnVolver.gridy = 9;
		contentPanel.add(btnVolver, gbc_btnVolver);
		btnVolver.addActionListener(this);
		this.setLocationRelativeTo(null);
		setModal(true);




	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==btnVolver)
		{
			dispose();
		}
		if(event.getSource()==aceptarButton)
		{
			long codigoReturn=-1;

			if(textFieldPassword2.getText().toString().equals(textFieldPassword1.getText().toString()))
			{
				if(isNumeric(textFieldNroDoc.getText().toString()))
				{


					if(!textFieldApellido.getText().toString().isEmpty()&&
							!textFieldNombre.getText().toString().isEmpty()&&
							!textFieldNroDoc.getText().toString().isEmpty()&&
							!textFieldPassword1.getText().toString().isEmpty()&&
							!textFieldPassword2.getText().toString().isEmpty()&&
							!textFieldTipoUsuario.getText().toString().isEmpty()&&
							!textFieldUserName.getText().toString().isEmpty())
					{
						for (modelo.Usuario usuarioAct : Controlador.getInstancia().getUsuarios())
						{
							if(!usuarioAct.getUserName().equalsIgnoreCase(textFieldUserName.getText().toString()))
							{
								codigoReturn=Controlador.getInstancia().altaUsuario(textFieldApellido.getText().toString(),textFieldNombre.getText().toString()
										,textFieldNroDoc.getText().toString(),textFieldPassword1.getText().toString(),
										textFieldTipoUsuario.getText().toString(),
										textFieldUserName.getText().toString(),comboBoxTipoDoc.getSelectedItem().toString());
								break;
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Ya existe otro Usuario con el mismo User Name (Nombre de Usuario)", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
								break;
							}
						}
						if(codigoReturn==-1)
						{
							//Error
							JOptionPane.showMessageDialog(null, "Se produjo un error al intentar dar de Alta el Usuario. Intente nuevamente.", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							//OK
							JOptionPane.showMessageDialog(null, "Alta de Usuario exitosa", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
					else
					{
						//Campos en blanco
						JOptionPane.showMessageDialog(null, "Por favor, verifique que todos los campos se encuentren completos.", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);

					}
				}else
				{
					//DNI no numerico
					JOptionPane.showMessageDialog(null, "Número Documento Inválido.", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);

				}
			}else
			{

				//Claves no coinciden
				JOptionPane.showMessageDialog(null, "Por favor, verifique que ambas contraseñas coincidan.", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
				textFieldPassword1.setText("");
				textFieldPassword2.setText("");
			}
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

	@Override
	public void keyPressed(KeyEvent event) {

		{
			if (event.getKeyCode()== KeyEvent.VK_ENTER ){
				this.aceptarButton.doClick();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
