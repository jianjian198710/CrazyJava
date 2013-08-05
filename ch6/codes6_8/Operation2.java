package codes6_8;
/*
 * (1)���һ�������ö�e���,ֻҪ�������˳���ķ���,�����ǳ���ö�e�,
 *    ϵ�y��Ĭ�Jʹ��abstract���,������ʹ��final���.
 * (2)ÿ��ö�eֵ��횞����ķ����ṩ���F.
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
