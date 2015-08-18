package vista;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controlador.Controlador;

import javax.swing.JPasswordField;

import modelo.Usuario;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import junit.framework.Test;

import java.awt.event.KeyAdapter;




public class Login extends javax.swing.JDialog implements ActionListener, KeyListener{


	private static final long serialVersionUID = 1L;

	private JLabel jLabel1;
	private JLabel jLabel_Usuario;
	private JLabel jLabel_contrasenia;
	private JLabel jLabel5;
	private JSeparator jSeparator2;
	private JButton aceptarButton;
	private JButton cancelButton;
	private JPasswordField passwordText;
	private JTextField usuarioText;
	private JLabel lblEstacionamiento;
	private BufferedImage image1;
	private JLabel lblNewLabel;
	private BufferedImage image;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setVisible(true);
			}
		});
	}
	
	public Login() {
		super();
		setResizable(false);
		initGUI();
	}
	
	

	
	@SuppressWarnings("serial")
	private void initGUI() {
		try {
			
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
					getContentPane().setLayout(null);
				
					jLabel1 = new JLabel();
					jLabel1.setBounds(273, 83, 157, 128);
					getContentPane().add(jLabel1);
					
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/login.png")));
				
				
					jLabel_Usuario = new JLabel();
					jLabel_Usuario.setBounds(25, 89, 82, 14);
					jLabel_Usuario.setForeground(Color.WHITE);
					jLabel_Usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
					getContentPane().add(jLabel_Usuario);
					jLabel_Usuario.setText("Usuario");
				
				
					jLabel_contrasenia = new JLabel();
					jLabel_contrasenia.setBounds(25, 151, 82, 14);
					jLabel_contrasenia.setForeground(Color.WHITE);
					jLabel_contrasenia.setFont(new Font("Tahoma", Font.BOLD, 11));
					getContentPane().add(jLabel_contrasenia);
					jLabel_contrasenia.setText("Contrase\u00F1a");
				
				

					
					image = ImageIO.read(Test.class.getClassLoader().getResource("image/user_16.png"));
					usuarioText = new JTextField() {

						private static final long serialVersionUID = 1L;

						protected void paintComponent(Graphics g) {
					        super.paintComponent(g);
					        int centerPoint = (getHeight() - image.getHeight())/2;
					        g.drawImage(image, 0, centerPoint, this);
					    }
					};
					usuarioText.setBounds(25, 114, 228, 26);
					
					usuarioText.setMargin(new Insets(0, image.getWidth(), 0, 0));
					getContentPane().add(usuarioText);
					usuarioText.addKeyListener(this);
				
					image1 = ImageIO.read(Test.class.getClassLoader().getResource("image/key_16.png"));
					passwordText = new JPasswordField(){
						protected void paintComponent(Graphics g) {
					        super.paintComponent(g);
					        int centerPoint = (getHeight() - image1.getHeight())/2;
					        g.drawImage(image1, 0, centerPoint, this);
					    }
					};
					passwordText.setBounds(25, 170, 228, 26);
					passwordText.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent evt) {
							if(evt.getKeyCode() == KeyEvent.VK_ENTER){
								
							}
						}
					});
					passwordText.setMargin(new Insets(0, image1.getWidth(), 0, 0));
					getContentPane().add(passwordText);
					passwordText.addKeyListener(this);
				
					cancelButton = new JButton();
					cancelButton.setBounds(226, 246, 118, 32);
					getContentPane().add(cancelButton);
					cancelButton.setText("Cancelar");
					cancelButton.setMnemonic(KeyEvent.VK_C);
					cancelButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/cancel.png")));
					cancelButton.setFont(new java.awt.Font("Tahoma",1,11));
					cancelButton.addActionListener(this);
				
				
					aceptarButton = new JButton();
					aceptarButton.setBounds(54, 246, 123, 32);
					getContentPane().add(aceptarButton);
					aceptarButton.setText("Aceptar");
					aceptarButton.setMnemonic(KeyEvent.VK_A);
					aceptarButton.setFont(new java.awt.Font("Tahoma",1,11));
					aceptarButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("image/ok.png")));
					aceptarButton.addActionListener(this);
				
				
					jSeparator2 = new JSeparator();
					jSeparator2.setBounds(0, 222, 401, 10);
					getContentPane().add(jSeparator2);
				
			
			
					lblNewLabel = new JLabel("Sistema de Estacionamiento");
					lblNewLabel.setBounds(97, 303, 218, 14);
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
					getContentPane().add(lblNewLabel);

					lblEstacionamiento = new JLabel("Estacionamiento");
					lblEstacionamiento.setBounds(50, 11, 350, 67);
					lblEstacionamiento.setForeground(new Color(255, 255, 255));
					lblEstacionamiento.setFont(new Font("Tahoma", Font.BOLD, 40));
					getContentPane().add(lblEstacionamiento);
			
	
					jLabel5 = new JLabel();
					jLabel5.setBounds(0, 0, 420, 385);
					getContentPane().add(jLabel5);
					jLabel5.setIcon(new ImageIcon(Login.class.getResource("/image/blue-energy.jpg")));

		
			
					this.setTitle("Login");
					this.setSize(419, 366);
					this.setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == this.aceptarButton ){
			
			if (usuarioText.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Debe Ingresar un usuario", "Login", JOptionPane.INFORMATION_MESSAGE);
			}else
				if (passwordText.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Debe Ingresar una contraseña", "Login", JOptionPane.INFORMATION_MESSAGE);
				}else{
					
					boolean con = Controlador.getInstancia().cargaInicial();
					
					if (con == false){
						JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con la Base de Datos, consulte con el Administrador del Sistema", "Login", JOptionPane.ERROR_MESSAGE);
					}else{
						//Aqui guardo el usuario actual del sistema
						boolean validar = Controlador.getInstancia().validarLogin(usuarioText.getText(), passwordText.getText());
						
						if (validar == true){
							
							//DIFERENCIA ENTRE USUARIO ADMIN Y OPERADOR

							if(Controlador.getInstancia().getUsuarioActual().getPermisos().equals(Usuario.PERMISOS.ADMIN))
							{
								MenuAdmin mpc = new MenuAdmin ();
								mpc.setVisible(true);
								dispose();
							}
							if(Controlador.getInstancia().getUsuarioActual().getPermisos().equals(Usuario.PERMISOS.CAJA))
							{
								MenuOperador mop = new MenuOperador ();
								mop.setVisible(true);
								dispose();
							}
							
							
						}else{
							JOptionPane.showMessageDialog(null, "Usuario y Contraseña Invalidos", "Login", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
				}
		}
		else if(event.getSource() == this.cancelButton)
		{
			System.exit(0);
		}
		
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent event) {
		
		
		//INTRO
		if (event.getKeyCode()== KeyEvent.VK_ENTER && !usuarioText.getText().equalsIgnoreCase("") && !passwordText.getText().equalsIgnoreCase("")){
			this.aceptarButton.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}
		
	
}
