package codes13_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteDDL {

	public void createTable(String sql)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/jianjian";
		String user = "root";
		String password = "198710";
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement state = conn.createStatement()){
			state.executeUpdate(sql);
		}
	}
	public static void main(String[] args) throws Exception {
		ExecuteDDL ed = new ExecuteDDL();
		ed.createTable("create table jdbc_test"+"(jdbc_id int auto_increment primary key,"+"jdbc_name varchar(255),"+"jdbc_desc varchar(255));");
		System.out.println("------建表成功-----");
	}

}
