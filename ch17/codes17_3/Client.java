package codes17_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/*
 * (1)Socket常用构造方法:Socket(InetAddress/String remoteAddress, int port).
 * (2)InputStream getInputStream():返回Socket的输入流,让程序通过该输入流从Socket读取数据,
 * 	  OutputStream getOutputStream():返回Socket的输出流,让程序通过该输出流向Socket写入数据.
 * (3)Socket对象提供了一个setSoTimeout(int Timeout)方法来设置读写超时时长,如果在使用Socket进行读,
 *    写操作完成之前超出了该时间的限制,那么这些方法会抛出SocketTimeoutException.
 * (4)连接超时可以先new一个无连接的Socket,再调用Socket的connect()方法来连接远程服务器,而connect()方法可以
 *    接收一个超时时长的参数
 *    Socket s = new Socket();
 *    s.connect(new InetAddress(host,port),10000);
 */
public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",30000);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		System.out.println("来自服务器端的数据:"+line);
		br.close();
		socket.close();
	}
}
