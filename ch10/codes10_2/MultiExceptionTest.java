package codes10_2;

public class MultiExceptionTest {
	/**
	 * �����@���������r ,����׃�����[ʽ��final���,��˳����܌�����׃�������xֵ��
	 * ���@�΂������t�]���@�N��r
	 */
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a/b;
			System.out.println(c);
		}catch(IndexOutOfBoundsException|NumberFormatException|ArithmeticException e){
			System.out.println("One of Three Exceptions!");
			//���@�ஐ��,����׃�������xֵ
//			e = new ArithmeticException("test");
		}catch(Exception e){
			System.out.println("Unknown Exception!");
			//���@�ή���,����׃�������xֵ
			e = new RuntimeException("test");
		}
		
	}

}
