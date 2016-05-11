package co.edu.udea.iw.service;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class PqrService {
	private PqrDAO pqrDAO;
	
	@Transactional
	public void realiarPqr(String cedula,String tipo, String descripcion) throws ServiceException, DaoException{
		if(Validaciones.isTextoVacio(cedula)){
			throw new ServiceException("cedula vacia");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new ServiceException("Tipo de solicitud vacio");
		}
		if(Validaciones.isTextoVacio(descripcion)){
			throw new ServiceException("descripcion vacia");
		}
		
		String empleado = "123456"; //cedula del administrador
		Date fecha = new Date();
		
		Pqr pqr = new Pqr();
		pqr.setTipo(tipo);
		pqr.setDescripcion(descripcion);
		//pqr.setEmpleado(empleado);
		pqr.setEstado("pendiente");
		pqr.setFechaSolicitud(fecha);
		pqr.setUsuario(cedula);
		pqrDAO.guardar(pqr);
	}

	public PqrDAO getPqrDAO() {
		return pqrDAO;
	}

	public void setPqrDAO(PqrDAO pqrDAO) {
		this.pqrDAO = pqrDAO;
	}
	
	
}
