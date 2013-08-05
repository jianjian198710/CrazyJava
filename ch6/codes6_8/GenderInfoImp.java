package codes6_8;
/*
 * 如果由枚举类來實現接口里的方法,則每個枚舉值在調用該方法時都有相同的行為方式.
 * 如果需要每個枚舉值在調用該方法時呈現不同的行為方式,則可以讓每個枚舉值分別來實現該方法.
 */
public enum GenderInfoImp implements GenderInfo {
	MALE("男")
	{
		public void info(){
			System.out.println("The value presents Male!");
		}
		
	},
	FEMALE("女"){
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
