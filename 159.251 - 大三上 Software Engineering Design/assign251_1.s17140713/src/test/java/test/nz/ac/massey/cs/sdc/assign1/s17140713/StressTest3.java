package test.nz.ac.massey.cs.sdc.assign1.s17140713;

import static org.junit.Assert.*;

import java.awt.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;


public class StressTest3 {
	ConsoleAppender c = new ConsoleAppender(new PatternLayout());
	Logger logger = Logger.getLogger("1");

	@Before
	public void setUp() throws Exception {
		logger.addAppender(c);
	}
	
	@Test
	public void test() {
		for (int i=0;i<100000;i++) {
			logger.info("123");
		}
	}
}
