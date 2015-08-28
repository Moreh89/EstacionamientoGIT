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
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import modelo.ModeloVehiculo;
import controlador.Controlador;

public class GestionModelo extends JDialog implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton aceptarButton;
	private JButton cancelarButton;
	private JTextField textFieldAgregarModelo;
	private JButton btnAgregarModelo;
	private JTextField textFieldModeloActual;
	private JButton btnModificarModelo;
	private DefaultListModel<modelo.ModeloVehiculo> listModel;
	private JList listModelos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionModelo dialog = new GestionModelo();
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
	public GestionModelo() {
		setResizable(false);
		setTitle("Gestion Modelo");
		setBounds(100, 100, 534, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionModelo.class.getResource("/image/ok.png")));
		aceptarButton.setBounds(155, 320, 116, 32);
		contentPanel.add(aceptarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		cancelarButton.setBounds(283, 320, 116, 32);
		contentPanel.add(cancelarButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 49, 307, 260);
		contentPanel.add(scrollPane);
		


		listModel = new DefaultListModel<modelo.ModeloVehiculo>();
		for (modelo.ModeloVehiculo modeloTemp : Controlador.getInstancia().getModelosActuales()) {
			listModel.addElement(modeloTemp);
		} 
		listModelos= new JList(listModel);
		listModelos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listModelos);
		listModelos.addListSelectionListener(this);
		
		textFieldAgregarModelo = new JTextField();
		textFieldAgregarModelo.setBounds(325, 82, 203, 32);
		contentPanel.add(textFieldAgregarModelo);
		textFieldAgregarModelo.setColumns(10);
		
		btnAgregarModelo = new JButton("Agregar Modelo");
		btnAgregarModelo.setIcon(new ImageIcon(GestionModelo.class.getResource("/image/plus.png")));
		btnAgregarModelo.setBounds(325, 125, 203, 29);
		contentPanel.add(btnAgregarModelo);
		btnAgregarModelo.addActionListener(this);
		
		textFieldModeloActual = new JTextField();
		textFieldModeloActual.setBounds(325, 206, 203, 32);
		contentPanel.add(textFieldModeloActual);
		textFieldModeloActual.setColumns(10);
		
		btnModificarModelo = new JButton("Modificar Modelo");
		btnModificarModelo.setIcon(new ImageIcon(GestionModelo.class.getResource("/image/modificar.png")));
		btnModificarModelo.setBounds(325, 246, 203, 29);
		contentPanel.add(btnModificarModelo);
		btnModificarModelo.addActionListener(this);
		
		this.setLocationRelativeTo(null);
		setModal(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==btnAgregarModelo)
		{
			long codigoReturn=-1;
			codigoReturn= Controlador.getInstancia().altaModelo(textFieldAgregarModelo.getText().toString());
			if(codigoReturn == -1)
			{
				JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Modelo",JOptionPane.INFORMATION_MESSAGE);
			}
			if(codigoReturn >= 0)
			{
				JOptionPane.showMessageDialog(null, "Modelo generado correctamente", "Gestion Modelo", JOptionPane.INFORMATION_MESSAGE);
			}
			dispose();
		}
		if(event.getSource()==btnModificarModelo)
		{
			if(!textFieldModeloActual.getText().toString().isEmpty())
			{
				long codigoReturn=-1;
				modelo.ModeloVehiculo modeloAct=(ModeloVehiculo) listModelos.getSelectedValue();
				modeloAct.setDescripcion(textFieldModeloActual.getText().toString());
				codigoReturn= Controlador.getInstancia().modificarModelo(modeloAct);
				
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Modelo",JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Modelo actualizado correctamente", "Gestion Modelo", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		}
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listModelos){
			modelo.ModeloVehiculo modeloSeleccionado = (ModeloVehiculo) this.listModelos.getSelectedValue();
			textFieldModeloActual.setText(modeloSeleccionado.getDescripcion());
		}			
	}
}
