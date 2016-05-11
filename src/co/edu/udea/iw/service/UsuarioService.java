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
	 */
	@Transactional
	public void crearUsuario(String cedula, String password, String nombre, String email) throws ServiceException, DaoException{
		
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
	
	/*
	 * Crea una PQR (Peticion Queja o sujerencia)
	 * @param cedula La cedula del usuario que realiza la solicitud
	 * @param tipo El tipo de solicitud (Queja, Reclamo, sujerencia)
	 * @param descripcion La descripcion de la solicitud
	 * 
	 */
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	
	

}
