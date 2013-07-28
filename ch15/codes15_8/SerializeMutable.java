package codes15_8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
	/**
	 * �����л�һ����׃����r,ֻ�е�һ��ʹ��writeObject()����ݔ���r�ŕ���ԓ�����D�Q���ֹ����в�ݔ��,
	 * �������ٴ��{��writeObject()�����r,ֻ��ݔ�����л���̖,
	 * ��ʹ����ԓ�����Fieldֵ����׃,��׃��Field��ֵҲ������ݔ��
	 */
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mutable.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mutable.txt"))){
				Person per = new Person("Sun",500);
				oos.writeObject(per);
				per.setName("Tang");
				oos.writeObject(per);
				Person per1 = (Person)ois.readObject();
				Person per2 = (Person)ois.readObject();
				System.out.println(per1==per2);
				//��ʹ����ԓ�����Fieldֵ����׃,��׃��Field��ֵҲ������ݔ��
				System.out.println(per2.getName());
		}catch(IOException ioe){
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
