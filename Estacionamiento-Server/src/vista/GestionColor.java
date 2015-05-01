package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GestionColor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JTextField textFieldAgregarColor;
	private JButton btnAgregarColor;
	private JTextField textField;
	private JButton btnModificarColor;

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
	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public GestionColor() {
		setResizable(false);
		setTitle("Gestion Color");
		setBounds(100, 100, 534, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(155, 320, 116, 32);
		contentPanel.add(aceptarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(BuscardorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(283, 320, 116, 32);
		contentPanel.add(cancelarButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 6, 307, 303);
		contentPanel.add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1 Rojo", "2 Azul", "3 Verde", "4 Amarillo", "5 Negro", "6 blanco"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		textFieldAgregarColor = new JTextField();
		textFieldAgregarColor.setBounds(325, 6, 203, 32);
		contentPanel.add(textFieldAgregarColor);
		textFieldAgregarColor.setColumns(10);
		
		btnAgregarColor = new JButton("Agregar Color");
		btnAgregarColor.setIcon(new ImageIcon(GestionColor.class.getResource("/image/plus.png")));
		btnAgregarColor.setBounds(325, 49, 203, 29);
		contentPanel.add(btnAgregarColor);
		
		textField = new JTextField();
		textField.setBounds(325, 130, 203, 32);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnModificarColor = new JButton("Modificar Color");
		btnModificarColor.setIcon(new ImageIcon(GestionColor.class.getResource("/image/plus.png")));
		btnModificarColor.setBounds(325, 170, 203, 29);
		contentPanel.add(btnModificarColor);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}
}
