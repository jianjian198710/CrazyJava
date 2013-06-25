package codes6_8;

public class GenderBetterTest {

	public static void main(String[] args) {
		GenderBetter g = GenderBetter.valueOf(GenderBetter.class, "MALE");
		g.setName("ÄÐ");
		System.out.println(g.getName());
		g.setName("other");
	}

}
