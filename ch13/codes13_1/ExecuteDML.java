package codes13_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteDML {

	public void insertData(String sql)throws Exception{
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
		ExecuteDML ed = new ExecuteDML();
		ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc) values ('AAA','AAA_DESC'),('BBB','BBB_DESC');");
	}

}
