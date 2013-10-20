package codes13_4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame {

	private final String CONFIG_FILE = "DBConfig/Mysql.properties";
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private JFrame jf = new JFrame("Login on");
	private JTextField nameField = new JTextField(20);
	private JTextField passwordField = new JTextField(20);
	private JButton loginButton = new JButton("登录");
	
	public void init()throws Exception{
		Properties properties = new Properties();
		properties.load(new FileInputStream(CONFIG_FILE));
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		Class.forName(driver);
		
		loginButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validate2(nameField.getText(),passwordField.getText())){
					JOptionPane.showMessageDialog(jf, "登录成功");
				}else{
					JOptionPane.showConfirmDialog(jf, "登录失败");
				}
			}
		});
		jf.add(nameField,BorderLayout.NORTH);
		jf.add(passwordField);
		jf.add(loginButton,BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	
	/*输入'or true or'
	 *SQL:select * from jdbc_test where jdbc_name = ''or true or'' and jdbc_desc = '' 会杯具
	 *所以要使用PreparedStatement validate2
	 */
	public boolean validate(String name, String pass){
		String sql = "select * from jdbc_test where jdbc_name = '"+name+"' and jdbc_desc = '"+pass+"'";
		System.out.println(sql);
		try(Connection conn = DriverManager.getConnection(url, user, password);
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql)){
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validate2(String name, String pass){
		String sql = "select * from jdbc_test where jdbc_name=? and jdbc_desc=?";
		try(Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pres = conn.prepareStatement(sql)){
			pres.setString(1, nameField.getText());
			pres.setString(2, passwordField.getText());
			try(ResultSet rs = pres.executeQuery()){
				if(rs.next()){
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		new LoginFrame().init();
	}

}
