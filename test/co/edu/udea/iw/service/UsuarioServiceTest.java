package co.edu.udea.iw.service;

import static org.junit.Assert.*;

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
	
	@Autowired
	UsuarioService usuarioService;
	
	/*
	 * Prueba para el metodo CrearUsuario
	 */
	@Test
	public void testCrearUsuario() {
		try {
			usuarioService.crearUsuario("1111", "luis", "luis", "l@udea.edu.co");
			System.out.println(new Cifrar().encrypt("123"));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (DaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/*
	 * Prueba para el metodo Login
	 */
	@Test
	public void testLogin() {
		try {
			usuarioService.login("123", "123");
		} catch (DaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}


}
