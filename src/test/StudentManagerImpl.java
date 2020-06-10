package test;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import test.DBO;


public class StudentManagerImpl implements StudentManager {

	public Student CheckLogin(String name, String sid, String password) {
		Student s=null;
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="select * from student";
		conn=(Connection) DBO.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String nm=rs.getString("name");
				String id=rs.getString("sid");
				String psd=rs.getString("password");
	if(nm.equals(name) && id.equals(sid) && psd.equals(password)) {
					s= new Student();
					s.setName(nm);
					s.setSid(id);
					s.setPassword(psd);
					s.setGender(rs.getString("gender"));
					s.setAddress(rs.getString("address"));
					s.setId(rs.getInt("id"));
					s.setBirthday(rs.getString("birthday"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="insert into student(sid,name,password,gender,birthday,address) values(?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pst=null;
		conn=(Connection) DBO.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,student.getSid());
			pst.setString(2,student.getName());
			pst.setString(3, student.getPassword());
			pst.setString(4,student.getGender());
			pst.setString(5,student.getBirthday());
			pst.setString(6,student.getAddress());	
			pst.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean updateStudent(String sid, Student student) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="update student set name=?,password=?,gender=?,birthday=?,address=? where sid='"+sid+"'";
		Connection conn=null;
		PreparedStatement pst=null;
		conn=(Connection) DBO.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1,student.getName());
			pst.setString(2,student.getPassword());
			pst.setString(3,student.getGender());
			pst.setString(4,student.getBirthday());
			pst.setString(5,student.getAddress());	
			pst.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean deleteStudent(String sid) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="delete from student where sid='"+sid+"'";
		System.out.println(sql);
		Connection conn=null;
		PreparedStatement pst=null;
		conn=(Connection) DBO.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			int row=pst.executeUpdate();
			if(row>0)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public List<Student> getAllStudent(String sid) {
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		String sql="select * from student where sid='"+sid+"'";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		conn=(Connection) DBO.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Student s=new Student();
				s.setSid(sid);
				s.setName(rs.getString("name"));
				s.setPassword(rs.getString("password"));
				s.setGender(rs.getString("gender"));
				s.setBirthday(rs.getString("birthday"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}	
}
