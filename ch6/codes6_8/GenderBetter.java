package codes6_8;

public enum GenderBetter {
	MALE,FEMALE;
	private String name;
	
	public void setName(String name){
		switch(this){
			case MALE:
				if(name.equals("��")){
					this.name = name;
				}else{
					System.out.println("Parameter error!");
				}
				break;
			case FEMALE:
				if(name.equals("Ů")){
					this.name = name;
				}else{
					System.out.println("Parameter error!");
				}
				break;
		}
	}
	
	public String getName(){
		return name;
	}
}
