package codes8_6;

import java.util.TreeMap;

public class TreeMapTest {

	/**
	 * œyÔ‡TreeMapî
	 */
	public static void main(String[] args) {
		TreeMap<R,String> tm = new TreeMap<R,String>();
		tm.put(new R(3),"Crazy Java");
		tm.put(new R(-5),"Crazy Ajax");
		tm.put(new R(9),"Fuck Erlang");
		System.out.println(tm);
		
		System.out.println(tm.firstEntry());
		System.out.println(tm.lastKey());
		System.out.println(tm.higherKey(new R(2)));
		System.out.println(tm.lowerEntry(new R(2)));
		System.out.println(tm.subMap(new R(-1), new R(4)));

	}

}

class R implements Comparable<R>{
	int count;
	
	public R(int count){
		this.count = count;
	}
	
	public String toString(){
		return "R["+this.count+"]";
	}
	
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}else if(obj!=null && obj.getClass()==R.class){
			R r = (R)obj;
			return r.count==this.count;
		}
		return false;
	}
	
	public int compareTo(R r){
		if(this.count>r.count){
			return 1;
		}else if(this.count==r.count){
			return 0;
		}else{
			return -1;
		}
	}
	
}