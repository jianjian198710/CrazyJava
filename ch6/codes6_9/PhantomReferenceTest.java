package codes6_9;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
/*
 * ̓������Ҫ��춸�ۙ����GC�Ġ�B,�����܆Ϊ�ʹ��,��횺��������ReferenceQueue��ʹ��
 */
public class PhantomReferenceTest {

	public static void main(String[] args) {
		String str = new String("Hello Java!");
		ReferenceQueue<String> rq = new ReferenceQueue<String>();
		//����һ��̓����,ָ��Hello Java!
		PhantomReference<String> pr = new PhantomReference<String>(str,rq);
		str = null;
		//����ͨ�^̓�����L�������Ì���,���Դ�̎��null
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		//�������õČ�����պ�,̓���Ì����������������
		System.out.println(rq.poll() == pr);

	}

}
