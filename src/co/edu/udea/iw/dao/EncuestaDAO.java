package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Interfaz que define los metodos que va a implementar el DAO de encuesta
 * @author LUIS FERNANDO OROZCO
 */
public interface EncuestaDAO {
	public void guardar(Encuesta encuesta)throws DaoException;
	public void modificar(Encuesta encuesta)throws DaoException;
	public Encuesta obtener(int id)throws DaoException;
	public List<Encuesta> obtener()throws DaoException;
}
