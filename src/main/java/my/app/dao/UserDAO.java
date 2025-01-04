package my.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import my.app.entity.MD5;
import my.app.entity.User;
import my.app.hibernate.HibernateUtil;

public class UserDAO {
	
	private Session session;
	private Transaction transaction;

	public boolean authenticate(String username, String password) {
		
		session = HibernateUtil.getSession().openSession();
		String hql = "FROM User where username = :username";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("username",username);
		
		User user = query.uniqueResult();
		if(user.getPassword().equals(MD5.getMd5(password))) {
			return true;
		}else {
			return false;
		}
	}
}
