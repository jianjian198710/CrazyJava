package codes6_8;

public enum GenderBest {
	
	MALE("��"),FEMALE("Ů");
	private final String name;
	//ö�eĘ�����ֻ��ʹ��private�L�����Ʒ�,��ָ��Ĭ�JҲ��private.
	private GenderBest(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
