package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import modelo.LiquidacionAlquileres;
import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

public class AnularLiquidacionAlquileres extends JDialog implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton anularButton;
	private JButton cancelarButton;
	private DefaultListModel<LiquidacionAlquileres> listModel;
	private JList<LiquidacionAlquileres> listLiquidaciones;
	private JLabel lblFechaEmisionLiquidacion;
	private JTextField textFieldFechaEmisionLiquidacion;
	private LiquidacionAlquileres liquidacionSeleccionado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionColor dialog = new GestionColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AnularLiquidacionAlquileres() {
		setResizable(false);
		setTitle("Anular Liquidacion de Alquileres");
		setBounds(100, 100, 403, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{50, 150, 150, 50, 0};
		gbl_contentPanel.rowHeights = new int[]{234, 30, 35, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);

		listModel = new DefaultListModel<modelo.LiquidacionAlquileres>();
		for (modelo.LiquidacionAlquileres liquidacionTemp : Controlador.getInstancia().getLiquidacionesAlquileresRecientes()) {
			listModel.addElement(liquidacionTemp);
		} 		
		listLiquidaciones= new JList(listModel);
		listLiquidaciones.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listLiquidaciones);
		listLiquidaciones.addListSelectionListener(this);

		lblFechaEmisionLiquidacion = new JLabel("Fecha Emision Liquidacion:");
		GridBagConstraints gbc_lblFechaEmisionLiquidacion = new GridBagConstraints();
		gbc_lblFechaEmisionLiquidacion.anchor = GridBagConstraints.WEST;
		gbc_lblFechaEmisionLiquidacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaEmisionLiquidacion.gridx = 1;
		gbc_lblFechaEmisionLiquidacion.gridy = 1;
		contentPanel.add(lblFechaEmisionLiquidacion, gbc_lblFechaEmisionLiquidacion);

		textFieldFechaEmisionLiquidacion = new JTextField();
		textFieldFechaEmisionLiquidacion.setEnabled(false);
		textFieldFechaEmisionLiquidacion.setEditable(false);
		GridBagConstraints gbc_textFieldFechaEmisionLiquidacion = new GridBagConstraints();
		gbc_textFieldFechaEmisionLiquidacion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFechaEmisionLiquidacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaEmisionLiquidacion.gridx = 2;
		gbc_textFieldFechaEmisionLiquidacion.gridy = 1;
		contentPanel.add(textFieldFechaEmisionLiquidacion, gbc_textFieldFechaEmisionLiquidacion);
		textFieldFechaEmisionLiquidacion.setColumns(10);
		//						listLiquidaciones.addListSelectionListener(this);

		anularButton = new JButton("Anular Liquidacion");
		anularButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_anularButton = new GridBagConstraints();
		gbc_anularButton.fill = GridBagConstraints.BOTH;
		gbc_anularButton.insets = new Insets(0, 0, 5, 5);
		gbc_anularButton.gridx = 1;
		gbc_anularButton.gridy = 2;
		contentPanel.add(anularButton, gbc_anularButton);
		anularButton.addActionListener(this);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelarButton.fill = GridBagConstraints.BOTH;
		gbc_cancelarButton.gridx = 2;
		gbc_cancelarButton.gridy = 2;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);



		this.setLocationRelativeTo(null);
		setModal(true);


	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==anularButton)
		{
			Controlador.getInstancia().anularLiquidacionAlquileres((LiquidacionAlquileres) listLiquidaciones.getSelectedValue());
			dispose();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listLiquidaciones){
			liquidacionSeleccionado = (LiquidacionAlquileres) this.listLiquidaciones.getSelectedValue();
			textFieldFechaEmisionLiquidacion.setText(new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(liquidacionSeleccionado.getFechaEmision()));
		}		
	}
}
