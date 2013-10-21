package codes13_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC连接的事物支持由Connection提供,Connection默认打开自动提交,即关闭事物
 */
public class TransactionTest {

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
	
	public void insertInTransaction(String[] sqls) throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password)){
				//关闭自动提交,开启事务
				conn.setAutoCommit(false);
				try(Statement state = conn.createStatement()){
						for(String sql:sqls){
							state.executeUpdate(sql);
						}
				}
				//提交事务
				conn.commit();
		}
	}
	
	//设置回滚中间点
	public void insertInTransaction2() throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password)){
				//关闭自动提交,开启事务
				conn.setAutoCommit(false);
				try(Statement state = conn.createStatement()){
							state.executeUpdate("insert into jdbc_test values(null,'DDD',444)");
							//创建中间点
							Savepoint sp = conn.setSavepoint("Save1");
							state.executeUpdate("insert into jdbc_test values(null,'AAA',111)");
							state.executeUpdate("insert into jdbc_test values(null,'EEE',555)");
							//回滚
							conn.rollback(sp);
						}
				//***普通的提交,回滚都会结束当前事务,但回滚到指定中间点因为依然处于事务之中,所以不会结束当前事务
				conn.commit();
				}
	}
	
	public static void main(String[] args) throws Exception {
		TransactionTest tt = new TransactionTest();
		tt.initDB("DBConfig/Mysql.properties");
		String[] sqls = {"insert into jdbc_test values(null,'AAA',111)",
						"insert into jdbc_test values(null,'BBB',222)",
						"insert into jdbc_test values(null,'CCC',333)"};
		tt.insertInTransaction(sqls);
		tt.insertInTransaction2();
		
	}

}
