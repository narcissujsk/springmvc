package test;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learn.springInAction.knights.BraveKnight;
import learn.springInAction.knights.Knight;
import learn.springInAction.knights.Quest;


public class BraveKnightTest {
	private static final Logger logger = LoggerFactory.getLogger(BraveKnightTest.class);
  @Test
  public void knightShouldEmbarkOnQuest() {
    Quest mockQuest = mock(Quest.class);
    BraveKnight knight = new BraveKnight(mockQuest);
    knight.embarkOnQuest();
    verify(mockQuest, times(1)).embark();
  }

	
	private AbstractApplicationContext context;

	@Before
	public void before() {
		 context = new ClassPathXmlApplicationContext("xml/knight.xml");
	}

	@After
	public void after() {
		context.close();
	}

	@Test
	public void testknight() {
		Knight knight =(Knight) context.getBean("knightTest");
		knight.embarkOnQuest();
	}

}
