package com.yanran.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanran.student.manager.StudentManager;
import com.yanran.student.manager.TeacherManager;
import com.yanran.student.manager.impl.StudentManagerImpl;
import com.yanran.student.manager.impl.TeacherManagerImpl;
import com.yanran.student.model.Student;
import com.yanran.student.model.Teacher;
import com.yanran.student.util.PageModel;

public class Page extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		if("teacher".equals(type)) {
			TeacherManager smg = new TeacherManagerImpl();
			PageModel<Teacher> pageModel = smg.getTeachers(pageNo, pageSize);
			request.setAttribute("pageModel", pageModel);
		}else {
			StudentManager smg = new StudentManagerImpl();
			PageModel<Student> pageModel = smg.getStudents(pageNo, pageSize);
			request.setAttribute("pageModel", pageModel);
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageSize", pageSize);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

}
