package vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

import org.jdesktop.swingx.JXDatePicker;

import modelo.MovimientoCC;
import controlador.Controlador;

import java.awt.Panel;
import java.awt.Font;



@SuppressWarnings("rawtypes")
public class VerMovimientosCC extends JDialog implements ActionListener, KeyListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private DefaultTableModel model;
	@SuppressWarnings("unused")
	private CobroExtraordinario cobroExtraordinario;


	private JButton buscarButton;
	private JPanel panelClientes;
	private JScrollPane scrollPaneClientes;
	private JList listMovimientos;
	private DefaultListModel<MovimientoCC> listModel;
	private JPanel panelAtributos;
	private JButton btnVolver;
	private JXDatePicker fechaDesde;
	private JLabel lblFechaHasta;
	private JXDatePicker fechaHasta;
	private JLabel lblFecha;
	private JLabel lblDescripcin;
	private JLabel lblMonto;
	private JLabel lblUsuario;
	private JTextField textFieldFecha;
	private JTextField textFieldDescripcion;
	private JTextField textFieldMonto;
	private JTextField textFieldUsuario;
	private JTextField textFieldResumenCuenta;


	public VerMovimientosCC() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initGUI();
	}



	@SuppressWarnings("unchecked")
	public void initGUI(){
		setTitle("Movimientos Cuenta Corriente");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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


		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 585, 4);
		contentPane.add(separator);

		panelAtributos = new JPanel();
		panelAtributos.setBounds(10, 314, 585, 178);
		contentPane.add(panelAtributos);
		GridBagLayout gbl_panelAtributos = new GridBagLayout();
		gbl_panelAtributos.columnWidths = new int[]{0, 0, 0};
		gbl_panelAtributos.rowHeights = new int[]{30, 30, 30, 30, 30, 0};
		gbl_panelAtributos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAtributos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAtributos.setLayout(gbl_panelAtributos);

		JLabel lblResumenCuenta = new JLabel("Resumen Cuenta:");
		GridBagConstraints gbc_lblResumenCuenta = new GridBagConstraints();
		gbc_lblResumenCuenta.anchor = GridBagConstraints.EAST;
		gbc_lblResumenCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblResumenCuenta.gridx = 0;
		gbc_lblResumenCuenta.gridy = 0;
		panelAtributos.add(lblResumenCuenta, gbc_lblResumenCuenta);

		textFieldResumenCuenta = new JTextField();
		textFieldResumenCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldResumenCuenta.setEnabled(false);
		textFieldResumenCuenta.setEditable(false);
		textFieldResumenCuenta.setForeground(Color.red);
		GridBagConstraints gbc_textFieldResumenCuenta = new GridBagConstraints();
		gbc_textFieldResumenCuenta.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldResumenCuenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldResumenCuenta.gridx = 1;
		gbc_textFieldResumenCuenta.gridy = 0;
		panelAtributos.add(textFieldResumenCuenta, gbc_textFieldResumenCuenta);
		textFieldResumenCuenta.setColumns(10);

		lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 1;
		panelAtributos.add(lblFecha, gbc_lblFecha);

		textFieldFecha = new JTextField();
		textFieldFecha.setEnabled(false);
		textFieldFecha.setEditable(false);
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFecha.gridx = 1;
		gbc_textFieldFecha.gridy = 1;
		panelAtributos.add(textFieldFecha, gbc_textFieldFecha);
		textFieldFecha.setColumns(10);

		lblDescripcin = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 2;
		panelAtributos.add(lblDescripcin, gbc_lblDescripcin);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEnabled(false);
		textFieldDescripcion.setEditable(false);
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDescripcion.gridx = 1;
		gbc_textFieldDescripcion.gridy = 2;
		panelAtributos.add(textFieldDescripcion, gbc_textFieldDescripcion);
		textFieldDescripcion.setColumns(10);

		lblMonto = new JLabel("Monto:");
		GridBagConstraints gbc_lblMonto = new GridBagConstraints();
		gbc_lblMonto.anchor = GridBagConstraints.EAST;
		gbc_lblMonto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonto.gridx = 0;
		gbc_lblMonto.gridy = 3;
		panelAtributos.add(lblMonto, gbc_lblMonto);

		textFieldMonto = new JTextField();
		textFieldMonto.setEnabled(false);
		textFieldMonto.setEditable(false);
		GridBagConstraints gbc_textFieldMonto = new GridBagConstraints();
		gbc_textFieldMonto.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMonto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMonto.gridx = 1;
		gbc_textFieldMonto.gridy = 3;
		panelAtributos.add(textFieldMonto, gbc_textFieldMonto);
		textFieldMonto.setColumns(10);

		lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 4;
		panelAtributos.add(lblUsuario, gbc_lblUsuario);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setEditable(false);
		textFieldUsuario.setEnabled(false);
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.gridx = 1;
		gbc_textFieldUsuario.gridy = 4;
		panelAtributos.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);

		panelClientes = new JPanel();
		panelClientes.setBounds(10, 81, 585, 190);
		contentPane.add(panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{240, 0};
		gbl_panelClientes.rowHeights = new int[]{125, 0};
		gbl_panelClientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelClientes.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelClientes.setLayout(gbl_panelClientes);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneClientes = new GridBagConstraints();
		gbc_scrollPaneClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClientes.gridx = 0;
		gbc_scrollPaneClientes.gridy = 0;
		panelClientes.add(scrollPaneClientes, gbc_scrollPaneClientes);

		listModel = new DefaultListModel<modelo.MovimientoCC>();
		listMovimientos = new JList(listModel);
		listMovimientos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPaneClientes.setViewportView(listMovimientos);


		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(VerMovimientosCC.class.getResource("/image/izq.png")));
		btnVolver.setBounds(436, 510, 159, 50);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);

		Panel panel = new Panel();
		panel.setBounds(10, 0, 585, 46);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 80, 100, 80, 155, 0};
		gbl_panel.rowHeights = new int[]{40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_fechaDesde_1_1 = new GridBagConstraints();
		gbc_fechaDesde_1_1.anchor = GridBagConstraints.WEST;
		gbc_fechaDesde_1_1.gridx = 2;
		gbc_fechaDesde_1_1.gridy = 1;
		gbc_fechaDesde_1_1.fill = GridBagConstraints.BOTH;
		gbc_fechaDesde_1_1.insets = new Insets(0, 0, 0, 5);

		JLabel lblFechaDesde = new JLabel("Fecha Desde:");
		GridBagConstraints gbc_lblFechaDesde = new GridBagConstraints();
		gbc_lblFechaDesde.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDesde.gridx = 0;
		gbc_lblFechaDesde.gridy = 0;
		panel.add(lblFechaDesde, gbc_lblFechaDesde);

		fechaDesde = new JXDatePicker();
		GridBagConstraints gbc_fechaDesde = new GridBagConstraints();
		gbc_fechaDesde.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaDesde.insets = new Insets(0, 0, 0, 5);
		gbc_fechaDesde.gridx = 1;
		gbc_fechaDesde.gridy = 0;
		panel.add(fechaDesde, gbc_fechaDesde);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.DAY_OF_MONTH,1);
