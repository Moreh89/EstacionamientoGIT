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

import modelo.Descuento;
import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ResourceBundle.Control;

public class GestionDescuento extends JDialog implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JTextField textFieldAgregarDescuentoDescripcion;
	private JButton btnAgregarDescuento;
	private JTextField textFieldNombreDescuentoActual;
	private JButton btnModificarDescuento;
	private DefaultListModel<modelo.Descuento> listModel;
	private JList<Descuento> listDescuentos;
	private JButton btnEliminarDescuento;
	private JPanel panel;
	private JLabel lblNombre;
	private JLabel lblMonto;
	private JLabel lblNuevoDescuento;
	private JTextField textFieldAgregarDescuentoPorcentaje;
	private JPanel panel_1;
	private JLabel labelPorcentajeActual;
	private JTextField textFieldPorcentajeDescuentoActual;
	private JLabel lblModificarDescuento;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionDescuento dialog = new GestionDescuento();
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
	public GestionDescuento() {
		setResizable(false);
		setTitle("Gestion Descuento");
		setBounds(100, 100, 624, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{265, 30, 0, 203, 0};
		gbl_contentPanel.rowHeights = new int[]{32, 30, 50, 52, 32, 30, 0, 65, 0, 30, 0, 32, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridheight = 12;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		listModel = new DefaultListModel<modelo.Descuento>();
		for (modelo.Descuento descuentoTemp : Controlador.getInstancia().getDescuentosActuales()) {
			listModel.addElement(descuentoTemp);
		} 
		listDescuentos= new JList(listModel);
		listDescuentos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listDescuentos);
		listDescuentos.addListSelectionListener(this);

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
		gbl_panel.columnWidths = new int[]{85, 153, 0};
		gbl_panel.rowHeights = new int[]{40, 30, 30, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		lblNuevoDescuento = new JLabel("Nuevo Descuento");
		lblNuevoDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNuevoDescuento = new GridBagConstraints();
		gbc_lblNuevoDescuento.gridwidth = 2;
		gbc_lblNuevoDescuento.insets = new Insets(0, 0, 5, 0);
		gbc_lblNuevoDescuento.gridx = 0;
		gbc_lblNuevoDescuento.gridy = 0;
		panel.add(lblNuevoDescuento, gbc_lblNuevoDescuento);

		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);

		textFieldAgregarDescuentoDescripcion = new JTextField();
		GridBagConstraints gbc_textFieldAgregarDescuentoDescripcion = new GridBagConstraints();
		gbc_textFieldAgregarDescuentoDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textFieldAgregarDescuentoDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAgregarDescuentoDescripcion.gridx = 1;
		gbc_textFieldAgregarDescuentoDescripcion.gridy = 1;
		panel.add(textFieldAgregarDescuentoDescripcion, gbc_textFieldAgregarDescuentoDescripcion);
		textFieldAgregarDescuentoDescripcion.setColumns(10);

		lblMonto = new JLabel("Porcentaje:");
		GridBagConstraints gbc_lblMonto = new GridBagConstraints();
		gbc_lblMonto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonto.gridx = 0;
		gbc_lblMonto.gridy = 2;
		panel.add(lblMonto, gbc_lblMonto);

		textFieldAgregarDescuentoPorcentaje = new JTextField();
		GridBagConstraints gbc_textFieldAgregarDescuentoPorcentaje = new GridBagConstraints();
		gbc_textFieldAgregarDescuentoPorcentaje.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAgregarDescuentoPorcentaje.fill = GridBagConstraints.BOTH;
		gbc_textFieldAgregarDescuentoPorcentaje.gridx = 1;
		gbc_textFieldAgregarDescuentoPorcentaje.gridy = 2;
		panel.add(textFieldAgregarDescuentoPorcentaje, gbc_textFieldAgregarDescuentoPorcentaje);
		textFieldAgregarDescuentoPorcentaje.setColumns(10);

		btnAgregarDescuento = new JButton("Agregar Descuento");
		GridBagConstraints gbc_btnAgregarDescuento = new GridBagConstraints();
		gbc_btnAgregarDescuento.anchor = GridBagConstraints.NORTH;
		gbc_btnAgregarDescuento.gridx = 1;
		gbc_btnAgregarDescuento.gridy = 3;
		panel.add(btnAgregarDescuento, gbc_btnAgregarDescuento);
		btnAgregarDescuento.setIcon(new ImageIcon(GestionDescuento.class.getResource("/image/plus.png")));
		btnAgregarDescuento.addActionListener(this);

		panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 4;
		contentPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{85, 153, 0};
		gbl_panel_1.rowHeights = new int[] {40, 30, 30, 20, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		lblModificarDescuento = new JLabel("Descuento Seleccionado");
		lblModificarDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblModificarDescuento = new GridBagConstraints();
		gbc_lblModificarDescuento.gridwidth = 2;
		gbc_lblModificarDescuento.insets = new Insets(0, 0, 5, 0);
		gbc_lblModificarDescuento.gridx = 0;
		gbc_lblModificarDescuento.gridy = 0;
		panel_1.add(lblModificarDescuento, gbc_lblModificarDescuento);

		JLabel labelNombreActual = new JLabel("Nombre:");
		GridBagConstraints gbc_labelNombreActual = new GridBagConstraints();
		gbc_labelNombreActual.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombreActual.gridx = 0;
		gbc_labelNombreActual.gridy = 1;
		panel_1.add(labelNombreActual, gbc_labelNombreActual);

		textFieldNombreDescuentoActual = new JTextField();
		GridBagConstraints gbc_textFieldNombreDescuentoActual = new GridBagConstraints();
		gbc_textFieldNombreDescuentoActual.fill = GridBagConstraints.BOTH;
		gbc_textFieldNombreDescuentoActual.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombreDescuentoActual.gridx = 1;
		gbc_textFieldNombreDescuentoActual.gridy = 1;
		panel_1.add(textFieldNombreDescuentoActual, gbc_textFieldNombreDescuentoActual);
		textFieldNombreDescuentoActual.setColumns(10);

		labelPorcentajeActual = new JLabel("Porcentaje:");
		GridBagConstraints gbc_labelPorcentajeActual = new GridBagConstraints();
		gbc_labelPorcentajeActual.insets = new Insets(0, 0, 5, 5);
		gbc_labelPorcentajeActual.gridx = 0;
		gbc_labelPorcentajeActual.gridy = 2;
		panel_1.add(labelPorcentajeActual, gbc_labelPorcentajeActual);

		textFieldPorcentajeDescuentoActual = new JTextField();
		GridBagConstraints gbc_textFieldPorcentajeDescuentoActual = new GridBagConstraints();
		gbc_textFieldPorcentajeDescuentoActual.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPorcentajeDescuentoActual.fill = GridBagConstraints.BOTH;
		gbc_textFieldPorcentajeDescuentoActual.gridx = 1;
		gbc_textFieldPorcentajeDescuentoActual.gridy = 2;
		panel_1.add(textFieldPorcentajeDescuentoActual, gbc_textFieldPorcentajeDescuentoActual);
		textFieldPorcentajeDescuentoActual.setColumns(10);

		btnModificarDescuento = new JButton("Modificar Descuento");
		GridBagConstraints gbc_btnModificarDescuento = new GridBagConstraints();
		gbc_btnModificarDescuento.anchor = GridBagConstraints.NORTH;
		gbc_btnModificarDescuento.gridx = 1;
		gbc_btnModificarDescuento.gridy = 3;
		panel_1.add(btnModificarDescuento, gbc_btnModificarDescuento);
		btnModificarDescuento.setIcon(new ImageIcon(GestionDescuento.class.getResource("/image/modificar.png")));
		btnModificarDescuento.addActionListener(this);

		btnEliminarDescuento = new JButton("Eliminar Descuento");
		btnEliminarDescuento.setIcon(new ImageIcon(GestionDescuento.class.getResource("/image/menos.png")));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 9;
		contentPanel.add(btnEliminarDescuento, gbc_btnEliminar);
		btnEliminarDescuento.addActionListener(this);

		btnSalir = new JButton("Volver");
		btnSalir.setIcon(new ImageIcon(GestionDescuento.class.getResource("/image/izq.png")));
		GridBagConstraints gbc_SalirButton = new GridBagConstraints();
		gbc_SalirButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SalirButton.gridx = 3;
		gbc_SalirButton.gridy = 11;
		contentPanel.add(btnSalir, gbc_SalirButton);
		btnSalir.addActionListener(this);


	

		this.setLocationRelativeTo(null);
		setModal(true);


	}
//TODO CHECKEAR PORCENTAJES (SACAR VALIDACIONES DE INTERES)
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==btnAgregarDescuento)
		{
			long codigoReturn=-1;
			codigoReturn= Controlador.getInstancia().altaDescuento(textFieldAgregarDescuentoDescripcion.getText(), Double.parseDouble(textFieldAgregarDescuentoPorcentaje.getText()));
			if(codigoReturn == -1)
			{
				JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Descuento",JOptionPane.INFORMATION_MESSAGE);
			}
			if(codigoReturn >= 0)
			{
				JOptionPane.showMessageDialog(null, "Descuento generado correctamente", "Gestion Descuento", JOptionPane.INFORMATION_MESSAGE);
			}
			dispose();
		}
		if(event.getSource()==btnModificarDescuento)
		{
			if(!textFieldNombreDescuentoActual.getText().isEmpty() &&
					!textFieldPorcentajeDescuentoActual.getText().isEmpty() &&
					isNumeric(textFieldPorcentajeDescuentoActual.getText()))
			{
				long codigoReturn=-1;
				codigoReturn=Controlador.getInstancia().modificarDescuento(textFieldNombreDescuentoActual.getText(), Double.parseDouble(textFieldPorcentajeDescuentoActual.getText()),(modelo.Descuento)this.listDescuentos.getSelectedValue());
				if(codigoReturn == -1)
				{
					JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Descuento",JOptionPane.INFORMATION_MESSAGE);
				}
				if(codigoReturn >= 0)
				{
					JOptionPane.showMessageDialog(null, "Descuento actualizado correctamente", "Gestion Descuento", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		}
		if(event.getSource()==btnEliminarDescuento)
		{
			long codigoReturn=Controlador.getInstancia().deshabilitarDescuento(listDescuentos.getSelectedValue().getIdDescuento());
			
			if(codigoReturn==-1)
			{
				JOptionPane.showMessageDialog(null,  "Se produjo un error, intente nuevamente.", "Gestion Descuento",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Descuento eliminado correctamente", "Gestion Descuento", JOptionPane.INFORMATION_MESSAGE);
			}
			dispose();
		}
		if(event.getSource()==btnSalir)
		{
			dispose();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == this.listDescuentos){
			modelo.Descuento descuentoSeleccionado = (modelo.Descuento) this.listDescuentos.getSelectedValue();
			textFieldNombreDescuentoActual.setText(descuentoSeleccionado.getDescripcion());
			textFieldPorcentajeDescuentoActual.setText(Double.toString(descuentoSeleccionado.getDescuento()));
		}		
	}

	private static boolean isNumeric(String str)  
	{  
		try  
		{  
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}
}
