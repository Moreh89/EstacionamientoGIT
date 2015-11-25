package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Cochera;

public class ListadoCocheras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoCocheras frame = new ListadoCocheras();
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
	public ListadoCocheras() {
		setTitle("Listado Cocheras");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListadoCocheras.class.getResource("/image/printer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cochera", "Cliente"
			}
		));
		scrollPane.setViewportView(table);
		
		ArrayList<Cochera> cocheras = Controlador.getInstancia().getCocheras();
		String numeroCochera = "";
		
		for (Cochera cochera : cocheras) {
			
			while(!numeroCochera.equals("") && Integer.parseInt(cochera.getUbicacion()) > (Integer.parseInt(numeroCochera)+1)){
				numeroCochera = String.valueOf(Integer.parseInt(numeroCochera)+1);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{numeroCochera, ""});
				
			}
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{cochera.getUbicacion(), cochera.getCliente().getApellido() + " " + cochera.getCliente().getNombre()});
			numeroCochera = cochera.getUbicacion();
			
		}
		
	}

}
