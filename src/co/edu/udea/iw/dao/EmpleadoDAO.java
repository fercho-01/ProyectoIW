package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.util.exception.DaoException;

/*
 * Interfaz que define los metodos que va a implementar el DAO de empleado
 * @author LUIS FERNANDO OROZCO
 */
public interface EmpleadoDAO {
	public void guardar(Empleado empleado)throws DaoException;
	public void modificar(Empleado empleado)throws DaoException;
	public Empleado obtener(String cedula)throws DaoException;
	public List<Empleado> obtener()throws DaoException;
}
