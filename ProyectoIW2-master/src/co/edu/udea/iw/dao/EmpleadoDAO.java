package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.util.exception.DaoException;

/*
 * Interfaz que define los metodos que va a implementar el DAO de empleado
 * @author LUIS FERNANDO OROZCO
 */
public interface EmpleadoDAO {
	/*
	 * Metodo para guardar un empleado
	 * @param empleado Objeto que se va a insertar en la base de datos
	 */
	public void guardar(Empleado empleado)throws DaoException;
	
	/*
	 * Modifica un empleado en la base de datos
	 * @param empleado Objeto con los datos actualizados
	 */
	public void modificar(Empleado empleado)throws DaoException;
	
	/*
	 * Busca un empleado en la base de datos por cedula
	 * @param cedula Cedula del empleado
	 * @return Objeto empleado, si no se encuentra null
	 */
	public Empleado obtener(String cedula)throws DaoException;
	
	/*
	 * Se Obtiene lista con todos los empleados presentes en la base de datos
	 */
	public List<Empleado> obtener()throws DaoException;
}
