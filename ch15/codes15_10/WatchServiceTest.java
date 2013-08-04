package codes15_10;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceTest {
	/**
	 * Path�ṩ��register(WatchService watcher,WatchEvent.Kind<?>...events)��O �ļ�ϵ�y׃��
	 * WatchService����һ���ļ�ϵ�y�O ����,���H�O Path�����Ŀ��µ��ļ�׃��
	 * WathchService������������@ȡ���O Ŀ䛵��ļ�׃���¼�
	 * (1)WatchKey poll() �@ȡ��һ��WatchKey(),����]�оͷ���null
	 * (2)WatchKey poll(long timeout,TimeUnit unit) �ȴ�timeout�r�gȥ�@ȡ��һ��WatchKey
	 * (3)WatchKey take() �@ȡ��һ��WatchKey,�]��WatchKey���^�m�ȴ�
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		//�@ȡ�ļ�ϵ�y��WatchServiceϵ�y
		WatchService watchService = FileSystems.getDefault().newWatchService();
		//��H�P�]�ԱO ���ѽ����dȤ���¼�
		Paths.get("H:/").register(watchService, 
									StandardWatchEventKinds.ENTRY_CREATE,
									StandardWatchEventKinds.ENTRY_MODIFY,
									StandardWatchEventKinds.ENTRY_DELETE);
		while(true){
			//ͨ��WatchKey�ӿڿ��Ի�ȡ�ڶ�Ӧ�ı����Ӷ��������������¼���
			//ÿ���¼���java.nio.file.WatchEvent�ӿ�����ʾ
			WatchKey key = watchService.take();
			//pollEvents�������Եõ���Ӧ�����Ӷ������������������¼�
			for(WatchEvent<?> event:key.pollEvents()){
				/*  ����Ŀ¼���ݱ仯��ص��¼��У���������Ϣ��һ��Path�ӿڵ�ʵ�ֶ���,
				 *  ��ʾ���ǲ����¼����ļ�·������ڱ�����·�������·��,
				 */
				System.out.println(event.context()+" �ļ��l����"+event.kind()+" �¼�!");
			}
			//�ڴ�����һ��WatchKey�ӿ�ʵ�ֶ����е�ȫ���¼�֮����Ҫͨ��reset�������������á�
			//ֻ��������֮���²�����ͬ���¼����п��ܴ�WatchService�ӿ�ʵ�ֶ������ٴλ�ȡ��
			boolean valid = key.reset();
			if(!valid){
				break;
			}
		}
		
	}

}
