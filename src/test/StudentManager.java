/**
 * 
 */
package test;

import java.util.List;

import test.Student;

/**
 * @author yanran
 *
 */
public interface StudentManager {
	//登陆时
	public Student CheckLogin(String name,String sid,String password);
	//添加学生信息
	public boolean addStudent(Student student);
	//更新学生信息
	public boolean updateStudent(String sid,Student student);
	//删除学生信息
	public boolean deleteStudent(String sid);
	//查询所有的学生信息
	public List<Student> getAllStudent(String sid);

}
