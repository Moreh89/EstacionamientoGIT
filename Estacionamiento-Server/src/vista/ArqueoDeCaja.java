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


import org.jdesktop.swingx.JXDatePicker;

//import reportes.ReporteEjemplo;
import java.awt.Font;

public class ArqueoDeCaja extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JXDatePicker fechaHasta;
	private JXDatePicker fechaDesde;
	private JButton exportarButton;
	private JButton cancelarButton;

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
	public ArqueoDeCaja() {
		setTitle("Cierre Facturaci\u00F3n");
		setBounds(100, 100, 289, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblFechaaDesde = new JLabel("Fecha Desde");
		lblFechaaDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblFechaaDesde.setBounds(10, 36, 79, 14);
		contentPanel.add(lblFechaaDesde);
		
		fechaDesde = new JXDatePicker();
		fechaDesde.setDate(Calendar.getInstance().getTime());
		fechaDesde.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		fechaDesde.setBounds(103, 32, 149, 22);
		contentPanel.add(fechaDesde);
		
		JLabel lblFechaHasta = new JLabel("Fecha Hasta");
		lblFechaHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaHasta.setBounds(10, 61, 79, 14);
		contentPanel.add(lblFechaHasta);
		
		fechaHasta = new JXDatePicker();
		fechaHasta.setDate(Calendar.getInstance().getTime());
		fechaHasta.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		fechaHasta.setBounds(103, 57, 149, 22);
		contentPanel.add(fechaHasta);
		
		exportarButton = new JButton("Generar");
		exportarButton.setIcon(new ImageIcon(BuscardorUsuario.class.getResource("/image/pdf.png")));
		exportarButton.setBounds(29, 104, 116, 32);
		contentPanel.add(exportarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(BuscardorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(155, 104, 116, 32);
		contentPanel.add(cancelarButton);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}
	
}
