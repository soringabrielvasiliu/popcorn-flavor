package model;

import java.io.*;
import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import entities.Actor;
import entities.Movie;

@SuppressWarnings("unchecked")
public abstract class AbstractModel<T> {
	
	private static SessionFactory factory;
    private Class<T> entityClass;
    protected final SessionFactory sessionFactory = HibernateUtil
            .getSessionFactory();

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
                    .createQuery("from " + entityClass.getName() + " where idMovie < 20").list();
        } catch (RuntimeException re) {
            return null;
        }
    }

    @SuppressWarnings("deprecation")
	public List<Movie> getMovieDetail(String name) {
//    	Transaction tx = null;
        try {
        	Configuration cfg = new Configuration();
    		cfg.configure("hibernate.cfg.xml");
    		factory = cfg.buildSessionFactory();
    		Session s = factory.openSession();
            Query query = s.createQuery("from Movie where title = :title");
			query.setParameter("title", name);
			List<Movie> list = (List<Movie>)query.list();
//			for (Movie m : list) {
//				System.out.println(m.getIdMovie() + "\t" + m.getTitle() + "\t"
//						+ m.getType() + "\t" + m.getEndYear() + "\t"
//						+ m.getPlot());
//			}
			s.close();
			return list;
        } catch (RuntimeException re) {
            return null;
        }
    }
    
    @SuppressWarnings("deprecation")
	public List<Actor> getActorDetail(String name) {
//    	Transaction tx = null;
    	try {
    		Configuration cfg = new Configuration();
    		cfg.configure("hibernate.cfg.xml");
    		factory = cfg.buildSessionFactory();
    		Session s = factory.openSession();
        	Query query = s.createQuery("from Actor where firstName = :firstName");
        	query.setParameter("firstName", name);
        	List<Actor> list = (List<Actor>)query.list();
//			for (Actor a : list) {
//				System.out.println(a.getIdActor() + "\t" + a.getFirstName()
//						+ "\t" + a.getLastName() + "\t" + a.getNickname()
//						+ "\t" + a.getDateBirth() + "\t" + a.getDateDeath()
//						+ "\t" + a.getBiography() + "\t" + a.getHeight());
//			}
        	s.close();
        	return list;
        	
		} catch (RuntimeException re) {
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