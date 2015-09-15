package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.AccountController;
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
	
	public void postCommentWithoutRating(String c, int idMovie, StringBuffer username) {
		Date date = new Date();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Comment comm = new Comment(idMovie,  username.toString(), c, date, "null");
		s.save(comm);
		tx.commit();
		s.close();

	}
	
	public void postCommentWithtRating(String c, int idMovie, StringBuffer username, String rating) {
		Date date = new Date();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Comment comm = new Comment(idMovie,  username.toString(), c, date, rating);
		s.save(comm);
		tx.commit();
		s.close();

	}
	
	public List<Comment> getComment(int idMovie) {
		Session s = factory.openSession();
		Query query = s.createQuery("from Comment where idMovie= :idMovie");
		query.setParameter("idMovie", idMovie);
		List<Comment> list = query.list();
		s.close();
		return list;
	}
	public void updateRating( int rating, int idMovie) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("from Movie where idMovie=:idMovie");
		query.setParameter("idMovie", idMovie);
		Movie m = (Movie) query.uniqueResult();
		m.setTotalVoters(m.getTotalVoters() + 1);
		m.setTotalRating((m.getTotalRating() + rating));
		Query queryUpdate = s.createQuery("update Movie set totalRating=:totalRating , totalVoters=:totalVoters where idMovie=:idMovie");
		queryUpdate.setParameter("totalRating", m.getTotalRating());
		queryUpdate.setParameter("totalVoters", m.getTotalVoters());
		queryUpdate.setParameter("idMovie", idMovie);
		queryUpdate.executeUpdate();
		tx.commit();
	}
	
	public void addToWatchlist(int idMovie, StringBuffer username) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Watchlist w = new Watchlist(idMovie,  username.toString());
		s.save(w);
		tx.commit();
	}
	
	public String verifyExistingWatchlist(int idMovie, StringBuffer username) {
		String response = null;
		int idWatchlist;
		Session s = factory.openSession();
		Query query = s.createQuery("from Watchlist where idMovie=:idMovie and username=:username");
		query.setParameter("idMovie", idMovie);
		query.setParameter("username", username.toString());
		Watchlist w = (Watchlist) query.uniqueResult();
		if (w != null )
			response = null;
		else
			response = "you can add to watchlist";
		return response;
	}
	
	public String verifyExistingMoviePref(int idMovie, StringBuffer username) {
		String response = null;
		Session s = factory.openSession();
		Query query = s.createQuery("from MoviePref where idMovie=:idMovie and username=:username");
		query.setParameter("idMovie", idMovie);
		query.setParameter("username", username.toString());
		MoviePref mp = (MoviePref) query.uniqueResult();
		if (mp != null )
			response = null;
		else
			response = "you can add to preferences";
		return response;
	}
	
	public void addToMoviePref (int idMovie, StringBuffer username) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		MoviePref mp = new MoviePref(idMovie,  username.toString());
		s.save(mp);
		tx.commit();
	}
	
	public String  verifyExistingRating(int idMovie,StringBuffer username) {
		String response = null;
		Session s = factory.openSession();
		Query query = s.createQuery("Select rating from Comment where idMovie=:idMovie and username=:username");
		query.setParameter("idMovie", idMovie);
		query.setParameter("username", username.toString());
		List<String> l = (List<String>) query.list();
		if (l == null) return "you can add rate";
		else {
			int ok = 0;
			for ( String c: l) {
				if (c.equals("null")) {
					ok++;
				}
			}
			if (l.size() == ok)
				response = "you can add rate";
			else
				response = null;
		}
		return response;
	}
}