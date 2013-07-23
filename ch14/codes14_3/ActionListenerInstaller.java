package codes14_3;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

/**
 * 處理ActionListenerFor標籤的方法
 */
public class ActionListenerInstaller {
	
	public static void processAnnotations(Object obj){
		try{
			Class c1 = obj.getClass();
			for(Field f:c1.getDeclaredFields()){
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				//在那个对象上获取此字段的值
				Object fobj = f.get(obj);
				if(a!=null&&fobj!=null&&fobj instanceof AbstractButton){
					//獲取ActionListenerFor的元數據
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
