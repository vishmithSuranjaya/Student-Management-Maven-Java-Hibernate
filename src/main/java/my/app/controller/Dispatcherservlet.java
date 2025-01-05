package my.app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.app.dao.StudentDAO;
import my.app.dao.UserDAO;
import my.app.entity.Student;

/**
 * Servlet implementation class Dispatcherservlet
 */
@WebServlet("/")
public class Dispatcherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url_path = request.getServletPath();
		
		if(url_path.equals("/")) {
			getView(request, "login").forward(request, response);
		}else if(url_path.equals("/login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDAO userdao = new UserDAO();
			if(userdao.authenticate(username, password)) {
				getView(request, "/dashboard").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/");
			}
		}else if(url_path.equals("/students")) {
			List<Student> stdList = new StudentDAO().getAllStudents();
			request.setAttribute("stdList", stdList);
			getView(request, "students").forward(request, response);
		}else if(url_path.equals("/save-student")) {
			Student std = new Student();
			std.setFirst_name(request.getParameter("firstname"));
			std.setLast_name(request.getParameter("lastname"));
			std.setEmail(request.getParameter("email"));
			
			try {
				std.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")));
				std.setEnrollement_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enrollmentdate")));
			}catch(ParseException e) {
				e.printStackTrace();
			}
			
			std.setGender(request.getParameter("gender").charAt(0));
			std.setPhone(request.getParameter("phone"));
			std.setAddress(request.getParameter("address"));
			
			new StudentDAO().saveStudent(std);
			response.sendRedirect(request.getContextPath()+"/students");
		}else if(url_path.equals("/deleteStudent")) {
			int id = Integer.parseInt(request.getParameter("u"));
			new StudentDAO().deleteStudent(id);
			response.sendRedirect(request.getContextPath()+"/students");
		}else if(url_path.equals("/editStudent")) {
			int id = Integer.parseInt(request.getParameter("u"));
			Student std = new StudentDAO().getStudent(id);
			request.setAttribute("student", std);
			getView(request, "editStudent").forward(request, response);
			
		}else if(url_path.equals("/update-student")) {
			int id = Integer.parseInt(request.getParameter("u"));
			Student std = new Student();
			std.setStudent_id(id);
			std.setFirst_name(request.getParameter("firstname"));
			std.setLast_name(request.getParameter("lastname"));
			std.setEmail(request.getParameter("email"));
			
			try {
				std.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")));
				std.setEnrollement_date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enrollmentdate")));
			}catch(ParseException e){
				e.printStackTrace();
			}
			
			std.setGender(request.getParameter("gender").charAt(0));
			std.setPhone(request.getParameter("phone"));
			std.setAddress(request.getParameter("address"));
			
			new StudentDAO().UpdateStudent(std);
			response.sendRedirect(request.getContextPath() + "/students");
		}else if(url_path.equals("/courses")) {
			getView(request, "courses").forward(request, response);
		}
	}
	
	private RequestDispatcher getView(HttpServletRequest request, String view) {
		return request.getRequestDispatcher("/WEB-INF/views/"+view+".jsp");
	}

}
