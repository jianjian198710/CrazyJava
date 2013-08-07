package codes7_1;

public class ArgsTest {
	//main方法由JVM调用,即args形参应该有JVM负责赋值
	public static void main(String[] args) {
		System.out.println(args.length);
		for(String arg:args){
			System.out.println(arg);
		}
	}

}
