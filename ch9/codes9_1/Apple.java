package codes9_1;
	/**
	 * 測試類的泛型聲明
	 */
public class Apple<T> {
	private T info;
	public Apple(){}
	public Apple(T info){
		this.info = info;
	}
	public void setInfo(T info){
		this.info = info;
	}
	public T getInfo(){
		return this.info;
	}
	
	public static void main(String[] args) {
		Apple<String> apple = new Apple<String>("蘋果");
		System.out.println(apple.getInfo());
		
		Apple<Double> apple2 = new Apple<Double>(5.67);
		System.out.println(apple2.getInfo());
	}

}
