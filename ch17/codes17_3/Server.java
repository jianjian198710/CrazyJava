package codes17_3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * (1)ServerSocket对象用于监听来自客户端的Socket连接
 * (2)Socket accept()用于接收一个客户端Socket的连接请求,该方法返回一个与客户端Socket对应的Socket;否则该方法一直处于等待状态,线程也被阻塞
 * (3)ServerSocket常用的构造器:ServerSocket(int port)
 */
public class Server {
	
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();
			//将Socket对应的输出流包装成PrintStream,将消息发送给Client
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("You get the message from Server!!");
			ps.close();
			ps.flush();
		}
	}
}
