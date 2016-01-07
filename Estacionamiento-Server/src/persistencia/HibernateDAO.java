package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import persistencia.clases.Cliente;



public class HibernateDAO {
	protected static HibernateDAO instancia = null;
	protected static SessionFactory sf = null;
	protected static Session session = null;


	public static HibernateDAO getInstancia(){
		if(instancia == null){
			instancia = new HibernateDAO();
		} 
		return instancia;
	}

	protected HibernateDAO()  {
		sf = HibernateFactory.getSessionFactory();
	}

	public Session getSession(){
		if(session == null || !session.isOpen()){
			session = sf.openSession();
			System.out.println("OPEN: " + session.isOpen());
		}
		return session;
	}

	public void closeSession(){
		if (session.isOpen()) 
		{
			session.close();
			System.out.println("\nOPEN: " + session.isOpen());
		}
	}

	@SuppressWarnings("rawtypes")
	public void persistList(List lista){
		Session session = getSession();
		session.beginTransaction();
		for(Object e : lista){
			session.persist(e);
		}
		session.flush();
		session.getTransaction().commit();
	}


	public List<?> getListInt(String className, String columna,int value)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s. "+ columna + " =?").setInteger(0, value).list();
		session.flush();
		return list;
	}

	public List<?> getListString(String className, String columna,String value)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s."+ columna + " =?").setString(0, value).list();
		session.flush();
		return list;
	}

	public List<?> getListbetweenDates(String className, String columnaFiltro,String valorFiltro, String columnaFechaIni, String fehaInicio, String columanFechaFin, String fechaFin)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s."+ columnaFiltro + " =?" + " and " + columnaFechaIni + ">=?" + " and " +  columanFechaFin + "<=?").setString(0, valorFiltro).setString(1, fehaInicio).setString(2, fechaFin).list();
		session.flush();
		return list;
	}

	public List<?> getListbetweenDates(String className, String columnaFiltro1 ,String valorFiltro1, String columnaFiltro2 , boolean valorFiltro2, String columnaFechaIni, String fehaInicio, String columanFechaFin, String fechaFin)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s."+ columnaFiltro1 + " =?" + " and " + columnaFiltro2 + " =?" + " and " + columnaFechaIni + ">=?" + " and " +  columanFechaFin + "<=?").setString(0, valorFiltro1).setBoolean(1, valorFiltro2).setString(2, fehaInicio).setString(3, fechaFin).list();
		session.flush();
		return list;
	}

	public List<?> getListbetweenDates(String className, String columnaFiltro,long valorFiltro, String columnaFechaIni, String fehaInicio, String columanFechaFin, String fechaFin)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s."+ columnaFiltro + " =?" + " and " + columnaFechaIni + ">=?" + " and " +  columanFechaFin + "<=?").setLong(0, valorFiltro).setString(1, fehaInicio).setString(2, fechaFin).list();
		session.flush();
		return list;
	}


	public List<?> getListAfterDates(String className, String columnaFiltro,String valorFiltro, String columnaFechaIni, Date fehaInicio)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s."+ columnaFiltro + " =?" + " and " + columnaFechaIni + ">=?" ).setString(0, valorFiltro).setDate(1, fehaInicio).list();
		session.flush();
		return list;
	}


	// Devuelve un objeto, en className recibe el nombre de la clase, campo es la columna y valor es el filtro.
	public Object getObjectWithString(String className, String campo, String value) {

		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setString(0, value).uniqueResult();
		s.flush();
		return r;
	}

	public Object getObjectWithInt(String className, String campo, int value) {
		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setInteger(0, value).uniqueResult();
		s.flush();
		return r;
	}

	public Object getObjectWithLong(String className, String campo, long value) {
		Session s = this.getSession();
		Object r = s.createQuery("from " + className + " s where s." + campo + " = ?").setLong(0, value).uniqueResult();
		s.flush();
		return r;
	}

	public void delete(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.flush();
	}

	public Object update(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(obj);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}

	public Object save(Object obj) {
		Session session = getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}

	public List<?> getList(String className)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className).list();
		session.flush();
		return list;
	}

	@SuppressWarnings("rawtypes")
	public Object get(Object clase, int id) {
		Session session = getSession();
		session.beginTransaction();
		Object obj = session.get((Class) clase, id);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}

	@SuppressWarnings("rawtypes")
	public Object get(Object clase, double id) {
		Session session = getSession();
		session.beginTransaction();
		Object obj = session.get((Class) clase, id);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}
	@SuppressWarnings("rawtypes")
	public Object get(Object clase, long id) {
		Session session = getSession();
		session.beginTransaction();
		Object obj = session.get((Class) clase, id);
		session.getTransaction().commit();
		session.flush();
		return obj;
	}


	public String backUp(String databaseName, String path,String fileNameBackup)
	{
		Session session = getSession();
		session.beginTransaction();
		SQLQuery query=session.createSQLQuery("BACKUP DATABASE " + databaseName + " TO DISK = " + path +fileNameBackup);
		query.executeUpdate();
		session.flush();
		return path+fileNameBackup;
		

//RESTORE DATABASE ESTACIONAMIENTO from disk = 'RUTA' with replace, MOVE 'ESTACIONAMIENTO' TO 'c:\temp\db2.mdf',
//				  MOVE 'estacionamiento_log' TO 'c:\temp\db2.ldf';

	}


	public List<?> getListLiquidacionesDatediff(String className, String columna,int value)
	{
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s.estado=1 AND DATEDIFF(DAY," +columna+",CURRENT_TIMESTAMP)<"+ "?").setInteger(0, value).list();
		session.flush();
		return list;
	}



	public List<?> getListTwoInt(String className, String columna,int condicion1, int condicion2) {
		Session session=getSession();
		List<?> list = session.createQuery("from "+className + " s where s.estado = 1 AND (s. "+ columna + " =? OR s."+columna + " =?)").setInteger(0, condicion1).setInteger(1, condicion2).list();
		session.flush();
		return list;
	}

	//trae clientes propietarios , particulares o inquilinos (de a pares).
	public long eliminarTickets(Date fechaDesde, Date fechaHasta) {
		long ret = -1;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.beginTransaction();
		String stringQ= "DELETE Ticket where Cliente is null AND fechaSalida IS NOT NULL AND estado = 2 AND DATEDIFF(dd, fechaSalida, :fechaD)<=0 AND DATEDIFF(dd, fechaSalida, :fechaH)>=0";
		SQLQuery query=session.createSQLQuery(stringQ);
		query.setDate("fechaD", fechaDesde);
		query.setDate("fechaH", fechaHasta);
		ret = query.executeUpdate();
		tx.commit();
		return ret;
	}

	public List<?> getListClientesNoBorrados() {
		Session session=getSession();
		List<?> list = session.createQuery("from Cliente c where c.estado <> 2").list();
		session.flush();
		return list;
	}

	public long generarAumentoAlquileres(double aumento) {
		long ret = -1;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.beginTransaction();
		String stringQ= ("UPDATE Cochera SET costoCochera = costoCochera* :porcentajeAumento WHERE estado = 1 AND porcentajeExpensas=0 AND costoCochera > 0");
		SQLQuery query=session.createSQLQuery(stringQ);
		query.setDouble("porcentajeAumento", aumento);
		ret = query.executeUpdate();
		tx.commit();
		return ret;
	}

	
}
