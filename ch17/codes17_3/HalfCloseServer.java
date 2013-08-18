package codes17_3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/*
 * 网络通信中不能通过关闭输出流来表示输出已经结束,因为当关闭输出流时,该输出流对应的Socket也将随之关闭,这样导致程序无法从该Socket的输入流中读取数据了
 * (1)Socket提供了两个半关闭的方法,只关闭Socket的输入流或者输出流:shutdownInput(),shutdownOutput()
 * (2)即使用一个Socket实例先后调用shutdownInput(),shutdownOutput()方法,该Socket依然没有被关闭,只是该Socket既不能输出数据,也不能读取数据
 * (3)当调用Socket的shutdownInput()和shutdownOutput()方法关闭了输出流或输入流之后,该Socket无法再次打开输出流或输入流
 */
public class HalfCloseServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("服务器第一行数据");
		ps.println("服务器第二行数据");
		//关闭Socket的输出流
		socket.shutdownOutput();
		System.out.println(socket.isClosed());
		//输入流依然可以正常读取
		Scanner scanner = new Scanner(socket.getInputStream());
		while(scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		}
		scanner.close();
		socket.close();
		ss.close();
	}
}
