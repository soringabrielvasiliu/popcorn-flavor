package model;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.*;

public class MoviesModel extends AbstractModel<Movie> {

	private static SessionFactory factory;
	public Configuration cfg = new Configuration();
	@SuppressWarnings("deprecation")
	public MoviesModel() {
		super(Movie.class);
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}
		
	public List<Movie> getMovies() {
		try {
			Session s = factory.openSession();
			Query query = s.createQuery("from Movie").setMaxResults(10);
			@SuppressWarnings("unchecked")
			List<Movie> list = (List<Movie>)query.list();
			s.close();
			return list;
		} catch (Exception e) {
			return null;
		} 
	}
	
	public Movie getMovieById(int id) {
		try {
			Session s = factory.openSession();
			Query query = s.createQuery("from Movie where idMovie=:id");
			query.setParameter("id", id);
			Movie m = (Movie) query.uniqueResult();
			return m;
		} catch (Exception e) {
			return null;
		} 
	}
	
	public List<String> getMovieGenres(int id) {
		try {
			Session s = factory.openSession();
			Query  query = s.createQuery("select g.name from Genre g , MovieGenre mg where mg.idMovie= :idd and mg.idGenre = g.idGenre");
			query.setParameter("idd", id);
			List<String> m = (List<String>) query.list();
			s.close();
			return m;
		} catch (Exception e) {
			return null;
		} 
	}
}