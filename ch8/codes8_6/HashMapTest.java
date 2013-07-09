package codes8_6;

import java.util.HashMap;

public class HashMapTest {

	/**
	 * 测试HashMap判斷兩個Key相等的標準是,equal()返回true,hashCode值相同
	 * 判斷兩個value的標準是,equal()返回true
	 */
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(new A(1),"Crazy Java");
		map.put(new A(2),"Crazy Ajax");
		map.put(new A(3),new B());
		System.out.println(map);
		//返回true,因为B对象总是和其他的相等
		System.out.println(map.containsValue("ABB"));
		System.out.println(map.containsKey(new A(1)));
		map.remove(new A(3));
		for(Object key:map.keySet()){
			System.out.print(key+"------>");
			System.out.print(map.get(key));
		}
	}
}

class A{
	int count;
	public A(int count){
		this.count = count;
	}
	
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}else if(obj!=null && obj.getClass()==A.class){
			A a = (A)obj;
			return a.count==this.count;
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		return this.count;
	}
	
	public String toString(){
		return "A["+this.count+"]";
	}
}

class B{
	public boolean equals(Object obj){
		return true;
	}
}
