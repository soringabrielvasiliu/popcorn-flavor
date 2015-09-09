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
	private Session session;
	
	public AccountModel() {
		super(User.class);
	}
	
	@SuppressWarnings("deprecation")
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
	
	
	
	@SuppressWarnings("deprecation")
	public User profile(StringBuffer username) {
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
	
	@SuppressWarnings("deprecation")
	public String updateProfile(User u, StringBuffer username) {
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
					query.executeUpdate();
					tx.commit();
				} else {
					Query query = session
							.createQuery("update User u set u.firstName= :firstName, u.lastName= :lastName, u.password= :password where u.username= :username");
					query.setParameter("firstName", u.getFirstName());
					query.setParameter("lastName", u.getLastName());
					query.setParameter("password", u.getPassword());
					query.setParameter("username", username.toString());
					query.executeUpdate();
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}