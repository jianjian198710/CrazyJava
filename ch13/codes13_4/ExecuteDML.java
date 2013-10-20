package codes13_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public void initDB(String filename)throws IOException, ClassNotFoundException{
		File file = new File(filename);
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		Class.forName(driver);
	}
	
	public void insertData(String sql)throws Exception{

		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement state = conn.createStatement()){
			state.executeUpdate(sql);
		}
	}
	public static void main(String[] args) throws Exception {
		ExecuteDML ed = new ExecuteDML();
		ed.initDB("DBConfig/Mysql.properties");
		ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc) values ('CCC','CCC_DESC'),('DDD','DDD_DESC');");
	}

}
