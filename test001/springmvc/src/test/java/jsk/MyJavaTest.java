package jsk;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import learn.springInAction.aop.AopConfigTest;

public class MyJavaTest {
	private static final Logger logger = LoggerFactory.getLogger(MyJavaTest.class);
	@Test
	public void test() {
		String str="物理CPU：双路Intel E5-2630v4 Series;逻辑CPU：20核；内存：64G ；系统盘：100G SASRAID5；数据盘：500G";
		List<String> ss = Arrays.asList(str.split("；|;"));
		System.out.println(ss);
		System.out.println(ss.size());
		logger.info(ss+"");
	}

}
