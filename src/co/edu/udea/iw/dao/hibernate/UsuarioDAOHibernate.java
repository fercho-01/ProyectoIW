package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.DaoException;
/*
 * Implementacion de la interfaz UsuarioDAO
 * @author LUIS FERNANDO OROZCO
 * @author GILBERTO RENDON
 * @author JONATHAN TORRES
 */
public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO{

	@Override
	public void insertar(Usuario usuario) throws DaoException {
		Session session=null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
	}

	@Override
	public void modificar(Usuario usuario) throws DaoException {
		Session session = null;
		try{
			session=getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.update(usuario);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
	}


	@Override
	public Usuario obtener(String cedula) throws DaoException {
		Usuario usuario = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			usuario = (Usuario)session.get(Usuario.class, cedula);
		}catch(HibernateException e){
			throw new DaoException(e);
		}
		return usuario;
	}

	@Override
	public List<Usuario> obtener() throws DaoException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new DaoException();
		}
		return usuarios;
	}

}
