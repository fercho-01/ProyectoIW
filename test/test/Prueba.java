package test;

/*
 * @author LUIS FERNANDO OROZCO
 *			JOSÉ RENDÓN
 *			JONATHAN TORRES
 * @version 1.0 
 */

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
//import org.apache.log4j.Priority;
//import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.util.exception.DaoException;
//import co.edu.udea.iw.util.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class Prueba {
	
	
private static Logger logger = Logger.getLogger(Prueba.class);	
	@Autowired
	EmpleadoDAO empleadoDAO;

	@Test
	public void testObtener() throws DaoException {
		logger.info("se inicio la prueba");
		
		List<Empleado> empleados = null;
		
		try{
			empleados = empleadoDAO.obtener();
			
			for(Empleado empleado : empleados){
				System.out.println("Nombre ciudad: " + empleado.getNombre());
			}
			
			assertTrue(true);
		}catch(DaoException e){
		     e.printStackTrace();
			//fail(e.printStackTrace());
			 logger.error("hubo un error",e);
			
		}
		logger.info("la prueba finalizo bien");
	}

	/*Ahora con otra clase*/
	
	@Autowired
	EncuestaDAO encuestaDAO;

	@Test
	public void testObtener1() throws DaoException {
		logger.info("se inicio la prueba");
		
		List<Encuesta> encuestas = null;
		
		try{
			encuestas = encuestaDAO.obtener();
			
			for(Encuesta encuesta : encuestas){
				System.out.println("Nombre ciudad: " + encuesta.getDescripcion());
			}
			
			assertTrue(true);
		}catch(DaoException e){
		     e.printStackTrace();
			//fail(e.printStackTrace());
			 logger.error("hubo un error",e);
			
		}
		logger.info("la prueba finalizo bien");
	}
	
	/**/
	
	
	
	
	
}