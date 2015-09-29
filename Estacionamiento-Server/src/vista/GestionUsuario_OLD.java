package vista;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;

@SuppressWarnings("rawtypes")
public class GestionUsuario_OLD extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUserNameSearch;
	private DefaultTableModel model;
	private JScrollPane scrollPane;


	private TableRowSorter<TableModel> sorter;
	private JTextField textFieldUserName;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNumeroDocumento;

	public GestionUsuario_OLD() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initGUI();
	}



	public void initGUI(){
		setTitle("Gestión Usuarios");
		setResizable(false);
		setBounds(100, 100, 828, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{120, 120, 120, 5, 0, 0};
		gbl_contentPane.rowHeights = new int[]{32, 6, 225, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		textFieldUserNameSearch = new JTextField();
		GridBagConstraints gbc_textFieldUserNameSearch = new GridBagConstraints();
		gbc_textFieldUserNameSearch.gridwidth = 2;
		gbc_textFieldUserNameSearch.anchor = GridBagConstraints.SOUTH;
		gbc_textFieldUserNameSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserNameSearch.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserNameSearch.gridx = 0;
		gbc_textFieldUserNameSearch.gridy = 0;
		contentPane.add(textFieldUserNameSearch, gbc_textFieldUserNameSearch);
		textFieldUserNameSearch.setColumns(10);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
		gbc_lblNombreUsuario.gridwidth = 2;
		gbc_lblNombreUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreUsuario.gridx = 0;
		gbc_lblNombreUsuario.gridy = 0;
		contentPane.add(lblNombreUsuario, gbc_lblNombreUsuario);


		JButton buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();

			}
		});
		GridBagConstraints gbc_buscarButton = new GridBagConstraints();
		gbc_buscarButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarButton.insets = new Insets(0, 0, 5, 5);
		gbc_buscarButton.gridx = 2;
		gbc_buscarButton.gridy = 0;
		contentPane.add(buscarButton, gbc_buscarButton);
		buscarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/search.png")));

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridwidth = 3;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{120, 210, 30, 0};
		gbl_panel_1.rowHeights = new int[]{40, 40, 32, 32, 32, 32, 32, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
		gbc_lblNombreDeUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeUsuario.gridx = 0;
		gbc_lblNombreDeUsuario.gridy = 1;
		panel_1.add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);

		textFieldUserName = new JTextField();
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 1;
		panel_1.add(textFieldUserName, gbc_textFieldUserName);
		textFieldUserName.setFocusable(false);
		textFieldUserName.setEnabled(false);
		textFieldUserName.setEditable(false);
		textFieldUserName.setColumns(10);

		JLabel lblTipoUsuario = new JLabel("Tipo Usuario:");
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 0;
		gbc_lblTipoUsuario.gridy = 2;
		panel_1.add(lblTipoUsuario, gbc_lblTipoUsuario);

		JComboBox comboBoxPermisos = new JComboBox();
		GridBagConstraints gbc_comboBoxPermisos = new GridBagConstraints();
		gbc_comboBoxPermisos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPermisos.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPermisos.gridx = 1;
		gbc_comboBoxPermisos.gridy = 2;
		panel_1.add(comboBoxPermisos, gbc_comboBoxPermisos);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		panel_1.add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 3;
		panel_1.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 4;
		panel_1.add(lblApellido, gbc_lblApellido);

		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 4;
		panel_1.add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);

		JLabel lblTipoDocumento = new JLabel("Tipo Documento:");
		GridBagConstraints gbc_lblTipoDocumento = new GridBagConstraints();
		gbc_lblTipoDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDocumento.gridx = 0;
		gbc_lblTipoDocumento.gridy = 5;
		panel_1.add(lblTipoDocumento, gbc_lblTipoDocumento);

		JComboBox comboBoxTipoDocumento = new JComboBox();
		GridBagConstraints gbc_comboBoxTipoDocumento = new GridBagConstraints();
		gbc_comboBoxTipoDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTipoDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoDocumento.gridx = 1;
		gbc_comboBoxTipoDocumento.gridy = 5;
		panel_1.add(comboBoxTipoDocumento, gbc_comboBoxTipoDocumento);

		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		GridBagConstraints gbc_lblNumeroDocumento = new GridBagConstraints();
		gbc_lblNumeroDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDocumento.insets = new Insets(0, 0, 0, 5);
		gbc_lblNumeroDocumento.gridx = 0;
		gbc_lblNumeroDocumento.gridy = 6;
		panel_1.add(lblNumeroDocumento, gbc_lblNumeroDocumento);

		textFieldNumeroDocumento = new JTextField();
		GridBagConstraints gbc_textFieldNumeroDocumento = new GridBagConstraints();
		gbc_textFieldNumeroDocumento.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldNumeroDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumeroDocumento.gridx = 1;
		gbc_textFieldNumeroDocumento.gridy = 6;
		panel_1.add(textFieldNumeroDocumento, gbc_textFieldNumeroDocumento);
		textFieldNumeroDocumento.setColumns(10);

		JButton btnNuevoAdministrativo = new JButton("<html>Usuario <br>Administrativo</br></html>");
		GridBagConstraints gbc_btnNuevoAdministrativo = new GridBagConstraints();
		gbc_btnNuevoAdministrativo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoAdministrativo.gridx = 0;
		gbc_btnNuevoAdministrativo.gridy = 4;
		contentPane.add(btnNuevoAdministrativo, gbc_btnNuevoAdministrativo);
		btnNuevoAdministrativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		btnNuevoAdministrativo.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/plus.png")));

		JButton btnNuevoOperador = new JButton("<html>Usuario <br>Operador</br></html>");
		GridBagConstraints gbc_btnNuevoOperador = new GridBagConstraints();
		gbc_btnNuevoOperador.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoOperador.gridx = 1;
		gbc_btnNuevoOperador.gridy = 4;
		contentPane.add(btnNuevoOperador, gbc_btnNuevoOperador);
		btnNuevoOperador.addActionListener(this);

		btnNuevoOperador.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/plus.png")));

		JButton btnModificarButton = new JButton("Modificar");
		GridBagConstraints gbc_btnModificarButton = new GridBagConstraints();
		gbc_btnModificarButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificarButton.gridx = 2;
		gbc_btnModificarButton.gridy = 4;
		contentPane.add(btnModificarButton, gbc_btnModificarButton);
		btnModificarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/modificar.png")));
		btnModificarButton.addActionListener(this);


		JButton btnDeshabilitar = new JButton("Deshabilitar");
		GridBagConstraints gbc_btnDeshabilitar = new GridBagConstraints();
		gbc_btnDeshabilitar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeshabilitar.gridx = 4;
		gbc_btnDeshabilitar.gridy = 4;
		contentPane.add(btnDeshabilitar, gbc_btnDeshabilitar);
		btnDeshabilitar.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/menos.png")));

		JButton cancelarButton = new JButton("Cancelar");
		GridBagConstraints gbc_cancelarButton = new GridBagConstraints();
		gbc_cancelarButton.insets = new Insets(0, 0, 5, 0);
		gbc_cancelarButton.gridx = 4;
		gbc_cancelarButton.gridy = 5;
		contentPane.add(cancelarButton, gbc_cancelarButton);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(GestionUsuario.class.getResource("/image/cancel.png")));
		model = new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Nombre Usuario");
		model.addColumn("Borrado");

		this.setLocationRelativeTo(null);
		setModal(true);
	}

	private void filtrar() {

		ArrayList<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object,Object>>();

		RowFilter<TableModel, Object> rf = null;
		@SuppressWarnings("unused")
		int indiceColumnaTabla = 2;


		try {
			String text = textFieldUserNameSearch.getText();
			String[] textArray = text.split(" ");

			for (int i = 0; i < textArray.length; i++) {
				rfs.add(RowFilter.regexFilter("(?i)" + textArray[i], 0, 1, 2, 4));
			}	

			rf = RowFilter.andFilter(rfs);	

		} catch (java.util.regex.PatternSyntaxException e) {

		}

		sorter.setRowFilter(rf);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}
}

