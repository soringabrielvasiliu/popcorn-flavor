package model;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import entities.*;

public class AccountModel extends AbstractModel<User> {
	private static SessionFactory factory;
	
	public AccountModel() {
		super(User.class);
	}
	
	public User login(String username, String password) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			Session s = factory.openSession();
			Query query = s.createQuery("from User u where u.username=:username and u.password=:password");
	
			query.setString("username", username);
			query.setString("password", password);
	
			return (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
//	public int register(String username, String firstName, String lastName,
//			String password, String genre, String mail) {
//		int noEmail;
//		try {
//			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
//                sessionFactory.getCurrentSession().getTransaction().begin(); 
//			Query verifyUsername = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(username) FROM user where username= :username");
//			verifyUsername.setString("username", username);	
//			int noUser = verifyUsername.getFetchSize();
//			
//			System.out.println(noUser );
//			if (noUser == 0) {
//				Query verifyEmail = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(username) FROM user where username= :username");
//				verifyUsername.setString("username", username);	
//				noEmail = verifyEmail.getFetchSize();
//			
//				if (noEmail == 0) {
//					Transaction tx = null;
//					Session session = factory.openSession();
//					tx = ((SharedSessionContract) sessionFactory).beginTransaction();
//					Query query = sessionFactory
//							.getCurrentSession()
//							.createQuery(
//									"insert into user(username, firstName, lastName, password, genre, mail)"
//											+ "values(username, firstName, lastName, password, genre, mail)");
//
//					query.setString("username", username);
//					query.setString("firstName", firstName);
//					query.setString("lastName", lastName);
//					query.setString("password", password);
//					query.setString("genre", genre);
//					query.setString("mail", mail);
//					tx.commit();
//					return 2;
//				} else {
//					return 0;
//				}
//			}
//			
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			return -1;
//		}
//	}
	
	public User profile(String username) {
		try {

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			Session s = factory.openSession();
			Query query = s.createQuery(
					"from User u where u.username=:username");
			query.setString("username", username.toString());
			return (User) query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public String updateProfile(User u, String username) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				if (u.getPassword().equals("")) {
					Query query = session
							.createQuery("update User u set u.firstName= :firstName, u.lastName= :lastName where u.username= :username");
					query.setParameter("firstName", u.getFirstName());
					query.setParameter("lastName", u.getLastName());
					query.setParameter("username", username.toString());
					int result = query.executeUpdate();
					tx.commit();
				} else {
					Query query = session
							.createQuery("update User u set u.firstName= :firstName, u.lastName= :lastName, u.password= :password where u.username= :username");
					query.setParameter("firstName", u.getFirstName());
					query.setParameter("lastName", u.getLastName());
					query.setParameter("password", u.getPassword());
					query.setParameter("username", username.toString());
					int result = query.executeUpdate();
					tx.commit();
				}
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "Success";
	}

	public void sendRecoveryEmail(String email) {
		try {
			final String username = "yourEail@gmail.com"; // Enter your email here
			final String password = "XXXXX"; // Enter your password here

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			javax.mail.Session session = javax.mail.Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
				message.setSubject("Testing Subject");
				message.setText("Test," + "\n\n No spam to my email, please!");

				Transport.send(message);

				System.out.println("Done sending to " + email);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}