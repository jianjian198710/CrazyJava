package codes17_4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/*
 * (1)Javaʹ��DatagramSocket����UDPЭ���Socket,DatagramSocket���ֹ�����:
 *    (a)DatagramSocket():Ĭ�ϱ�����ַ,��һ�˿�
 *    (b)DatagramSocket(int port)
 *    (c)DatagramSocket(int port,InetAddress laddr)
 * (2)����,�������ݵķ���
 *    (a)receive(DatagramPacket p)
 *    (b)send(DatagramPacket p)
 * (3)DatagramSocket����֪���������ݱ����͵�����,������DatagramPacket����������ݱ���Ŀ�ĵ�
 * (4)DatagramPacket������:
 *    (a)DatagramPacket(byte[] buf,int length)
 *    (b)DatagramPacket(byte[] buf,int length,InetAddress addr,int port)
 *    (c)DatagramPacket(byte[] buf,int offset,int length):��һ������������������,���ƶ����յ������ݷ���buf������ʱ��offset��ʼ,�ܹ�length���ֽ�
 *    (d)DatagramPacket(byte[],int offset,int length,InetAddress address,int port) 
 */
public class UdpServer {

	public static final int PORT = 30000;
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN];
	//����DatagramPacket����
	private DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
	private DatagramPacket outPacket;
	String[] books = new String[]{"CrazyJava!",
								  "FuckErlang!",};
	public void init()throws Exception{
		//����DatagramSocket����
		try(DatagramSocket socket = new DatagramSocket(PORT)){
			for(int i=0;i<1000;i++){
				//��ȡsocket�е�����,���������ݷ���inPacket��
				socket.receive(inPacket);
				System.out.println(inBuff==inPacket.getData());
				System.out.println(new String(inBuff,0,inPacket.getLength()));
				byte[] sendData = books[i%2].getBytes();
				//��ָ�����ֽ�����Ϊ��������,��ַΪ��ǰ�������ݵ�Դ��ַ
				outPacket = new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
				//��������
				socket.send(outPacket);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		new UdpServer().init();
	}

}
