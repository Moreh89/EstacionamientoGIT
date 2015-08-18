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
import controlador.Controlador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class AgregarPersonaAutorizada extends JFrame implements ActionListener
{

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
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblPersonasAuth;
	
	@SuppressWarnings("rawtypes")
	private JList listPersonas;
	
	
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

	@SuppressWarnings("rawtypes")
	public AgregarPersonaAutorizada(AltaCliente altaCliente) {
		setResizable(false);
		this.altaCliente=altaCliente;
		setTitle("Gestion Persona Autorizada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 38, 40, 40, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);
		

		labelApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 0;
		gbc_labelApellido.gridy = 2;
		contentPane.add(labelApellido, gbc_labelApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.gridwidth = 2;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 2;
		contentPane.add(textFieldApellido, gbc_textFieldApellido);

		lblPersonasAuth = new JLabel("Personas Auth:");
		GridBagConstraints gbc_lblPersonasAuth = new GridBagConstraints();
		gbc_lblPersonasAuth.fill = GridBagConstraints.VERTICAL;
		gbc_lblPersonasAuth.anchor = GridBagConstraints.WEST;
		gbc_lblPersonasAuth.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonasAuth.gridx = 0;
		gbc_lblPersonasAuth.gridy = 3;
		contentPane.add(lblPersonasAuth, gbc_lblPersonasAuth);
		
				buttonAgregar = new JButton("Agregar");
				buttonAgregar.setIcon(new ImageIcon(AgregarPersonaAutorizada.class.getResource("/image/plus.png")));
				buttonAgregar.setFont(new Font("Dialog", Font.PLAIN, 16));
				GridBagConstraints gbc_buttonAgregar = new GridBagConstraints();
				gbc_buttonAgregar.fill = GridBagConstraints.HORIZONTAL;
				gbc_buttonAgregar.insets = new Insets(0, 0, 5, 0);
				gbc_buttonAgregar.gridx = 3;
				gbc_buttonAgregar.gridy = 3;
				contentPane.add(buttonAgregar, gbc_buttonAgregar);
				buttonAgregar.addActionListener(this);		

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);

		listPersonas = new JList();
		scrollPane.setViewportView(listPersonas);
				
						btnModificar = new JButton("Modificar");
						btnModificar.setFont(new Font("Dialog", Font.PLAIN, 16));
						GridBagConstraints gbc_btnModificar = new GridBagConstraints();
						gbc_btnModificar.fill = GridBagConstraints.BOTH;
						gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
						gbc_btnModificar.gridx = 1;
						gbc_btnModificar.gridy = 9;
						contentPane.add(btnModificar, gbc_btnModificar);
		
				
		
				
		
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setFont(new Font("Dialog", Font.PLAIN, 16));
				GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
				gbc_btnEliminar.fill = GridBagConstraints.BOTH;
				gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
				gbc_btnEliminar.gridx = 3;
				gbc_btnEliminar.gridy = 9;
				contentPane.add(btnEliminar, gbc_btnEliminar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(MenuOperador.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBorrar.gridx = 1;
		gbc_btnBorrar.gridy = 10;
		contentPane.add(btnCancelar, gbc_btnBorrar);


		btnCrear = new JButton("Finalizar");
		btnCrear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCrear.setIcon(new ImageIcon(AgregarPersonaAutorizada.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.fill = GridBagConstraints.BOTH;
		gbc_btnCrear.gridx = 3;
		gbc_btnCrear.gridy = 10;
		contentPane.add(btnCrear, gbc_btnCrear);
		btnCrear.addActionListener(this);
		btnCancelar.addActionListener(this);

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
				Controlador.getInstancia().agregarPersonaAutorizada(textFieldNombre.getText(), textFieldApellido.getText());
				limpiarCampos();

			}
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
