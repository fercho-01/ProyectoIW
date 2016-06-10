package co.edu.udea.iw.service;

import java.util.Date;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

/*
 * Esta clase provee los metodos necesarios por un usuario en la logica de negocio 
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
@Transactional
public class UsuarioService {
	private UsuarioDAO usuarioDAO;

	/*
	 * Metodo para crear usuarios en el sistema
	 * @param cedula La Cedula del usuario
	 * @param password La contraseña del usuario
	 * @param nombre El nombre del usuario
	 * @param email El email del usuario
	 * @return true si se realiza la operacion exitosamente
	 */
	@Transactional
	public boolean crearUsuario(String cedula, String password, String nombre, String email) throws ServiceException, DaoException{
		if(Validaciones.isTextoVacio(cedula)){
			throw new ServiceException("Cedula vacia");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new ServiceException("password vacio");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new ServiceException("nombre vacio");
		}
		if(Validaciones.isTextoVacio(email)){
			throw new ServiceException("email vacio");
		}
		if(!Validaciones.isEmail(email)){
			throw new ServiceException("email no valido");
		}
		if(usuarioDAO.obtener(cedula)!=null){
			throw new ServiceException("el usuario ya existe");
		}
		Cifrar cifrar = new Cifrar();
		Usuario usuario = new Usuario();
		usuario.setCedula(cedula);
		usuario.setPassword(cifrar.encrypt(password));
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		
		usuarioDAO.insertar(usuario);
		return true;
	}
	
	/*
	 * Confirma si la cedula y password de un usuario son correctos
	 * @param cedula Login del usuario
	 * @param password Contraseña del usuario
	 * @return true si los datos son correctos, false de lo contrario
	 */
	public boolean login(String cedula, String password) throws DaoException, ServiceException{
		Cifrar cifrar = new Cifrar();
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new ServiceException("cedula vacia");
		}
		if(Validaciones.isTextoVacio(password)){
			throw new ServiceException("contraseña vacia");
		}
		
		Usuario usuario = usuarioDAO.obtener(cedula);
		if(usuario==null){
			throw new ServiceException("Usuario o contraseña no validos");
		}
		if(!cifrar.encrypt(password).equals(usuario.getPassword())){
			throw new ServiceException("Usuario o contraseña no validos");
		}
		return true;	
	}
	
	/**
	 * Metodo para modificar los datos de un usuario
	 * @param cedula Cedula del usuario
	 * @param password Contraseña del usuario
	 * @param nombre Nombre del usuario	
	 * @param email Correo electronico del usuario
	 * @return true si la operacion se realizo de manera exitosa, false de lo contrario
	 * @throws ServiceException 
	 * @throws DaoException 
	 */
	public boolean modificarUsuario(String cedula,String password,String nombre,String email) throws ServiceException, DaoException{
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
		if(!Validaciones.isEmail(email)){
			throw new ServiceException("email no valido");
		}
		if(usuarioDAO.obtener(cedula)==null){
			throw new ServiceException("usuario no encontrado");
		}
		Usuario usuario = new Usuario();
		usuario.setCedula(cedula);
		usuario.setEmail(email);
		usuario.setNombre(nombre);
		usuario.setPassword(cifrar.encrypt(password));
		usuarioDAO.modificar(usuario);
		return true;
	}
	/**
	 * Metodo para obtener un usuario al proporcional la cedula.
	 * @param cedula Identificacion del usuario
	 * @return Objeto Usuario, en caso de no existir null
	 * @throws ServiceException 
	 * @throws DaoException 
	 */
	public Usuario obtener(String cedula) throws ServiceException, DaoException{
		if(Validaciones.isTextoVacio(cedula)){
			throw new ServiceException("cedula no valida");
		}
		return usuarioDAO.obtener(cedula);
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	
	

}
