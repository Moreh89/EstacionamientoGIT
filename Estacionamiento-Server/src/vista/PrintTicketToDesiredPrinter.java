package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;


public class PrintTicketToDesiredPrinter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintTicketToDesiredPrinter frame = new PrintTicketToDesiredPrinter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrintTicketToDesiredPrinter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		   Container contentPane = this.getContentPane();

		    final JPanel printPanel = new PrintableJPanel();
		    contentPane.add(printPanel, BorderLayout.CENTER);
		    GridBagLayout gbl_printPanel = new GridBagLayout();
		    gbl_printPanel.columnWidths = new int[]{204, 0};
		    gbl_printPanel.rowHeights = new int[]{168, 0, 0};
		    gbl_printPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		    gbl_printPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		    printPanel.setLayout(gbl_printPanel);
		    
		    JPanel panel = new JPanel();
		    GridBagConstraints gbc_panel = new GridBagConstraints();
		    gbc_panel.insets = new Insets(0, 0, 5, 0);
		    gbc_panel.fill = GridBagConstraints.BOTH;
		    gbc_panel.gridx = 0;
		    gbc_panel.gridy = 0;
		    printPanel.add(panel, gbc_panel);
		    GridBagLayout gbl_panel = new GridBagLayout();
		    gbl_panel.columnWidths = new int[]{116, 0};
		    gbl_panel.rowHeights = new int[]{22, 0};
		    gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		    gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		    panel.setLayout(gbl_panel);
		    
		    JTextPane txtpnXvx = new JTextPane();
		    txtpnXvx.setContentType("text/html");
		    txtpnXvx.setText("<html>Fecha Ing: 10/01/2015 10:30<br>Vehiculo: Auto<br>Modelo: Chevrolet Aveo<br>Patente: 343<br></html>");
		    GridBagConstraints gbc_txtpnXvx = new GridBagConstraints();
		    gbc_txtpnXvx.fill = GridBagConstraints.BOTH;
		    gbc_txtpnXvx.gridx = 0;
		    gbc_txtpnXvx.gridy = 0;
		    panel.add(txtpnXvx, gbc_txtpnXvx);
		    
		    JPanel panel_1 = new JPanel();
		    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		    gbc_panel_1.fill = GridBagConstraints.BOTH;
		    gbc_panel_1.gridx = 0;
		    gbc_panel_1.gridy = 1;
		    printPanel.add(panel_1, gbc_panel_1);
		    

			try {
			    Barcode barcode;
				barcode = BarcodeFactory.create2of7("0123456789");
			    panel_1.add(barcode);
			} catch (BarcodeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    
		    
		    
		    

		    JButton button = new JButton("Print");
		    contentPane.add(button, BorderLayout.SOUTH);

		    ActionListener listener = new ActionListener() {
		    	
					public void actionPerformed(ActionEvent e) {
				        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
				        PrintService printService = null;
				        
						PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
								null, null);
						for (PrintService printer : printServices) {
							if (printer.getName().equalsIgnoreCase(
									"\\\\ABBDAT05\\ABB-FL6-SC645-HP5550")) {
								printService = printer;
							}
						}
						if(printService== null){
					        printService = PrintServiceLookup
				            .lookupDefaultPrintService();
						}

				        DocPrintJob job = printService.createPrintJob();
				        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
				
				        DocAttributeSet das = new HashDocAttributeSet();
				        Doc doc = new SimpleDoc(printPanel, flavor, das);
				        try {
				          job.print(doc, pras);
				        } catch (PrintException pe) {
				          pe.printStackTrace();
				        }
				      }
		    };
		    button.addActionListener(listener);
		
		
	}
	
	  static class PrintableJPanel extends JPanel implements Printable {

			private static final long serialVersionUID = 1L;

		    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		      if (pageIndex == 0) {
		        return Printable.PAGE_EXISTS;
		      } else {
		        return Printable.NO_SUCH_PAGE;
		      }
		    }
		  }

}
