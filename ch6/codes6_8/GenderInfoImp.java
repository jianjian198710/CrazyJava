package codes6_8;

public enum GenderInfoImp implements GenderInfo {
	MALE("��")
	{
		public void info(){
			System.out.println("The value presents Male!");
		}
		
	},
	FEMALE("Ů"){
		public void info(){
			System.out.println("The value presents Female!");
		}
	};
	private final String name;
	private GenderInfoImp(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	
}
