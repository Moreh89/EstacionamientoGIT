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
import modelo.Ticket;
import controlador.Controlador;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TicketsAbiertos extends JDialog implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private DefaultListModel<Ticket> listModel;
	private JList<Ticket> listTickets;
	private JTextField textFieldBuscarTiket;
	private JButton btnBuscar;
	private JLabel lblTicketsAbiertos;
	private JLabel lblNumerotickets;



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
	public TicketsAbiertos() {
		setResizable(false);
		setTitle("Tickets Abiertos");
		setBounds(100, 100, 534, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(155, 320, 116, 32);
		contentPanel.add(aceptarButton);
		aceptarButton.addActionListener(this);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(283, 320, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 6, 307, 303);
		contentPanel.add(scrollPane);
		

		listModel = new DefaultListModel<Ticket>();
		for (Ticket ticketTemp : Controlador.getInstancia().obtenerTicketsAbiertos()) {
			listModel.addElement(ticketTemp);
		} 
		listTickets= new JList(listModel);
		listTickets.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listTickets.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listTickets);
		
		JPanel panel = new JPanel();
		panel.setBounds(325, 13, 191, 294);
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{60, 0, 60, 0, 0, 0, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textFieldBuscarTiket = new JTextField();
		textFieldBuscarTiket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textFieldBuscarTiket = new GridBagConstraints();
		gbc_textFieldBuscarTiket.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBuscarTiket.fill = GridBagConstraints.BOTH;
		gbc_textFieldBuscarTiket.gridx = 0;
		gbc_textFieldBuscarTiket.gridy = 0;
		panel.add(textFieldBuscarTiket, gbc_textFieldBuscarTiket);
		textFieldBuscarTiket.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.fill = GridBagConstraints.BOTH;
		gbc_btnBuscar.gridx = 0;
		gbc_btnBuscar.gridy = 2;
		panel.add(btnBuscar, gbc_btnBuscar);
		btnBuscar.addActionListener(this);
		
		lblTicketsAbiertos = new JLabel("Tickets Abiertos:");
		lblTicketsAbiertos.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTicketsAbiertos = new GridBagConstraints();
		gbc_lblTicketsAbiertos.insets = new Insets(0, 0, 5, 0);
		gbc_lblTicketsAbiertos.gridx = 0;
		gbc_lblTicketsAbiertos.gridy = 4;
		panel.add(lblTicketsAbiertos, gbc_lblTicketsAbiertos);
		
		lblNumerotickets = new JLabel("");
		lblNumerotickets.setForeground(Color.RED);
		lblNumerotickets.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNumerotickets = new GridBagConstraints();
		gbc_lblNumerotickets.fill = GridBagConstraints.VERTICAL;
		gbc_lblNumerotickets.gridx = 0;
		gbc_lblNumerotickets.gridy = 6;
		panel.add(lblNumerotickets, gbc_lblNumerotickets);
		lblNumerotickets.setText(String.valueOf(listTickets.getModel().getSize()));
		
		
		listTickets.addListSelectionListener(this);
		
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
			if(this.listTickets.getSelectedValue() != null) {
				Controlador.getInstancia().setTicket(this.listTickets.getSelectedValue());
			}
			else {
				Controlador.getInstancia().setTicket(null);
			}
			dispose();
		}
		if(event.getSource() == btnBuscar){
			listModel.clear();
			if(!this.textFieldBuscarTiket.getText().equals("")){

				for (Ticket ticketTemp : Controlador.getInstancia().obtenerTicketsAbiertos()) {
					if(ticketTemp.getPatente().toLowerCase().contains((this.textFieldBuscarTiket.getText().toLowerCase())))
					listModel.addElement(ticketTemp);
				} 	
			}else{
				
				for (Ticket ticketTemp : Controlador.getInstancia().obtenerTicketsAbiertos()) {
					listModel.addElement(ticketTemp);
				} 	
			}

		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listTickets){

		}		
	}
}
