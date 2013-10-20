package codes13_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * (1)ResultSet定位记录指针的方法有absolute(),previous(),next(),last()等方法
 * (2)以默认方式打开的ResultSet是不可更新的
 * (3)三种类型的ResultSetType(ResultSet.TYPE_FORWARD_ONLY,TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE)
 * (4)两种类型的ResultSetConcurrency(ResultSet.CONCUR_UPDATABLE,CONCUR_READ_ONLY)
 * (5)如果要创建可更新的ResultSet,则使用查询语句查询的数据通常只能来自于一个数据表,
 *    而且查询结果集中的数据必须包含主键列,否则会引起更新失败
 */
public class ResultSetTest {

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
	
	public void query(String sql)throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password);
			//打开可更新的ResultSet
			PreparedStatement pres = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pres.executeQuery()){
				rs.last();
				int rowCount = rs.getRow();
				for(int i=rowCount;i>0;i--){
					rs.absolute(i);
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					//更新
					rs.updateString(2, "学生名"+i);
					//数据库里的数据被更新了
					rs.updateRow();
				}
		}
	}
	public static void main(String[] args) throws Exception {
		ResultSetTest rt = new ResultSetTest();
		rt.initDB("DBConfig/Mysql.properties");
		rt.query("select * from jdbc_test");
	}

}