//		fechaDesde.setDate(Calendar.getInstance().getTime());
		fechaDesde.setDate(calendar.getTime());
		fechaDesde.setFormats(new SimpleDateFormat("dd-MM-yyyy"));

		lblFechaHasta = new JLabel("Fecha Hasta:");
		GridBagConstraints gbc_lblFechaHasta = new GridBagConstraints();
		gbc_lblFechaHasta.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaHasta.gridx = 2;
		gbc_lblFechaHasta.gridy = 0;
		panel.add(lblFechaHasta, gbc_lblFechaHasta);


		fechaHasta = new JXDatePicker();
		GridBagConstraints gbc_fechaHasta = new GridBagConstraints();
		gbc_fechaHasta.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechaHasta.insets = new Insets(0, 0, 0, 5);
		gbc_fechaHasta.gridx = 3;
		gbc_fechaHasta.gridy = 0;
		panel.add(fechaHasta, gbc_fechaHasta);
		fechaHasta.setDate(Calendar.getInstance().getTime());
		fechaHasta.setFormats(new SimpleDateFormat("dd-MM-yyyy"));


		buscarButton = new JButton("Buscar");
		GridBagConstraints gbc_buscarButton = new GridBagConstraints();
		gbc_buscarButton.fill = GridBagConstraints.VERTICAL;
		gbc_buscarButton.gridx = 4;
		gbc_buscarButton.gridy = 0;
		panel.add(buscarButton, gbc_buscarButton);
		buscarButton.addActionListener(this);
		buscarButton.setIcon(new ImageIcon(VerMovimientosCC.class.getResource("/image/search.png")));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 297, 585, 4);
		contentPane.add(separator_1);
		listMovimientos.addListSelectionListener(this);

		this.setLocationRelativeTo(null);
		setModal(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.buscarButton){
			listModel.clear();
			
			if(fechaHasta.getDate().compareTo(fechaDesde.getDate())>=0)
			{
				//Fecha hasta mayor a Desde
				ArrayList<MovimientoCC> movimientos= Controlador.getInstancia().getMovimientosCliente(fechaDesde.getDate(), fechaHasta.getDate());
				for(MovimientoCC movimientoAct : movimientos)
				{
					listModel.addElement(movimientoAct);
				}
				double estadoCrediticio = 0;
				estadoCrediticio=Controlador.getInstancia().getResumenCuentaMovimientosClienteActual();
				textFieldResumenCuenta.setText(String.format("%.0f", estadoCrediticio));
				if(estadoCrediticio<0)
				{
					textFieldResumenCuenta.setDisabledTextColor(Color.RED);

				}
				else
				{
					textFieldResumenCuenta.setDisabledTextColor(Color.GREEN);

				}
			}
		}
		if(e.getSource()==btnVolver)
		{
			Controlador.getInstancia().setClienteActual(null);
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listMovimientos && this.listMovimientos.getSelectedValue() != null){
			modelo.MovimientoCC movimientoSeleccionado = (MovimientoCC) this.listMovimientos.getSelectedValue();
			this.textFieldDescripcion.setText(movimientoSeleccionado.getDescripcion());
			this.textFieldFecha.setText(movimientoSeleccionado.getFecha().toString());
			this.textFieldMonto.setText(String.format("%.0f",movimientoSeleccionado.getMontoCobrado()));
			this.textFieldUsuario.setText(movimientoSeleccionado.getUsuario().getUserName());
		}
	}
}

