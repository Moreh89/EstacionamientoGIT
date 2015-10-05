package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPiso;
	private Cochera cochera;

	
	public VerCochera(Cochera cochera) {
		setAlwaysOnTop(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.cochera=cochera;
		initGUI();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI(){
		setTitle("Ver Cochera");
		setResizable(false);
		setBounds(100, 100, 377, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 353, 116);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{181, 170, 0};
		gbl_panel.rowHeights = new int[] {28, 28, 28, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel labelPiso = new JLabel("Piso:");
		GridBagConstraints gbc_labelPiso = new GridBagConstraints();
		gbc_labelPiso.anchor = GridBagConstraints.WEST;
		gbc_labelPiso.insets = new Insets(0, 0, 5, 5);
		gbc_labelPiso.gridx = 0;
		gbc_labelPiso.gridy = 0;
		panel.add(labelPiso, gbc_labelPiso);

		comboBoxPiso = new JComboBox();
		comboBoxPiso.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		GridBagConstraints gbc_comboBoxPiso = new GridBagConstraints();
		gbc_comboBoxPiso.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPiso.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxPiso.gridx = 1;
		gbc_comboBoxPiso.gridy = 0;
		panel.add(comboBoxPiso, gbc_comboBoxPiso);
		//TODO PISO no se esta guardando, habria que sacar este combobox

		JLabel labelCostoMensual = new JLabel("Costo Mensual:");
		GridBagConstraints gbc_labelCostoMensual = new GridBagConstraints();
		gbc_labelCostoMensual.anchor = GridBagConstraints.WEST;
		gbc_labelCostoMensual.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoMensual.gridx = 0;
		gbc_labelCostoMensual.gridy = 1;
		panel.add(labelCostoMensual, gbc_labelCostoMensual);

		textCostoMensual = new JTextField(String.valueOf(cochera.getCostoCochera()));
		textCostoMensual.setEnabled(false);
		textCostoMensual.setEditable(false);
		textCostoMensual.setColumns(10);
		GridBagConstraints gbc_textCostoMensual = new GridBagConstraints();
		gbc_textCostoMensual.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCostoMensual.insets = new Insets(0, 0, 5, 0);
		gbc_textCostoMensual.gridx = 1;
		gbc_textCostoMensual.gridy = 1;
		panel.add(textCostoMensual, gbc_textCostoMensual);

		JLabel labelUbicacion = new JLabel("Ubicacion:");
		GridBagConstraints gbc_labelUbicacion = new GridBagConstraints();
		gbc_labelUbicacion.anchor = GridBagConstraints.WEST;
		gbc_labelUbicacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelUbicacion.gridx = 0;
		gbc_labelUbicacion.gridy = 2;
		panel.add(labelUbicacion, gbc_labelUbicacion);

		textFieldUbicacion = new JTextField(cochera.getUbicacion());
		textFieldUbicacion.setEnabled(false);
		textFieldUbicacion.setEditable(false);
		textFieldUbicacion.setColumns(10);
		GridBagConstraints gbc_textFieldUbicacion = new GridBagConstraints();
		gbc_textFieldUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUbicacion.gridx = 1;
		gbc_textFieldUbicacion.gridy = 2;
		panel.add(textFieldUbicacion, gbc_textFieldUbicacion);

		JLabel labelPorcentajeExpensas = new JLabel("Porcentaje Expensas:");
		GridBagConstraints gbc_labelPorcentajeExpensas = new GridBagConstraints();
		gbc_labelPorcentajeExpensas.anchor = GridBagConstraints.WEST;
		gbc_labelPorcentajeExpensas.insets = new Insets(0, 0, 0, 5);
		gbc_labelPorcentajeExpensas.gridx = 0;
		gbc_labelPorcentajeExpensas.gridy = 3;
		panel.add(labelPorcentajeExpensas, gbc_labelPorcentajeExpensas);

		textFieldPorcentajeExpensas = new JTextField(String.valueOf(cochera.getPorcentajeExpensas()));
		textFieldPorcentajeExpensas.setEnabled(false);
		textFieldPorcentajeExpensas.setEditable(false);
		textFieldPorcentajeExpensas.setColumns(10);
		GridBagConstraints gbc_textFieldPorcentajeExpensas = new GridBagConstraints();
		gbc_textFieldPorcentajeExpensas.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPorcentajeExpensas.gridx = 1;
		gbc_textFieldPorcentajeExpensas.gridy = 3;
		panel.add(textFieldPorcentajeExpensas, gbc_textFieldPorcentajeExpensas);

		buttonVolver = new JButton("Volver");
		buttonVolver.setIcon(new ImageIcon(VerCochera.class.getResource("/image/izq.png")));
		buttonVolver.setBounds(199, 146, 160, 56);
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

