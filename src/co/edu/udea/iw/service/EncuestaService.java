package co.edu.udea.iw.service;
/*
 * Metodos para las encuestas
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */

import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;

public class EncuestaService {
	
	EncuestaDAO encuestaDAO;
	
	/*
	 * Metodo para almacenar encuestas
	 * @param encuesta Encuesta a almacenar
	 * @return true si la operacion es exitosa
	 */
	public boolean crearEncuesta(Encuesta encuesta) throws ServiceException, DaoException{
		if(encuesta==null){
			throw new ServiceException("encuesta null");
		}
		encuestaDAO.guardar(encuesta);
		return true;
	}

	public EncuestaDAO getEncuestaDAO() {
		return encuestaDAO;
	}

	public void setEncuestaDAO(EncuestaDAO encuestaDAO) {
		this.encuestaDAO = encuestaDAO;
	}
	
}
