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

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
/*
 * Pruebas para la clase PqrService
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class PqrServiceTest {
	
	private static Logger logger=Logger.getLogger(PqrServiceTest.class);
	@Autowired
	PqrService pqrService;
	/*
	 * Prueba al metodo RealizarPqr
	 */
	@Test
	public void testRealiarPqr() throws DaoException {
		logger.info("ha iniciado la prueba de realizar PQR");
		Pqr pqr = new Pqr();
		Usuario usuario = new Usuario();
		usuario.setCedula("123");
		usuario.setNombre("123");
		usuario.setPassword("123");
		usuario.setEmail("l@udea.edu.co");
		
		try {
			boolean check = pqrService.realiarPqr(usuario, "queja", "no me gusta el servicio");
			assertTrue(check);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			logger.error("Ha ocurrido un error en el servicio", e);
		}
		
		logger.info("la prueba de realizar PQR ha finalizado correctamente");
	}
	
	
	
	/*
	 * prueba al metodo realizarRevision
	 */
	
	@Test
	public void testRevision(){

		logger.info("ha iniciado la prueba de realizar Revision");
		try {
			boolean check = pqrService.realizarRevision();
			assertTrue(check);
		} catch (DaoException e) {
			e.printStackTrace();
			fail();
			logger.error(e.getMessage(),e);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			fail();
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		logger.info("la prueba de realizar Revision ha finalizado de forma correcta");
	}

}
