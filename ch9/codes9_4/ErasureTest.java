package codes9_4;

public class ErasureTest {
	/**
	 * �yԇ���͵Ĳ���,��һ�����з�����Ϣ�ĵČ����x�oһ���]�з�����Ϣ��׃���r,���м���̖֮�g����Ϣ�����ӵ�,
	 * ׃��ԓ�����ĵ�һ���������
	 */
	public static void main(String[] args) {
		Apple<Integer> a = new Apple<Integer>(5);
		Integer as = a.getSize();
		//��a���󸳸�Apple����,��ʧ���������������Ϣ
		Apple b = a;
		//bֻ֪��size��������Number
		Number size1 = b.getSize();
		System.out.println(size1);
		//�����������������
//		Integer size2 = b.getSize();
	}

}


class Apple<T extends Number>{
	T size;
	public Apple(){}
	public Apple(T size){
		this.size = size;
	}
	public void setSize(T size){
		this.size = size;
	}
	public T getSize(){
		return this.size;
	}
}
