package controlador;

import java.awt.Graphics2D;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.JDialog;
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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JTextPane;

import vista.GestionColor;

import java.awt.Toolkit;
import java.awt.Font;


public class PrintTicketTest2 {


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrinterJob pj = PrinterJob.getPrinterJob();
			String toPrint = "Test";
			
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

		    StringBuilder  builder = new StringBuilder();
		    builder.append(toPrint);
		    builder.append(EscapeCodeUtil.createEscapeCode(10));

		    PrintRequestAttributeSet aset= new HashPrintRequestAttributeSet();
		    aset.add(new MediaPrintableArea(100,400,210,160,Size2DSyntax.MM));


		    InputStream is = new ByteArrayInputStream(builder.toString().getBytes("UTF-8"));

		    Doc mydoc = new SimpleDoc(is, flavor, null);

		    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

			//Este te permite elegir la printer
			if (pj.printDialog() == false) return;
			else{defaultService = pj.getPrintService();}

		        //print using default
		       DocPrintJob job = defaultService.createPrintJob();
		                job.print(mydoc, aset);   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	public static class EscapeCodeUtil {

		public static String createEscapeCode(int ... codes)
		{
		    StringBuilder sb = new StringBuilder();

		    for(int code : codes)
		        sb.append((char) code);

		    return sb.toString();
		}
		}
	
}
