package codes14_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnotationTest {
	/**
	 * 定義兩個Button,使用@ActionListenerFor標籤為這兩個按鈕綁定Listener
	 */
	private JFrame mainWin = new JFrame("Use Annotation to Bind Listener");
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok = new JButton("Confirm");
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel = new JButton("Cancel");
	
	public void init(){
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args) {
		new AnnotationTest().init();

	}

}

class OkListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "單擊了確認按鈕");
	}
}

class CancelListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "單擊了取消按鈕");
	}
}