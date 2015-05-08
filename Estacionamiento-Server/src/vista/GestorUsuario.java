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

@SuppressWarnings("rawtypes")
public class GestorUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField buscarTextField;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	
	
	private TableRowSorter<TableModel> sorter;
	
	public GestorUsuario() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		initGUI();
	}
	
	

	public void initGUI(){
		setTitle("Gestor Usuarios");
		setResizable(false);
		setBounds(100, 100, 699, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscar = new JLabel("ID:");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscar.setBounds(10, 19, 46, 14);
		contentPane.add(lblBuscar);
		
		buscarTextField = new JTextField();
		buscarTextField.setBounds(53, 14, 339, 25);
		contentPane.add(buscarTextField);
		buscarTextField.setColumns(10);
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
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 64, 510, 224);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		
		JButton buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							filtrar();
				
			}
		});
		buscarButton.setBounds(404, 7, 116, 32);
		contentPane.add(buscarButton);
		buscarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/search.png")));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 510, 6);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(530, -12, 176, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton nuevoAdministrativoButton = new JButton("<html>Usuario <br>Administrativo</br></html>");
		nuevoAdministrativoButton.setBounds(10, 23, 140, 40);
		panel.add(nuevoAdministrativoButton);
		nuevoAdministrativoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		nuevoAdministrativoButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/plus.png")));
		
		JButton modificarButton = new JButton("Modificar");
		modificarButton.setBounds(10, 130, 140, 32);
		panel.add(modificarButton);
		modificarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/modificar.png")));
		
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(10, 265, 140, 32);
		panel.add(cancelarButton);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarButton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/cancel.png")));
		
		JButton nuevoOperadorbutton = new JButton("<html>Usuario <br>Operador</br></html>");
		nuevoOperadorbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

			}
		});
		nuevoOperadorbutton.setIcon(new ImageIcon(GestorUsuario.class.getResource("/image/plus.png")));
		nuevoOperadorbutton.setBounds(10, 74, 140, 40);
		panel.add(nuevoOperadorbutton);
		modificarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		this.setLocationRelativeTo(null);
		setModal(true);
	}
	
	private void filtrar() {
		
		ArrayList<RowFilter<Object, Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		
		RowFilter<TableModel, Object> rf = null;
		@SuppressWarnings("unused")
		int indiceColumnaTabla = 2;

		
		try {
			String text = buscarTextField.getText();
		    String[] textArray = text.split(" ");

		    for (int i = 0; i < textArray.length; i++) {
		        rfs.add(RowFilter.regexFilter("(?i)" + textArray[i], 0, 1, 2, 4));
		    }	
			
		    rf = RowFilter.andFilter(rfs);	
		
		} catch (java.util.regex.PatternSyntaxException e) {
			
		}
		
		sorter.setRowFilter(rf);
		}
	
	

}

