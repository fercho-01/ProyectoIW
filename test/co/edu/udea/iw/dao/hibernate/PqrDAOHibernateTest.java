package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PqrDAOHibernateTest {
	@Autowired
	PqrDAOHibernate pqrDAO;
	@Test
	public void testObtenerInt() {
		try {
			Pqr pqr = pqrDAO.obtener(3);
			
			System.out.println(pqr.getDescripcion());
			assertTrue(pqr!=null);
		} catch (DaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
