package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.MyException;
/*
 * Interfaz que define los metodos que va a implementar el dao de Usuario
 * @author LUIS FERNANDO OROZCO
 * 
 */
public interface UsuarioDAO {
	public void guardar(Usuario usuario)throws MyException;
	public void modificar(Usuario usuario)throws MyException;
	public void eliminar(String cedula)throws MyException;
	public Usuario obtener(String cedula)throws MyException;
	public List<Usuario> obtener()throws MyException;
}
