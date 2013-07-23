package codes14_3;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

/**
 * ̎��ActionListenerFor�˻`�ķ���
 */
public class ActionListenerInstaller {
	
	public static void processAnnotations(Object obj){
		try{
			Class c1 = obj.getClass();
			for(Field f:c1.getDeclaredFields()){
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				//���Ǹ������ϻ�ȡ���ֶε�ֵ
				Object fobj = f.get(obj);
				if(a!=null&&fobj!=null&&fobj instanceof AbstractButton){
					//�@ȡActionListenerFor��Ԫ����
					Class<? extends ActionListener> listenerClazz = a.listener();
					ActionListener a1 = listenerClazz.newInstance();
					AbstractButton ab = (AbstractButton)fobj;
					ab.addActionListener(a1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
