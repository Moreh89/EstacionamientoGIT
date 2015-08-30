package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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

import modelo.LiquidacionExpensas;
import controlador.Controlador;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class AnularLiquidacionExpensas extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton anularButton;
	private JButton cancelarButton;
	private DefaultListModel<LiquidacionExpensas> listModel;
	private JList listLiquidaciones;



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
	public AnularLiquidacionExpensas() {
		setResizable(false);
		setTitle("Anular Liquidacion de Expensas");
		setBounds(100, 100, 481, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{50, 200, 200, 50, 0};
		gbl_contentPanel.rowHeights = new int[]{234, 35, 50, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		listModel = new DefaultListModel<modelo.LiquidacionExpensas>();
		for (modelo.LiquidacionExpensas liquidacionTemp : Controlador.getInstancia().getLiquidacionesRecientes()) {
			listModel.addElement(liquidacionTemp);
		} 		
		
		listLiquidaciones= new JList(listModel);
		listLiquidaciones.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listLiquidaciones);
		//						listLiquidaciones.addListSelectionListener(this);

		anularButton = new JButton("Anular Liquidacion");
		anularButton.setIcon(new ImageIcon(GestionColor.class.getResource("/image/ok.png")));
		GridBagConstraints gbc_anularButton = new GridBagConstraints();
		gbc_anularButton.fill = GridBagConstraints.VERTICAL;
		gbc_anularButton.insets = new Insets(0, 0, 5, 5);
		gbc_anularButton.gridx = 1;
		gbc_anularButton.gridy = 2;
		contentPanel.add(anularButton, gbc_anularButton);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 5, 5);
		gbc_cancelarButton.fill = GridBagConstraints.VERTICAL;
		gbc_cancelarButton.gridx = 2;
		gbc_cancelarButton.gridy = 2;
		contentPanel.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(this);



		this.setLocationRelativeTo(null);
		setModal(true);


	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==cancelarButton)
		{
			dispose();
		}
		if(event.getSource()==anularButton)
		{
			dispose();
		}
	}

	//	@Override
	//	public void valueChanged(ListSelectionEvent e) {
	//		if(e.getSource() == this.listLiquidaciones){
	//			LiquidacionExpensas liquidacionSeleccionado = (LiquidacionExpensas) this.listLiquidaciones.getSelectedValue();
	//			textFieldLiquidacionActual.setText(new SimpleDateFormat("yyyy_MM_dd").format(liquidacionSeleccionado.getFechaEmision()));
	//		}		
	//	}
}
