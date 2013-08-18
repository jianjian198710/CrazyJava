package codes17_3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/*
 * ����ͨ���в���ͨ���ر����������ʾ����Ѿ�����,��Ϊ���ر������ʱ,���������Ӧ��SocketҲ����֮�ر�,�������³����޷��Ӹ�Socket���������ж�ȡ������
 * (1)Socket�ṩ��������رյķ���,ֻ�ر�Socket�����������������:shutdownInput(),shutdownOutput()
 * (2)��ʹ��һ��Socketʵ���Ⱥ����shutdownInput(),shutdownOutput()����,��Socket��Ȼû�б��ر�,ֻ�Ǹ�Socket�Ȳ����������,Ҳ���ܶ�ȡ����
 * (3)������Socket��shutdownInput()��shutdownOutput()�����ر����������������֮��,��Socket�޷��ٴδ��������������
 */
public class HalfCloseServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("��������һ������");
		ps.println("�������ڶ�������");
		//�ر�Socket�������
		socket.shutdownOutput();
		System.out.println(socket.isClosed());
		//��������Ȼ����������ȡ
		Scanner scanner = new Scanner(socket.getInputStream());
		while(scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		}
		scanner.close();
		socket.close();
		ss.close();
	}
}
