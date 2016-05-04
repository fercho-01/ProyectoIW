package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.util.exception.MyException;

/*
 * Interfaz que define los metodos que va a implementar el DAO de empleado
 * @author LUIS FERNANDO OROZCO
 */
public interface EmpleadoDAO {
	public void guardar(Empleado empleado)throws MyException;
	public void modificar(Empleado empleado)throws MyException;
	public void eliminar(String cedula)throws MyException;
	public Empleado obtener(String cedula)throws MyException;
	public List<Empleado> obtener()throws MyException;
}
