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
import modelo.ModeloVehiculo;
import controlador.Controlador;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

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
	private JList<ModeloVehiculo> listModelos;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblModeloNuevo;
	private JLabel lblModeloSeleccionado;
	private JLabel lblDescripcin;
	private JLabel label;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GestionModelo() {
		setResizable(false);
		setTitle("Gesti\u00F3n Modelo");
		setBounds(100, 100, 625, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{265, 30, 0, 203, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 35, 32, 29, 52, 32, 55, 10, 32, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{70, 86, 0};
		gbl_panel.rowHeights = new int[]{30, 35, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblModeloNuevo = new JLabel("Modelo Nuevo");
		lblModeloNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblModeloNuevo = new GridBagConstraints();
		gbc_lblModeloNuevo.insets = new Insets(0, 0, 5, 0);
		gbc_lblModeloNuevo.gridx = 1;
		gbc_lblModeloNuevo.gridy = 0;
		panel.add(lblModeloNuevo, gbc_lblModeloNuevo);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 1;
		panel.add(lblDescripcin, gbc_lblDescripcin);
		
		textFieldAgregarModelo = new JTextField();
		GridBagConstraints gbc_textFieldAgregarModelo = new GridBagConstraints();
		gbc_textFieldAgregarModelo.fill = GridBagConstraints.BOTH;
		gbc_textFieldAgregarModelo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAgregarModelo.gridx = 1;
		gbc_textFieldAgregarModelo.gridy = 1;
		panel.add(textFieldAgregarModelo, gbc_textFieldAgregarModelo);
		textFieldAgregarModelo.setColumns(10);
		
		btnAgregarModelo = new JButton("Agregar Modelo");
		GridBagConstraints gbc_btnAgregarModelo = new GridBagConstraints();
		gbc_btnAgregarModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregarModelo.gridx = 1;
		gbc_btnAgregarModelo.gridy = 2;
		panel.add(btnAgregarModelo, gbc_btnAgregarModelo);
		btnAgregarModelo.setIcon(new ImageIcon(GestionModelo.class.getResource("/image/plus.png")));
		btnAgregarModelo.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);

		listModel = new DefaultListModel<modelo.ModeloVehiculo>();
		for (modelo.ModeloVehiculo modeloTemp : Controlador.getInstancia().getModelosActuales()) {
			listModel.addElement(modeloTemp);
		} 
		listModelos= new JList(listModel);
		listModelos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listModelos);
		listModelos.addListSelectionListener(this);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 4;
		contentPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{70, 0, 0};
		gbl_panel_1.rowHeights = new int[]{30, 35, 35, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblModeloSeleccionado = new JLabel(" Modelo Seleccionado");
		lblModeloSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblModeloSeleccionado = new GridBagConstraints();
		gbc_lblModeloSeleccionado.insets = new Insets(0, 0, 5, 0);
		gbc_lblModeloSeleccionado.gridx = 1;
		gbc_lblModeloSeleccionado.gridy = 0;
		panel_1.add(lblModeloSeleccionado, gbc_lblModeloSeleccionado);
		
		label = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel_1.add(label, gbc_label);
		
		textFieldModeloActual = new JTextField();
		GridBagConstraints gbc_textFieldModeloActual = new GridBagConstraints();
		gbc_textFieldModeloActual.fill = GridBagConstraints.BOTH;
		gbc_textFieldModeloActual.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldModeloActual.gridx = 1;
		gbc_textFieldModeloActual.gridy = 1;
		panel_1.add(textFieldModeloActual, gbc_textFieldModeloActual);
		textFieldModeloActual.setColumns(10);
		
		btnModificarModelo = new JButton("Modificar Modelo");
		GridBagConstraints gbc_btnModificarModelo = new GridBagConstraints();
		gbc_btnModificarModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificarModelo.gridx = 1;
		gbc_btnModificarModelo.gridy = 2;
		panel_1.add(btnModificarModelo, gbc_btnModificarModelo);
		btnModificarModelo.setIcon(new ImageIcon(GestionModelo.class.getResource("/image/modificar.png")));
		btnModificarModelo.addActionListener(this);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionModelo.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.anchor = GridBagConstraints.SOUTH;
		gbc_aceptarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_aceptarButton.insets = new Insets(0, 0, 5, 0);
		gbc_aceptarButton.gridx = 3;
		gbc_aceptarButton.gridy = 6;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelarButton.gridx = 3;
		gbc_cancelarButton.gridy = 8;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		


		
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
