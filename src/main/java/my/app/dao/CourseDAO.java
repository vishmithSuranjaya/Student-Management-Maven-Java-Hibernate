package my.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import my.app.entity.Courses;
import my.app.hibernate.HibernateUtil;

public class CourseDAO {

	public boolean AddCourse(Courses course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSession().openSession()){
			transaction = session.beginTransaction();
			session.save(course);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return false;
	}
	
	public List<Courses> getAllCourses(){
		 List<Courses> courseList = null;
		 Transaction transaction = null;
		 
		 try(Session session = HibernateUtil.getSession().openSession()){
			 String hql = "FROM Courses";
			 Query<Courses> courses = session.createQuery(hql,Courses.class);
			 courseList = courses.getResultList();
		 }catch (Exception e) {
			// TODO: handle exception
			 
		}
		 return courseList;
	}
}
