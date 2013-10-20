package codes13_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
/**
 * (1)RowSet继承了ResultSet接口,与ResultSet相比,RowSet默认是可滚动,可更新的,可序列化的结果集,并且可作为JavaBean使用
 * (2)对于离线RowSet而言,程序在创建RowSet时已经把数据从底层数据库读取到了内存
 * (3)Java 6以前生成RowSet要使用RowSetImpl,但是现在RowSetImpl已经删除了
 * (4)Java 7增加了RowSetProvider和RowSetFactory,用于创建RowSet实例
 */
public class JdbcRowSetTest {

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
	
	public void update(String sql)throws Exception{
		RowSetFactory factory = RowSetProvider.newFactory();
		try(JdbcRowSet jdbcRs = factory.createJdbcRowSet()){
			jdbcRs.setUrl(url);
			jdbcRs.setUsername(user);
			jdbcRs.setPassword(password);
			jdbcRs.setCommand(sql);
			jdbcRs.execute();
			jdbcRs.afterLast();
			while(jdbcRs.previous()){
				System.out.println(jdbcRs.getString(1)+"\t"+jdbcRs.getString(2)+"\t"+jdbcRs.getString(3));
				if(jdbcRs.getString("jdbc_desc").equals("AAA_DESC")){
					jdbcRs.updateString("jdbc_desc", "SB");
					jdbcRs.updateRow();
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		JdbcRowSetTest jt = new JdbcRowSetTest();
		jt.initDB("DBConfig/Mysql.properties");
		jt.update("select * from jdbc_test");
	}

}
