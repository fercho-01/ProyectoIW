package co.edu.udea.iw.service;

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.mail.Mail;

/*
 * Metodos para que un empleado realice las operaciones en el sistema
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public class EmpleadoService {
	PqrDAO pqrDAO;
	/*
	 * Metodo que le permite al administrador delegar la responsabilidad de responder un pqr
	 * @param empleado Empleado al cual le toca responder el pqr
	 * @param pqr Pqr a la cual se le va a asignar el empleado
	 * @return true si se realiza la operacion exitosamente
	 */
	public boolean modificarPqr(Empleado empleado,Pqr pqr) throws ServiceException, DaoException{
		if(empleado == null){
			throw new ServiceException("empleado null");
		}
		if(pqr==null){
			throw new ServiceException("pqr null");
		}
		pqr.setEmpleado(empleado);
		pqrDAO.modificar(pqr);
		Mail.send(empleado.getEmail(), pqr.getUsuario(), pqr);
		return true;
	}
	public PqrDAO getPqrDAO() {
		return pqrDAO;
	}
	public void setPqrDAO(PqrDAO pqrDAO) {
		this.pqrDAO = pqrDAO;
	}
	
	
}
