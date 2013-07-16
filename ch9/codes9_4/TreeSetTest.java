package codes9_4;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	/**
	 * TreeSet<E>��һ����������
	 * TreeSet(Comparator<? super E> c)
	 * ͨ�^�����޵�ͨ����ķ���,�����ڄ���TreeSet����ĕr�`���x����m��Comparator,
	 * ֻҪComparator����̖�д���������TreeSet����̖�еĸ���ͻ��Ǳ�����
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
