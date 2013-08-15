package codes16_9;
/*
 * (1)ThreadLocal���һ�����̵ľֲ�׃��,ͨ�^�є�������ThraedLocal�оͿ���׌ÿ�����̄���һ��ԓ׃���ĸ���
 * (2)ThreadLocal�ṩ����3��public����
 *     (a)T get():���ش˾��ֲ̾�׃���Ю�ǰ���̵�ֵ
 * 	   (b)void remove():�h���˾��ֲ̾�׃���Ю�ǰ���̵�ֵ
 *     (c)void set(T value):�O�ôξ��ֲ̾�׃���Ю�ǰ���̸����е�ֵ
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		Account at = new Account("��ʼ��");
		/*
		 * �mȻ�ɂ����̹���ͬһ������,��ֻ��һ��������,����춎�������ThreadLocal��͵�,����ÿ�����̶���ȫ���и��ԵĎ���������,
		 * �����i==6֮��,�������ɂ������L��ͬһ�������r���F��ͬ�Ď�����
		 */
		new MyTest(at,"���̼�").start();
		new MyTest(at,"������").start();
	}

}

class Account{
	private ThreadLocal<String> name = new ThreadLocal<String>();
	public Account(String str){
		this.name.set(str);
		//�L����ǰ���̵�name������ֵ (�����̞�:��ʼ�� ����ɂ����̸�����:null)
		System.out.println("---"+this.name.get());
	}
	public String getName() {
		return name.get();
	}
	public void setName(String str) {
		this.name.set(str);
	}
}

class MyTest extends Thread{
	private Account account;
	public MyTest(Account account,String name){
		super(name);
		this.account = account;
	}
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			if(i==6){
				//����������Q�ɮ�ǰ������
				account.setName(getName());
			}
			System.out.println(account.getName()+" ����i��ֵ: "+i);	
		}
	}
}