package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import java.util.Date;

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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class PqrServiceTest {
	@Autowired
	PqrService pqrService;
	/*
	 * Prueba al metodo RealizarPqr
	 */
	@Test
	public void testRealiarPqr() throws DaoException {
		Pqr pqr = new Pqr();
		Usuario usuario = new Usuario();
		usuario.setCedula("123");
		usuario.setNombre("123");
		usuario.setPassword("123");
		usuario.setEmail("l@udea.edu.co");
		
		try {
			pqrService.realiarPqr(usuario, "queja", "no me gusta el servicio");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
