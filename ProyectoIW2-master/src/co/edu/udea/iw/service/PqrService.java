package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.mail.Mail;
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
		String correo = "Administrador@udea.edu.co";
		Mail.send(correo, usuario, pqr);
	}

	public PqrDAO getPqrDAO() {
		return pqrDAO;
	}

	public void setPqrDAO(PqrDAO pqrDAO) {
		this.pqrDAO = pqrDAO;
	}
	
	public void realizarRevision() throws ServiceException, DaoException{
		
		String noRespondidos="Los pqrs que no han sido respuestos son:\n \n  ";
		String insatisfechos= "Los usuarios que estan insatisfechos con el servicio son: \n \n";
		List<Pqr> pqrs = null;
		
		try{
			pqrs=pqrDAO.obtener();
			
			for(Pqr pqr: pqrs){
				
				if("pendiente".equals(pqr.getEstado())){
					
					noRespondidos= noRespondidos + "id: " +pqr.getId() + " empleado a cargo: " + pqr.getEmpleado() +"\n"; 
				}
				
				if("insatisfecho".equals(pqr.getDescripcion())){
					insatisfechos= insatisfechos + "usuario: " + pqr.getUsuario() + " id del pqr: "+ pqr.getId() +"\n";
					
					}
				
			}
			String mensaje= noRespondidos + insatisfechos;
			Mail.send("correoGerente@email.com", mensaje);
			
		}catch(DaoException e){
			e.printStackTrace();
			
		}
		
		
	}
	
}
