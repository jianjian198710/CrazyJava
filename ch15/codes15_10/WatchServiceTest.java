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
	 * Path提供了register(WatchService watcher,WatchEvent.Kind<?>...events)來監聽文件系統變化
	 * WatchService代表一個文件系統監聽服務,覆轍監聽Path代表的目錄下的文件變化
	 * WathchService有三個方法來獲取被監聽目錄的文件變化事件
	 * (1)WatchKey poll() 獲取下一個WatchKey(),如果沒有就返回null
	 * (2)WatchKey poll(long timeout,TimeUnit unit) 等待timeout時間去獲取下一個WatchKey
	 * (3)WatchKey take() 獲取下一個WatchKey,沒有WatchKey就繼續等待
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		//獲取文件系統的WatchService系統
		WatchService watchService = FileSystems.getDefault().newWatchService();
		//為H盤註冊監聽器已經感興趣的事件
		Paths.get("H:/").register(watchService, 
									StandardWatchEventKinds.ENTRY_CREATE,
									StandardWatchEventKinds.ENTRY_MODIFY,
									StandardWatchEventKinds.ENTRY_DELETE);
		while(true){
			//通过WatchKey接口可以获取在对应的被监视对象上所产生的事件。
			//每个事件用java.nio.file.WatchEvent接口来表示
			WatchKey key = watchService.take();
			//pollEvents方法可以得到对应被监视对象上所发生的所有事件
			for(WatchEvent<?> event:key.pollEvents()){
				/*  在与目录内容变化相关的事件中，上下文信息是一个Path接口的实现对象,
				 *  表示的是产生事件的文件路径相对于被监视路径的相对路径,
				 */
				System.out.println(event.context()+" 文件發生了"+event.kind()+" 事件!");
			}
			//在处理完一个WatchKey接口实现对象中的全部事件之后，需要通过reset方法来进行重置。
			//只有在重置之后，新产生的同类事件才有可能从WatchService接口实现对象中再次获取。
			boolean valid = key.reset();
			if(!valid){
				break;
			}
		}
		
	}

}
