package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.MyException;
/*
 * Interfaz que define los metodos que va a implementar el DAO de Pqr
 * @author LUIS FERNANDO OROZCO
 */
public interface PqrDAO {
	public void guardar(Pqr pqr)throws MyException;
	public void modificar(Pqr pqr)throws MyException;
	public Pqr obtener(int id)throws MyException;
	public List<Pqr> obtener()throws MyException;
}
