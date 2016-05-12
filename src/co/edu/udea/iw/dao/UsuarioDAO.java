package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Interfaz que define los metodos que va a implementar el dao de Usuario
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public interface UsuarioDAO {
	
	/*
	 * Inserta un elemento en la tabla usuarios de la base de datos
	 * @param usuario Objeto a insertar
	 */
	public void insertar(Usuario usuario)throws DaoException;
	
	/*
	 * Modifica un elemento de la tabla usuario en la base de datos
	 * @param usuario Objeto con los datos acutalizados
	 */
	public void modificar(Usuario usuario)throws DaoException;
	
	/*
	 * Busca un usuario al proporcionar la cedula
	 * @param cedula Cedula del usuario
	 * @return Objeto con la informacion, si no se encuentra null
	 */
	public Usuario obtener(String cedula)throws DaoException;
	
	/*
	 * Obtiene todos los elementos de la tabla usuarios
	 */
	public List<Usuario> obtener()throws DaoException;
}
