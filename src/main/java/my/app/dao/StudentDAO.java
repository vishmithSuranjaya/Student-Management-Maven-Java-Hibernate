package my.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import my.app.entity.Student;
import my.app.hibernate.HibernateUtil;

public class StudentDAO {

	public boolean saveStudent(Student std) {
		
		Transaction transaction = null;
		Session session = HibernateUtil.getSession().openSession();
			transaction = session.beginTransaction();
			session.save(std);
			transaction.commit();
			return true;
	}
	
	public List<Student> getAllStudents(){
		List<Student> stdList = null;
		Session session = HibernateUtil.getSession().openSession();
		String hql = "FROM Student";
		Query<Student> query = session.createQuery(hql,Student.class);
		stdList = query.getResultList();
		return stdList;
	}
	
	public boolean deleteStudent(int id) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction transaction = session.beginTransaction();
		Student stu = session.get(Student.class, id);
		if(stu != null) {
			session.delete(stu);
			transaction.commit();
			return true;
		}
		return false;
	}
	
	public Student getStudent(int id) {
		Session session = HibernateUtil.getSession().openSession();
		Student std = session.get(Student.class, id);
		return std;
	}
	
	public boolean UpdateStudent(Student std) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(std);
		transaction.commit();
		return true;
	}
}
