package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;








import controlador.Controlador;
import modelo.Cliente;



//import reportes.ReporteEjemplo;
import java.awt.Font;

public class CobroExtraordinario extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JButton limpiarCamposButton;
	private JTextField montoCobradoTextField;
	private JComboBox comboBoxTipoCobro;
	private modelo.Cliente cliente=new Cliente();
	private JTextField clienteTextField;
	private JButton btnBuscarCliente;
	
	
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
		setBounds(100, 100, 329, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		
		JLabel lblNuevaCon = new JLabel("Tipo Cobro:");
		lblNuevaCon.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNuevaCon.setBounds(10, 60, 70, 25);
		contentPanel.add(lblNuevaCon);

		JLabel lblNuevaCon2 = new JLabel("Monto:");
		lblNuevaCon2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevaCon2.setBounds(10, 90, 70, 25);
		contentPanel.add(lblNuevaCon2);

		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(CambioContrasenia.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(184, 130, 116, 32);
		contentPanel.add(aceptarButton);
		aceptarButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(10, 130, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		
		comboBoxTipoCobro = new JComboBox();
		comboBoxTipoCobro .setModel(new DefaultComboBoxModel(new String[] {"1. Expensas", "2. Alquiler"}));
		comboBoxTipoCobro.setBounds(80, 60, 145, 25);
		GridBagConstraints gbc_comboBoxTipoCobro  = new GridBagConstraints();
		contentPanel.add(comboBoxTipoCobro, gbc_comboBoxTipoCobro);

		montoCobradoTextField = new JTextField();
		montoCobradoTextField.setBounds(80, 90, 145, 25);
		contentPanel.add(montoCobradoTextField);
		
		JLabel clienteLabel = new JLabel("Cliente:");
		clienteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		clienteLabel.setBounds(10, 30, 70, 25);
		contentPanel.add(clienteLabel);
		
		clienteTextField = new JTextField();
		clienteTextField.setBounds(80, 30, 145, 25);
		contentPanel.add(clienteTextField);
		clienteTextField.setEnabled(false);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.setIcon(new ImageIcon(CobroExtraordinario.class.getResource("/image/search.png")));
		btnBuscarCliente.setBounds(250, 30, 50, 25);
		contentPanel.add(btnBuscarCliente);
		btnBuscarCliente.addActionListener(this);
		
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
		
		if(event.getSource()==btnBuscarCliente)
		{
			new BuscadorCliente().setVisible(true);
			if(cliente!=null)
			{
				clienteTextField.setText(cliente.getNombre()+cliente.getApellido());
			}
		}
		if(event.getSource()==aceptarButton)
		{
			
			long codigoReturn;
			if(cliente!=null && !montoCobradoTextField.getText().isEmpty() && cliente.getCuentaCorriente()!=null)
			{
				codigoReturn=Controlador.getInstancia().generarCobroExtraordinario(comboBoxTipoCobro.getSelectedItem().toString(), Double.parseDouble(montoCobradoTextField.getText()),cliente);
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null, "Cobro no realizado", "No se pudo realizar el cobro.", JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Cobro realizado exitosamente", "Se generó correctamente el cobro del pago de" + comboBoxTipoCobro.getSelectedItem().toString(), JOptionPane.INFORMATION_MESSAGE);
				}
			}
			dispose();
		}
		if(event.getSource()==limpiarCamposButton)
		{
			montoCobradoTextField.setText("");
		}
	}
}
