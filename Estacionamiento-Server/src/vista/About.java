package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;


public class About extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JPanel panelBackUp;
	private JButton buttonVolver;
	private JTextArea textAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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

	public About() {
		initGUI();
	}


	public void initGUI(){
		setTitle("Application About");
		setResizable(false);

		setBounds(100, 100, 421, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);




		panelBackUp = new JPanel();
		panelBackUp.setBorder(null);
		panelBackUp.setBackground(Color.WHITE);
		panelBackUp.setBounds(9, 7, 396, 222);
		contentPane.add(panelBackUp);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{73, 213, 100, 0};
		gbl_contentPane.rowHeights = new int[]{52, 35, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBackUp.setLayout(gbl_contentPane);
		panelBackUp.setOpaque(false);
		
		textAbout = new JTextArea();
		textAbout.setFont(new Font("Monospaced", Font.BOLD, 13));
		textAbout.setEnabled(false);
		textAbout.setWrapStyleWord(true);
		textAbout.setBackground(Color.WHITE);
		textAbout.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textAbout.setOpaque(false);
		textAbout.setText("Sistema para Gesti\u00F3n de Estacionamiento\r\n\r\nBuilt: 24/11/2015\r\n\r\nVersion: 1.2");
		textAbout.setEditable(false);
		GridBagConstraints gbc_textAbout = new GridBagConstraints();
		gbc_textAbout.gridheight = 2;
		gbc_textAbout.gridwidth = 3;
		gbc_textAbout.insets = new Insets(0, 0, 5, 0);
		gbc_textAbout.fill = GridBagConstraints.BOTH;
		gbc_textAbout.gridx = 0;
		gbc_textAbout.gridy = 0;
		panelBackUp.add(textAbout, gbc_textAbout);
				
						buttonVolver = new JButton("Volver");
						buttonVolver.setIcon(new ImageIcon(About.class.getResource("/image/izq.png")));
						GridBagConstraints gbc_buttonVolver = new GridBagConstraints();
						gbc_buttonVolver.fill = GridBagConstraints.BOTH;
						gbc_buttonVolver.gridx = 2;
						gbc_buttonVolver.gridy = 2;
						panelBackUp.add(buttonVolver, gbc_buttonVolver);
		buttonVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource()==buttonVolver){
			dispose();

		}

	}
}
