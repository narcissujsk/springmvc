package task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component("mytask")
@Lazy(false)
//使用Lazy注解是因为spring 配置文件采用懒加载的原因default-lazy-init="true" 这个配置会导致 @Scheduled失效
public class MyTask {
	static int num;
	private static final Logger logger = LoggerFactory.getLogger(MyTask.class);
	public MyTask() {
		// TODO Auto-generated constructor stub
	}
	@Scheduled(fixedRate=1000)
	@Async
	public void run(){
		try {
			executeTask();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}

	private void executeTask() throws InterruptedException {
		
		logger.info("mytask begin no."+num++);
		Thread.sleep(100*1000);
		logger.info("mytask end"+num);
	}
}
