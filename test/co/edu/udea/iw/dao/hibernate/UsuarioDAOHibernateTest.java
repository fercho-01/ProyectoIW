package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Clase con las pruebas de usuarioDAOHibernate
 * @author LUIS FERNANDO OROZCO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioDAOHibernateTest {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	/*
	 * Pruena para el metodo insertar
	 */
	
	@Test
	//@Rollback(false) para que en verdad inserte en la base de datos
	public void testInsertar() {
		Usuario usuario = new Usuario();
		usuario.setCedula("1216713123");
		usuario.setEmail("l@udea.edu.co");
		usuario.setNombre("Luis Fernando");
		usuario.setPassword("123");
		
		try {
			usuarioDao.insertar(usuario);
			assertTrue(true);
		} catch (DaoException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testModificar() {
		
	}
	
	/*
	 * Prueba para el metodo obtener
	 */
	@Test
	public void testObtenerString() {
		try {
			Usuario usuario = usuarioDao.obtener("123");
			System.out.println(usuario.getNombre());
			assertTrue(true);
		} catch (DaoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testObtener() {
		fail("Not yet implemented");
	}
	
}
