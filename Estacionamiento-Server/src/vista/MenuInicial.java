package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import javax.swing.JMenu;

public class MenuInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
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
	public MenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnABM = new JMenu("ABM");
		menuBar.add(mnABM);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnABM.add(mnCliente);
		
		JMenuItem mntmAltaCliente = new JMenuItem("Alta");
		mnCliente.add(mntmAltaCliente);
		
		JMenuItem mntmModificacionCliente = new JMenuItem("Modificacion");
		mnCliente.add(mntmModificacionCliente);
		
		JMenuItem mntmBajaCliente = new JMenuItem("Baja");
		mnCliente.add(mntmBajaCliente);
		
		JMenu mnVehiculo = new JMenu("Vehiculo");
		mnABM.add(mnVehiculo);
		
		JMenuItem mntmAltaVehiculo = new JMenuItem("Alta");
		mnVehiculo.add(mntmAltaVehiculo);
		
		JMenuItem mntmModificacionVehiculo = new JMenuItem("Modificacion");
		mnVehiculo.add(mntmModificacionVehiculo);
		
		JMenuItem mntmBajaVehiculo = new JMenuItem("Baja");
		mnVehiculo.add(mntmBajaVehiculo);
		
		JMenu mnUsuario = new JMenu("Usuario");
		mnABM.add(mnUsuario);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta");
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmModificacionUsuario = new JMenuItem("Modificacion");
		mnUsuario.add(mntmModificacionUsuario);
		
		JMenuItem mntmBajaUsuario = new JMenuItem("Baja");
		mnUsuario.add(mntmBajaUsuario);
		
		JMenu mnGestionClientes = new JMenu("Gestion Clientes");
		menuBar.add(mnGestionClientes);
		
		JMenuItem mntmCuentaCorriente = new JMenuItem("Cuenta Corriente");
		mnGestionClientes.add(mntmCuentaCorriente);
		
		JMenuItem mntmPersonasAutorizadas = new JMenuItem("Personas Autorizadas");
		mnGestionClientes.add(mntmPersonasAutorizadas);
		
		JMenuItem mntmAsociacionCocheras = new JMenuItem("Asociacion Cocheras");
		mnGestionClientes.add(mntmAsociacionCocheras);
		
		JMenu mnGestionEstacionamiento = new JMenu("Gestion Estacionamiento");
		menuBar.add(mnGestionEstacionamiento);
		
		JMenu mnTarifas = new JMenu("Tarifas");
		mnGestionEstacionamiento.add(mnTarifas);
		
		JMenu mnDescuentos = new JMenu("Descuentos");
		mnGestionEstacionamiento.add(mnDescuentos);
		
		JMenu mnCocheras = new JMenu("Cocheras");
		mnGestionEstacionamiento.add(mnCocheras);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
	}

}
