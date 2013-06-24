package codes6_8;

public class EnumOtherMethodTest {

	public static void main(String[] args) {
		System.out.println(SeasonEnum.SPRING.compareTo(SeasonEnum.SUMMER));
		System.out.println(SeasonEnum.SUMMER.ordinal());
		
		SeasonEnum s = Enum.valueOf(SeasonEnum.class, "SPRING");
		System.out.println(s);

	}

}
