package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
/*
 * Pruebas para encuesta service
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class EncuestaServiceTest {
	@Autowired
	EncuestaService encuestaService;
	
	private static Logger logger = Logger.getLogger(EmpleadoServiceTest.class);
	/*
	 * Prueba para el metodoEncuesta
	 */
	
	@Test
	public void testCrearEncuesta() {
		Usuario usuario = new Usuario();
		usuario.setCedula("123");
		usuario.setEmail("l@udea.edu.co");
		usuario.setNombre("luis");
		usuario.setPassword("123");
		
		Pqr pqr = new Pqr();
		pqr.setId(1);
		pqr.setDescripcion("no me gusta");
		pqr.setEstado("pendiente");
		pqr.setFechaSolicitud(new Date());
		pqr.setTipo("queja");
		pqr.setUsuario(usuario);
		
		Encuesta encuesta = new Encuesta();
		encuesta.setDescripcion("datos");
		encuesta.setFecha(new Date());
		encuesta.setIdPqr(pqr);
		
		try {
			encuestaService.crearEncuesta(encuesta);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			logger.error("error en encuesta",e);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			logger.error("error en encuesta",e);
		}
	}

}
