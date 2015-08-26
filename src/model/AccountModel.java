package model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import entities.*;

public class AccountModel extends AbstractModel<User> {
	private static SessionFactory factory;
	
	public AccountModel() {
		super(User.class);
	}
	
	public User login(String username, String password) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
	            sessionFactory.getCurrentSession().getTransaction().begin();
	
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from User u where u.username=:username and u.password=:password");
	
			query.setString("username", username);
			query.setString("password", password);
	
			return (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int register(String username, String firstName, String lastName,
			String password, String genre, String mail) {
		int noEmail;
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin(); 
			Query verifyUsername = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(username) FROM user where username= :username");
			verifyUsername.setString("username", username);	
			int noUser = verifyUsername.getFetchSize();
			
			System.out.println(noUser );
			if (noUser == 0) {
				Query verifyEmail = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(username) FROM user where username= :username");
				verifyUsername.setString("username", username);	
				noEmail = verifyEmail.getFetchSize();
			
				if (noEmail == 0) {
					Transaction tx = null;
					Session session = factory.openSession();
					tx = ((SharedSessionContract) sessionFactory).beginTransaction();
					Query query = sessionFactory
							.getCurrentSession()
							.createQuery(
									"insert into user(username, firstName, lastName, password, genre, mail)"
											+ "values(username, firstName, lastName, password, genre, mail)");

					query.setString("username", username);
					query.setString("firstName", firstName);
					query.setString("lastName", lastName);
					query.setString("password", password);
					query.setString("genre", genre);
					query.setString("mail", mail);
					tx.commit();
					return 2;
				} else {
					return 0;
				}
			}
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return -1;
		}
	}
}