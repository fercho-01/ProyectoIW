package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Interfaz que define los metodos que va a implementar el DAO de Pqr
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public interface PqrDAO {
	
	/*
	 * Almacena un pqr nuevo en la base de datos
	 * @param pqr Objeto a insertar en la base de datos
	 */
	public void guardar(Pqr pqr)throws DaoException;
	
	/*
	 * Modifica un elemento en la base de datos
	 * @param pqr Objeto con los datos actualizados
	 */
	public void modificar(Pqr pqr)throws DaoException;
	
	/*
	 * Obtiene un pqr dado el id
	 * @param id Id del pqr a buscar
	 * @return Objeto Pqr cuyo id es el proporcionado, si no existe null
	 */
	public Pqr obtener(Integer id)throws DaoException;
	
	/*
	 * Obtiene lista de Pqrs presentes en la base de datos
	 */
	public List<Pqr> obtener()throws DaoException;
	
	/**
	 * Obtiene lista de Pqrs sin responder
	 */
	public List<Pqr> obtenerSinResponder()throws DaoException;
}
