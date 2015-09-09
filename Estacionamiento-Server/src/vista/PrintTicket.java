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
import javax.swing.border.EmptyBorder;
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

@SuppressWarnings("serial")
public class PrintTicket extends JFrame {

	private JPanel contentPane;
	private JPanel panelAttributes;
	private JTextPane txtpnfechaIng;
	private JPanel panel;
	private Barcode barcode;
	private static String impersora;


	public PrintTicket (Ticket ticket, String printerName) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PrintTicket.class.getResource("/image/printer.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		impersora = printerName;
		
		try {
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[] { 168, 0 };
			gbl_contentPane.rowHeights = new int[] { 185, 64, 0 };
			gbl_contentPane.columnWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			gbl_contentPane.rowWeights = new double[] { 1.0, 0.0,
					Double.MIN_VALUE };
			contentPane.setLayout(gbl_contentPane);

			panelAttributes = new JPanel();
			GridBagConstraints gbc_panelAttributes = new GridBagConstraints();
			gbc_panelAttributes.insets = new Insets(0, 0, 5, 0);
			gbc_panelAttributes.fill = GridBagConstraints.BOTH;
			gbc_panelAttributes.gridx = 0;
			gbc_panelAttributes.gridy = 0;
			contentPane.add(panelAttributes, gbc_panelAttributes);
			GridBagLayout gbl_panelAttributes = new GridBagLayout();
			gbl_panelAttributes.columnWidths = new int[] { 116, 0 };
			gbl_panelAttributes.rowHeights = new int[] { 22, 0 };
			gbl_panelAttributes.columnWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			gbl_panelAttributes.rowWeights = new double[] { 1.0,
					Double.MIN_VALUE };
			panelAttributes.setLayout(gbl_panelAttributes);

			txtpnfechaIng = new JTextPane();
			txtpnfechaIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtpnfechaIng.setContentType("text/html");
			txtpnfechaIng
					.setText("<html><b>P.J.E.Uriburu 1058<br>Fecha Ing:<br>"+new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(ticket.getFechaLlegada())+"<br>Vehiculo:<br>"+ ticket.getCatergoriaVehiculo().getDescripcion()+"<br>Modelo:<br>"+ticket.getModeloVehiculo().getDescripcion()+"<br>Patente:<br>"+ticket.getPatente().toUpperCase()+"</b><br></html>");
			GridBagConstraints gbc_txtpnfechaIng = new GridBagConstraints();
			gbc_txtpnfechaIng.fill = GridBagConstraints.BOTH;
			gbc_txtpnfechaIng.gridx = 0;
			gbc_txtpnfechaIng.gridy = 0;
			panelAttributes.add(txtpnfechaIng, gbc_txtpnfechaIng);

			panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.anchor = GridBagConstraints.SOUTHWEST;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPane.add(panel, gbc_panel);

			// Always get a Barcode from the BarcodeFactory
			String numeroTck = String.valueOf(ticket.getIdTicket());
			while (numeroTck.length() < 10) {
				numeroTck = "0" + numeroTck;
			}
			barcode = BarcodeFactory.createCode128(numeroTck);
			barcode.setBarHeight(30);
			barcode.setBarWidth(2);

			panel.add(barcode);
			printWork(this);
			this.dispose();
		} catch (BarcodeException e) {
			e.printStackTrace();
		}

	}



	//Otros ejemplos de creacion de barras
	public static void drawingBarcodeDirectToGraphics()
			throws BarcodeException, OutputException {
		// Always get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128A("My Barcode");

		// We are created an image from scratch here, but for printing in Java,
		// your print renderer should have a Graphics internally anyway
		BufferedImage image = new BufferedImage(500, 500,
				BufferedImage.TYPE_BYTE_GRAY);
		// We need to cast the Graphics from the Image to a Graphics2D:
		// this is OK
		Graphics2D g = (Graphics2D) image.getGraphics();

		// Barcode supports a direct draw method to Graphics2D that lets you
		// position the barcode on the canvas
		barcode.draw(g, 10, 56);
	}

	public static void outputtingBarcodeAsPNG() throws BarcodeException,
			IOException, OutputException {
		// get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128A("My Barcode");
		File f = new File("mybarcode.png");
		// Let the barcode image handler do the hard work
		BarcodeImageHandler.savePNG(barcode, f);
	}

	public static void outputtingBarcodeAsJPEG() throws BarcodeException,
			IOException, OutputException {
		Barcode barcode3 = BarcodeFactory.createCode128C("123456");
		barcode3.setResolution(300);
		BarcodeImageHandler.saveJPEG(barcode3, new File("123456.jpg"));
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

			PrintRequestAttributeSet aset= new HashPrintRequestAttributeSet();
		    aset.add(new MediaPrintableArea(2,2,210,160,Size2DSyntax.MM));
			
			pj.print(aset);
			
//Elegir printer end			

		} catch (PrinterException xcp) {
			xcp.printStackTrace(System.err);
		}
	}


}
