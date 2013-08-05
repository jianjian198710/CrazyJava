package codes6_8;
/*
 * (1)對於一個抽象的枚舉類而言,只要它包含了抽象的方法,它就是抽象枚舉類,
 *    系統會默認使用abstract修飾,而不是使用final修飾.
 * (2)每個枚舉值必須為抽象的方法提供實現.
 * 
 */
public enum Operation2 {
	PLUS
	{
		public double eval(double x,double y){
			return x+y;
		}
	},
	
	MINUS{
		public double eval(double x,double y){
			return x-y;
		}
	},
	
	TIMES{
		public double eval(double x,double y){
			return x*y;
		}
	},
	
	DIVIDE{
		public double eval(double x,double y){
			return x/y;
		}
	};
	
	public abstract double eval(double x,double y);
	
	public static void mian(String[] args){
		System.out.println(Operation2.PLUS.eval(8,8));
		System.out.println(Operation2.MINUS.eval(8,8));
		System.out.println(Operation2.TIMES.eval(8,8));
		System.out.println(Operation2.DIVIDE.eval(8,8));
	}
}
