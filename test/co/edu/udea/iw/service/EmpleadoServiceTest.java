package co.edu.udea.iw.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
/*
 * Pruebas para la clase EmpleadoService
 * @author LUIS FERNANDO OROZCO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class EmpleadoServiceTest {
	
	@Autowired
	EmpleadoService empleadoService;
	/*
	 * Prueba del metodo DelegarResponsabilidad
	 */
	@Test
	public void testDelegarResponsabilidad() {
		Empleado empleado = new Empleado();
		empleado.setCedula("987");
		empleado.setCargo("atencion");
		empleado.setEmail("f@udea.edu.co");
		empleado.setNombre("fecho");
		empleado.setPassword("123");
		
		Pqr pqr = new Pqr();
		pqr.setDescripcion("no me gusta el servicio");
		pqr.setEstado("pendiente");
		pqr.setFechaSolicitud(new Date());
		pqr.setId(1);
		pqr.setTipo("queja");
		
		try {
			empleadoService.delegarResponsabilidad(empleado, pqr);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
