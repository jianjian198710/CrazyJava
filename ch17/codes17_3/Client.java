package codes17_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/*
 * (1)Socket���ù��췽��:Socket(InetAddress/String remoteAddress, int port).
 * (2)InputStream getInputStream():����Socket��������,�ó���ͨ������������Socket��ȡ����,
 * 	  OutputStream getOutputStream():����Socket�������,�ó���ͨ�����������Socketд������.
 * (3)Socket�����ṩ��һ��setSoTimeout(int Timeout)���������ö�д��ʱʱ��,�����ʹ��Socket���ж�,
 *    д�������֮ǰ�����˸�ʱ�������,��ô��Щ�������׳�SocketTimeoutException.
 * (4)���ӳ�ʱ������newһ�������ӵ�Socket,�ٵ���Socket��connect()����������Զ�̷�����,��connect()��������
 *    ����һ����ʱʱ���Ĳ���
 *    Socket s = new Socket();
 *    s.connect(new InetAddress(host,port),10000);
 */
public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",30000);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		System.out.println("���Է������˵�����:"+line);
		br.close();
		socket.close();
	}
}
