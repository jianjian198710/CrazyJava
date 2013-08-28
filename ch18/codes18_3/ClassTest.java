package codes18_3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings(value="unchecked")
@Deprecated
public class ClassTest {

	private ClassTest(){}
	public ClassTest(String name){
		System.out.println("ִ���в����Ĺ�����");
	}
	
	public void info(){
		System.out.println("ִ���޲ε�info����");
	}
	
	public void info(String str){
		System.out.println("ִ���вε�info����"+", ��str����ֵ: "+str);
	}
	
	class Inner{}
	
	public static void main(String[] args) throws Exception{
		Class<ClassTest> clazz = ClassTest.class;
		//��ȡ��Class��������Ӧ���ȫ��������
		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest��ȫ������������: ");
		for(Constructor c: ctors){
			System.out.println(c);
		}
		//��ȡ��Class�����Ӧ��ȫ��public������
		Constructor[] publicCtors = clazz.getConstructors();
		System.out.println("ClassTestȫ��public����������: ");
		for(Constructor c: publicCtors){
			System.out.println(c);		
		}
		//��ȡ��Class��������Ӧ���ȫ��public����(������Object�̳еķ���)
		Method[] mtds = clazz.getMethods();
		System.out.println("ClassTestȫ��public��������: ");
		for(Method m: mtds){
			System.out.println(m);
		}
		//��ȡָ������
		System.out.println("ClassTest���һ���ַ���������info����Ϊ: "+clazz.getMethod("info", String.class));
		
		//��ȡ��Class��������Ӧ���ȫ��ע��
		Annotation[] anns = clazz.getAnnotations();
		System.out.println("ClassTestȫ��Annotation����: ");
		for(Annotation an: anns){
			//���null @SuppressWarningsʹ����@Retention(value=SOURCE)����,�����@SuppressWarningsֻ�ܱ�����Դ���뼶����
			System.out.println(an);
		}
		System.out.println("��ClassԪ���ϵ�@SuppressWarningsע��Ϊ: "+clazz.getAnnotation(SuppressWarnings.class));
		
		//��ȡ��Class��������Ӧ���ȫ���ڲ���
		Class<?>[] inners = clazz.getDeclaredClasses();
		System.out.println("ClassTest��ȫ���ڲ�������: ");
		for(Class c: inners){
			System.out.println(c);
		}
		
		//����ClassTest��Inner�ڲ��� ע��$
		Class inClazz = Class.forName("codes18_3.ClassTest$Inner");
		//ͨ��getDeclaringClass()���ʸ������ڵ��ⲿ��
		System.out.println("inClazz��Ӧ���ⲿ��Ϊ: "+inClazz.getDeclaringClass());
		
		System.out.println("ClassTest�İ�Ϊ: "+clazz.getPackage());
		System.out.println("ClassTest�ĸ���Ϊ: "+clazz.getSuperclass());
		
	}

}
