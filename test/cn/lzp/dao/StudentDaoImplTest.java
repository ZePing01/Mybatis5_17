package cn.lzp.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import cn.lzp.po.Student;

public class StudentDaoImplTest {
	
    private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		//创建sqlSessionFactory
		
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
       
		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
    //测试根据id查询的方法
	@Test
	public void testFindStudentBySid() throws Exception {
		//创建IStudentDao的对象
		IStudentDao iStudentDao=new StudentDaoImpl(sqlSessionFactory);
	     
		//调用IStudentDao的方法
		Student student=iStudentDao.findStudentBySid(346);
		
		System.out.println(student);
	}
    
	//测试添加学生
	@Test
	public void testInsertStudent() throws Exception{
		//创建IStudentDao的对象
		IStudentDao iStudentDao=new StudentDaoImpl(sqlSessionFactory);
	     
		Student student=new Student();
		student.setSname("李斯");
		student.setSnumber("2511150301");
	    student.setSclass("15级3班");
	    student.setScourse("离散数学");
	    student.setSscore("70");
		
		//调用IStudentDao的方法
		iStudentDao.insertStudent(student);
		
		System.out.println(student);
	}
	
	//测试删除学生
//	@Test
//	public void testDeleteStudent() throws Exception{
//		//创建IStudentDao的对象
//		IStudentDao iStudentDao=new StudentDaoImpl(sqlSessionFactory);
//	     
//		//调用IStudentDao的方法
//		Student 
//		iStudentDao.deleteStudent(student);
//		
//		System.out.println();
//	}
}
