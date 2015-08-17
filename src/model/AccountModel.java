package model;

import org.hibernate.Query;

import entities.*;

public class AccountModel extends AbstractModel<User> {

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
			return null;
		}
	}
}