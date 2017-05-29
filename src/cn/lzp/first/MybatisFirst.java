package cn.lzp.first;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;



import cn.lzp.po.Student;



public class MybatisFirst {
	
	private static final SqlSessionFactory SqlSessionFactoryBuilder = null;

		// 根据id查询学生信息，得到一条记录结果
		@Test
		public void findStudentBySidTest() throws IOException{
			// mybatis配置文件
			String resource = "SqlMapConfig.xml";
			// 得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);
           
			// 创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	      
			// 通过工厂得到SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();

			// 通过SqlSession操作数据库
			// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
			// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
			// sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
			// selectOne查询出一条记录
			Student student = sqlSession.selectOne("test.findStudentBySid", 9);

			System.out.println(student);

			// 释放资源
			sqlSession.close();
		}
		
		@Test
		//根据学生姓名查询学生信息
		public void findStudentBySnameTest() throws IOException{
			// mybatis配置文件
			String resource = "SqlMapConfig.xml";
			// 得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);
           
			// 创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	      
			// 通过工厂得到SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//通过SqlSession操作数据库
			List<Student> list=sqlSession.selectList("test.findStudentBySname", "丹丹");
			
			System.out.println(list);
			
			//释放资源
			sqlSession.close();
			
		}
		
		@Test
		//添加学生信息
		public void insertStudentTest() throws IOException{
			// mybatis配置文件
			String resource = "SqlMapConfig.xml";
			// 得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);
           
			// 创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	      
			// 通过工厂得到SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//设置添加信息
			Student student=new Student();
			student.setSname("小花");
			student.setSnumber("123123234");
			student.setSpass("1234");
			student.setSsex("女");
			student.setSage(19);
			student.setSdate("2015");
			student.setCid(1);
			student.setAid(2);
			student.setIsSchool(1);
			
			//通过SqlSession操作数据库
			sqlSession.insert("test.insertStudent", student);
			
			//提交信息
			sqlSession.commit();
			
			//自增主键的值
			System.out.println("自增主键值："+student.getSid());
			
			//释放资源
			sqlSession.close();
			
		}
		
		//删除学生
		@Test
		public void deleteStudentTest() throws IOException{
			 //获取配置文件
			String resource="SqlMapConfig.xml";
			
			//得到配置流
			InputStream inputStream=Resources.getResourceAsStream(resource);
	 
			//创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			
			//打开会话
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//通过sqlSession删除学生
			sqlSession.delete("test.deleteStudent",1);
			
			//注意——提交
			sqlSession.commit();
			
			//释放流
			sqlSession.close();
		}
		
		@Test
		//更新数据
		public void updateStudentTest() throws IOException{
			//获取配置信息
			String resource="SqlMapConfig.xml";
			
			//得到配置流
			InputStream inputStream=Resources.getResourceAsStream(resource);
			
			//创建会话工厂
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			
			//设置添加信息
			Student student=new Student();
			student.setSid(11);
			student.setSname("小花");
			student.setSnumber("123122334");
			student.setSpass("1234");
			student.setSsex("女");
			student.setSage(19);
			student.setSdate("2015");
			student.setCid(1);
			student.setAid(2);
			student.setIsSchool(1);
			
			//打开会话
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//通过SqlSession更新信息
			sqlSession.update("test.updateStudent", student);
			
			//提交
			sqlSession.commit();
			
			//释放
			sqlSession.close();
		}
}
