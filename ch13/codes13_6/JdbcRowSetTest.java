package codes13_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
/**
 * (1)RowSet�̳���ResultSet�ӿ�,��ResultSet���,RowSetĬ���ǿɹ���,�ɸ��µ�,�����л��Ľ����,���ҿ���ΪJavaBeanʹ��
 * (2)��������RowSet����,�����ڴ���RowSetʱ�Ѿ������ݴӵײ����ݿ��ȡ�����ڴ�
 * (3)Java 6��ǰ����RowSetҪʹ��RowSetImpl,��������RowSetImpl�Ѿ�ɾ����
 * (4)Java 7������RowSetProvider��RowSetFactory,���ڴ���RowSetʵ��
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
