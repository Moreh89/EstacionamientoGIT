package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import controlador.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class BackupBD extends JDialog implements ActionListener {

	private static JPanel contentPane;
	private JPanel panelBackUp;
	private JLabel labelLetraDisco;
	private JTextField textFieldLetraDisco;
	private JButton buttonCancelar;
	private JButton buttonBackUp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackupBD frame = new BackupBD();
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

	public BackupBD() {
		initGUI();
	}


	public void initGUI(){
		setTitle("BackUp Base de Datos");
		setResizable(false);

		setBounds(100, 100, 352, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);




		panelBackUp = new JPanel();
		panelBackUp.setBounds(9, 7, 327, 121);
		contentPane.add(panelBackUp);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{147, 165, 0};
		gbl_contentPane.rowHeights = new int[]{52, 55, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBackUp.setLayout(gbl_contentPane);

		labelLetraDisco = new JLabel("Letra disco:");
		GridBagConstraints gbc_labelLetraDisco = new GridBagConstraints();
		gbc_labelLetraDisco.anchor = GridBagConstraints.WEST;
		gbc_labelLetraDisco.insets = new Insets(0, 0, 5, 5);
		gbc_labelLetraDisco.gridx = 0;
		gbc_labelLetraDisco.gridy = 0;
		panelBackUp.add(labelLetraDisco, gbc_labelLetraDisco);

		textFieldLetraDisco = new JTextField();
		textFieldLetraDisco.setColumns(10);
		GridBagConstraints gbc_textFieldLetraDisco = new GridBagConstraints();
		gbc_textFieldLetraDisco.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLetraDisco.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLetraDisco.gridx = 1;
		gbc_textFieldLetraDisco.gridy = 0;
		panelBackUp.add(textFieldLetraDisco, gbc_textFieldLetraDisco);

		buttonCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_buttonCancelar = new GridBagConstraints();
		gbc_buttonCancelar.fill = GridBagConstraints.BOTH;
		gbc_buttonCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonCancelar.gridx = 0;
		gbc_buttonCancelar.gridy = 1;
		panelBackUp.add(buttonCancelar, gbc_buttonCancelar);
		buttonCancelar.addActionListener(this);

		buttonBackUp = new JButton("BackUp");
		GridBagConstraints gbc_buttonBackUp = new GridBagConstraints();
		gbc_buttonBackUp.fill = GridBagConstraints.BOTH;
		gbc_buttonBackUp.gridx = 1;
		gbc_buttonBackUp.gridy = 1;
		panelBackUp.add(buttonBackUp, gbc_buttonBackUp);
		buttonBackUp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource()==buttonBackUp){
			if(!textFieldLetraDisco.getText().isEmpty())
			{
				boolean bk = Controlador.getInstancia().backUp(textFieldLetraDisco.getText());
				if (bk == true){
					JOptionPane.showMessageDialog(null, "Se realizó el Resguardo Satisfactoriamente", "Resguardo de Base de datos", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "No se pudo realizar el Resguardo de la Base de Datos", "Resguardo de Base de datos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		if(event.getSource()==buttonCancelar)
		{
			dispose();
		}

	}

}
