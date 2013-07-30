package codes15_9;

import java.nio.CharBuffer;

public class BufferTest {
	/**
	 * Buffer��������һ������,�����Ա�����������ͬ�Ĕ���,��һ�������,���Þ�ByteBuffer��CharBuffer,
	 * ͨ��ʹ��static XxxBuffer allocate(int capacity)����һ��XxxBuffer����
	 * ��Buffer����������Ҫ�ĸ���:����(capacity),����(limit),λ��(position)
	 * ��Buffer�b�딵���Y����,�{��flip()��������limit�O�Þ�position����λ��,����position�O��0
	 * ��Bufferݔ�������Y����,�{��clear()����,��position�O��0,��limit�Þ�capacity
	 * Bufferʹ��put()��get()�������xȡ����,�֞������ͽ^���ɷN
	 */
	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:"+buff.capacity());
		//��ʼ���rlimitָ��8,��ǌ��H�惦���g
		System.out.println("limit:"+buff.limit());
		System.out.println("position:"+buff.position());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("��������Ԫ�غ�,position="+buff.position());
		buff.flip();
		//limit��positionλ�� 3
		System.out.println("ִ��flip()��,limit="+buff.limit());
		//position�Ƶ� 0
		System.out.println("position="+buff.position());
		
		System.out.println("��һ��Ԫ��:"+buff.get());
		//position�ĵ�һ��Ԫ������һ��,����1
		System.out.println("ȡ����һ��Ԫ�غ�,postion="+buff.position());
		
		buff.clear();
		//limit�Þ�capacity 8
		System.out.println("ִ��clear()��,limit="+buff.limit());
		//position�Þ� 0
		System.out.println("ִ��clear()��,position="+buff.position());
		System.out.println("ִ��claer()��,���������ݲ�û�б����:"+buff.get(2));
		//���ǰ��ʹ��get(int)����,ֱ��ʹ��������,���]���õ�position,���positiionλ�ò�׃ 0
		System.out.println("ִ�ж�ȡ��,position="+buff.position());
	}

}
