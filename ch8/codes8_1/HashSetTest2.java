package codes8_1;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {

	/**
	 * The test is to verify when the fields of object which in the HashSet change, 
	 * maybe the HashSet has two same object.
	 */
	public static void main(String[] args) {
		HashSet<R> hs = new HashSet<R>();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(9));
		hs.add(new R(-2));
		System.out.println(hs);
		
		Iterator<R> it = hs.iterator();
		R first = it.next();
		//����һ��Ԫ�ص�ֵ��Ϊ-3
		first.count = -3;
		//��������count��-3,������ʵ��һ����ԭ��countֵΪ5��Hash���λ����
		System.out.println(hs);
		//ֻ��ɾ��������,��Ϊ��һ����ԭ��countֵΪ5��Hash���е�λ����
		hs.remove(new R(-3));
		System.out.println(hs);
		//false
		System.out.println(hs.contains(new R(-3)));
		//false
		System.out.println(hs.contains(new R(5)));
		
	}

}

class R{
	int count;
	public R(int count){
		this.count = count;
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj !=null && obj.getClass() == R.class){
			R r = (R)obj;
			if(r.count ==this.count){
				return true;
			}
		}
		return false;
	}
	
	public int hashcode(){
		return this.count;
	}
	
	public String toString(){
		return "count"+this.count;
	}
}
