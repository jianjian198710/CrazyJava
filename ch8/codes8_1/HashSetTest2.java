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
		//将第一个元素的值改为-3
		first.count = -3;
		//出现两个count：-3,但是其实第一个在原来count值为5的Hash表的位置上
		System.out.println(hs);
		//只会删除第三个,因为第一个在原来count值为5的Hash表中的位置上
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
