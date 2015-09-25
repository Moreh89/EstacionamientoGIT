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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

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
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblDescripcinColorNuevo;
	private JLabel lblDescripcinColorSeleccionado;
	private JLabel lblDescripcin;
	private JLabel lblDescripcin_1;



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
		setTitle("Gesti\u00F3n Color");
		setBounds(100, 100, 612, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{265, 30, 0, 203, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 32, 29, 45, 32, 29, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.gridheight = 10;
				gbc_scrollPane.gridwidth = 2;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				contentPanel.add(scrollPane, gbc_scrollPane);
				listColores= new JList(listModel);
				listColores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				scrollPane.setViewportView(listColores);
				listColores.addListSelectionListener(this);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 215, 0};
		gbl_panel.rowHeights = new int[]{30, 35, 35, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblDescripcinColorNuevo = new JLabel("Color Nuevo");
		lblDescripcinColorNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDescripcinColorNuevo = new GridBagConstraints();
		gbc_lblDescripcinColorNuevo.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescripcinColorNuevo.gridx = 1;
		gbc_lblDescripcinColorNuevo.gridy = 0;
		panel.add(lblDescripcinColorNuevo, gbc_lblDescripcinColorNuevo);
		
		lblDescripcin_1 = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_lblDescripcin_1 = new GridBagConstraints();
		gbc_lblDescripcin_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin_1.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin_1.gridx = 0;
		gbc_lblDescripcin_1.gridy = 1;
		panel.add(lblDescripcin_1, gbc_lblDescripcin_1);
		
		textFieldAgregarColor = new JTextField();
		GridBagConstraints gbc_textFieldAgregarColor = new GridBagConstraints();
		gbc_textFieldAgregarColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAgregarColor.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAgregarColor.gridx = 1;
		gbc_textFieldAgregarColor.gridy = 1;
		panel.add(textFieldAgregarColor, gbc_textFieldAgregarColor);
		textFieldAgregarColor.setColumns(10);
		
		btnAgregarColor = new JButton("Agregar Color");
		GridBagConstraints gbc_btnAgregarColor = new GridBagConstraints();
		gbc_btnAgregarColor.anchor = GridBagConstraints.NORTH;
		gbc_btnAgregarColor.gridx = 1;
		gbc_btnAgregarColor.gridy = 2;
		panel.add(btnAgregarColor, gbc_btnAgregarColor);
		btnAgregarColor.setIcon(new ImageIcon(GestionColor.class.getResource("/image/plus.png")));
		btnAgregarColor.addActionListener(this);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 5;
		contentPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 217, 0};
		gbl_panel_1.rowHeights = new int[]{30, 35, 35, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblDescripcinColorSeleccionado = new JLabel("Color Seleccionado");
		lblDescripcinColorSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDescripcinColorSeleccionado = new GridBagConstraints();
		gbc_lblDescripcinColorSeleccionado.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescripcinColorSeleccionado.gridx = 1;
		gbc_lblDescripcinColorSeleccionado.gridy = 0;
		panel_1.add(lblDescripcinColorSeleccionado, gbc_lblDescripcinColorSeleccionado);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 1;
		panel_1.add(lblDescripcin, gbc_lblDescripcin);
		
		textFieldColorActual = new JTextField();
		GridBagConstraints gbc_textFieldColorActual = new GridBagConstraints();
		gbc_textFieldColorActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldColorActual.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldColorActual.anchor = GridBagConstraints.NORTH;
		gbc_textFieldColorActual.gridx = 1;
		gbc_textFieldColorActual.gridy = 1;
		panel_1.add(textFieldColorActual, gbc_textFieldColorActual);
		textFieldColorActual.setColumns(10);
		
		btnModificarColor = new JButton("Modificar Color");
		GridBagConstraints gbc_btnModificarColor = new GridBagConstraints();
		gbc_btnModificarColor.gridx = 1;
		gbc_btnModificarColor.gridy = 2;
		panel_1.add(btnModificarColor, gbc_btnModificarColor);
		btnModificarColor.setIcon(new ImageIcon(GestionColor.class.getResource("/image/modificar.png")));
		btnModificarColor.addActionListener(this);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_aceptarButton = new GridBagConstraints();
		gbc_aceptarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_aceptarButton.insets = new Insets(0, 0, 5, 0);
		gbc_aceptarButton.gridx = 3;
		gbc_aceptarButton.gridy = 7;
		contentPanel.add(aceptarButton, gbc_aceptarButton);
		
		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelarButton.gridx = 3;
		gbc_cancelarButton.gridy = 9;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);
		

		listModel = new DefaultListModel<modelo.ColorVehiculo>();
		for (modelo.ColorVehiculo colorTemp : Controlador.getInstancia().getColoresActuales()) {
			listModel.addElement(colorTemp);
		} 
		
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
