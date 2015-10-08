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
import controlador.Controlador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEstacionamiento;
	private JMenuBar menuBar;
	private JMenu mnCliente;
	private JMenuItem mntmAltaCliente;
	private JMenuItem mntmModificacionCliente;
	private JMenu mnUsuario;
	private JMenuItem mntmModificacionUsuario;
	private JMenu mnGestionEstacionamiento;
	private JMenu mnColor;
	private JMenuItem mntmGestionColor;
	private JMenu mnDescuentos;
	private JMenuItem mntmGestionDescuento;
	private JMenu mnModelo;
	private JMenuItem mntmGestionModelo;
	private JMenu mnTarifas;
	private JMenuItem mntmGestionTarifa;
	private JMenu mnTasaInteres;
	private JMenuItem mntmGestionTasaInteres;
	private JMenu mnConsultas;
	private JMenuItem mntmArqueoDeCaja;
	private JMenuItem mntmBuscarCliente;
	private JMenuItem mntmTicketsAbiertos;
	private JMenuItem mntmDeudores;
	private JMenu mnMiCuenta;
	private JMenuItem mntmCambiarClave;
	private JMenuItem mntmSalir;
	private JMenu menuSistema;
	private JMenuItem menuItemBackUp;
	private JMenuItem mntmLiquidarExpensas;
	private JMenu mnExpensas;
	private JMenuItem mntmAnularExpensas;
	private JMenuItem mntmCobroExtraordinario;
	private JMenu mnAlquileres;
	private JMenuItem mntmLiquidarAlquileres;
	private JMenuItem mntmAnularAlquileres;
	private JMenuItem mntmTicketsTarjeta;
	private JMenu menuHelp;
	private JMenuItem mnAbout;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setTitle("Gestor Estacionamiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 427);

		// PARA MAXIMIZAR LA VENTANA
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		mnUsuario.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/users.png")));

		mntmModificacionUsuario = new JMenuItem("Gestionar");
		mnUsuario.add(mntmModificacionUsuario);
		mntmModificacionUsuario.addActionListener(this);

		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		mnCliente.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/paciente.png")));

		mntmAltaCliente = new JMenuItem("Alta");
		mnCliente.add(mntmAltaCliente);
		mntmAltaCliente.addActionListener(this);

		mntmModificacionCliente = new JMenuItem("Modificacion/Baja");
		mnCliente.add(mntmModificacionCliente);
		mntmModificacionCliente.addActionListener(this);

		mnGestionEstacionamiento = new JMenu("Gestion de Estacionamiento");
		mnGestionEstacionamiento.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/modificar.png")));
		menuBar.add(mnGestionEstacionamiento);

		mntmCobroExtraordinario = new JMenuItem("Cobro Extraordinario");
		mnGestionEstacionamiento.add(mntmCobroExtraordinario);
		mntmCobroExtraordinario.addActionListener(this);

		mnAlquileres = new JMenu("Alquileres");
		mnGestionEstacionamiento.add(mnAlquileres);

		mntmLiquidarAlquileres = new JMenuItem("Emitir Liquidaci\u00F3n");
		mnAlquileres.add(mntmLiquidarAlquileres);
		mntmLiquidarAlquileres.addActionListener(this);

		mntmAnularAlquileres = new JMenuItem("Anular Liquidaci\u00F3n");
		mnAlquileres.add(mntmAnularAlquileres);
		mntmAnularAlquileres.addActionListener(this);

		mnColor = new JMenu("Colores");
		mnGestionEstacionamiento.add(mnColor);

		mntmGestionColor = new JMenuItem("Gestionar");
		mnColor.add(mntmGestionColor);
		mntmGestionColor.addActionListener(this);

		mnDescuentos = new JMenu("Descuentos");
		mnGestionEstacionamiento.add(mnDescuentos);

		mntmGestionDescuento = new JMenuItem("Gestionar");
		mnDescuentos.add(mntmGestionDescuento);
		mntmGestionDescuento.addActionListener(this);

		mnExpensas = new JMenu("Expensas");
		mnGestionEstacionamiento.add(mnExpensas);

		mntmLiquidarExpensas = new JMenuItem("Emitir Liquidaci\u00F3n");
		mnExpensas.add(mntmLiquidarExpensas);
		mntmLiquidarExpensas.addActionListener(this);

		mntmAnularExpensas = new JMenuItem("Anular Liquidaci\u00F3n");
		mnExpensas.add(mntmAnularExpensas);
		mntmAnularExpensas.addActionListener(this);

		mnModelo = new JMenu("Modelos");
		mnGestionEstacionamiento.add(mnModelo);

		mntmGestionModelo = new JMenuItem("Gestionar");
		mnModelo.add(mntmGestionModelo);
		mntmGestionModelo.addActionListener(this);

		mnTarifas = new JMenu("Tarifas");
		mnGestionEstacionamiento.add(mnTarifas);

		mntmGestionTarifa = new JMenuItem("Gestionar");
		mnTarifas.add(mntmGestionTarifa);
		mntmGestionTarifa.addActionListener(this);

		mnTasaInteres = new JMenu("Tasa Interes");
		mnGestionEstacionamiento.add(mnTasaInteres);

		mntmGestionTasaInteres = new JMenuItem("Gestionar");
		mnTasaInteres.add(mntmGestionTasaInteres);
		mntmGestionTasaInteres.addActionListener(this);

		mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/buscar.png")));
		menuBar.add(mnConsultas);

		mntmArqueoDeCaja = new JMenuItem("Arqueo de Caja");
		mnConsultas.add(mntmArqueoDeCaja);
		mntmArqueoDeCaja.addActionListener(this);

		mntmBuscarCliente = new JMenuItem("Buscar Cliente");
		mnConsultas.add(mntmBuscarCliente);
		mntmBuscarCliente.addActionListener(this);

		mntmDeudores = new JMenuItem("Clientes Deudores");
		mnConsultas.add(mntmDeudores);

		mntmTicketsAbiertos = new JMenuItem("Tickets Abiertos");
		mnConsultas.add(mntmTicketsAbiertos);
		
		mntmTicketsTarjeta = new JMenuItem("Tickets Tarjeta");
		mnConsultas.add(mntmTicketsTarjeta);
		mntmTicketsAbiertos.addActionListener(this);
		mntmDeudores.addActionListener(this);
		mntmTicketsTarjeta.addActionListener(this);

		menuSistema = new JMenu("Gestion de Sistema");
		menuBar.add(menuSistema);

		menuItemBackUp = new JMenuItem("Realizar BackUp");
		menuSistema.add(menuItemBackUp);
		menuItemBackUp.addActionListener(this);

		mnMiCuenta = new JMenu("Mi Cuenta");
		mnMiCuenta.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/users.png")));
		menuBar.add(mnMiCuenta);

		mntmCambiarClave = new JMenuItem("Cambiar Clave");
		mntmCambiarClave.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/key.png")));
		mnMiCuenta.add(mntmCambiarClave);
		mntmCambiarClave.addActionListener(this);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuAdmin.class
				.getResource("/image/exit.png")));
		mnMiCuenta.add(mntmSalir);
		
		menuHelp = new JMenu("Ayuda");
		menuHelp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(menuHelp);
		
		mnAbout = new JMenuItem("System About");
		mnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuHelp.add(mnAbout);
		mnAbout.addActionListener(this);

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

		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == mntmAltaCliente) {
			new AltaCliente().setVisible(true);
		}
		if (event.getSource() == mntmBuscarCliente) {
			new BuscadorCliente().setVisible(true);
		}
		if (event.getSource() == mntmModificacionUsuario) {
			new GestionUsuario().setVisible(true);
		}
		if (event.getSource() == mntmArqueoDeCaja) {
			new ArqueoDeCaja().setVisible(true);
		}
		if (event.getSource() == mntmCambiarClave) {
			new CambioContrasenia().setVisible(true);
		}
		if (event.getSource() == mntmGestionColor) {
			new GestionColor().setVisible(true);
		}
		if (event.getSource() == mntmGestionModelo) {
			new GestionModelo().setVisible(true);
		}
		if (event.getSource() == mntmGestionTasaInteres) {
			new GestionTasaInteres().setVisible(true);
		}
		if (event.getSource() == menuItemBackUp) {
			new BackupBD().setVisible(true);
		}
		if (event.getSource() == mntmSalir) {
			new Login().setVisible(true);
			dispose();
		}
		if (event.getSource() == mntmGestionDescuento) {
			new GestionDescuento().setVisible(true);
		}
		if (event.getSource() == mntmLiquidarExpensas) {
			new EmitirLiquidacionExpensas().setVisible(true);
		}

		if (event.getSource() == mntmAnularExpensas) {
			new AnularLiquidacionExpensas().setVisible(true);
		}

		if (event.getSource() == mntmGestionTarifa) {
			new GestionTarifa().setVisible(true);
		}

		if (event.getSource() == mntmModificacionCliente) {
			new BuscadorCliente().setVisible(true);
			if (Controlador.getInstancia().getClienteActual()!= null)
			new ModificarCliente(Controlador.getInstancia().getClienteActual()).setVisible(true);
			

		}
		if (event.getSource() == mntmCobroExtraordinario) {
			new CobroExtraordinario().setVisible(true);
		}
		if (event.getSource() == mntmDeudores) {
			new VerDeudores().setVisible(true);
		}
		if (event.getSource() == mntmLiquidarAlquileres) {
			new EmitirLiquidacionAlquileres().setVisible(true);
		}
		if (event.getSource() == mntmAnularAlquileres) {
			new AnularLiquidacionAlquileres().setVisible(true);
		}
		if (event.getSource() == mntmTicketsAbiertos) {
			new TicketsAbiertos().setVisible(true);
		}
		if(event.getSource()==mntmTicketsTarjeta)
		{
			new VerTicketsAbonadosTarjeta().setVisible(true);

		}
		if(event.getSource()==mnAbout)
		{
			new About().setVisible(true);
		}
	}

}
