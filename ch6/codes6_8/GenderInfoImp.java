package codes6_8;
/*
 * �����ö�����팍�F�ӿ���ķ���,�tÿ��ö�eֵ���{��ԓ�����r������ͬ���О鷽ʽ.
 * �����Ҫÿ��ö�eֵ���{��ԓ�����r�ʬF��ͬ���О鷽ʽ,�t����׌ÿ��ö�eֵ�քe�팍�Fԓ����.
 */
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
