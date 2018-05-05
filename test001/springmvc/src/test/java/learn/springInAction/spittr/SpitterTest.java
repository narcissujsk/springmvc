package learn.springInAction.spittr;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import learn.springInAction.spittr.data.JdbcSpittleRepository2;

public class SpitterTest {
	private static final Logger logger = LoggerFactory.getLogger(SpitterTest.class);
	@Test
	public void test() {
		JdbcSpittleRepository2 dao = new JdbcSpittleRepository2();
		List<Spittle> ls = dao.findSpittles(3, 3);
		logger.info(ls+"");
	}

}
