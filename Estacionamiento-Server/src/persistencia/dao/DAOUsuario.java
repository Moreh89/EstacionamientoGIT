package persistencia.dao;
import modelo.Usuario;

public class DAOUsuario {

	private static DAOUsuario ins = null;

	public static DAOUsuario getInstance(){
		if (ins == null) ins = new DAOUsuario();

		return ins;
	}

	public long persistir(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

}
