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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtEstacionamiento;

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
		setTitle("Gestor Estacionamiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 427);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnABM = new JMenu("ABM");
		mnABM.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/plus.png")));
		menuBar.add(mnABM);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/paciente.png")));
		mnABM.add(mnCliente);
		
		JMenuItem mntmAltaCliente = new JMenuItem("Alta");
		mnCliente.add(mntmAltaCliente);
		
		JMenuItem mntmModificacionCliente = new JMenuItem("Modificacion");
		mnCliente.add(mntmModificacionCliente);
		
		JMenuItem mntmBajaCliente = new JMenuItem("Baja");
		mnCliente.add(mntmBajaCliente);
		
		JMenu mnUsuario = new JMenu("Usuario");
		mnUsuario.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/users.png")));
		mnABM.add(mnUsuario);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta");
		mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmModificacionUsuario = new JMenuItem("Modificacion");
		mnUsuario.add(mntmModificacionUsuario);
		
		JMenuItem mntmBajaUsuario = new JMenuItem("Baja");
		mnUsuario.add(mntmBajaUsuario);
		
		JMenu mnVehiculo = new JMenu("Vehiculo");
		mnVehiculo.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/alquilar.png")));
		mnABM.add(mnVehiculo);
		
		JMenuItem mntmAltaVehiculo = new JMenuItem("Alta");
		mnVehiculo.add(mntmAltaVehiculo);
		
		JMenuItem mntmModificacionVehiculo = new JMenuItem("Modificacion");
		mnVehiculo.add(mntmModificacionVehiculo);
		
		JMenuItem mntmBajaVehiculo = new JMenuItem("Baja");
		mnVehiculo.add(mntmBajaVehiculo);
		
		JMenu mnGestionClientes = new JMenu("Gestion Clientes");
		mnGestionClientes.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/paciente.png")));
		menuBar.add(mnGestionClientes);
		
		JMenuItem mntmAsociacionCocheras = new JMenuItem("Asociacion Cocheras");
		mnGestionClientes.add(mntmAsociacionCocheras);
		
		JMenuItem mntmCuentaCorriente = new JMenuItem("Cuenta Corriente");
		mnGestionClientes.add(mntmCuentaCorriente);
		
		JMenuItem mntmPersonasAutorizadas = new JMenuItem("Personas Autorizadas");
		mnGestionClientes.add(mntmPersonasAutorizadas);
		
		JMenu mnGestionEstacionamiento = new JMenu("Gestion Estacionamiento");
		mnGestionEstacionamiento.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/modificar.png")));
		menuBar.add(mnGestionEstacionamiento);
		
		JMenu mnCocheras = new JMenu("Cocheras");
		mnGestionEstacionamiento.add(mnCocheras);
		
		JMenuItem mntmAltaCochera = new JMenuItem("Alta");
		mnCocheras.add(mntmAltaCochera);
		
		JMenuItem mntmModificacionCochera = new JMenuItem("Modificacion");
		mnCocheras.add(mntmModificacionCochera);
		
		JMenu mnColor = new JMenu("Color");
		mnGestionEstacionamiento.add(mnColor);
		
		JMenuItem mntmAltaColor = new JMenuItem("Alta");
		mnColor.add(mntmAltaColor);
		
		JMenuItem mntmModificacionColor = new JMenuItem("Modificacion");
		mnColor.add(mntmModificacionColor);
		
		JMenu mnDescuentos = new JMenu("Descuentos");
		mnGestionEstacionamiento.add(mnDescuentos);
		
		JMenuItem mntmAltaDescuento = new JMenuItem("Alta");
		mnDescuentos.add(mntmAltaDescuento);
		
		JMenuItem mntmModificacionDescuento = new JMenuItem("Modificacion");
		mnDescuentos.add(mntmModificacionDescuento);
		
		JMenuItem mntmBajaModificacion = new JMenuItem("Baja");
		mnDescuentos.add(mntmBajaModificacion);
		
		JMenu mnExpensas = new JMenu("Expensas");
		mnGestionEstacionamiento.add(mnExpensas);
		
		JMenuItem mntmAltaExpensa = new JMenuItem("Alta");
		mnExpensas.add(mntmAltaExpensa);
		
		JMenuItem mntmModificacionExpensa = new JMenuItem("Modificacion");
		mnExpensas.add(mntmModificacionExpensa);
		
		JMenuItem mntmBajaExpensa = new JMenuItem("Baja");
		mnExpensas.add(mntmBajaExpensa);
		
		JMenu mnModelo = new JMenu("Modelo");
		mnGestionEstacionamiento.add(mnModelo);
		
		JMenuItem mntmAltaModelo = new JMenuItem("Alta");
		mnModelo.add(mntmAltaModelo);
		
		JMenuItem mntmModificacionModelo = new JMenuItem("Modificacion");
		mnModelo.add(mntmModificacionModelo);
		
		JMenu mnTarifas = new JMenu("Tarifas");
		mnGestionEstacionamiento.add(mnTarifas);
		
		JMenuItem mntmAltaTarifa = new JMenuItem("Alta");
		mnTarifas.add(mntmAltaTarifa);
		
		JMenuItem mntmModificacionTarifa = new JMenuItem("Modificacion");
		mnTarifas.add(mntmModificacionTarifa);
		
		JMenu mnTasaInteres = new JMenu("Tasa Interes");
		mnGestionEstacionamiento.add(mnTasaInteres);
		
		JMenuItem mntmModificacionTasaInteres = new JMenuItem("Modificacion");
		mnTasaInteres.add(mntmModificacionTasaInteres);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/buscar.png")));
		menuBar.add(mnConsultas);
		
		JMenuItem mntmArqueoDeCaja = new JMenuItem("Arqueo de Caja");
		mnConsultas.add(mntmArqueoDeCaja);
		
		JMenuItem mntmBuscarCliente = new JMenuItem("Buscar Cliente");
		mnConsultas.add(mntmBuscarCliente);
		
		JMenuItem mntmCantidadAutos = new JMenuItem("Cantidad Autos");
		mnConsultas.add(mntmCantidadAutos);
		
		JMenuItem mntmDeudores = new JMenuItem("Deudores");
		mnConsultas.add(mntmDeudores);
		
		JMenu mnMiCuenta = new JMenu("Mi Cuenta");
		mnMiCuenta.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/users.png")));
		menuBar.add(mnMiCuenta);
		
		JMenuItem mntmCambiarClave = new JMenuItem("Cambiar Clave");
		mntmCambiarClave.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/key.png")));
		mnMiCuenta.add(mntmCambiarClave);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/exit.png")));
		mnMiCuenta.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		txtEstacionamiento = new JTextField();
		txtEstacionamiento.setFont(new Font("Lucida Grande", Font.BOLD, 42));
		txtEstacionamiento.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstacionamiento.setEditable(false);
		txtEstacionamiento.setEnabled(false);
		txtEstacionamiento.setText("Estacionamiento");
		contentPane.add(txtEstacionamiento, BorderLayout.CENTER);
		txtEstacionamiento.setColumns(10);
	}

}
