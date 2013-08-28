package codes18_3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings(value="unchecked")
@Deprecated
public class ClassTest {

	private ClassTest(){}
	public ClassTest(String name){
		System.out.println("执行有参数的构造器");
	}
	
	public void info(){
		System.out.println("执行无参的info方法");
	}
	
	public void info(String str){
		System.out.println("执行有参的info方法"+", 其str参数值: "+str);
	}
	
	class Inner{}
	
	public static void main(String[] args) throws Exception{
		Class<ClassTest> clazz = ClassTest.class;
		//获取该Class对象所对应类的全部构造器
		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest的全部构造器如下: ");
		for(Constructor c: ctors){
			System.out.println(c);
		}
		//获取该Class对象对应的全部public构造器
		Constructor[] publicCtors = clazz.getConstructors();
		System.out.println("ClassTest全部public构造器如下: ");
		for(Constructor c: publicCtors){
			System.out.println(c);		
		}
		//获取该Class对象所对应类的全部public方法(包括从Object继承的方法)
		Method[] mtds = clazz.getMethods();
		System.out.println("ClassTest全部public方法如下: ");
		for(Method m: mtds){
			System.out.println(m);
		}
		//获取指定方法
		System.out.println("ClassTest里带一个字符串参数的info方法为: "+clazz.getMethod("info", String.class));
		
		//获取该Class对象所对应类的全部注释
		Annotation[] anns = clazz.getAnnotations();
		System.out.println("ClassTest全部Annotation如下: ");
		for(Annotation an: anns){
			//输出null @SuppressWarnings使用了@Retention(value=SOURCE)修饰,这表明@SuppressWarnings只能保存在源代码级别上
			System.out.println(an);
		}
		System.out.println("该Class元素上的@SuppressWarnings注释为: "+clazz.getAnnotation(SuppressWarnings.class));
		
		//获取该Class对象所对应类的全部内部类
		Class<?>[] inners = clazz.getDeclaredClasses();
		System.out.println("ClassTest的全部内部类如下: ");
		for(Class c: inners){
			System.out.println(c);
		}
		
		//加载ClassTest的Inner内部类 注意$
		Class inClazz = Class.forName("codes18_3.ClassTest$Inner");
		//通过getDeclaringClass()访问该类所在的外部类
		System.out.println("inClazz对应的外部类为: "+inClazz.getDeclaringClass());
		
		System.out.println("ClassTest的包为: "+clazz.getPackage());
		System.out.println("ClassTest的父类为: "+clazz.getSuperclass());
		
	}

}
