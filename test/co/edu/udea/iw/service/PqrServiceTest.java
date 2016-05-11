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
/*
 * Pruebas para la clase PqrService
 * @author LUIS FERNANDO OROZCO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class PqrServiceTest {
	@Autowired
	PqrDAO pqrDao;
	/*
	 * Prueba al metodo RealizarPqr
	 */
	@Test
	public void testRealiarPqr() {
		Pqr pqr = new Pqr();
		Usuario usuario = new Usuario();
		usuario.setCedula("123");
		usuario.setNombre("123");
		usuario.setPassword("123");
		usuario.setEmail("l@udea.edu.co");
		pqr.setUsuario(usuario);
		pqr.setEstado("espera");
		//pqr.setEmpleado("12345");
		pqr.setFechaSolicitud(new Date());
		pqr.setTipo("queja");
		
		//pqr.setUsuario("123");
		pqr.setDescripcion("no me gusta el servicio");
		try {
			pqrDao.guardar(pqr);
		} catch (DaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
