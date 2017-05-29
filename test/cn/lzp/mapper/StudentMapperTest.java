package cn.lzp.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.lzp.po.Student;

public class StudentMapperTest {
	
    public SqlSessionFactory sqlSessionFactory;
    
	@Before
	public void setUp() throws Exception {
		//创建sqlSessionFactory
		
		// mybatis配置文件
		String resource="SqlMapConfig.xml";	
		// 得到配置文件流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		       
		// 创建会话工厂，传入mybatis的配置文件信息
		 sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);	
	}
    
	//根据id查询测试
	@Test
	public void testFindStudentBySid() throws Exception {
		//打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper的对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//调用StudentMapper的方法
		Student student=studentMapper.findStudentBySid(105);
		
		System.out.println(student);	
	}
    
	//根据用户名查询测试
	@Test
	public void testFindStudentBySname() throws Exception {
	   //打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//调用StudentMapper方法
		List<Student> list=studentMapper.findStudentBySname("丹丹");
		
		//提交信息
		sqlSession.commit();
		
		System.out.println(list);
	}
		
	//添加学生测试
	@Test
	public void testInsertStudent() throws Exception {
		//打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper的对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//添加学生信息
		Student student=new Student();
		student.setSname("李斯");
		student.setSnumber("123423234");
		student.setSpass("1234");
		student.setSsex("男");
		student.setSage(19);
		student.setSdate("2015");
		student.setCid(1);
		student.setAid(2);
		student.setIsSchool(1);
		
		//调用StudentMapper方法
		studentMapper.insertStudent(student);
		
		//提交信息
		sqlSession.commit();
	}

	//删除学生测试
	@Test
	public void testDeleteStudent() throws Exception {
	   //打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//调用StudentMapper方法
		studentMapper.deleteStudent(346);
		
		//提交信息
		sqlSession.commit();
	}
	
	//更新学生测试
	@Test
	public void TestUpdateStudent() throws Exception{
		//打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//更新学生信息,要考虑同名学生
		Student student=new Student();
		student.setSid(361);
		student.setSname("李斯");
		student.setSnumber("77777777");
		student.setSpass("1234");
		student.setSsex("男");
		student.setSage(19);
		student.setSdate("2015");
		student.setCid(1);
		student.setAid(2);
		student.setIsSchool(1);
		
		//调用StudentMapper方法
		studentMapper.updateStudent(student);
		
		
		//提交信息
		sqlSession.commit();
	}

}
