package codes6_8;

public enum Operation {
	PLUS,MINUS,TIMES,DIVIDE;
	public double eval(double x,double y){
		switch(this){
			case PLUS:
				return x+y;
			case MINUS:
				return x-y;
			case TIMES:
				return x*y;
			case DIVIDE:
				return x/y;
			default: return 0;
		}
	}
	
	public static void main(String[] args){
		System.out.println(Operation.PLUS.eval(8,8));
		System.out.println(Operation.MINUS.eval(8,8));
		System.out.println(Operation.TIMES.eval(8,8));
		System.out.println(Operation.DIVIDE.eval(8,8));
	}
}
