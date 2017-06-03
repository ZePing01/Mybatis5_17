package cn.lzp.po;

import java.util.List;

/**
 * 
 * @author Administrator
 * VO:
 * viewObject：负责封装页面传递过来的数据，viewObject是一个页面上提交后的数据,不一定完全和PO的属性相同....
 */
public class StudentQueryVo {
    //这里包装所需要的查询条件
	
	//传入多个id
	private List<Integer> sids;
	
	//学生查询条件
	private StudentCustom studentCustom;
	
	public StudentCustom getStudentCustom(){
		return studentCustom;
	}
	
	public void setStudentCustom(StudentCustom studentCustom){
		this.studentCustom=studentCustom;
	}

	public List<Integer> getSids() {
		return sids;
	}

	public void setSids(List<Integer> sids) {
		this.sids = sids;
	}
	
	//可以包装其他信息
	
	
}
