package cn.lzp.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.lzp.po.Student;
import cn.lzp.po.StudentCustom;
import cn.lzp.po.StudentQueryVo;

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
	
	//用户信息综合查询测试
	@Test
	public void testFindStudentList() throws Exception {
		//打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper的对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//创建包装对象，设置查询条件
		StudentCustom studentCustom=new StudentCustom();
		StudentQueryVo studentQueryVo=new StudentQueryVo();
		//studentCustom.setSclass("15级3班");
		studentCustom.setSname("小明");
		
		//传入多个sid
		List<Integer> sids=new ArrayList<Integer>();
		sids.add(1);
		sids.add(6);
		sids.add(7);
		studentQueryVo.setSids(sids);
		studentQueryVo.setStudentCustom(studentCustom);
		
		//调用StudentMapper的方法
		List<StudentCustom> list=studentMapper.findStudentList(studentQueryVo);
		
		System.out.println(list);	
	}
	
	//用户信息综合查询总数
		@Test
		public void testFindStudentCount() throws Exception {
			//打开会话
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//创建StudentMapper的对象
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			
			//创建包装对象，设置查询条件
			StudentCustom studentCustom=new StudentCustom();
			StudentQueryVo studentQueryVo=new StudentQueryVo();
			//由于使用的是动态SQL，如果不设置某个值，就不会拼接在查询语句
			//studentCustom.setSclass("15级3班");
			studentCustom.setSname("小明");
			studentQueryVo.setStudentCustom(studentCustom);
			
			//调用StudentMapper的方法
			int count=studentMapper.findStudentCount(studentQueryVo);
			
			System.out.println(count);	
		}
	    
	//根据id查询测试
	@Test
	public void testFindStudentBySid() throws Exception {
		//打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper的对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//调用StudentMapper的方法
		Student student=studentMapper.findStudentBySid(1);
		
		System.out.println(student);	
	}
    
	//根据id查询测试，用resultMap输出
	@Test
	public void testFindStudentBySidResultMap() throws Exception {
		//打开会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//创建StudentMapper的对象
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		
		//调用StudentMapper的方法
		Student student=studentMapper.findStudentBySidResultMap(4);
		
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
		List<Student> list=studentMapper.findStudentBySname("小明");
		
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
		//student.setSid("2");
		student.setSname("赵小明");
		student.setSnumber("2511150307");
	    student.setSclass("15级3班");
	    student.setScourse("离散数学");
	    student.setSscore("46");
	    
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
		studentMapper.deleteStudent(3);
		
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
		student.setSname("李斯");
		student.setSnumber("2511150301");
	    student.setSclass("15级3班");
	    student.setScourse("离散数学");
	    student.setSscore("70");
		
		//调用StudentMapper方法
		studentMapper.updateStudent(student);
		
		
		//提交信息
		sqlSession.commit();
	}

}
