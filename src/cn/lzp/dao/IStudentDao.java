package cn.lzp.dao;

import cn.lzp.po.Student;

public interface IStudentDao {
	
	//根据id查询
	public Student findStudentBySid(int sid) throws Exception;
	
	//添加学生
	public void insertStudent(Student student) throws Exception;
	
	//删除学生
	public void deleteStudent(int sid) throws Exception;
	
}
