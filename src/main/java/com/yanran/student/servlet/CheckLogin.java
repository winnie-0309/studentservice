package com.yanran.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yanran.student.manager.StudentManager;
import com.yanran.student.manager.impl.StudentManagerImpl;
import com.yanran.student.model.Student;
import com.yanran.student.util.PageModel;

public class CheckLogin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		// String sid=request.getParameter("sid");
		String password = request.getParameter("password");
		// 生成验证码
		String checkcode = request.getParameter("checkcode");
		String piccode = (String) request.getSession().getAttribute("checkcode");
		StudentManager smg = new StudentManagerImpl();
		Student s = new Student();
		s = smg.checkLogin(name, password);
		HttpSession session = request.getSession();
		session.setAttribute("person", s);
		if (s != null && checkcode.equalsIgnoreCase(piccode)) {
			String pageNo = "1";
			String pageSize = "5";
			PageModel<Student> pageModel = smg.getStudents(pageNo, pageSize);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("pageModel", pageModel);
			// response.sendRedirect("../home.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", "登陆失败：用户名，密码，验证码或许不正确！");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}

	}
}
