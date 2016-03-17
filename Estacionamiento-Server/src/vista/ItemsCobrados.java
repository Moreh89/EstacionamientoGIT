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

import modelo.IncrementoPrepago;
import modelo.MovimientoCC;
import modelo.Ticket;
import modelo.Usuario;
import persistencia.dao.DAOMovimientoCC;
import controlador.Controlador;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;

public class ItemsCobrados extends JDialog implements ActionListener, ListSelectionListener {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private DefaultListModel<String> listModel;
	private JList<String> listElementos;
	private JLabel lblTicketsAbiertos;
	private JLabel lblTotalCobrado;
	private double total = 0;


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
		aceptarButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		aceptarButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(316, 450, 149, 32);
		contentPanel.add(aceptarButton);
		aceptarButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 6, 784, 303);
		contentPanel.add(scrollPane);
		

		listModel = new DefaultListModel<String>();
		for (Ticket ticketTemp : Controlador.getInstancia().obtenerTicketsCobrados(usuario, fechaInicio,fechaFin)) {
			
//			if(ticketTemp.getEstado() == Ticket.Estado.PREPAGO && ticketTemp.getPrepago() > 0){
//				total = total + ticketTemp.getPrepago();
//				listModel.addElement("PREGPADO TICKET PATENTE: " + ticketTemp.getPatente().toUpperCase() + " MONTO: "+ String.valueOf(ticketTemp.getPrepago()));
//			}
			if(ticketTemp.getEstado() == Ticket.Estado.CERRADO){
//				if(ticketTemp.getFechaLlegada().compareTo(fechaInicio) >= 0 && ticketTemp.getPrepago() > 0){
//					total = total + ticketTemp.getPrepago();
//					listModel.addElement("PREGPADO TICKET PATENTE: " + ticketTemp.getPatente().toUpperCase() + " MONTO: "+ String.valueOf(ticketTemp.getPrepago()));
//				}//TO DO que onda los pagados con tarjeta? los muestro si no? -- &&!ticketTemp.pagoTarjeta
				if ( ticketTemp.getMontoCobrado() > 0){
					total = total + ticketTemp.getMontoCobrado();
					String item = "CIERRE TICKET: " + String.valueOf(ticketTemp.getIdTicket()) + " MONTO: "+ String.valueOf(ticketTemp.getMontoCobrado());
					if(ticketTemp.isPagotarjeta()){
						item = item + " (TARJETA)";
					}
					if(ticketTemp.getDescuento()!=null && ticketTemp.getDescuento().getDescuento() > 0){
						item = item + " CON DESCUENTO: " + ticketTemp.getDescuento().getDescripcion();
					}
					if(ticketTemp.getCliente()!=null){
						item = item + " CLIENTE: " + ticketTemp.getCliente().toString().toUpperCase();
					}
					item = item + " " + ticketTemp.getObservacion();
					listModel.addElement(item);
				}
			}
			
		} 
		for (MovimientoCC movimientoCCTemp : Controlador.getInstancia().obtenetMovimientosCobrados(usuario, fechaInicio,fechaFin)){
			if(!movimientoCCTemp.getEstado().equalsIgnoreCase("anulado")){
			total = total + Math.round(movimientoCCTemp.getMontoCobrado());
			String lineTemp = "PAGO EXTRAORDINARIO CONCEPTO: " + movimientoCCTemp.getDescripcion() + " MONTO: " + movimientoCCTemp.getMontoCobrado();
			lineTemp = lineTemp + " CLIENTE: " + DAOMovimientoCC.getInstance().getNombreCliente(movimientoCCTemp.getIdMovimiento()).toUpperCase();
			listModel.addElement(lineTemp);
			}
		}
		for (IncrementoPrepago incrementoTemp : Controlador.getInstancia().obternerIncrementos(usuario, fechaInicio,fechaFin)){
			total = total +  Math.round(incrementoTemp.getPrepago());
			listModel.addElement("PREPAGO TICKET: " + String.valueOf(incrementoTemp.getNumeroTicket()) + " MONTO: " + String.valueOf(incrementoTemp.getPrepago()));
		}
		
		listElementos= new JList(listModel);
		listElementos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listElementos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listElementos);
		
		lblTicketsAbiertos = new JLabel("Total Cobrado:");
		lblTicketsAbiertos.setBounds(201, 344, 201, 37);
		contentPanel.add(lblTicketsAbiertos);
		lblTicketsAbiertos.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblTotalCobrado = new JLabel("");
		lblTotalCobrado.setBounds(453, 329, 312, 71);
		contentPanel.add(lblTotalCobrado);
		lblTotalCobrado.setForeground(Color.RED);
		lblTotalCobrado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalCobrado.setText(String.valueOf(Math.round(total)));
		listElementos.addListSelectionListener(this);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
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
