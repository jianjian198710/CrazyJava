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
 * (1)ResultSet��λ��¼ָ��ķ�����absolute(),previous(),next(),last()�ȷ���
 * (2)��Ĭ�Ϸ�ʽ�򿪵�ResultSet�ǲ��ɸ��µ�
 * (3)�������͵�ResultSetType(ResultSet.TYPE_FORWARD_ONLY,TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE)
 * (4)�������͵�ResultSetConcurrency(ResultSet.CONCUR_UPDATABLE,CONCUR_READ_ONLY)
 * (5)���Ҫ�����ɸ��µ�ResultSet,��ʹ�ò�ѯ����ѯ������ͨ��ֻ��������һ�����ݱ�,
 *    ���Ҳ�ѯ������е����ݱ������������,������������ʧ��
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
			//�򿪿ɸ��µ�ResultSet
			PreparedStatement pres = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pres.executeQuery()){
				rs.last();
				int rowCount = rs.getRow();
				for(int i=rowCount;i>0;i--){
					rs.absolute(i);
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
					//����
					rs.updateString(2, "ѧ����"+i);
					//���ݿ�������ݱ�������
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
