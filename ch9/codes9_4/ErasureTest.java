package codes9_4;

public class ErasureTest {
	/**
	 * 測試泛型的擦除,當一個具有泛型信息的的對象賦給一個沒有泛型信息的變量時,所有尖括號之間的信息都被扔掉,
	 * 變為該參數的第一個上限類型
	 */
	public static void main(String[] args) {
		Apple<Integer> a = new Apple<Integer>(5);
		Integer as = a.getSize();
		//Apple b的類型為Apple<Number>
		Apple b = a;
		Number size1 = b.getSize();
		System.out.println(size1);
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
