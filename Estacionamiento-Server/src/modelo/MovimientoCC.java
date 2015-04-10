package modelo;

import java.sql.Date;

public class MovimientoCC 
{
	long idMovimiento;
	Date fecha;
	String descripcion;
	double montoCobrado;
	String estado;
	Ticket ticket;
}
