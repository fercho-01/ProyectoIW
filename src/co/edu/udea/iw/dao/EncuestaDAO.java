package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Interfaz que define los metodos que va a implementar el DAO de encuesta
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public interface EncuestaDAO {
	
	/*
	 * Metodo para almacenar una nueva encuesta en la base de datos
	 * @param encuesta Elemento a insertar en la base de datos
	 */
	public void guardar(Encuesta encuesta)throws DaoException;
	
	/*
	 * Modifica un elemento de la tabla encuestas
	 * @param encuesta Objeto con los datos actualizados
	 */
	public void modificar(Encuesta encuesta)throws DaoException;
	
	/*
	 * Obtiene encuesta cuyo id es el ingresado por parametro
	 * @param id Id de la encuesta
	 * @return Objeto de tipo Encuesta, en caso de no existir null
	 */
	public Encuesta obtener(int id)throws DaoException;
	
	/*
	 * Obtiene lista de encuestas presentes en la base de datos
	 */
	public List<Encuesta> obtener()throws DaoException;
}
