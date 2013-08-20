package codes17_4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/*
 * (1)Java使用DatagramSocket代表UDP协议的Socket,DatagramSocket三种构造器:
 *    (a)DatagramSocket():默认本机地址,任一端口
 *    (b)DatagramSocket(int port)
 *    (c)DatagramSocket(int port,InetAddress laddr)
 * (2)接收,发送数据的方法
 *    (a)receive(DatagramPacket p)
 *    (b)send(DatagramPacket p)
 * (3)DatagramSocket并不知道将该数据报发送到哪里,而是由DatagramPacket自身决定数据报的目的地
 * (4)DatagramPacket构造器:
 *    (a)DatagramPacket(byte[] buf,int length)
 *    (b)DatagramPacket(byte[] buf,int length,InetAddress addr,int port)
 *    (c)DatagramPacket(byte[] buf,int offset,int length):以一个空数组来创建对象,并制定接收到的数据放入buf数组中时从offset开始,总共length个字节
 *    (d)DatagramPacket(byte[],int offset,int length,InetAddress address,int port) 
 */
public class UdpServer {

	public static final int PORT = 30000;
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN];
	//创建DatagramPacket对象
	private DatagramPacket inPacket = new DatagramPacket(inBuff,inBuff.length);
	private DatagramPacket outPacket;
	String[] books = new String[]{"CrazyJava!",
								  "FuckErlang!",};
	public void init()throws Exception{
		//创建DatagramSocket对象
		try(DatagramSocket socket = new DatagramSocket(PORT)){
			for(int i=0;i<1000;i++){
				//读取socket中的数据,读到的数据放入inPacket中
				socket.receive(inPacket);
				System.out.println(inBuff==inPacket.getData());
				System.out.println(new String(inBuff,0,inPacket.getLength()));
				byte[] sendData = books[i%2].getBytes();
				//以指定的字节数作为发送数据,地址为先前接收数据的源地址
				outPacket = new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
				//发送数据
				socket.send(outPacket);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		new UdpServer().init();
	}

}
