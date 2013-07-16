package codes9_4;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	/**
	 * TreeSet<E>有一個如下構造器
	 * TreeSet(Comparator<? super E> c)
	 * 通過帶下限的通配符的方法,可以在創建TreeSet對象的時靈活選擇合適的Comparator,
	 * 只要Comparator尖括號中穿入的類型是TreeSet尖括號中的父類型或是本身即可
	 */
	public static void main(String[] args) {
		TreeSet<String> ts1 = new TreeSet<String>(new Comparator<Object>(){
			@Override
			public int compare(Object o1, Object o2) {
				if(o1.hashCode()>o2.hashCode()){
					return 1;
				}else if(o1.hashCode()==o2.hashCode()){
					return 0;
				}else{
					return -1;
				}
			}
		});
		ts1.add("hello");
		ts1.add("wa");
		
		TreeSet<String> ts2 = new TreeSet<String>(new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()>s2.length()){
					return 1;
				}else if(s1.length()==s2.length()){
					return 0;
				}else{
					return -1;
				}
			}
		});
		ts2.add("hello");
		ts2.add("wa");
		System.out.println(ts1);
		System.out.println(ts2);
	}
}
