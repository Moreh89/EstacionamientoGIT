package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import modelo.MovimientoCC;
import modelo.Ticket;
import modelo.Usuario;
import controlador.Controlador;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;

public class ItemsCobrados extends JDialog implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private DefaultListModel<String> listModel;
	private JList<String> listElementos;
	private JLabel lblTicketsAbiertos;
	private JLabel lblTotalCobrado;
	private double total = 0;


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
	 * @param fechaFin 
	 * @param fechaInicio 
	 * @param usuario 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ItemsCobrados(Usuario usuario, Date fechaInicio, Date fechaFin) {
		setResizable(false);
		setTitle("Items Cobrados");
		setBounds(100, 100, 808, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(191, 450, 116, 32);
		contentPanel.add(aceptarButton);
		aceptarButton.addActionListener(this);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(358, 450, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 6, 784, 303);
		contentPanel.add(scrollPane);
		

		listModel = new DefaultListModel<String>();
		for (Ticket ticketTemp : Controlador.getInstancia().obtenerTicketsCobrados(usuario, fechaInicio,fechaFin)) {
			
			if(ticketTemp.getEstado() == Ticket.Estado.PREPAGO && ticketTemp.getPrepago() > 0){
				total = total + ticketTemp.getPrepago();
				listModel.addElement("PREGPADO TICKET PATENTE: " + ticketTemp.getPatente().toUpperCase() + " MONTO: "+ String.valueOf(ticketTemp.getPrepago()));
			}
			if(ticketTemp.getEstado() == Ticket.Estado.CERRADO){
				if(ticketTemp.getFechaLlegada().compareTo(fechaInicio) >= 0 && ticketTemp.getPrepago() > 0){
					total = total + ticketTemp.getPrepago();
					listModel.addElement("PREGPADO TICKET PATENTE: " + ticketTemp.getPatente().toUpperCase() + " MONTO: "+ String.valueOf(ticketTemp.getPrepago()));
				}if ( ticketTemp.getMontoCobrado() > 0){
					total = total + ticketTemp.getMontoCobrado();
					listModel.addElement("CIERRE TICKET PATENTE: " + ticketTemp.getPatente().toUpperCase() + " MONTO: "+ String.valueOf(ticketTemp.getMontoCobrado()));
				}
			}
			
		} 
		for (MovimientoCC movimientoCCTemp : Controlador.getInstancia().obtenetMovimientosCobrados(usuario, fechaInicio,fechaFin)){
			total = total + movimientoCCTemp.getMontoCobrado();
			listModel.addElement("PAGO EXTRAORDINARIO CONCEPTO: " + movimientoCCTemp.getDescripcion() + " MONTO: " + movimientoCCTemp.getMontoCobrado());
		}
		
		
		listElementos= new JList(listModel);
		listElementos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listElementos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listElementos);
		
		lblTicketsAbiertos = new JLabel("Total Cobrado:");
		lblTicketsAbiertos.setBounds(191, 342, 133, 37);
		contentPanel.add(lblTicketsAbiertos);
		lblTicketsAbiertos.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblTotalCobrado = new JLabel("");
		lblTotalCobrado.setBounds(358, 329, 107, 71);
		contentPanel.add(lblTotalCobrado);
		lblTotalCobrado.setForeground(Color.RED);
		lblTotalCobrado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalCobrado.setText(String.valueOf(total));
		listElementos.addListSelectionListener(this);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==aceptarButton)
		{
	
			dispose();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listElementos){

		}		
	}
}
