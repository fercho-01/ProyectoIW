package temp;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.MyException;

@Transactional
public class test {
	private UsuarioDAO usuarioDao;
	public void insertar(Usuario usuario){
		try {
			usuarioDao.insertar(usuario);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
