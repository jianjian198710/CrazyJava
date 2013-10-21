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
/**
 * CachedRowSet是所有离线RowSet的父接口,离线RowSet会直接将底层数据读入内存中,封装成RowSet对象
 * 避免了ResultSet必须在Connection关闭之前处理
 */
public class CachedRowSetTest {

	private String driver;
	private static String url;
	private static String user;
	private static String password;
	
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
				//使用RowSetProvider创建RowSetFactory
				RowSetFactory factory = RowSetProvider.newFactory();
				//创建默认的CachedRowSet实例
				CachedRowSet cachers = factory.createCachedRowSet();
				//使用ResultSet装填RowSet
				cachers.populate(rs);
				return cachers;
		}
	}
	
	public static void main(String[] args) throws Exception {
		CachedRowSetTest ct = new CachedRowSetTest();
		ct.initDB("DBConfig/Mysql.properties");
		CachedRowSet cs = ct.query("select * from jdbc_test");
		cs.beforeFirst();
		while(cs.next()){
			System.out.println(cs.getString(1)+"\t"+cs.getString(2)+"\t"+cs.getString(3));
			if(cs.getInt("jdbc_id")==3){
				//修改指定记录
				cs.updateString(2, "尼玛");
				cs.updateRow();
			}
		}
		//重新获取底层连接
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		//把对RowSet所做的修改同步到底层数据库
		cs.acceptChanges(conn);
	}

}
