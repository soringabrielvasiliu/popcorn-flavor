package model;

import java.io.*;
import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import entities.Actor;
import entities.Movie;
import entities.MovieCast;
import entities.OtherMovies;

@SuppressWarnings("unchecked")
public abstract class AbstractModel<T> {

	private static SessionFactory factory;
	private Class<T> entityClass;
	protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public AbstractModel(Class<T> entityClass) {
		this.entityClass = entityClass;
	}


	public AbstractModel() {
	}

	public List<T> findAll() {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			return sessionFactory.getCurrentSession()
					.createQuery("from " + entityClass.getName()).list();
		} catch (RuntimeException re) {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public List<Movie> getMovieDetail(String name) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		try {
			Query query = s.createQuery("from Movie where title = :title").setMaxResults(10);
			query.setParameter("title", name);
			List<Movie> list = (List<Movie>) query.list();
			s.close();
			return list;
		} catch (RuntimeException re) {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public List<Actor> getActorDetail(String name) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		try {
			Query query = s
					.createQuery("from Actor where CONCAT(firstName, ' ', lastName) LIKE CONCAT('%', :name, '%') ").setMaxResults(20);
			query.setParameter("name", name);
			List<Actor> list = (List<Actor>) query.list();
			for (Actor a: list) {
				System.out.println(a.getFirstName() + "\t" + a.getLastName());
			}
			s.close();
			return list;

		} catch (RuntimeException re) {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	public List<OtherMovies> getOtherMoviesByActorId(int idActor) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		List<OtherMovies> returnList = new ArrayList<OtherMovies>();
		try {
			Query query = s
					.createQuery("select m.idMovie,m.title, m.beginYear, ma.role from Movie m , MovieActor ma where ma.idActor= :idd and m.idMovie = ma.idMovie");
			query.setParameter("idd", idActor);
			List<Object[]> list = (List<Object[]>) query.list();
			for (Object[] o : list) {
				String idMovie = String.valueOf(o[0]);
				String title = String.valueOf(o[1]);
				String year = String.valueOf(o[2]);
				String role = String.valueOf(o[3]);
				returnList.add(new OtherMovies(idMovie, title, year, role));
			}
			return returnList;
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("deprecation")
	public List<MovieCast> getMovieCast(int idMovie) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		List<MovieCast> returnList = new ArrayList<MovieCast>();
		try {
			Query query = s
					.createQuery("select a.idActor, a.firstName , a.lastName, ma.role from Actor a , MovieActor ma where ma.idMovie= :idd and a.idActor = ma.idActor");
			query.setParameter("idd", idMovie);
			List<Object[]> list = (List<Object[]>) query.list();
			for (Object[] o : list) {
				String idActor = String.valueOf(o[0]);
				String firstName = String.valueOf(o[1]);
				String lastName = String.valueOf(o[2]);
				String role = String.valueOf(o[3]);
				returnList
						.add(new MovieCast(idActor, firstName, lastName, role));
			}
			return returnList;
		} catch (Exception e) {
			return null;
		}

	}

	public void update(T instance) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().merge(instance);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException re) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw re;
		}
	}

	public void delete(T instance) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().delete(instance);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException re) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw re;
		}
	}

	public void create(T instance) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().persist(instance);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException re) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw re;
		}
	}

	public T find(Object primarykey) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			return (T) sessionFactory.getCurrentSession().get(entityClass,
					(Serializable) primarykey);
		} catch (RuntimeException re) {
			return null;
		}
	}
}