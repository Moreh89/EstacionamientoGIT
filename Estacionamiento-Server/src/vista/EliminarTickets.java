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
import javax.swing.JOptionPane;
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

public class EliminarTickets extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JXDatePicker fechaHasta;
	private JXDatePicker fechaDesde;
	private JButton btnBorrarTickets;
	private JButton btnVolver;

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
	public EliminarTickets() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ArqueoDeCaja.class.getResource("/image/printer.png")));
		setTitle("Eliminar Tickets");
		setBounds(100, 100, 290, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{111, 23, 116, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 40, 51, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblFechaaDesde = new JLabel("Fecha Desde:");
		lblFechaaDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFechaaDesde = new GridBagConstraints();
		gbc_lblFechaaDesde.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaaDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaaDesde.gridx = 0;
		gbc_lblFechaaDesde.gridy = 0;
		contentPanel.add(lblFechaaDesde, gbc_lblFechaaDesde);

		fechaDesde = new JXDatePicker();
		fechaDesde.setDate(Calendar.getInstance().getTime());
		fechaDesde.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		GridBagConstraints gbc_fechaDesde = new GridBagConstraints();
		gbc_fechaDesde.fill = GridBagConstraints.BOTH;
		gbc_fechaDesde.insets = new Insets(0, 0, 5, 0);
		gbc_fechaDesde.gridwidth = 2;
		gbc_fechaDesde.gridx = 1;
		gbc_fechaDesde.gridy = 0;
		contentPanel.add(fechaDesde, gbc_fechaDesde);

		JLabel lblFechaHasta = new JLabel("Fecha Hasta:");
		lblFechaHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFechaHasta = new GridBagConstraints();
		gbc_lblFechaHasta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaHasta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaHasta.gridx = 0;
		gbc_lblFechaHasta.gridy = 1;
		contentPanel.add(lblFechaHasta, gbc_lblFechaHasta);

		fechaHasta = new JXDatePicker();
		fechaHasta.setDate(Calendar.getInstance().getTime());
		fechaHasta.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		GridBagConstraints gbc_fechaHasta = new GridBagConstraints();
		gbc_fechaHasta.fill = GridBagConstraints.BOTH;
		gbc_fechaHasta.insets = new Insets(0, 0, 5, 0);
		gbc_fechaHasta.gridwidth = 2;
		gbc_fechaHasta.gridx = 1;
		gbc_fechaHasta.gridy = 1;
		contentPanel.add(fechaHasta, gbc_fechaHasta);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(EliminarTickets.class.getResource("/image/izq.png")));
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolver.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVolver.gridx = 0;
		gbc_btnVolver.gridy = 2;
		contentPanel.add(btnVolver, gbc_btnVolver);

		btnBorrarTickets = new JButton("Borrar");
		btnBorrarTickets.setIcon(new ImageIcon(ArqueoDeCaja.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_btnBorrarTickets = new GridBagConstraints();
		gbc_btnBorrarTickets.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrarTickets.gridx = 2;
		gbc_btnBorrarTickets.gridy = 2;
		contentPanel.add(btnBorrarTickets, gbc_btnBorrarTickets);
		btnBorrarTickets.addActionListener(this);
		this.setLocationRelativeTo(null);
		setModal(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnVolver){
			dispose();
		}
		if(e.getSource()==this.btnBorrarTickets)
		{
			if(fechaDesde.getDate().compareTo(fechaHasta.getDate())<1)
			{
				long codReturn = Controlador.getInstancia().eliminarTickets(fechaDesde.getDate(), fechaHasta.getDate());
				if(codReturn != -1)
				{
					JOptionPane.showMessageDialog(null, "Se eliminaron " + codReturn + " registros.", "Tickets Eliminados", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "Se produjo un error. Vuelva a intentarlo.", "Tickets Eliminados", JOptionPane.INFORMATION_MESSAGE);

				}
				dispose();
			}
		}
	}

}
