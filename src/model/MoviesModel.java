package model;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.*;

public class MoviesModel extends AbstractModel<Movie> {

	public MoviesModel() {
		super(Movie.class);
	}
	
	private static SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	public List<Movie> getMovies() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			Session s = factory.openSession();
			Query query = s.createQuery("from Movie").setMaxResults(1000);
			
			@SuppressWarnings("unchecked")
			List<Movie> list = (List<Movie>)query.list();
			s.close();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}