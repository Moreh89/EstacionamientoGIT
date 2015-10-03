package vista;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.Cliente;

import java.awt.Font;
import java.awt.Color;



@SuppressWarnings("rawtypes")
public class VerDeudores extends JDialog implements ActionListener, KeyListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private DefaultTableModel model;
	@SuppressWarnings("unused")
	private CobroExtraordinario cobroExtraordinario;
	private JPanel panelClientes;
	private JScrollPane scrollPaneClientes;
	private JList listDeudores;
	private DefaultListModel<modelo.Cliente> listModel;
	private JButton btnVolver;
	private JButton btnExportarAExcel;
	private JLabel lblMontoAdeudado;
	private JTextField textFieldMontoAdeudado;
	private JLabel lblTipoDeCliente;
	private JTextField textFieldTipoCliente;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerDeudores frame = new VerDeudores();
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

	public VerDeudores() {
		initGUI();
	}



	@SuppressWarnings("unchecked")
	public void initGUI(){
		setTitle("Listado de Clientes Deudores");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		model = new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{144, 239, 120, 0};
		gbl_contentPane.rowHeights = new int[]{400, 0, 0, 10, 35, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);


		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(VerDeudores.class.getResource("/image/izq.png")));
		btnVolver.addActionListener(this);

		panelClientes = new JPanel();
		GridBagConstraints gbc_panelClientes = new GridBagConstraints();
		gbc_panelClientes.anchor = GridBagConstraints.NORTH;
		gbc_panelClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelClientes.insets = new Insets(0, 0, 5, 0);
		gbc_panelClientes.gridwidth = 3;
		gbc_panelClientes.gridx = 0;
		gbc_panelClientes.gridy = 0;
		contentPane.add(panelClientes, gbc_panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{240, 0};
		gbl_panelClientes.rowHeights = new int[]{400, 0};
		gbl_panelClientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelClientes.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelClientes.setLayout(gbl_panelClientes);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneClientes = new GridBagConstraints();
		gbc_scrollPaneClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClientes.gridx = 0;
		gbc_scrollPaneClientes.gridy = 0;
		panelClientes.add(scrollPaneClientes, gbc_scrollPaneClientes);


		listModel = new DefaultListModel<modelo.Cliente>();
		for (modelo.Cliente clienteTemp : Controlador.getInstancia().getClientesConDeuda()) {
			listModel.addElement(clienteTemp);
		} 
		listDeudores = new JList(listModel);
		listDeudores.setEnabled(false);
		listDeudores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPaneClientes.setViewportView(listDeudores);
		listDeudores.addListSelectionListener(this);
		
		lblMontoAdeudado = new JLabel("Monto Adeudado:");
		GridBagConstraints gbc_lblMontoAdeudado = new GridBagConstraints();
		gbc_lblMontoAdeudado.anchor = GridBagConstraints.WEST;
		gbc_lblMontoAdeudado.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontoAdeudado.gridx = 0;
		gbc_lblMontoAdeudado.gridy = 1;
		contentPane.add(lblMontoAdeudado, gbc_lblMontoAdeudado);

		textFieldMontoAdeudado = new JTextField();
		textFieldMontoAdeudado.setEnabled(false);
		textFieldMontoAdeudado.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldMontoAdeudado.setEditable(false);
		GridBagConstraints gbc_textFieldMontoAdeudado = new GridBagConstraints();
		gbc_textFieldMontoAdeudado.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMontoAdeudado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMontoAdeudado.gridx = 1;
		gbc_textFieldMontoAdeudado.gridy = 1;
		contentPane.add(textFieldMontoAdeudado, gbc_textFieldMontoAdeudado);
		textFieldMontoAdeudado.setColumns(10);
		textFieldMontoAdeudado.setDisabledTextColor(Color.RED);
		textFieldMontoAdeudado.setFocusable(false);

		
		lblTipoDeCliente = new JLabel("Tipo de Cliente:");
		GridBagConstraints gbc_lblTipoDeCliente = new GridBagConstraints();
		gbc_lblTipoDeCliente.anchor = GridBagConstraints.WEST;
		gbc_lblTipoDeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeCliente.gridx = 0;
		gbc_lblTipoDeCliente.gridy = 2;
		contentPane.add(lblTipoDeCliente, gbc_lblTipoDeCliente);
		
		textFieldTipoCliente = new JTextField();
		textFieldTipoCliente.setEnabled(false);
		textFieldTipoCliente.setEditable(false);
		GridBagConstraints gbc_textFieldTipoCliente = new GridBagConstraints();
		gbc_textFieldTipoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTipoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTipoCliente.gridx = 1;
		gbc_textFieldTipoCliente.gridy = 2;
		contentPane.add(textFieldTipoCliente, gbc_textFieldTipoCliente);
		textFieldTipoCliente.setColumns(10);

		btnExportarAExcel = new JButton("Exportar a Excel");
		btnExportarAExcel.setIcon(new ImageIcon(VerDeudores.class.getResource("/image/guardar.png")));
		GridBagConstraints gbc_btnExportarAExcel_1 = new GridBagConstraints();
		gbc_btnExportarAExcel_1.fill = GridBagConstraints.BOTH;
		gbc_btnExportarAExcel_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnExportarAExcel_1.gridx = 0;
		gbc_btnExportarAExcel_1.gridy = 4;
		contentPane.add(btnExportarAExcel, gbc_btnExportarAExcel_1);
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.fill = GridBagConstraints.BOTH;
		gbc_btnVolver.gridx = 2;
		gbc_btnVolver.gridy = 4;
		contentPane.add(btnVolver, gbc_btnVolver);
		btnExportarAExcel.addActionListener(this);

		GridBagConstraints gbc_fechaDesde_1_1 = new GridBagConstraints();
		gbc_fechaDesde_1_1.anchor = GridBagConstraints.WEST;
		gbc_fechaDesde_1_1.gridx = 2;
		gbc_fechaDesde_1_1.gridy = 1;
		gbc_fechaDesde_1_1.fill = GridBagConstraints.BOTH;
		gbc_fechaDesde_1_1.insets = new Insets(0, 0, 0, 5);

		this.setLocationRelativeTo(null);
		setModal(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
		}

		if(e.getSource()==btnExportarAExcel)
		{
			long codigoReturn=-1;
			codigoReturn=Controlador.getInstancia().exportarDeudoresExcel();
			if(codigoReturn==1)
			{
				JOptionPane.showMessageDialog(null, "El listado de Deudores fue exportado exitosamente","Vista Deudores",  JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se pudo exportar el listado de Deudores. Intente nuevamente","Vista Deudores",  JOptionPane.INFORMATION_MESSAGE);

			}
			dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listDeudores){
			modelo.Cliente clienteSeleccionado = (Cliente) this.listDeudores.getSelectedValue();
//			textFieldMontoAdeudado.setText(Double.toString(Controlador.getInstancia().getClienteEstadoCrediticio(clienteSeleccionado.getIdCliente())));
			textFieldTipoCliente.setText(clienteSeleccionado.getTipoCliente().toString());
			textFieldMontoAdeudado.setText(Double.toString(clienteSeleccionado.getEstadoCrediticio()));

		}		
	}
}

