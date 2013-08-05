package codes6_8;
/*
 * (1)使用enum定義的枚舉類繼承了java.lang.Enum類,而不是Object類
 * (2)java.lang.Enum類實現了Serializable和Comparable接口
 * (3)非抽象的枚举类默认会使用final修饰符,因此枚举类不能派生子类,抽象enum可以使用匿名子类
 * (4)枚舉類的所有實例必須在第一行列出,系統會自動添加public static final修飾
 */
public enum SeasonEnum {
	SPRING,SUMMER,AUTUMN,WINTER
}
