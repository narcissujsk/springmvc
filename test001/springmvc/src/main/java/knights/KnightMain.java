package knights;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class KnightMain {

	public static void main(String[] args) throws Exception {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
					"src/main/webapp/META-INF/spring/knight.xml");
		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();
	}

	@Test
	public void test() {

		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/minstrel.xml");
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/webapp/META-INF/spring/knight.xml");

		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();

	}
}
