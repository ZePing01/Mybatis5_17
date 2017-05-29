package cn.lzp.mapper;

import java.util.List;

import cn.lzp.po.Student;

/**
 *  mapper接口
 * @author Administrator
 *
 */
public interface StudentMapper {

	//根据Id查询用户
	public Student findStudentBySid(int sid)throws Exception;
	
	//通过姓名查询学生表的记录
	public List<Student> findStudentBySname(String name)throws Exception;
	
	//添加学生
	public void insertStudent(Student student)throws Exception;
	
	//删除学生
    public void deleteStudent(int sid)throws Exception;
    
    //更新学生
    public void updateStudent(Student student)throws Exception;
    
}
