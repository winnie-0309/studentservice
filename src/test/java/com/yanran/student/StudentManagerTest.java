package com.yanran.student;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.yanran.student.manager.StudentManager;
import com.yanran.student.manager.impl.StudentManagerImpl;
import com.yanran.student.model.Student;
import com.yanran.student.util.PageModel;

public class StudentManagerTest {

    StudentManager studentManager;

    @Before
    public void setUp() throws Exception {
        studentManager = new StudentManagerImpl();
    }

    @Test
    public void testCheckLogin() {
        Student s = studentManager.checkLogin("yanran", "123456");
        Assert.assertNotNull(s);
        Assert.assertEquals("yanran", s.getName());
        Assert.assertEquals("女", s.getGender());
    }

    @Test
    public void testAddStudent() {
        //假设这些都是页面输入
        Student s = new Student();
        s.setName("tom");
        s.setPassword("123456");
        s.setAddress("武汉");
        s.setGender("男");
        s.setBirthday("2002-09-01");
        //调用接口将学生数据存入数据库中
        boolean success = studentManager.addStudent(s);
        //验证结果-期望成功
        Assert.assertTrue(success);
    }

    @Test
    public void testUpdateStudent() {
        String id ="0";
        String address="江苏";
        //模拟前端获取数据
        Student student = studentManager.getStudent(id);
        System.out.println("更新前："+student);
        //模拟前端修改地址
        student.setAddress(address);
        //更新
        boolean success = studentManager.updateStudent(student);
        //验证结果-期望成功
        Assert.assertTrue(success);
        student = studentManager.getStudent(id);
        Assert.assertEquals(address,student.getAddress());
        System.out.println("更新后："+student);
    }

    @Test
    public void testDeleteStudent() {
        String studentId = "9";
        //删除
        boolean success = studentManager.deleteStudent(studentId);
        //验证结果-期望成功
        Assert.assertTrue(success);
        Student student = studentManager.getStudent(studentId);
        Assert.assertNull(student);
    }

    //Test Drive Develop
    @Test
    public void testQueryAllStudentsByAddress() {
        String address="武汉";
        PageModel<Student> pageModel = studentManager.queryStudents(address,"1","100");
        final List<Student> students = pageModel.getList();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student);
            Assert.assertEquals(address, student.getAddress());
        }
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentManager.getAllStudents();
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    @Test
    public void testGetStudentsWithPage() {
        PageModel<Student> pageModel = studentManager.getStudents("1", "2");
        List<Student> students = pageModel.getList();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.print("当前页:" + pageModel.getPageNo() + " ");
        System.out.print("共" + pageModel.getTotalPages() + "页  ");
        System.out.print("首页:" + pageModel.getTopPageNo() + " ");
        System.out.print("上一页:" + pageModel.getPreviousPageNo() + " ");
        System.out.print("下一页:" + pageModel.getNextPageNo() + " ");
        System.out.print("尾页:" + pageModel.getBottomPageNo() + " ");
        System.out.print("共" + pageModel.getTotalRecords() + "条记录");
        System.out.println();

    }

}
