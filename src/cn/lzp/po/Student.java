package cn.lzp.po;

public class Student {
    private String sid;
    private String sname;
    private String snumber;
    private String sclass;
    private String scourse;
    private String sscore;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getScourse() {
		return scourse;
	}
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	public String getSscore() {
		return sscore;
	}
	public void setSscore(String sscore) {
		this.sscore = sscore;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", snumber="
				+ snumber + ", sclass=" + sclass + ", scourse=" + scourse
				+ ", sscore=" + sscore + "]";
	}
	
   
}
