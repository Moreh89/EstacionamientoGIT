package vista;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import controlador.Controlador;



@SuppressWarnings("rawtypes")
public class VerDeudores extends JDialog implements ActionListener, KeyListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private DefaultTableModel model;
	@SuppressWarnings("unused")
	private CobroExtraordinario cobroExtraordinario;
	private JPanel panelClientes;
	private JScrollPane scrollPaneClientes;
	private JList listMovimientos;
	private DefaultListModel<modelo.Cliente> listModel;
	private JButton btnCancelar;
	private JButton btnExportarAExcel;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerDeudores frame = new VerDeudores();
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

	public VerDeudores() {
		initGUI();
	}



	@SuppressWarnings("unchecked")
	public void initGUI(){
		setTitle("Listado de Clientes con Deuda");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 520);
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

		panelClientes = new JPanel();
		panelClientes.setBounds(10, 11, 503, 400);
		contentPane.add(panelClientes);
		GridBagLayout gbl_panelClientes = new GridBagLayout();
		gbl_panelClientes.columnWidths = new int[]{240, 0};
		gbl_panelClientes.rowHeights = new int[]{400, 0};
		gbl_panelClientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelClientes.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelClientes.setLayout(gbl_panelClientes);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPaneClientes = new GridBagConstraints();
		gbc_scrollPaneClientes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneClientes.gridx = 0;
		gbc_scrollPaneClientes.gridy = 0;
		panelClientes.add(scrollPaneClientes, gbc_scrollPaneClientes);

		listModel = new DefaultListModel<modelo.Cliente>();
				for (modelo.Cliente clienteTemp : Controlador.getInstancia().getClientesConDeuda()) {
					listModel.addElement(clienteTemp);
				} 
		
		listMovimientos = new JList(listModel);
		listMovimientos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPaneClientes.setViewportView(listMovimientos);


		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		btnCancelar.setBounds(393, 435, 120, 35);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		GridBagConstraints gbc_fechaDesde_1_1 = new GridBagConstraints();
		gbc_fechaDesde_1_1.anchor = GridBagConstraints.WEST;
		gbc_fechaDesde_1_1.gridx = 2;
		gbc_fechaDesde_1_1.gridy = 1;
		gbc_fechaDesde_1_1.fill = GridBagConstraints.BOTH;
		gbc_fechaDesde_1_1.insets = new Insets(0, 0, 0, 5);

		JButton btnExportarAExcel = new JButton("Exportar a Excel");
		btnExportarAExcel.setIcon(new ImageIcon(VerDeudores.class.getResource("/image/guardar.png")));
		btnExportarAExcel.setBounds(10, 435, 144, 35);
		contentPane.add(btnExportarAExcel);

		this.setLocationRelativeTo(null);
		setModal(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancelar)
		{
			dispose();
		}
		
		if(e.getSource()==btnExportarAExcel)
		{
			dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}

