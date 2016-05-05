package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.util.exception.MyException;
/*
 * Implementacion de los metodos de la interfaz EncuestaDAO
 * @auhtor LUIS FERNANDO OROZCO
 */
public class EncuestaDAOHibernate extends HibernateDaoSupport implements EncuestaDAO{

	@Override
	public void guardar(Encuesta encuesta) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(encuesta);
		}catch(HibernateException e){
			throw new MyException(e);
		}
		
	}

	@Override
	public void modificar(Encuesta encuesta) throws MyException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.update(encuesta);
		}catch(HibernateException e){
			throw new MyException(e);
		}
	}

	@Override
	public Encuesta obtener(int id) throws MyException {
		Session session = null;
		Encuesta encuesta = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			encuesta = (Encuesta)session.get(Encuesta.class, id);
		}catch(HibernateException e){
			throw new MyException();
		}
		return encuesta;
	}

	@Override
	public List<Encuesta> obtener() throws MyException {
		Session session = null;
		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Encuesta.class);
			encuestas = criteria.list();
		}catch(HibernateException e){
			throw new MyException(e);
		}
		return encuestas;
	}
	

}
