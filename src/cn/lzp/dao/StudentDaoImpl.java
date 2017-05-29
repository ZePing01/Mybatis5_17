package cn.lzp.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import cn.lzp.po.Student;

/*
 * dao实现类
 */
public class StudentDaoImpl implements IStudentDao {
    
	//需要向dao实现类中注入SqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	
	//通过构造函数来注入
	public StudentDaoImpl(SqlSessionFactory sqlSessionFactory){
		
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	//根据id查询学生
	@Override
	public Student findStudentBySid(int sid) throws Exception {
	    //打开SqlSession 
		SqlSession sqlSession=sqlSessionFactory.openSession();
	      
		//通过SqlSession操作数据库
		Student student=sqlSession.selectOne("test.findStudentBySid", sid);

		//释放资源
		sqlSession.close();
		
		return student;
		
	     
	}
    
	//添加学生
	@Override
	public void insertStudent(Student student) throws Exception {
		//打开SqlSession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//通过SqlSession连接数据库
		sqlSession.insert("test.deleteStudent", student);
		
		//提交信息
		sqlSession.commit();
		
		//释放资源
		sqlSession.close();
		
	}
    
	//删除学生
	@Override
	public void deleteStudent(int sid) throws Exception {
		//打开SqlSession
	SqlSession sqlSession=sqlSessionFactory.openSession();
	
	//通过SqlSession连接数据库
	sqlSession.insert("test.insertStudent", sid);
	
	//提交信息
	sqlSession.commit();
	
	//释放资源
	sqlSession.close();
		
	}

}
