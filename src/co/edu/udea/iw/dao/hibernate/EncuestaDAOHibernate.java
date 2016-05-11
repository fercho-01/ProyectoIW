package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Implementacion de los metodos de la interfaz EncuestaDAO
 * @auhtor LUIS FERNANDO OROZCO
 */
public class EncuestaDAOHibernate extends HibernateDaoSupport implements EncuestaDAO{

	@Override
	public void guardar(Encuesta encuesta) throws DaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(encuesta);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		
	}

	@Override
	public void modificar(Encuesta encuesta) throws DaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.update(encuesta);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
	}

	@Override
	public Encuesta obtener(int id) throws DaoException {
		Session session = null;
		Encuesta encuesta = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			encuesta = (Encuesta)session.get(Encuesta.class, id);
		}catch(HibernateException e){
			throw new DaoException();
		}
		return encuesta;
	}

	@Override
	public List<Encuesta> obtener() throws DaoException {
		Session session = null;
		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Encuesta.class);
			encuestas = criteria.list();
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		return encuestas;
	}
	

}
