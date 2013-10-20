package codes13_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {

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
	
	public CachedRowSet query(String sql)throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql)){
				RowSetFactory factory = RowSetProvider.newFactory();
				CachedRowSet cachers = factory.createCachedRowSet();
				cachers.populate(rs);
				return cachers;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
