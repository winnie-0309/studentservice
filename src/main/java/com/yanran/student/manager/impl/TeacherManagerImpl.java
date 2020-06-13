package com.yanran.student.manager.impl;

import java.util.List;

import com.yanran.student.manager.TeacherManager;
import com.yanran.student.model.Student;
import com.yanran.student.model.Teacher;
import com.yanran.student.util.PageModel;

public class TeacherManagerImpl implements TeacherManager {

	public Teacher checkLogin(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteTeacher(String teachId) {
		// TODO Auto-generated method stub
		return false;
	}


	public Teacher getTeacher(String teachId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Teacher> getAllTeacher(String teachId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteStudent(String studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> getStudents(int start, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<Teacher> getTeachers(String start, String pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

}
