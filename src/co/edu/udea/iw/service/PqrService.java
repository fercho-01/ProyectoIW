package co.edu.udea.iw.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.validations.Validaciones;
/*
 * Metodos para realizar operaciones con PQR
 * @author LUIS FERNANDO OROZCO
 */

@Transactional
public class PqrService {
	private PqrDAO pqrDAO;
	
	/*
	 * Metodo para almacenar un pqr nuevo
	 * @param usuario Usuario que realiza la solicitud
	 * @param tipo Tipo de pqr
	 * @param descripcion Descripcion con el motivo del pqr
	 */
	@Transactional
	public void realiarPqr(Usuario usuario,String tipo, String descripcion) throws ServiceException, DaoException{
		if(usuario==null){
			throw new ServiceException("cedula vacia");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new ServiceException("Tipo de solicitud vacio");
		}
		if(Validaciones.isTextoVacio(descripcion)){
			throw new ServiceException("descripcion vacia");
		}
		
		Date fecha = new Date();
		
		Pqr pqr = new Pqr();
		pqr.setTipo(tipo);
		pqr.setDescripcion(descripcion);
		pqr.setEstado("pendiente");
		pqr.setFechaSolicitud(fecha);
		pqr.setUsuario(usuario);
		pqrDAO.guardar(pqr);
	}

	public PqrDAO getPqrDAO() {
		return pqrDAO;
	}

	public void setPqrDAO(PqrDAO pqrDAO) {
		this.pqrDAO = pqrDAO;
	}
	
	
}
