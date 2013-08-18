package codes17_3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * (1)ServerSocket�������ڼ������Կͻ��˵�Socket����
 * (2)Socket accept()���ڽ���һ���ͻ���Socket����������,�÷�������һ����ͻ���Socket��Ӧ��Socket;����÷���һֱ���ڵȴ�״̬,�߳�Ҳ������
 * (3)ServerSocket���õĹ�����:ServerSocket(int port)
 */
public class Server {
	
	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();
			//��Socket��Ӧ���������װ��PrintStream,����Ϣ���͸�Client
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("You get the message from Server!!");
			ps.close();
			ps.flush();
		}
	}
}
