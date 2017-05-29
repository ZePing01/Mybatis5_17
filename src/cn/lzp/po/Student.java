package cn.lzp.po;

public class Student {
	 //id
		private int sid;
		//学生姓名
		private String sname;
		//学号
		private String snumber;
		//密码
		private String spass;
		//年龄
		private int sage;
		//性别
		private String ssex;
		//入学日期
		private String sdate;
		//所属班级
		private int cid;
		//所属学院
		private int aid;
		//是否在校
		//一个TINYINT型数据只占用一个字节,一个INT型数据占用四个字节。
		private int isSchool;
	
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
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
		public String getSpass() {
			return spass;
		}
		public void setSpass(String spass) {
			this.spass = spass;
		}
		public int getSage() {
			return sage;
		}
		public void setSage(int sage) {
			this.sage = sage;
		}
		public String getSsex() {
			return ssex;
		}
		public void setSsex(String ssex) {
			this.ssex = ssex;
		}
		public String getSdate() {
			return sdate;
		}
		public void setSdate(String sdate) {
			this.sdate = sdate;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public int getIsSchool() {
			return isSchool;
		}
		public void setIsSchool(int isSchool) {
			this.isSchool = isSchool;
		}
		@Override
		public String toString() {
			return "Student [sid=" + sid + ", sname=" + sname + ", snumber="
					+ snumber + ", spass=" + spass + ", sage=" + sage
					+ ", ssex=" + ssex + ", sdate=" + sdate + ", cid=" + cid
					+ ", aid=" + aid + ", isSchool=" + isSchool + "]";
		}	
		
}
