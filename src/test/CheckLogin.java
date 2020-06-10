package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String sid=request.getParameter("sid");
		String password=request.getParameter("password");
		//生成验证码
		String checkcode=request.getParameter("checkcode");
		String piccode=(String) request.getSession().getAttribute("piccode");
		StudentManager smg = new StudentManagerImpl();
		Student s=new Student();
		s=smg.CheckLogin(name, sid,password);
		HttpSession session=request.getSession();
		session.setAttribute("s", s);
		if(s!=null && checkcode.equalsIgnoreCase(piccode)) {
			response.sendRedirect("person.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}	

	}
}
