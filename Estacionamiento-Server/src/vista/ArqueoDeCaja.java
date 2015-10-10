package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import modelo.Usuario;

import org.jdesktop.swingx.JXDatePicker;

import controlador.Controlador;

//import reportes.ReporteEjemplo;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ArqueoDeCaja extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JXDatePicker fechaHasta;
	private JXDatePicker fechaDesde;
	private JButton generarButton;
	private JButton cancelarButton;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ArqueoDeCaja dialog = new ArqueoDeCaja();
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
	public ArqueoDeCaja() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArqueoDeCaja.class.getResource("/image/printer.png")));
		setTitle("Arqueo de Caja");
		setBounds(100, 100, 290, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{111, 23, 116, 0};
		gbl_contentPanel.rowHeights = new int[]{32, 40, 40, 32, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel());
		if(Controlador.getInstancia().getUsuarioActual().getPermisos() == Usuario.PERMISOS.ADMIN){
			for (Usuario usuarioTemp : Controlador.getInstancia().getUsuarios()) {
				comboBox.addItem(usuarioTemp);
			}
		}else{
			comboBox.addItem(Controlador.getInstancia().getUsuarioActual());
		}

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		contentPanel.add(comboBox, gbc_comboBox);
		
		JLabel lblFechaaDesde = new JLabel("Fecha Desde:");
		lblFechaaDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFechaaDesde = new GridBagConstraints();
		gbc_lblFechaaDesde.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaaDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaaDesde.gridx = 0;
		gbc_lblFechaaDesde.gridy = 1;
		contentPanel.add(lblFechaaDesde, gbc_lblFechaaDesde);
		
		fechaDesde = new JXDatePicker();
		fechaDesde.setDate(Calendar.getInstance().getTime());
		fechaDesde.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		GridBagConstraints gbc_fechaDesde = new GridBagConstraints();
		gbc_fechaDesde.fill = GridBagConstraints.BOTH;
		gbc_fechaDesde.insets = new Insets(0, 0, 5, 0);
		gbc_fechaDesde.gridwidth = 2;
		gbc_fechaDesde.gridx = 1;
		gbc_fechaDesde.gridy = 1;
		contentPanel.add(fechaDesde, gbc_fechaDesde);
		
		JLabel lblFechaHasta = new JLabel("Fecha Hasta:");
		lblFechaHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFechaHasta = new GridBagConstraints();
		gbc_lblFechaHasta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaHasta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaHasta.gridx = 0;
		gbc_lblFechaHasta.gridy = 2;
		contentPanel.add(lblFechaHasta, gbc_lblFechaHasta);
		
		fechaHasta = new JXDatePicker();
		fechaHasta.setDate(Calendar.getInstance().getTime());
		fechaHasta.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		GridBagConstraints gbc_fechaHasta = new GridBagConstraints();
		gbc_fechaHasta.fill = GridBagConstraints.BOTH;
		gbc_fechaHasta.insets = new Insets(0, 0, 5, 0);
		gbc_fechaHasta.gridwidth = 2;
		gbc_fechaHasta.gridx = 1;
		gbc_fechaHasta.gridy = 2;
		contentPanel.add(fechaHasta, gbc_fechaHasta);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(this);
		
		generarButton = new JButton("Generar");
		generarButton.setIcon(new ImageIcon(ArqueoDeCaja.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_generarButton = new GridBagConstraints();
		gbc_generarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_generarButton.insets = new Insets(0, 0, 0, 5);
		gbc_generarButton.gridx = 0;
		gbc_generarButton.gridy = 3;
		contentPanel.add(generarButton, gbc_generarButton);
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelarButton.gridx = 2;
		gbc_cancelarButton.gridy = 3;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		generarButton.addActionListener(this);
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.cancelarButton){
			dispose();
		}
		if(e.getSource()==this.generarButton){
			new ItemsCobrados((Usuario) this.comboBox.getSelectedItem(),this.fechaDesde.getDate(),this.fechaHasta.getDate()).setVisible(true);
			dispose();
		}
	}
	
}
