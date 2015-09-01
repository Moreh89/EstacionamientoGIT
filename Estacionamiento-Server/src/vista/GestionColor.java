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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import modelo.ColorVehiculo;
import controlador.Controlador;

public class GestionColor extends JDialog implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JTextField textFieldAgregarColor;
	private JButton btnAgregarColor;
	private JTextField textFieldColorActual;
	private JButton btnModificarColor;
	private DefaultListModel<modelo.ColorVehiculo> listModel;
	private JList<ColorVehiculo> listColores;



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
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(283, 320, 116, 32);
		contentPanel.add(cancelarButton);
		cancelarButton.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 6, 307, 303);
		contentPanel.add(scrollPane);
		

		listModel = new DefaultListModel<modelo.ColorVehiculo>();
		for (modelo.ColorVehiculo colorTemp : Controlador.getInstancia().getColoresActuales()) {
			listModel.addElement(colorTemp);
		} 
		listColores= new JList(listModel);
		listColores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listColores);
		listColores.addListSelectionListener(this);
		
		textFieldAgregarColor = new JTextField();
		textFieldAgregarColor.setBounds(325, 6, 203, 32);
		contentPanel.add(textFieldAgregarColor);
		textFieldAgregarColor.setColumns(10);
		
		btnAgregarColor = new JButton("Agregar Color");
		btnAgregarColor.setIcon(new ImageIcon(GestionColor.class.getResource("/image/plus.png")));
		btnAgregarColor.setBounds(325, 49, 203, 29);
		contentPanel.add(btnAgregarColor);
		btnAgregarColor.addActionListener(this);
		
		textFieldColorActual = new JTextField();
		textFieldColorActual.setBounds(325, 130, 203, 32);
		contentPanel.add(textFieldColorActual);
		textFieldColorActual.setColumns(10);
		
		btnModificarColor = new JButton("Modificar Color");
		btnModificarColor.setIcon(new ImageIcon(GestionColor.class.getResource("/image/plus.png")));
		btnModificarColor.setBounds(325, 170, 203, 29);
		contentPanel.add(btnModificarColor);
		btnModificarColor.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==btnAgregarColor)
		{
			long codigoReturn=-1;
			codigoReturn= Controlador.getInstancia().altaColor(textFieldAgregarColor.getText().toString());
			if(codigoReturn == -1)
			{
				JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Color",JOptionPane.INFORMATION_MESSAGE);
			}
			if(codigoReturn >= 0)
			{
				JOptionPane.showMessageDialog(null, "Color generado correctamente", "Gestion Color", JOptionPane.INFORMATION_MESSAGE);
			}
			dispose();
		}
		if(event.getSource()==btnModificarColor)
		{
			if(!textFieldColorActual.getText().toString().isEmpty())
			{
				long codigoReturn=-1;
				modelo.ColorVehiculo colorAct=(ColorVehiculo) listColores.getSelectedValue();
				colorAct.setDescripcion(textFieldColorActual.getText().toString());
				codigoReturn= Controlador.getInstancia().modificarColor(colorAct);
				
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Color",JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Color actualizado correctamente", "Gestion Color", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listColores){
			ColorVehiculo colorSeleccionado = (ColorVehiculo) this.listColores.getSelectedValue();
			textFieldColorActual.setText(colorSeleccionado.getDescripcion());
		}		
	}
}
