package my.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int course_id;
	
	@Column(name ="course_name")
	private String course_name;
	
	@Column(name="course_code")
	private String course_code;
	
	@Column(name ="credits")
	private int credits;
	
	@ManyToOne
	@JoinColumn(name="department_id",referencedColumnName = "department_id")
	private Department department;

	public Courses() {
		
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
}
