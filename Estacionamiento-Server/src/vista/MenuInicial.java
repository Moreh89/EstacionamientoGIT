package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEstacionamiento;
	private JMenuBar menuBar;
	private JMenu mnABM;
	private JMenu mnCliente;
	private JMenuItem mntmAltaCliente;
	private JMenuItem mntmModificacionCliente;
	private JMenuItem mntmBajaCliente;
	private JMenu mnUsuario;
	private JMenuItem mntmAltaUsuario;
	private JMenuItem mntmModificacionUsuario;
	private JMenuItem mntmBajaUsuario;
	private JMenu mnVehiculo;
	private JMenuItem mntmAltaVehiculo;
	private JMenuItem mntmModificacionVehiculo;
	private JMenuItem mntmBajaVehiculo;
	private JMenu mnGestionClientes;
	private JMenuItem mntmAsociacionCocheras;
	private JMenuItem mntmCuentaCorriente;
	private JMenuItem mntmPersonasAutorizadas;
	private JMenu mnGestionEstacionamiento;
	private JMenu mnCocheras;
	private JMenuItem mntmAltaCochera;
	private JMenuItem mntmModificacionCochera;
	private JMenu mnColor;
	private JMenuItem mntmAltaColor;
	private JMenuItem mntmModificacionColor;
	private JMenu mnDescuentos;
	private JMenuItem mntmAltaDescuento;
	private JMenuItem mntmModificacionDescuento;
	private JMenuItem mntmBajaModificacion;
	private JMenu mnModelo;
	private JMenuItem mntmAltaModelo;
	private JMenuItem mntmModificacionModelo;
	private JMenu mnTarifas;
	private JMenuItem mntmAltaTarifa;
	private JMenuItem mntmModificacionTarifa;
	private JMenu mnTasaInteres;
	private JMenuItem mntmModificacionTasaInteres;
	private JMenu mnConsultas;
	private JMenuItem mntmArqueoDeCaja;
	private JMenuItem mntmBuscarCliente;
	private JMenuItem mntmCantidadAutos;
	private JMenuItem mntmDeudores;
	private JMenu mnMiCuenta;
	private JMenuItem mntmCambiarClave;
	private JMenuItem mntmSalir;

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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnABM = new JMenu("ABM");
		mnABM.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/plus.png")));
		menuBar.add(mnABM);
		
		mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/paciente.png")));
		mnABM.add(mnCliente);
		
		mntmAltaCliente = new JMenuItem("Alta");
		mnCliente.add(mntmAltaCliente);
		mntmAltaCliente.addActionListener(this);
		
		mntmModificacionCliente = new JMenuItem("Modificacion");
		mnCliente.add(mntmModificacionCliente);
		mntmModificacionCliente.addActionListener(this);
		
		mntmBajaCliente = new JMenuItem("Baja");
		mnCliente.add(mntmBajaCliente);
		mntmBajaCliente.addActionListener(this);
		
		mnUsuario = new JMenu("Usuario");
		mnUsuario.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/users.png")));
		mnABM.add(mnUsuario);
		
		mntmAltaUsuario = new JMenuItem("Alta");
		mnUsuario.add(mntmAltaUsuario);
		mntmAltaUsuario.addActionListener(this);
		
		mntmModificacionUsuario = new JMenuItem("Modificacion");
		mnUsuario.add(mntmModificacionUsuario);
		mntmModificacionUsuario.addActionListener(this);
		
		mntmBajaUsuario = new JMenuItem("Baja");
		mnUsuario.add(mntmBajaUsuario);
		mntmBajaUsuario.addActionListener(this);
		
		mnVehiculo = new JMenu("Vehiculo");
		mnVehiculo.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/alquilar.png")));
		mnABM.add(mnVehiculo);
		
		mntmAltaVehiculo = new JMenuItem("Alta");
		mnVehiculo.add(mntmAltaVehiculo);
		mntmAltaVehiculo.addActionListener(this);
		
		mntmModificacionVehiculo = new JMenuItem("Modificacion");
		mnVehiculo.add(mntmModificacionVehiculo);
		mntmModificacionVehiculo.addActionListener(this);
		
		mntmBajaVehiculo = new JMenuItem("Baja");
		mnVehiculo.add(mntmBajaVehiculo);
		mntmBajaVehiculo.addActionListener(this);
		
		mnGestionClientes = new JMenu("Gestion Clientes");
		mnGestionClientes.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/paciente.png")));
		menuBar.add(mnGestionClientes);
		
		mntmAsociacionCocheras = new JMenuItem("Asociacion Cocheras");
		mnGestionClientes.add(mntmAsociacionCocheras);
		mntmAsociacionCocheras.addActionListener(this);
		
		mntmCuentaCorriente = new JMenuItem("Cuenta Corriente");
		mnGestionClientes.add(mntmCuentaCorriente);
		mntmCuentaCorriente.addActionListener(this);
		
		mntmPersonasAutorizadas = new JMenuItem("Personas Autorizadas");
		mnGestionClientes.add(mntmPersonasAutorizadas);
		mntmPersonasAutorizadas.addActionListener(this);
		
		mnGestionEstacionamiento = new JMenu("Gestion Estacionamiento");
		mnGestionEstacionamiento.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/modificar.png")));
		menuBar.add(mnGestionEstacionamiento);
		
		mnCocheras = new JMenu("Cocheras");
		mnGestionEstacionamiento.add(mnCocheras);
		
		mntmAltaCochera = new JMenuItem("Alta");
		mnCocheras.add(mntmAltaCochera);
		mntmAltaCochera.addActionListener(this);
		
		mntmModificacionCochera = new JMenuItem("Modificacion");
		mnCocheras.add(mntmModificacionCochera);
		mntmModificacionCochera.addActionListener(this);
		
		mnColor = new JMenu("Color");
		mnGestionEstacionamiento.add(mnColor);
		
		mntmAltaColor = new JMenuItem("Alta");
		mnColor.add(mntmAltaColor);
		mntmAltaColor.addActionListener(this);
		
		mntmModificacionColor = new JMenuItem("Modificacion");
		mnColor.add(mntmModificacionColor);
		mntmModificacionColor.addActionListener(this);
		
		mnDescuentos = new JMenu("Descuentos");
		mnGestionEstacionamiento.add(mnDescuentos);
		
		mntmAltaDescuento = new JMenuItem("Alta");
		mnDescuentos.add(mntmAltaDescuento);
		mntmAltaDescuento.addActionListener(this);
		
		mntmModificacionDescuento = new JMenuItem("Modificacion");
		mnDescuentos.add(mntmModificacionDescuento);
		mntmModificacionDescuento.addActionListener(this);
		
		mntmBajaModificacion = new JMenuItem("Baja");
		mnDescuentos.add(mntmBajaModificacion);
		mntmBajaModificacion.addActionListener(this);
		
		mnModelo = new JMenu("Modelo");
		mnGestionEstacionamiento.add(mnModelo);
		
		mntmAltaModelo = new JMenuItem("Alta");
		mnModelo.add(mntmAltaModelo);
		mntmAltaModelo.addActionListener(this);
		
		mntmModificacionModelo = new JMenuItem("Modificacion");
		mnModelo.add(mntmModificacionModelo);
		mntmModificacionModelo.addActionListener(this);
		
		mnTarifas = new JMenu("Tarifas");
		mnGestionEstacionamiento.add(mnTarifas);
		
		mntmAltaTarifa = new JMenuItem("Alta");
		mnTarifas.add(mntmAltaTarifa);
		mntmAltaTarifa.addActionListener(this);
		
		mntmModificacionTarifa = new JMenuItem("Modificacion");
		mnTarifas.add(mntmModificacionTarifa);
		mntmAltaTarifa.addActionListener(this);
		
		mnTasaInteres = new JMenu("Tasa Interes");
		mnGestionEstacionamiento.add(mnTasaInteres);
		
		mntmModificacionTasaInteres = new JMenuItem("Modificacion");
		mnTasaInteres.add(mntmModificacionTasaInteres);
		mntmModificacionTasaInteres.addActionListener(this);
		
		mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/buscar.png")));
		menuBar.add(mnConsultas);
		
		mntmArqueoDeCaja = new JMenuItem("Arqueo de Caja");
		mnConsultas.add(mntmArqueoDeCaja);
		mntmArqueoDeCaja.addActionListener(this);
		
		mntmBuscarCliente = new JMenuItem("Buscar Cliente");
		mnConsultas.add(mntmBuscarCliente);
		mntmBuscarCliente.addActionListener(this);
		
		mntmCantidadAutos = new JMenuItem("Cantidad Autos");
		mnConsultas.add(mntmCantidadAutos);
		mntmCantidadAutos.addActionListener(this);
		
		mntmDeudores = new JMenuItem("Deudores");
		mnConsultas.add(mntmDeudores);
		mntmDeudores.addActionListener(this);
		
		mnMiCuenta = new JMenu("Mi Cuenta");
		mnMiCuenta.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/users.png")));
		menuBar.add(mnMiCuenta);
		
		mntmCambiarClave = new JMenuItem("Cambiar Clave");
		mntmCambiarClave.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/key.png")));
		mnMiCuenta.add(mntmCambiarClave);
		mntmCambiarClave.addActionListener(this);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuInicial.class.getResource("/image/exit.png")));
		mnMiCuenta.add(mntmSalir);
		mntmSalir.addActionListener(this);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
