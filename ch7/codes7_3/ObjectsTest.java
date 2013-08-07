package codes7_3;

import java.util.Objects;

public class ObjectsTest {
	/*
	 * 測試Objects類,該類主要提供了一些工具方法來操作對象,
	 * 這些工具方法大多是"空指針"安全的
	 */
	static ObjectsTest obj;
	public static void main(String[] args) {
		//輸出一個null對象的toString,輸出null
		System.out.println(Objects.toString(obj));
		//輸出一個null對象的hashCode值,輸出0
		System.out.println(Objects.hashCode(obj));
		//requireNonNull()當傳入的參數不為null 返回參數本省 否則報NullPointerException
		System.out.println(Objects.requireNonNull(obj,"The parameter can't be null!"));
	}
}
