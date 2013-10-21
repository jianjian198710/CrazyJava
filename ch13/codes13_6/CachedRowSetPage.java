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

public class CachedRowSetPage {

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
	
	public CachedRowSet query(String sql,int pageSize,int page) throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql)){
				RowSetFactory factory = RowSetProvider.newFactory();
				CachedRowSet cachedRs = factory.createCachedRowSet();
				//设置每页显示的记录数
				cachedRs.setPageSize(pageSize);
				//使用ResultSet装填RowSet,设置从第几条记录开始
				cachedRs.populate(rs, (page-1)*pageSize+1);
				return cachedRs;
		}
	}
	
	public static void main(String[] args) throws Exception {
		CachedRowSetPage cp = new CachedRowSetPage();
		cp.initDB("DBConfig/Mysql.properties");
		CachedRowSet rs = cp.query("select * from jdbc_test",3,2);
		rs.beforeFirst();
		while(rs.next()){
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
	}

}
