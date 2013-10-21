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
 * JDBC���ӵ�����֧����Connection�ṩ,ConnectionĬ�ϴ��Զ��ύ,���ر�����
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
				//�ر��Զ��ύ,��������
				conn.setAutoCommit(false);
				try(Statement state = conn.createStatement()){
						for(String sql:sqls){
							state.executeUpdate(sql);
						}
				}
				//�ύ����
				conn.commit();
		}
	}
	
	//���ûع��м��
	public void insertInTransaction2() throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password)){
				//�ر��Զ��ύ,��������
				conn.setAutoCommit(false);
				try(Statement state = conn.createStatement()){
							state.executeUpdate("insert into jdbc_test values(null,'DDD',444)");
							//�����м��
							Savepoint sp = conn.setSavepoint("Save1");
							state.executeUpdate("insert into jdbc_test values(null,'AAA',111)");
							state.executeUpdate("insert into jdbc_test values(null,'EEE',555)");
							//�ع�
							conn.rollback(sp);
						}
				//***��ͨ���ύ,�ع����������ǰ����,���ع���ָ���м����Ϊ��Ȼ��������֮��,���Բ��������ǰ����
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
