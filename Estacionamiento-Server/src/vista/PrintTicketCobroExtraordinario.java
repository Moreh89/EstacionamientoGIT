package vista;

import java.awt.Graphics2D;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import modelo.Ticket;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class PrintTicketCobroExtraordinario extends JFrame {

	private JPanel contentPane;
	private JPanel panelAttributes;
	private JTextPane txtpnfechaIng;
	private Barcode barcode;
	private static String impersora;
	private static PrintTicket standalone = null;
	
	public static PrintTicket getInstance(Ticket ticket, String printerName){
		if(standalone == null) standalone = new PrintTicket(ticket, printerName);
		
		return standalone;
	}

	
	public void imprimir(){
		printWork(this);
	}

	public PrintTicketCobroExtraordinario (modelo.MovimientoCC cobroExtraordinario, String printerName, modelo.Cliente cliente) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PrintTicket.class.getResource("/image/printer.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 150);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);

		impersora = printerName;
		
		try {
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[] { 168, 0 };
			gbl_contentPane.rowHeights = new int[] { 164, 0 };
			gbl_contentPane.columnWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			gbl_contentPane.rowWeights = new double[] { 0.0,
					Double.MIN_VALUE };
			contentPane.setLayout(gbl_contentPane);

			panelAttributes = new JPanel();
			panelAttributes.setBackground(Color.WHITE);
			GridBagConstraints gbc_panelAttributes = new GridBagConstraints();
			gbc_panelAttributes.anchor = GridBagConstraints.NORTH;
			gbc_panelAttributes.fill = GridBagConstraints.HORIZONTAL;
			gbc_panelAttributes.gridx = 0;
			gbc_panelAttributes.gridy = 0;
			contentPane.add(panelAttributes, gbc_panelAttributes);
			GridBagLayout gbl_panelAttributes = new GridBagLayout();
			gbl_panelAttributes.columnWidths = new int[] { 116, 0 };
			gbl_panelAttributes.rowHeights = new int[] {150};
			gbl_panelAttributes.columnWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			gbl_panelAttributes.rowWeights = new double[] { 0.0 };
			panelAttributes.setLayout(gbl_panelAttributes);

			txtpnfechaIng = new JTextPane();
			txtpnfechaIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtpnfechaIng.setContentType("text/html");
			txtpnfechaIng.setText("<html><b>P.J.E.Uriburu 1058 CABA<br>Fecha:"+new SimpleDateFormat("dd-MM-yyyy HH:mm").format(cobroExtraordinario.getFecha())+"<br>Cliente: "+ cliente.getNombre()+" "+cliente.getApellido()+"<br>Descripcion: "+ cobroExtraordinario.getDescripcion()+"<br>Monto: "+cobroExtraordinario.getMontoCobrado()+"</b><br></html>");
			GridBagConstraints gbc_txtpnfechaIng = new GridBagConstraints();
			gbc_txtpnfechaIng.fill = GridBagConstraints.BOTH;
			gbc_txtpnfechaIng.gridx = 0;
			gbc_txtpnfechaIng.gridy = 0;
			panelAttributes.add(txtpnfechaIng, gbc_txtpnfechaIng);
			this.setVisible(true);
			this.toBack();
//			printWork(this);
//			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	public static void printWork(final JFrame frame) {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setJobName(" Imprimir Ticket ");

		pj.setPrintable(new Printable() {
			@Override
			public int print(Graphics pg, PageFormat pf, int pageNum) {
				if (pageNum > 0)
					return Printable.NO_SUCH_PAGE;

				Graphics2D g2 = (Graphics2D) pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				frame.paint(g2);
				return Printable.PAGE_EXISTS;
			}
		});
		
//Este te permite elegir la printer
//		if (pj.printDialog() == false) return;
		

//Elegir printer automatico start
		try {
			PrintService printerTouse = null;
			PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
					null, null);
			
//Para saber el nombre de tus impresoras
//			for (PrintService printer : printServices) {
//				System.out.println("Impresora: " + printer.getName()+"/n");
//			}
			
			
// aca iria el atributo con el nombre de la impresora
			for (PrintService printer : printServices) {
				if (printer.getName().equalsIgnoreCase(
						impersora)) {
					printerTouse = printer;
				}
			}
			if(printerTouse== null){
				printerTouse = PrintServiceLookup
	            .lookupDefaultPrintService();
			}
			pj.setPrintService(printerTouse);
			PrintRequestAttributeSet aset= new HashPrintRequestAttributeSet();
		    aset.add(new MediaPrintableArea(0,0,210,160,Size2DSyntax.MM));
			
			pj.print(aset);
			
//Elegir printer end			

		} catch (PrinterException xcp) {
			xcp.printStackTrace(System.err);
		}
	}


	public static PrintTicket getInstance() {
		return standalone;
	}


	public PrintTicket clear() {
		
		PrintTicket temp = standalone;
		standalone = null;
		return temp;
	}

	public void PrintCobroExtraOrdinario (modelo.MovimientoCC cobroExtraordinario, String printerName, modelo.Cliente cliente) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PrintTicket.class.getResource("/image/printer.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);

		impersora = printerName;
		
		try {
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[] { 168, 0 };
			gbl_contentPane.rowHeights = new int[] { 164, 54, 0, 0 };
			gbl_contentPane.columnWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			contentPane.setLayout(gbl_contentPane);

			panelAttributes = new JPanel();
			panelAttributes.setBackground(Color.WHITE);
			GridBagConstraints gbc_panelAttributes = new GridBagConstraints();
			gbc_panelAttributes.anchor = GridBagConstraints.NORTH;
			gbc_panelAttributes.insets = new Insets(0, 0, 5, 0);
			gbc_panelAttributes.fill = GridBagConstraints.HORIZONTAL;
			gbc_panelAttributes.gridx = 0;
			gbc_panelAttributes.gridy = 0;
			contentPane.add(panelAttributes, gbc_panelAttributes);
			GridBagLayout gbl_panelAttributes = new GridBagLayout();
			gbl_panelAttributes.columnWidths = new int[] { 116, 0 };
			gbl_panelAttributes.rowHeights = new int[] {150};
			gbl_panelAttributes.columnWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			gbl_panelAttributes.rowWeights = new double[] { 0.0 };
			panelAttributes.setLayout(gbl_panelAttributes);

			txtpnfechaIng = new JTextPane();
			txtpnfechaIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtpnfechaIng.setContentType("text/html");
			txtpnfechaIng.setText("<html><b>P.J.E.Uriburu 1058 CABA<br>Fecha Ing:<br>"+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(cobroExtraordinario.getFecha())+"<br>Cliente: "+ cliente.getNombre()+" "+cliente.getApellido()+"<br>Descripcion: "+ cobroExtraordinario.getDescripcion()+"<br>Monto: "+cobroExtraordinario.getMontoCobrado()+"</b><br></html>");
			GridBagConstraints gbc_txtpnfechaIng = new GridBagConstraints();
			gbc_txtpnfechaIng.fill = GridBagConstraints.BOTH;
			gbc_txtpnfechaIng.gridx = 0;
			gbc_txtpnfechaIng.gridy = 0;
			panelAttributes.add(txtpnfechaIng, gbc_txtpnfechaIng);

		
			this.setVisible(true);
			this.toBack();
//			printWork(this);
//			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
