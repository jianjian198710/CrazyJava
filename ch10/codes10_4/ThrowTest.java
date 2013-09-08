package codes10_4;
/**
 * 測試throw語句,該語句拋出的是Checked異常,需要捕获或抛出,如果抛出是Runtime异常,则无需捕获或抛出
 */
public class ThrowTest {

	public static void throwChecked(int a)throws Exception{
		if(a>0){
			throw new Exception("It's should be a<=0");
		}
	}
	
	public static void throwRuntime(int a){
		if(a>0){
			throw new RuntimeException("It's should be a<=0");
		}
	}
	
	public static void main(String[] args) {
		try{
			throwChecked(3);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		throwRuntime(3);
	}
}
