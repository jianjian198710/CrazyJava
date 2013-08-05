package codes6_8;

public enum GenderBest {
	
	MALE("男"),FEMALE("女");
	private final String name;
	//枚舉類的構造器只能使用private訪問控制符,不指定默認也為private.
	private GenderBest(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
