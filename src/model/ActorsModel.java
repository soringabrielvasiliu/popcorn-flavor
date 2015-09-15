package model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.AccountController;
import entities.Actor;
import entities.ActorPref;
import entities.MoviePref;

public class ActorsModel extends AbstractModel<Actor>{

	private static SessionFactory factory;
	
	@SuppressWarnings("deprecation")
	public ActorsModel() {
		super(Actor.class);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}

	public Actor getActorById(int id) {
		
		try {
			Session s = factory.openSession();
			Query query = s.createQuery("from Actor where idActor=:id");
			query.setParameter("id", id);
			Actor a = (Actor) query.uniqueResult();
			s.close();
			return a;
		} catch (Exception e) {
			return null;
		} 
	}
	
	public String verifyExistingMoviePref(int idActor, StringBuffer username) {
		String response = null;
		Session s = factory.openSession();
		Query query = s.createQuery("from ActorPref where idActor=:idActor and username=:username");
		query.setParameter("idActor", idActor);
		query.setParameter("username", username.toString());
		ActorPref ap = (ActorPref) query.uniqueResult();
		if (ap != null )
			response = null;
		else
			response = "you can add to preferences";
		return response;
	}
	
	public void addToActorPref (int idActor, StringBuffer username) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		ActorPref ap = new ActorPref(idActor,  username.toString());
		s.save(ap);
		tx.commit();
	}

}
