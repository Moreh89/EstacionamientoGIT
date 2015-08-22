package vista;

import java.awt.EventQueue;
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
import javax.swing.JSeparator;
import controlador.Controlador;


public class AgregarCochera extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCostoMensual;
	private JTextField textFieldPorcentajeExpensas;
	private JButton buttonCancelar;
	private JTextField textFieldUbicacion;
	private JButton buttonAgregarCochera;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPiso;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCochera frame = new AgregarCochera(null);
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
	public AgregarCochera(AltaCliente altaCliente) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initGUI();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI(){
		setTitle("Alta Cochera");
		setResizable(false);
		setBounds(100, 100, 336, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 306, 116);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{152, 148, 0};
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
		comboBoxPiso.setModel(new DefaultComboBoxModel(new String[] {"1ro", "2do", "3ro", "4to", "5to", "6to", "7mo"}));
		GridBagConstraints gbc_comboBoxPiso = new GridBagConstraints();
		gbc_comboBoxPiso.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPiso.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxPiso.gridx = 1;
		gbc_comboBoxPiso.gridy = 0;
		panel.add(comboBoxPiso, gbc_comboBoxPiso);
		
		JLabel labelCostoMensual = new JLabel("Costo Mensual:");
		GridBagConstraints gbc_labelCostoMensual = new GridBagConstraints();
		gbc_labelCostoMensual.anchor = GridBagConstraints.WEST;
		gbc_labelCostoMensual.insets = new Insets(0, 0, 5, 5);
		gbc_labelCostoMensual.gridx = 0;
		gbc_labelCostoMensual.gridy = 1;
		panel.add(labelCostoMensual, gbc_labelCostoMensual);
		
		textCostoMensual = new JTextField();
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
		
		textFieldUbicacion = new JTextField();
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
		
		textFieldPorcentajeExpensas = new JTextField();
		textFieldPorcentajeExpensas.setColumns(10);
		GridBagConstraints gbc_textFieldPorcentajeExpensas = new GridBagConstraints();
		gbc_textFieldPorcentajeExpensas.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPorcentajeExpensas.gridx = 1;
		gbc_textFieldPorcentajeExpensas.gridy = 3;
		panel.add(textFieldPorcentajeExpensas, gbc_textFieldPorcentajeExpensas);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/cancel.png")));
		buttonCancelar.setBounds(6, 146, 148, 56);
		contentPane.add(buttonCancelar);
		buttonCancelar.addActionListener(this);
		
		buttonAgregarCochera = new JButton("Agregar Cochera");
		buttonAgregarCochera.setIcon(new ImageIcon(BuscadorCliente.class.getResource("/image/ok.png")));
		buttonAgregarCochera.setBounds(164, 146, 148, 56);
		contentPane.add(buttonAgregarCochera);
		buttonAgregarCochera.addActionListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(128, 133, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 133, 306, 2);
		contentPane.add(separator_1);
		
		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == buttonCancelar){
			dispose();
		}
		if(event.getSource()==buttonAgregarCochera)
		{
			Controlador.getInstancia().agregarCochera(textFieldUbicacion.getText(), Double.parseDouble(textCostoMensual.getText()), Float.parseFloat(textFieldPorcentajeExpensas.getText()),comboBoxPiso.getSelectedItem().toString());	
			dispose();
		}
		
	}
}

