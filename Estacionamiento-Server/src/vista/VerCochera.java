package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cochera;



public class VerCochera extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCostoMensual;
	private JTextField textFieldPorcentajeExpensas;
	private JTextField textFieldUbicacion;
	private JButton buttonVolver;
	private Cochera cochera;

	
	public VerCochera(Cochera cochera) {
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.cochera=cochera;
		initGUI();
	}


	public void initGUI(){
		setTitle("Ver Cochera");
		setResizable(false);
		setBounds(100, 100, 377, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 353, 101);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{181, 170, 0};
		gbl_panel.rowHeights = new int[] {28, 28, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel labelCostoMensual = new JLabel("Costo Mensual:");
		GridBagConstraints gbc_labelCostoMensual = new GridBagConstraints();
		gbc_labelCostoMensual.anchor = GridBagConstraints.WEST;
		gbc_labelCostoMensual.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoMensual.gridx = 0;
		gbc_labelCostoMensual.gridy = 0;
		panel.add(labelCostoMensual, gbc_labelCostoMensual);

		textCostoMensual = new JTextField(String.valueOf(cochera.getCostoCochera()));
		textCostoMensual.setEnabled(false);
		textCostoMensual.setEditable(false);
		textCostoMensual.setColumns(10);
		GridBagConstraints gbc_textCostoMensual = new GridBagConstraints();
		gbc_textCostoMensual.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoMensual.insets = new Insets(0, 0, 5, 0);
		gbc_textCostoMensual.gridx = 1;
		gbc_textCostoMensual.gridy = 0;
		panel.add(textCostoMensual, gbc_textCostoMensual);

		JLabel labelUbicacion = new JLabel("Ubicacion:");
		GridBagConstraints gbc_labelUbicacion = new GridBagConstraints();
		gbc_labelUbicacion.anchor = GridBagConstraints.WEST;
		gbc_labelUbicacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelUbicacion.gridx = 0;
		gbc_labelUbicacion.gridy = 1;
		panel.add(labelUbicacion, gbc_labelUbicacion);

		textFieldUbicacion = new JTextField(cochera.getUbicacion());
		textFieldUbicacion.setEnabled(false);
		textFieldUbicacion.setEditable(false);
		textFieldUbicacion.setColumns(10);
		GridBagConstraints gbc_textFieldUbicacion = new GridBagConstraints();
		gbc_textFieldUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUbicacion.gridx = 1;
		gbc_textFieldUbicacion.gridy = 1;
		panel.add(textFieldUbicacion, gbc_textFieldUbicacion);

		JLabel labelPorcentajeExpensas = new JLabel("Porcentaje Expensas:");
		GridBagConstraints gbc_labelPorcentajeExpensas = new GridBagConstraints();
		gbc_labelPorcentajeExpensas.anchor = GridBagConstraints.WEST;
		gbc_labelPorcentajeExpensas.insets = new Insets(0, 0, 0, 5);
		gbc_labelPorcentajeExpensas.gridx = 0;
		gbc_labelPorcentajeExpensas.gridy = 2;
		panel.add(labelPorcentajeExpensas, gbc_labelPorcentajeExpensas);

		textFieldPorcentajeExpensas = new JTextField(String.valueOf(cochera.getPorcentajeExpensas()));
		textFieldPorcentajeExpensas.setEnabled(false);
		textFieldPorcentajeExpensas.setEditable(false);
		textFieldPorcentajeExpensas.setColumns(10);
		GridBagConstraints gbc_textFieldPorcentajeExpensas = new GridBagConstraints();
		gbc_textFieldPorcentajeExpensas.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPorcentajeExpensas.gridx = 1;
		gbc_textFieldPorcentajeExpensas.gridy = 2;
		panel.add(textFieldPorcentajeExpensas, gbc_textFieldPorcentajeExpensas);

		buttonVolver = new JButton("Volver");
		buttonVolver.setIcon(new ImageIcon(VerCochera.class.getResource("/image/izq.png")));
		buttonVolver.setBounds(201, 118, 160, 56);
		contentPane.add(buttonVolver);
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

