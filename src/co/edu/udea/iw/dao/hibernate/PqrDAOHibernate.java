package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PqrDAO;
import co.edu.udea.iw.dto.Pqr;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Implementacion de los metodos de la interfaz PqrDAO
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public class PqrDAOHibernate extends HibernateDaoSupport implements PqrDAO{

	@Override
	public void guardar(Pqr pqr) throws DaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(pqr);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
	}

	@Override
	public void modificar(Pqr pqr) throws DaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.update(pqr);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		
	}

	@Override
	public Pqr obtener(Integer id) throws DaoException {
		Session session = null;
		Pqr pqr = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			Criteria criteria = session.createCriteria(Pqr.class).add(Restrictions.eq("id", id));
			pqr= (Pqr)criteria.uniqueResult();
			
			if(pqr==null){
				System.out.println("retorno null");
			}
		}catch(HibernateException e){
			throw new DaoException(e);
		}catch(Exception e){
			throw new DaoException(e);
		}
		return pqr;
	}

	@Override
	public List<Pqr> obtener() throws DaoException {
		Session session = null;
		List<Pqr> pqrs = new ArrayList<Pqr>();
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Pqr.class);
			pqrs = criteria.list();
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		return pqrs;
	}

	@Override
	public List<Pqr> obtenerSinResponder() throws DaoException {
		Session session = null;
		List<Pqr> pqrs = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Pqr.class);
			criteria.add(Restrictions.eq("estado", "pendiente"));
			pqrs = criteria.list();
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		return pqrs;
	}
	
	

}
