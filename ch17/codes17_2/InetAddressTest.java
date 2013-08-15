package codes17_2;

import java.net.InetAddress;
/*
 * (1)Java�ṩ��InetAddress�����IP��ַ,InetAddress����������:Inet4Address,Inet6Address
 * (2)InetAddressû�й�����,ʹ�þ�̬��������ȡʵ��
 * 	  (a)getByName(String host):����������ȡ
 * 	  (b)getByAddress(byte[] addr):����ԭʼIP��ַ��ȡ
 * (3)InetAddress�ṩ���������������ȡInetAddressʵ����Ӧ��IP��ַ��������
 *    (a)String getCannoicalHostName():��ȡ��IP��ַ��ȫ�޶�����
 *    (b)String getHostAddress():����InetAddressʵ����Ӧ��IP��ַ�ַ���
 *    (c)String getHostName():��ȡ��IP��ַ��������
 */
public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		//������������ȡ��ӦInetAddressʵ��
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		//�ж��Ƿ�ɴ�
		System.out.println("Baidu�Ƿ�ɴ�: "+ip.isReachable(2000));
		//��ȡ��InetAddressʵ����IP�ַ���
		System.out.println(ip.getHostAddress());
		//����IP��ַ����ȡ��Ӧ��InetAddress
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("�����Ƿ�ɴ�: "+local.isReachable(5000));
		//��ȡ��InetAddressʵ����Ӧ��ȫ�޶�����
		System.out.println(local.getCanonicalHostName());
	}

}
