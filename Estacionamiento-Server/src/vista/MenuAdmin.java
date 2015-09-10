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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private JMenuItem mntmBajaCliente;
	private JMenu mnUsuario;
	private JMenuItem mntmModificacionUsuario;
	private JMenu mnGestionEstacionamiento;
	private JMenu mnColor;
	private JMenuItem mntmGestionColor;
	private JMenu mnDescuentos;
	private JMenuItem mntmAltaDescuento;
	private JMenuItem mntmModificacionDescuento;
	private JMenuItem mntmBajaModificacion;
	private JMenu mnModelo;
	private JMenuItem mntmGestionModelo;
	private JMenu mnTarifas;
	private JMenuItem mntmGestionTarifa;
	private JMenu mnTasaInteres;
	private JMenuItem mntmGestionTasaInteres;
	private JMenu mnConsultas;
	private JMenuItem mntmArqueoDeCaja;
	private JMenuItem mntmBuscarCliente;
	private JMenuItem mntmCantidadAutos;
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


		//TODO PARA MAXIMIZAR LA VENTANA
				setExtendedState(getExtendedState()| JFrame.MAXIMIZED_BOTH); 
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		mnUsuario.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/users.png")));
		
		mntmModificacionUsuario = new JMenuItem("Gestionar");
		mnUsuario.add(mntmModificacionUsuario);
		mntmModificacionUsuario.addActionListener(this);
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		mnCliente.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/paciente.png")));
		
		mntmAltaCliente = new JMenuItem("Alta");
		mnCliente.add(mntmAltaCliente);
		mntmAltaCliente.addActionListener(this);
		
		mntmModificacionCliente = new JMenuItem("Modificacion");
		mnCliente.add(mntmModificacionCliente);
		mntmModificacionCliente.addActionListener(this);
		
		mntmBajaCliente = new JMenuItem("Baja");
		mnCliente.add(mntmBajaCliente);
		mntmBajaCliente.addActionListener(this);
		
		mnGestionEstacionamiento = new JMenu("Gestion Estacionamiento");
		mnGestionEstacionamiento.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/modificar.png")));
		menuBar.add(mnGestionEstacionamiento);
		
		mnColor = new JMenu("Color");
		mnGestionEstacionamiento.add(mnColor);
		
		mntmGestionColor = new JMenuItem("Gestionar");
		mnColor.add(mntmGestionColor);
		mntmGestionColor.addActionListener(this);
	
		
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

		mnExpensas = new JMenu("Expensas");
		mnGestionEstacionamiento.add(mnExpensas);
		
		mntmLiquidarExpensas = new JMenuItem("Emitir Liquidaci\u00F3n");
		mnExpensas.add(mntmLiquidarExpensas);
		mntmLiquidarExpensas.addActionListener(this);

		mntmAnularExpensas = new JMenuItem("Anular Liquidaci\u00F3n");
		mnExpensas.add(mntmAnularExpensas);
		mntmAnularExpensas.addActionListener(this);

		mntmCobroExtraordinario = new JMenuItem("Cobro Extraordinario");
		mnGestionEstacionamiento.add(mntmCobroExtraordinario);
		mntmCobroExtraordinario.addActionListener(this);
		
		
		mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/buscar.png")));
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
		
		menuSistema = new JMenu("Gestion Sistema");
		menuBar.add(menuSistema);
		
		menuItemBackUp = new JMenuItem("Realizar BackUp");
		menuSistema.add(menuItemBackUp);
		menuItemBackUp.addActionListener(this);
		
		mnMiCuenta = new JMenu("Mi Cuenta");
		mnMiCuenta.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/users.png")));
		menuBar.add(mnMiCuenta);
		
		mntmCambiarClave = new JMenuItem("Cambiar Clave");
		mntmCambiarClave.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/key.png")));
		mnMiCuenta.add(mntmCambiarClave);
		mntmCambiarClave.addActionListener(this);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(MenuAdmin.class.getResource("/image/exit.png")));
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
		
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == mntmAltaCliente){
			new AltaCliente().setVisible(true);
		}
		if (event.getSource() == mntmBuscarCliente){
			 new BuscadorCliente().setVisible(true);
		}
		if (event.getSource() == mntmModificacionUsuario){
			 new GestionUsuario().setVisible(true);
		}
		if (event.getSource() == mntmArqueoDeCaja){
			new ArqueoDeCaja().setVisible(true);
		}
		if (event.getSource() == mntmCambiarClave){
			new CambioContrasenia().setVisible(true);
		}
		if (event.getSource() == mntmGestionColor){
			new GestionColor().setVisible(true);
		}
		if (event.getSource() == mntmGestionModelo){
			new GestionModelo().setVisible(true);
		}
		if (event.getSource() == mntmGestionTasaInteres){
			new GestionTasaInteres().setVisible(true);
		}
		if (event.getSource() == menuItemBackUp){
			new BackupBD().setVisible(true);
		}
		if (event.getSource() == mntmSalir){
			new Login().setVisible(true);
			dispose();
		}
		if(event.getSource() == mntmAltaDescuento){
			new AltaDescuento().setVisible(true);
		}
		if(event.getSource() == mntmLiquidarExpensas){
			new EmitirLiquidacionExpensas().setVisible(true);
		}
		
		if(event.getSource()==mntmAnularExpensas){
			new AnularLiquidacionExpensas().setVisible(true);
		}
		
		if(event.getSource()==mntmGestionTarifa){
			new GestionTarifa().setVisible(true);
		}
		if(event.getSource()==mntmBajaCliente){
			new BuscadorCliente().setVisible(true);
			//TODO actualizar el cliente seleccionado
			int resultado = JOptionPane.showConfirmDialog(null, "Desea borrar el cliente seleccionado?");
			if (resultado== JOptionPane.YES_OPTION){
				
			}
		}
		if(event.getSource()==mntmModificacionCliente){
			//TODO enviar el cliente seleccionado o obtenerlo del controlador
			new ModificarCliente().setVisible(true);
		}
		if(event.getSource()==mntmCobroExtraordinario){
			new CobroExtraordinario().setVisible(true);
		}
		if(event.getSource()==mntmDeudores){
			new VerDeudores().setVisible(true);
		}
		
	}

}
