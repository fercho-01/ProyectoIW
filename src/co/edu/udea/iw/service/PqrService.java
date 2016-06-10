package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dao.hibernate.PqrDAOHibernate;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.mail.Mail;
import co.edu.udea.iw.util.validations.Validaciones;
/*
 * Metodos para realizar operaciones con PQR
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */

@Transactional
public class PqrService {
	private PqrDAO pqrDAO;
	private EmpleadoDAO empleadoDAO;
	
	/*
	 * Metodo para almacenar un pqr nuevo
	 * @param usuario Usuario que realiza la solicitud
	 * @param tipo Tipo de pqr
	 * @param descripcion Descripcion con el motivo del pqr
	 * @return true si se realiza la operacion exitosamente
	 */
	
	public boolean realiarPqr(Usuario usuario,String tipo, String descripcion) throws ServiceException, DaoException{
		if(usuario==null){
			throw new ServiceException("usuario no valido");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new ServiceException("Tipo de solicitud vacio");
		}
		if(Validaciones.isTextoVacio(descripcion)){
			throw new ServiceException("descripcion vacia");
		}
		
		Date fecha = new Date();
		System.out.println("1");
		Pqr pqr = new Pqr();
		System.out.println("2");
		pqr.setUsuario(usuario);
		System.out.println("3");
		pqr.setDescripcion(descripcion);
		System.out.println("4");
		pqr.setEstado("pendiente");
		System.out.println("5");
		pqr.setFechaSolicitud(fecha);
		System.out.println("6");
		pqr.setTipo(tipo);
		System.out.println("7");
		pqrDAO.guardar(pqr);
		System.out.println("8");
		String correo = "Administrador@udea.edu.co";
		System.out.println("9");
		Mail.send(correo, usuario, pqr);
		return true;
	}
	
	public boolean realizarRevision() throws ServiceException, DaoException{
		
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
			return false;
		}
		return true;
	}

	public PqrDAO getPqrDAO() {
		return pqrDAO;
	}

	public void setPqrDAO(PqrDAO pqrDAO) {
		this.pqrDAO = pqrDAO;
	}
	
	
	public boolean modificarPqr(int id, Empleado empleado, String respuesta) throws ServiceException, DaoException{
		//System.out.println("id: -- "+id);
		if(empleado==null){
			throw new ServiceException("cedula del empleado vacia");
		}
		if(Validaciones.isTextoVacio(respuesta)){
			throw new ServiceException("respuesta al pqr vacia");
		}
		
		
		Pqr pqr=pqrDAO.obtener(id);
		if(pqr==null){
			throw new ServiceException("El pqr no existe");
		}
		//System.out.println("::::: "+pqr.getDescripcion());
		/*
		System.out.println("::::: "+pqr.getDescripcion());
		Date fecha = new Date();
		pqr.setFechaRespuesta(fecha);
		pqr.setEstado("Respondido");
		pqr.setEmpleado(empleado);
		pqr.setRespuesta(respuesta);
		//pqrDAO.modificar(pqr);
		*/
		return true;
		 
		
	}
	
	
	public boolean Buscar(int id) throws ServiceException, DaoException{
		Pqr pqr = pqrDAO.obtener(id);
		if(pqr == null){
			throw new ServiceException("el pqr no existe");
		}
		return true;
	}
	
	
}
