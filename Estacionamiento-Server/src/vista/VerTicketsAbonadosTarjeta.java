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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;

import modelo.Ticket;
import controlador.Controlador;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JFormattedTextField;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JTextField;
import java.awt.Color;



public class VerTicketsAbonadosTarjeta extends JDialog implements ActionListener, KeyListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;

	private JButton buscarButton;
	private JButton buttonVolver;
	private JButton buttonExportarExcel;
	private JLabel lblFechaDesde;
	private JLabel lblFechaHasta;
	private JXDatePicker fechaDesde;
	private JXDatePicker fechaHasta;

	ArrayList<Ticket> ticketsTarjeta;
	private JScrollPane scrollPane_1;
	private String[] colName;
	private double montoTotalCobrado = 0;
	private JLabel label;
	private JTextField textFieldMontoTotalCobrado;

	public VerTicketsAbonadosTarjeta() {
		initGUI();
	}



	public void initGUI(){

		Controlador.getInstancia().actualizarClientes();

		setTitle("Vista Tickets Abonados con Tarjeta");
		setResizable(true);
		setBounds(100, 100, 666, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 80, 150, 20, 80, 150, 116, 0 };
		gbl_contentPane.rowHeights = new int[] { 32, 0, 31, 0, 0, 0, 20, 11, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		buscarButton = new JButton("Buscar");
		buscarButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		buscarButton.addActionListener(this);

		lblFechaDesde = new JLabel("Fecha Desde:");
		GridBagConstraints gbc_lblFechaDesde = new GridBagConstraints();
		gbc_lblFechaDesde.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDesde.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDesde.gridx = 0;
		gbc_lblFechaDesde.gridy = 0;
		contentPane.add(lblFechaDesde, gbc_lblFechaDesde);


		fechaDesde = new JXDatePicker();
		fechaDesde.setDate(Calendar.getInstance().getTime());
		fechaDesde.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		GridBagConstraints gbc_fechaDesde = new GridBagConstraints();
		gbc_fechaDesde.fill = GridBagConstraints.BOTH;
		gbc_fechaDesde.insets = new Insets(0, 0, 5, 5);
		gbc_fechaDesde.gridx = 1;
		gbc_fechaDesde.gridy = 0;
		contentPane.add(fechaDesde, gbc_fechaDesde);

		lblFechaHasta = new JLabel("Fecha Hasta:");
		GridBagConstraints gbc_lblFechaHasta = new GridBagConstraints();
		gbc_lblFechaHasta.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaHasta.anchor = GridBagConstraints.WEST;
		gbc_lblFechaHasta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaHasta.gridx = 3;
		gbc_lblFechaHasta.gridy = 0;
		contentPane.add(lblFechaHasta, gbc_lblFechaHasta);

		fechaHasta = new JXDatePicker();
		fechaHasta.setDate(Calendar.getInstance().getTime());
		fechaHasta.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		GridBagConstraints gbc_fechaHasta = new GridBagConstraints();
		gbc_fechaHasta.fill = GridBagConstraints.BOTH;
		gbc_fechaHasta.insets = new Insets(0, 0, 5, 5);
		gbc_fechaHasta.gridx = 4;
		gbc_fechaHasta.gridy = 0;
		contentPane.add(fechaHasta, gbc_fechaHasta);


		GridBagConstraints gbc_buscarButton = new GridBagConstraints();
		gbc_buscarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarButton.insets = new Insets(0, 0, 5, 0);
		gbc_buscarButton.gridx = 5;
		gbc_buscarButton.gridy = 0;
		contentPane.add(buscarButton, gbc_buscarButton);
		buscarButton.setIcon(new ImageIcon(BuscadorCliente.class
				.getResource("/image/search.png")));

		colName = new String[] { "Fecha" ,"Numero Ticket", "Monto" };

		model = new DefaultTableModel(colName,0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 6;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);

		label = new JLabel("Monto Total Cobrado:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		contentPane.add(label, gbc_label);

		textFieldMontoTotalCobrado = new JTextField();
		textFieldMontoTotalCobrado.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMontoTotalCobrado.setEnabled(false);
		textFieldMontoTotalCobrado.setEditable(false);
		textFieldMontoTotalCobrado.setDisabledTextColor(Color.RED);
		textFieldMontoTotalCobrado.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		contentPane.add(textFieldMontoTotalCobrado, gbc_textField);



		buttonExportarExcel = new JButton("Exportar a Excel");
		buttonExportarExcel.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonExportarExcel.setIcon(new ImageIcon(VerTicketsAbonadosTarjeta.class.getResource("/image/report.png")));
		GridBagConstraints gbc_buttonExportarExcel = new GridBagConstraints();
		gbc_buttonExportarExcel.fill = GridBagConstraints.VERTICAL;
		gbc_buttonExportarExcel.gridheight = 2;
		gbc_buttonExportarExcel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonExportarExcel.gridwidth = 2;
		gbc_buttonExportarExcel.gridx = 1;
		gbc_buttonExportarExcel.gridy = 5;
		contentPane.add(buttonExportarExcel, gbc_buttonExportarExcel);
		buttonExportarExcel.addActionListener(this);

		buttonVolver = new JButton("Volver");
		buttonVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonVolver.setIcon(new ImageIcon(VerTicketsAbonadosTarjeta.class.getResource("/image/izq.png")));
		GridBagConstraints gbc_buttonVolver = new GridBagConstraints();
		gbc_buttonVolver.insets = new Insets(0, 0, 5, 5);
		gbc_buttonVolver.gridheight = 2;
		gbc_buttonVolver.fill = GridBagConstraints.BOTH;
		gbc_buttonVolver.gridx = 4;
		gbc_buttonVolver.gridy = 5;
		contentPane.add(buttonVolver, gbc_buttonVolver);
		buttonVolver.addActionListener(this);


		this.setLocationRelativeTo(null);
		//Hace que esperes a que se cierre para seguir con lo demas
		this.setModal(true); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.buscarButton) {
			if(fechaDesde.getDate().compareTo(fechaHasta.getDate())<=0)
			{
				ticketsTarjeta=Controlador.getInstancia().getTicketsCobradosTarjeta(fechaDesde.getDate(), fechaHasta.getDate());
				if(!ticketsTarjeta.isEmpty())
				{
					cargarTabla();

				}
				else
				{
					JOptionPane.showMessageDialog(null, "No se encontraron Tickets cobrados con Tarjeta para los días seleccionados.","Vista Tickets Cobrados con Tarjeta",  JOptionPane.INFORMATION_MESSAGE);
					//no se encontraron tickets cobrados con tarjeta.
				}
			}
		}
		if (e.getSource() == this.buttonExportarExcel) 
		{
			if(!ticketsTarjeta.isEmpty())
			{
				double codigoReturn=-1;
				codigoReturn=Controlador.getInstancia().exportarTicketsAbonadosTarjeta(ticketsTarjeta);
				JOptionPane.showMessageDialog(null, "Se exportó correctamente el litado de Tickets abonado con tarjeta", "Tickets Abonados con Tarjeta",  JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		}
		if (e.getSource() == this.buttonVolver) {
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

	}

	public void cargarTabla()
	{

		for(Ticket ticketActual : ticketsTarjeta)
		{
			Object[] ticket = { ticketActual.getFechaSalida(), ticketActual.getIdTicket(), ticketActual.getMontoCobrado() };
			montoTotalCobrado=montoTotalCobrado+ticketActual.getMontoCobrado();
			model.addRow(ticket);
		}
		model = new DefaultTableModel(colName,model.getRowCount());
		textFieldMontoTotalCobrado.setText(Double.toString(Math.round(montoTotalCobrado)));
	}
}

