package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Interfaz que define los metodos que va a implementar el DAO de Pqr
 * @author LUIS FERNANDO OROZCO
 */
public interface PqrDAO {
	public void guardar(Pqr pqr)throws DaoException;
	public void modificar(Pqr pqr)throws DaoException;
	public Pqr obtener(int id)throws DaoException;
	public List<Pqr> obtener()throws DaoException;
}
