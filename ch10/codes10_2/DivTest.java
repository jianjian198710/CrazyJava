package codes10_2;
/**
 * (1)try���������ı����Ǵ����ھֲ�����,��ֻ��try������Ч,��catch���в��ܷ��ʸñ���
 * (2)Java�����еķ���������ֳ�����,�쳣Exception�ʹ���Error,���Ƕ��̳�Throwable����
 * (3)���и����쳣��catch�鶼Ӧ�����������쳣�ĺ���
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
			System.out.println("NumberFormatException��");
		}catch(ArithmeticException e){
			System.out.println("ArithmeticException��");
		}catch(Exception e){
			System.out.println("Unknown Exception!");
		}
	}

}
