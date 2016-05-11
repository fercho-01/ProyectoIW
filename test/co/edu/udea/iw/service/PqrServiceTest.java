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
import co.edu.udea.iw.util.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class PqrServiceTest {
	@Autowired
	PqrDAO pqrDao;
	
	@Test
	public void testRealiarPqr() {
		Pqr pqr = new Pqr();
		pqr.setEstado("espera");
		pqr.setEmpleado("12345");
		pqr.setFechaSolicitud(new Date());
		pqr.setTipo("queja");
		pqr.setUsuario("123");
		pqr.setDescripcion("no me gusta el servicio");
		try {
			pqrDao.guardar(pqr);
		} catch (DaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
