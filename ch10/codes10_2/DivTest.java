package codes10_2;
/**
 * (1)try块里声明的变量是代码内局部变量,它只在try块内有效,在catch块中不能访问该变量
 * (2)Java把所有的非正常情况分成两种,异常Exception和错误Error,它们都继承Throwable父类
 * (3)所有父类异常的catch块都应该排在子类异常的后面
 */
public class DivTest {

	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a/b;
			System.out.println(c);
		}catch(IndexOutOfBoundsException e){
			System.out.println("IndexOutOfBoundsException!");
		}catch(NumberFormatException e){
			System.out.println("NumberFormatException！");
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException！");
		}catch(Exception e){
			System.out.println("Unknown Exception!");
		}
	}

}
