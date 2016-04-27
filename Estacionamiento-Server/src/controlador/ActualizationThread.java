package controlador;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import modelo.Cliente;
import persistencia.HibernateDAO;
import persistencia.dao.DAOCliente;

public class ActualizationThread extends Thread {
	public static void actualizarEnMemoria(final Controlador c)
	{

		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				

			}
		}, 0, 1, TimeUnit.SECONDS);
	}

}
