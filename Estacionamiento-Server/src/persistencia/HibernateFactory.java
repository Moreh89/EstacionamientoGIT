package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import persistencia.clases.*;

 
public class HibernateFactory
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(CategoriaVehiculo.class);
        	 config.addAnnotatedClass(Cliente.class);
        	 config.addAnnotatedClass(Cochera.class);
        	 config.addAnnotatedClass(ColorVehiculo.class);
        	 config.addAnnotatedClass(CuentaCorriente.class);
        	 config.addAnnotatedClass(Descuento.class);
        	 config.addAnnotatedClass(ModeloVehiculo.class);
        	 config.addAnnotatedClass(MovimientoCC.class);
        	 config.addAnnotatedClass(Tarifa.class);
        	 config.addAnnotatedClass(Ticket.class);
        	 config.addAnnotatedClass(Usuario.class);
        	 config.addAnnotatedClass(Vehiculo.class);
        	 config.addAnnotatedClass(PersonaAutorizada.class);
        	 config.addAnnotatedClass(TasaInteres.class);
        	 config.addAnnotatedClass(LiquidacionExpensas.class);
        	 config.addAnnotatedClass(Interes.class);
        	 //Para cambiar atributos sin el archivo
//        	 config.setProperty("hibernate.connection.url", "jdbc:mysql://"+hostname+"/"+database);
//        	 config.setProperty("hibernate.connection.username", username);
//        	 config.setProperty("hibernate.connection.password", password);
           	 sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
