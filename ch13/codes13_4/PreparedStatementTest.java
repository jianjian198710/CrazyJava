package codes13_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/*
 * 1.ʹ��PreparedStatement������
 *   (1)���ܸ���
 *   (2)��ֹSQLע�� ��LoginFrame.class
 * 2.������������������,����ʹ��setObject()�������������,��PreparedStatement����������ת��
 * 3.ռλ������ֻ�ܴ�����ͨ��ֵ
 * 
 */
public class PreparedStatementTest {

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
	
	public void insertUsePrepare() throws Exception{
		try(Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pres = conn.prepareStatement("insert into jdbc_test(jdbc_name,jdbc_desc) values(?,'Fuck')")){
				for(int i=0;i<100;i++){
					//ռλ����Ŵ�1��ʼ
					pres.setString(1,"Fucker"+String.valueOf(i));
					pres.executeUpdate();
				}
			}
	}
	
	public static void main(String[] args) throws Exception {
		PreparedStatementTest pt = new PreparedStatementTest();
		pt.initDB("DBConfig/Mysql.properties");
		pt.insertUsePrepare();
	}
}
