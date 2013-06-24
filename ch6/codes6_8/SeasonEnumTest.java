package codes6_8;

public class SeasonEnumTest {
	
	public void judge(SeasonEnum s){
		switch(s)
		{
			case SPRING:
				System.out.println("Spring is coming!");
				break;
			case SUMMER:
				System.out.println("Summer is coming!");
				break;
			case AUTUMN:
				System.out.println("Autumn is coming£¡");
				break;
			case WINTER:
				System.out.println("Winter is coming!");
		}
	}
	
	public static void main(String[] args) {
		SeasonEnumTest enumTest = new SeasonEnumTest();
		for(SeasonEnum s:SeasonEnum.values()){
			System.out.println(s);
			enumTest.judge(s);
		}
	}
}
