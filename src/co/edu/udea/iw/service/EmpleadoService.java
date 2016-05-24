package co.edu.udea.iw.service;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.mail.Mail;
import co.edu.udea.iw.util.validations.Validaciones;

/*
 * Metodos para que un empleado realice las operaciones en el sistema
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
@Transactional
public class EmpleadoService {
	PqrDAO pqrDAO;
	EmpleadoDAO empleadoDAO;
	/*
	 * Metodo que le permite al administrador delegar la responsabilidad de responder un pqr
	 * @param empleado Empleado al cual le toca responder el pqr
	 * @param pqr Pqr a la cual se le va a asignar el empleado
	 * @return true si se realiza la operacion exitosamente
	 */
	public boolean modificarPqr(Empleado empleado,Pqr pqr) throws ServiceException, DaoException{
		if(empleadoDAO.obtener(empleado.getCedula())==null){
			throw new ServiceException("empleado no valido");
		}
		
		Pqr pqrtemp = pqrDAO.obtener(pqr.getId());
		if(pqrtemp==null){
			System.out.println("null pointer");
		}
		if(pqrDAO.obtener(pqr.getId())==null){
			//throw new ServiceException("pqr no valido");
		}
		
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
	
	/*
	 * Metodo encargado de logguear a un empleado en el sistema
	 * @param cedula Cedula del empleado
	 * @param password Constraseña del empleado
	 * @return true si la informacion es valida, de lo contrario false
	 */
	public boolean validar(String cedula, String password) throws ServiceException, DaoException{
		Cifrar cifrar = new Cifrar();
		if(Validaciones.isTextoVacio(cedula)){
			throw new ServiceException("Cedula vacio");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new ServiceException("Password vacio");
		}
		Empleado empleado = empleadoDAO.obtener(cedula);
		if(empleado == null){
			throw new ServiceException("usuario o contraseña no validos");
		}
		if(!empleado.getPassword().equals(cifrar.encrypt(password))){
			throw new ServiceException("usuario o contraseña no validos");
		}
		return true;
	}
	
	/*
	 * Metodo para registrar empleados
	 * @param cedula Cedula del empleado
	 * @param email Correo electronico del empleado
	 * @param nombre NOmbre del empleado
	 * @param cargo Cargo del empleado
	 * @param password Contraseña del empleado
	 */
	public boolean registrarEmpleado(String cedula,String email,String nombre,String cargo,String password) throws ServiceException, DaoException{
		Cifrar cifrar = new Cifrar();
		
		if(!Validaciones.isEmail(email)){
			throw new ServiceException("Email no valido");
		}
		if(Validaciones.isTextoVacio(cargo)){
			throw new ServiceException("cargo vacio");
		}
		if(Validaciones.isEmail(cedula)){
			throw new ServiceException("cedula vacia");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new ServiceException("nombre vacio");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new ServiceException("password no valido");
		}
		if(empleadoDAO.obtener(cedula)!=null){
			throw new ServiceException("empleado existente");
		}
		
		Empleado empleado = new Empleado();
		empleado.setCargo(cargo);
		empleado.setCedula(cedula);
		empleado.setEmail(email);
		empleado.setNombre(nombre);
		empleado.setPassword(cifrar.encrypt(password));
		empleadoDAO.guardar(empleado);
		return true;
	}
	
	/**
	 * Metodo para modificar un empleado
	 * @param cedula Cedula del empleado
	 * @param password Contraseña del empleado
	 * @param nombre Nombre del empleado
	 * @param email Correo electronico del empleado
	 * @param cargo Cargo del empleado
	 * @return true si la operacion es realizada con exito de lo contrario false
	 * @throws ServiceException
	 * @throws DaoException
	 */
	public boolean modificarEmpleado(String cedula,String password,String nombre,String email,String cargo) throws ServiceException, DaoException{
		Cifrar cifrar = new Cifrar();
		if(Validaciones.isTextoVacio(cedula)){
			throw new ServiceException("cedula vacia");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new ServiceException("contraseña vacia");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new ServiceException("nombre vacio");
		}
		if(Validaciones.isTextoVacio(cargo)){
			throw new ServiceException("cargo vacio");
		}
		if(!Validaciones.isEmail(email)){
			throw new ServiceException("email no valido");
		}
		if(empleadoDAO.obtener(cedula)==null){
			throw new ServiceException("El empleado no existe");
		}
		Empleado empleado = new Empleado();
		empleado.setCargo(cargo);
		empleado.setCedula(cedula);
		empleado.setEmail(email);
		empleado.setNombre(nombre);
		empleado.setPassword(cifrar.encrypt(password));
		empleadoDAO.modificar(empleado);
		return true;
	}
	
	public PqrDAO getPqrDAO() {
		return pqrDAO;
	}
	public void setPqrDAO(PqrDAO pqrDAO) {
		this.pqrDAO = pqrDAO;
	}
	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	
	
}
