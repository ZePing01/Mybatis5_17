package cn.lzp.jdbc;
//JDBC连接数据库，显示数据
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCTest {
   public static void main(String[] args) {
	  //数据库连接
	   Connection connection=null;
	   //预编译的Statement，使用预编译的Statement提高数据库性能
	   PreparedStatement preparedStatement=null;
	   //结果集
	   ResultSet resultSet=null;

	   try {
		//加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver"); 
		
		//获取数据库连接
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/SCM?useUnicode=true&characterEncoding=utf8","root","lizewei");
		
		//定义sql语句，？表示占位符
		String sql="select * from db_student where sname=?";
		
		//获取预处理statement
		preparedStatement = connection.prepareStatement(sql);
		
		//设置参数
		preparedStatement.setString(1, "苏丹丹");
		
		//向数据库发出sql执行查询，查询出结果集
		resultSet=preparedStatement.executeQuery();
		
		//遍历查询结果集
		while(resultSet.next()){
			System.out.println(resultSet.getString("sid")+"  "+resultSet.getString("sname"));
		}
		
	   } catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	   }finally{
		   //释放资源
		   if(resultSet!=null){
			   try{
				   resultSet.close();
			   }catch(SQLException e){
				   e.printStackTrace();
			   }
		   }
		   if(preparedStatement!=null){
			   try{
				   preparedStatement.close();
			   }catch(SQLException e){
				   e.printStackTrace();
			   }
		   }
		   if(connection!=null){
			   try {
				connection.close();
			   } catch (Exception e) {
					// TODO: handle exception
				   e.printStackTrace();
			   }
		   }
	   }
   }
}
