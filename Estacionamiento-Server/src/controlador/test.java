package controlador;

import persistencia.HibernateDAO;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HibernateDAO.getInstancia().getSession();
		Controlador.getInstancia().aplicarInteres();
	}

}
