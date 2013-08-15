package codes17_2;

import java.net.InetAddress;
/*
 * (1)Java提供了InetAddress类代表IP地址,InetAddress有两个子类:Inet4Address,Inet6Address
 * (2)InetAddress没有构造器,使用静态方法来获取实例
 * 	  (a)getByName(String host):根据主机获取
 * 	  (b)getByAddress(byte[] addr):根据原始IP地址获取
 * (3)InetAddress提供如下三个方法类获取InetAddress实例对应的IP地址和主机名
 *    (a)String getCannoicalHostName():获取此IP地址的全限定域名
 *    (b)String getHostAddress():返回InetAddress实例对应的IP地址字符串
 *    (c)String getHostName():获取此IP地址的主机名
 */
public class InetAddressTest {

	public static void main(String[] args) throws Exception {
		//根据主机名获取对应InetAddress实例
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		//判断是否可达
		System.out.println("Baidu是否可达: "+ip.isReachable(2000));
		//获取该InetAddress实例的IP字符串
		System.out.println(ip.getHostAddress());
		//根据IP地址来获取对应的InetAddress
		InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("本机是否可达: "+local.isReachable(5000));
		//获取该InetAddress实例对应的全限定域名
		System.out.println(local.getCanonicalHostName());
	}

}
