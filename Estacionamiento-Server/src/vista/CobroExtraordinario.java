package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import controlador.Controlador;
import modelo.Cliente;
//import reportes.ReporteEjemplo;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class CobroExtraordinario extends JDialog implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JButton limpiarCamposButton;
	private JTextField montoCobradoTextField;
	private JComboBox<String> comboBoxTipoCobro;
	private modelo.Cliente cliente=new Cliente();
	private JTextField clienteTextField;
	private JButton btnBuscarCliente;
	private GridBagConstraints gbc_comboBoxTipoCobro_1;
	private JComboBox comboBoxImpresoras;
	private JLabel labelImpresora;
	private JLabel labelComentario;
	private JTextField textFieldComentario;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CobroExtraordinario dialog = new CobroExtraordinario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CobroExtraordinario() 
	{
		setResizable(false);
		setTitle("Cobro Extraordinario");
		setBounds(100, 100, 450, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 141, 89, 58, 10, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 40, 40, 40, 40, 0, 32, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_comboBoxTipoCobro_1_1  = new GridBagConstraints();
		gbc_comboBoxTipoCobro_1_1.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTipoCobro_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoCobro_1_1.gridwidth = 3;
		gbc_comboBoxTipoCobro_1_1.gridx = 1;
		gbc_comboBoxTipoCobro_1_1.gridy = 0;

		JLabel clienteLabel = new JLabel("Cliente:");
		clienteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_clienteLabel = new GridBagConstraints();
		gbc_clienteLabel.anchor = GridBagConstraints.WEST;
		gbc_clienteLabel.fill = GridBagConstraints.VERTICAL;
		gbc_clienteLabel.insets = new Insets(0, 0, 5, 5);
		gbc_clienteLabel.gridx = 0;
		gbc_clienteLabel.gridy = 0;
		contentPanel.add(clienteLabel, gbc_clienteLabel);

		clienteTextField = new JTextField();
		GridBagConstraints gbc_clienteTextField = new GridBagConstraints();
		gbc_clienteTextField.gridwidth = 2;
		gbc_clienteTextField.fill = GridBagConstraints.BOTH;
		gbc_clienteTextField.insets = new Insets(0, 0, 5, 5);
		gbc_clienteTextField.gridx = 1;
		gbc_clienteTextField.gridy = 0;
		contentPanel.add(clienteTextField, gbc_clienteTextField);
		clienteTextField.setEnabled(false);

		btnBuscarCliente = new JButton("");
		btnBuscarCliente.setIcon(new ImageIcon(CobroExtraordinario.class.getResource("/image/search.png")));
		GridBagConstraints gbc_btnBuscarCliente = new GridBagConstraints();
		gbc_btnBuscarCliente.fill = GridBagConstraints.BOTH;
		gbc_btnBuscarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarCliente.gridx = 3;
		gbc_btnBuscarCliente.gridy = 0;
		contentPanel.add(btnBuscarCliente, gbc_btnBuscarCliente);
		btnBuscarCliente.addActionListener(this);


		JLabel lblNuevaCon = new JLabel("Tipo Cobro:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevaCon = new GridBagConstraints();
		gbc_lblNuevaCon.anchor = GridBagConstraints.WEST;
		gbc_lblNuevaCon.fill = GridBagConstraints.VERTICAL;
		gbc_lblNuevaCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaCon.gridx = 0;
		gbc_lblNuevaCon.gridy = 1;
		contentPanel.add(lblNuevaCon, gbc_lblNuevaCon);


		comboBoxTipoCobro = new JComboBox<String>();
		comboBoxTipoCobro.setModel(new DefaultComboBoxModel(new String[] {"1. ALQUILER", "2. EXPENSAS", "3. OTROS"}));
		gbc_comboBoxTipoCobro_1 = new GridBagConstraints();
		gbc_comboBoxTipoCobro_1.gridwidth = 3;
		gbc_comboBoxTipoCobro_1.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTipoCobro_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoCobro_1.gridx = 1;
		gbc_comboBoxTipoCobro_1.gridy = 1;
		contentPanel.add(comboBoxTipoCobro, gbc_comboBoxTipoCobro_1);

		JLabel lblNuevaCon2 = new JLabel("Monto:");
		lblNuevaCon2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevaCon2 = new GridBagConstraints();
		gbc_lblNuevaCon2.anchor = GridBagConstraints.WEST;
		gbc_lblNuevaCon2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNuevaCon2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaCon2.gridx = 0;
		gbc_lblNuevaCon2.gridy = 2;
		contentPanel.add(lblNuevaCon2, gbc_lblNuevaCon2);

		montoCobradoTextField = new JTextField();
		GridBagConstraints gbc_montoCobradoTextField = new GridBagConstraints();
		gbc_montoCobradoTextField.gridwidth = 3;
		gbc_montoCobradoTextField.fill = GridBagConstraints.BOTH;
		gbc_montoCobradoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_montoCobradoTextField.gridx = 1;
		gbc_montoCobradoTextField.gridy = 2;
		contentPanel.add(montoCobradoTextField, gbc_montoCobradoTextField);
		montoCobradoTextField.addKeyListener(this);
		
		labelComentario = new JLabel("Comentario:");
		labelComentario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelComentario = new GridBagConstraints();
		gbc_labelComentario.anchor = GridBagConstraints.EAST;
		gbc_labelComentario.insets = new Insets(0, 0, 5, 5);
		gbc_labelComentario.gridx = 0;
		gbc_labelComentario.gridy = 3;
		contentPanel.add(labelComentario, gbc_labelComentario);
		
		textFieldComentario = new JTextField();
		GridBagConstraints gbc_textFieldComentario = new GridBagConstraints();
		gbc_textFieldComentario.gridwidth = 3;
		gbc_textFieldComentario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldComentario.fill = GridBagConstraints.BOTH;
		gbc_textFieldComentario.gridx = 1;
		gbc_textFieldComentario.gridy = 3;
		contentPanel.add(textFieldComentario, gbc_textFieldComentario);
		
		labelImpresora = new JLabel("Impresora:");
		labelImpresora.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelImpresora = new GridBagConstraints();
		gbc_labelImpresora.insets = new Insets(0, 0, 5, 5);
		gbc_labelImpresora.anchor = GridBagConstraints.EAST;
		gbc_labelImpresora.gridx = 0;
		gbc_labelImpresora.gridy = 4;
		contentPanel.add(labelImpresora, gbc_labelImpresora);
		
		comboBoxImpresoras = new JComboBox();
		comboBoxImpresoras.setFocusable(false);
		GridBagConstraints gbc_comboBoxImpresoras = new GridBagConstraints();
		gbc_comboBoxImpresoras.gridwidth = 3;
		gbc_comboBoxImpresoras.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxImpresoras.fill = GridBagConstraints.BOTH;
		gbc_comboBoxImpresoras.gridx = 1;
		gbc_comboBoxImpresoras.gridy = 4;
		comboBoxImpresoras.addItem("NO IMPRIMIR");
		contentPanel.add(comboBoxImpresoras, gbc_comboBoxImpresoras);
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
				null, null);
		//Para saber el nombre de tus impresoras
		for (PrintService printer : printServices) {
			comboBoxImpresoras.addItem(printer.getName());
		}
		comboBoxImpresoras.setSelectedIndex(1);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_aceptarButton.insets = new Insets(0, 0, 0, 5);
		gbc_aceptarButton.gridx = 1;
		gbc_aceptarButton.gridy = 6;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		aceptarButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelarButton.gridx = 3;
		gbc_cancelarButton.gridy = 6;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);

		;

		this.setLocationRelativeTo(null);
		setModal(true);
	}

	public void cobroExtraOrdinarioSetCliente(modelo.Cliente cliente)
	{
		this.cliente=cliente;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}

		if(event.getSource()==limpiarCamposButton)
		{
			montoCobradoTextField.setText("");
		}

		if(event.getSource()==btnBuscarCliente)
		{
			new BuscadorCliente().setVisible(true);
			this.cliente=Controlador.getInstancia().getClienteActual();
			if(cliente!=null)
			{
				clienteTextField.setText(cliente.getNombre()+cliente.getApellido());
			}
		}
		if(event.getSource()==aceptarButton)
		{
			if(!clienteTextField.getText().isEmpty())
			{
				long codigoReturn;
				if(cliente!=null &&  cliente.getCuentaCorriente()!=null)
				{
					if(!montoCobradoTextField.getText().isEmpty()&&isNumeric(montoCobradoTextField.getText()))
					{
						int resultado = JOptionPane.showConfirmDialog (null, "¿Está seguro?","Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
						UIManager.put("OptionPane.yesButtonText", "Si");
						UIManager.put("OptionPane.noButtonText", "No");
						if(resultado != JOptionPane.CANCEL_OPTION && resultado != JOptionPane.CLOSED_OPTION)
						{
							if (resultado == JOptionPane.OK_OPTION)
							{
								String impresora = (String) this.comboBoxImpresoras.getSelectedItem();
								codigoReturn=Controlador.getInstancia().generarCobroExtraordinario(comboBoxTipoCobro.getSelectedItem().toString(), Double.parseDouble(montoCobradoTextField.getText()),cliente, impresora, textFieldComentario.getText());
								if(codigoReturn == -1)
								{
									JOptionPane.showMessageDialog(null, "No se pudo realizar el cobro.", "Cobro Extraordinario", JOptionPane.INFORMATION_MESSAGE);
								}
								if(codigoReturn >= 0)
								{
									JOptionPane.showMessageDialog(null, "Se generó correctamente el cobro del pago de " + comboBoxTipoCobro.getSelectedItem().toString(),"Cobro Extraordinario", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "El campo Monto se encuentra incompleto o el valor ingresado no es válido.","Cobro Extraordinario", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Cliente no seleccionado.", "Cobro Extraordinario", JOptionPane.INFORMATION_MESSAGE);
						}
					}

					else
					{
						JOptionPane.showMessageDialog(null, "Cliente no seleccionado.", "Cobro Extraordinario", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Cliente no seleccionado.", "Cobro Extraordinario", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	@SuppressWarnings("unused")
	public static boolean isNumeric(String str)  
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

	@Override
	public void keyPressed(KeyEvent event) {

		{
			if (event.getKeyCode()== KeyEvent.VK_ENTER){
				this.aceptarButton.doClick();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	


}
