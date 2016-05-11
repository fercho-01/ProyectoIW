package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PqrDAOHibernateTest {
	
	@Autowired
	PqrDAOHibernate pqrDao;
	
	@Test
	public void testGuardar() {
		Pqr pqr = new Pqr();
		pqr.setDescripcion("123");
		pqr.setEstado("pendiente");
		pqr.setFechaSolicitud(new Date());
		//pqr.setEmpleado("123456");
		pqr.setTipo("Queja");
		pqr.setUsuario("123");
		
		try {
			pqrDao.guardar(pqr);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
