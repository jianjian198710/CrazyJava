package codes7_1;

public class ArgsTest {
	//main������JVM����,��args�β�Ӧ����JVM����ֵ
	public static void main(String[] args) {
		System.out.println(args.length);
		for(String arg:args){
			System.out.println(arg);
		}
	}

}
