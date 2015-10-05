package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.PersonaAutorizada;

public class VerPersonaAutorizada extends JDialog implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblNombre;
	private JButton buttonVolver;
	private PersonaAutorizada persona;

	public VerPersonaAutorizada(PersonaAutorizada persona) {
		setAlwaysOnTop(true);
		setResizable(false);
		this.persona=persona;
		setTitle("Ver Persona Autorizada");
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

		lblNombre = new JLabel("Nombre Completo:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField(this.persona.getNombre());
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 1;
		contentPane.add(textFieldNombre, gbc_textFieldNombre);

		buttonVolver = new JButton("Volver");
		buttonVolver.setIcon(new ImageIcon(VerPersonaAutorizada.class.getResource("/image/izq.png")));
		buttonVolver.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_buttonVolver = new GridBagConstraints();
		gbc_buttonVolver.fill = GridBagConstraints.BOTH;
		gbc_buttonVolver.gridx = 1;
		gbc_buttonVolver.gridy = 3;
		contentPane.add(buttonVolver, gbc_buttonVolver);
		buttonVolver.addActionListener(this);
		this.setModal(true); 
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==buttonVolver)
		{
			dispose();
		}
	}

}
