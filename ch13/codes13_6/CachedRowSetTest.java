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
 * CachedRowSet����������RowSet�ĸ��ӿ�,����RowSet��ֱ�ӽ��ײ����ݶ����ڴ���,��װ��RowSet����
 * ������ResultSet������Connection�ر�֮ǰ����
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
				//ʹ��RowSetProvider����RowSetFactory
				RowSetFactory factory = RowSetProvider.newFactory();
				//����Ĭ�ϵ�CachedRowSetʵ��
				CachedRowSet cachers = factory.createCachedRowSet();
				//ʹ��ResultSetװ��RowSet
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
				//�޸�ָ����¼
				cs.updateString(2, "����");
				cs.updateRow();
			}
		}
		//���»�ȡ�ײ�����
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		//�Ѷ�RowSet�������޸�ͬ�����ײ����ݿ�
		cs.acceptChanges(conn);
	}

}
