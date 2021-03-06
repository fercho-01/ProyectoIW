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

import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.exception.DaoException;
import co.edu.udea.iw.util.exception.ServiceException;
/*
 * Pruebas para la clase EmpleadoService
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
public class EmpleadoServiceTest {
	
	
	private static Logger logger = Logger.getLogger(EmpleadoServiceTest.class);
	
	@Autowired
	EmpleadoService empleadoService;
	/*
	 * Prueba del metodo DelegarResponsabilidad
	 */
	@Test
	public void testDelegarResponsabilidad() {
		logger.info("Se inicia la prueba del metodo delegarResponsabilidad");
		
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
			boolean check = empleadoService.modificarPqr(empleado, pqr);
			assertTrue(check);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
			logger.error("ha ocurrido un error", e);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
			logger.error("ha ocurrido un error", e);
		
		}
		
		logger.info("ha finalizado el test de delegar responsabilidad");
	}

	@Test
	public void validar() {
		Cifrar cifrar = new Cifrar();
		try {
			boolean validacion = empleadoService.validar("987", "983");
			assertTrue(validacion);
		} catch (ServiceException e) {
			fail(e.getMessage());
			e.printStackTrace();
			logger.error("error en validacion",e);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
			logger.error("error en validacion",e);
		}
	}
	
	@Test
	public void guardar() {

		try {
			empleadoService.registrarEmpleado("988","l@udea.edu.co","l","soporte","123");
		} catch (ServiceException e) {
			fail(e.getMessage());
			e.printStackTrace();
			logger.error("error al registrar empleado",e);
		} catch (DaoException e) {
			e.printStackTrace();
			fail();
			logger.error("error al registrar empleado",e);
		}
	}
	
	/**
	 * Prueba para el metodo modificar empleado
	 */
	@Test
	public void modificar() {

		try {
			empleadoService.modificarEmpleado("123", "123", "luis", "l@udea.edu.co", "supervisor");
		} catch (ServiceException e) {
			fail(e.getMessage());
			e.printStackTrace();
			logger.error("error al modificar empleado",e);
		} catch (DaoException e) {
			e.printStackTrace();
			fail();
			logger.error("error al modificar empleado",e);
		}
	}
}
