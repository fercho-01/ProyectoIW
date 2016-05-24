package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Esta clase implementa la interfaz de EmpleadoDAO
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public class EmpleadoDAOHibernate extends HibernateDaoSupport implements EmpleadoDAO {

	@Override
	public void guardar(Empleado empleado) throws DaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(empleado);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		
	}

	@Override
	public void modificar(Empleado empleado) throws DaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.merge(empleado);
		}catch(HibernateException e){
			throw new DaoException();
		}
		
	}


	@Override
	public Empleado obtener(String cedula) throws DaoException {
		Session session = null;
		Empleado empleado = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			empleado = (Empleado)session.get(Empleado.class, cedula);
		}catch(HibernateException e){
			throw new DaoException(e.getMessage());
		}
		return empleado;
	}

	@Override
	public List<Empleado> obtener() throws DaoException {
		Session session = null;
		List<Empleado> empleados = new ArrayList<Empleado>();
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Empleado.class);
			empleados = criteria.list();
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		return empleados;
	}

}
