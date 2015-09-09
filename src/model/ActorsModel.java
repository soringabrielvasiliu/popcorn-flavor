package model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entities.Actor;

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
	
	
	

}
