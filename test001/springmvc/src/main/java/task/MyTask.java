package task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component("mytask")
public class MyTask {
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
		
		System.out.println("mytask begin");
		logger.info("");
		Thread.sleep(1000);
		System.out.println("mytask end");
	}
}
