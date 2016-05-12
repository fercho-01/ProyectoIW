package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
/*
 * Pruebas de la clase UsuarioService
 * @author LUIS FERNANDO OROZCO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class UsuarioServiceTest {
	
	private static Logger logger=Logger.getLogger(UsuarioServiceTest.class);
	
	@Autowired
	UsuarioService usuarioService;
	
	/*
	 * Prueba para el metodo CrearUsuario
	 */
	@Test
	public void testCrearUsuario() {
		logger.info("la prueba de Crear usuario ha iniciado");
		try {
			usuarioService.crearUsuario("1111", "luis", "luis", "l@udea.edu.co");
			System.out.println(new Cifrar().encrypt("123"));
		} catch (ServiceException e) {
			e.printStackTrace();
			//fail(e.getMessage());
			logger.error(e.getMessage(),e);
		} catch (DaoException e) {
			e.printStackTrace();
			//fail(e.getMessage());
			logger.error(e.getMessage(),e);
		}
		logger.info("la prueba de crear usuario finalizo");
	}

	/*
	 * Prueba para el metodo Login
	 */
	@Test
	public void testLogin() {
		
		logger.info("se inicia la prueba de login");
		try {
			usuarioService.login("123", "123");
		} catch (DaoException e) {
			e.printStackTrace();
			//fail(e.getMessage());
			logger.error(e.getMessage(),e);
		} catch (ServiceException e) {
			e.printStackTrace();
			//fail(e.getMessage());
			logger.error(e.getMessage(),e);
		}
		logger.info("la prueba de login ha finalizado");
	}


}
