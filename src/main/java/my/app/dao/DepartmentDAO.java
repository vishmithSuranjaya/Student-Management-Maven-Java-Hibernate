package my.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import my.app.entity.Department;
import my.app.hibernate.HibernateUtil;

public class DepartmentDAO {
	
	public List<Department> getAllDepts(){
		List<Department> deptList = null;
		
		try(Session session = HibernateUtil.getSession().openSession()){
			String hql = "FROM Department";
			Query<Department> depts = session.createQuery(hql,Department.class);
			deptList = depts.getResultList();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return deptList;
	}

}
