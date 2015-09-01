package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import controlador.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class BackupBD extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JPanel panelBackUp;
	private JLabel labelValidacion;
	private JButton buttonCancelar;
	private JButton buttonBackUp;
	private String path;
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
		setTitle("Back Up Base de Datos");
		setResizable(false);

		setBounds(100, 100, 421, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);




		panelBackUp = new JPanel();
		panelBackUp.setBounds(9, 7, 396, 114);
		contentPane.add(panelBackUp);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{43, 147, 104, 100, 0};
		gbl_contentPane.rowHeights = new int[]{52, 35, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBackUp.setLayout(gbl_contentPane);

		labelValidacion = new JLabel("\u00BFEst\u00E1 seguro que desea realizar el Respaldo de la Base de Datos?");
		GridBagConstraints gbc_labelValidacion = new GridBagConstraints();
		gbc_labelValidacion.anchor = GridBagConstraints.WEST;
		gbc_labelValidacion.gridwidth = 4;
		gbc_labelValidacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelValidacion.gridx = 0;
		gbc_labelValidacion.gridy = 0;
		panelBackUp.add(labelValidacion, gbc_labelValidacion);

		buttonBackUp = new JButton("SI");
		buttonBackUp.setIcon(new ImageIcon(BackupBD.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_buttonBackUp = new GridBagConstraints();
		gbc_buttonBackUp.anchor = GridBagConstraints.EAST;
		gbc_buttonBackUp.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBackUp.fill = GridBagConstraints.VERTICAL;
		gbc_buttonBackUp.gridx = 1;
		gbc_buttonBackUp.gridy = 1;
		panelBackUp.add(buttonBackUp, gbc_buttonBackUp);
		buttonBackUp.addActionListener(this);

		buttonCancelar = new JButton("NO");
		buttonCancelar.setIcon(new ImageIcon(BackupBD.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_buttonCancelar = new GridBagConstraints();
		gbc_buttonCancelar.anchor = GridBagConstraints.EAST;
		gbc_buttonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_buttonCancelar.gridx = 2;
		gbc_buttonCancelar.gridy = 1;
		panelBackUp.add(buttonCancelar, gbc_buttonCancelar);
		buttonCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource()==buttonBackUp){


			String bk = Controlador.getInstancia().backUp();
			if (!bk.isEmpty()){
				JOptionPane.showMessageDialog(null, "Se realizó el Resguardo en la ruta:\n"+bk, "Resguardo de Base de datos", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo realizar el Resguardo de la Base de Datos", "Resguardo de Base de datos", JOptionPane.INFORMATION_MESSAGE);
			}
			dispose();

		}

		if(event.getSource()==buttonCancelar)
		{
			dispose();
		}

	}
}
