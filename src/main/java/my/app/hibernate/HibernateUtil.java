package my.app.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import my.app.entity.Student;
import my.app.entity.User;


public class HibernateUtil {

private static SessionFactory sessionFactory;
	
	public static SessionFactory getSession() {
		
		if(sessionFactory == null) {
			Configuration cfg = new Configuration();
			
			Properties props = new Properties();
			props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/university_db");
			props.put(Environment.USER, "root");
			props.put(Environment.PASS, "");
			
			cfg.setProperties(props);
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Student.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
