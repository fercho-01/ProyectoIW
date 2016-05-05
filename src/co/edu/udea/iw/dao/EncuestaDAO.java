package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.util.exception.MyException;
/*
 * Interfaz que define los metodos que va a implementar el DAO de encuesta
 * @author LUIS FERNANDO OROZCO
 */
public interface EncuestaDAO {
	public void guardar(Encuesta encuesta)throws MyException;
	public void modificar(Encuesta encuesta)throws MyException;
	public Encuesta obtener(int id)throws MyException;
	public List<Encuesta> obtener()throws MyException;
}
