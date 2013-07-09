package codes8_3;

import java.util.TreeSet;

public class TreeSetTest3 {

	/**
	 * Test the TreeSet with objects in it whose fields can be changed
	 */
	public static void main(String[] args) {
		TreeSet<A> as = new TreeSet<A>();
		as.add(new A(5));
		as.add(new A(-3));
		as.add(new A(9));
		as.add(new A(-2));
		System.out.println(as);
		A first = as.first();
		first.count=20;
		A last = as.last();
		//��TreeSet�Юa������ͬ�Č���
		last.count = -2;
		System.out.println(as);
		//�h��ʧ��
		System.out.println(as.remove(new A(-2)));
		System.out.println(as);
		//�h���ɹ�������TreeSet���Ԅh���]�б��޸�Field���Ҳ��c�������޸�Field�Č������}�Č���
		System.out.println(as.remove(new A(5)));
		System.out.println(as);
	}

}

class A implements Comparable<Object>{

	int count;
	public A(int count){
		this.count = count;
	}
	
	public String toString(){
		return "A[count:"+count+"]";
	}
	@Override
	public int compareTo(Object obj) {
		A a = (A)obj;
		if(this.count<a.count){
			return -1;
		}else if(this.count>a.count){
			return 1;
		}else{
			return 0;
		}
	}
	
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj!=null&&obj.getClass()==A.class){
			A a = (A)obj;
			if(a.count==this.count){
				return true;
			}
		}
		return false;
	}
	
}