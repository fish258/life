package test.nz.ac.massey.cs.sdc.assign1.s17140713;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import nz.ac.massey.cs.sdc.assign1.s17140713.VelocityLayout;

public class StressTest5 {

	LinkedList l = new LinkedList(); 
	public VelocityLayout vlyt = new VelocityLayout("@c@n@d@m@p@t");
	Logger logger = Logger.getLogger("1");


	@Before
	public void setUp() throws Exception {
		ConsoleAppender f = new ConsoleAppender(vlyt);
		logger.addAppender(f);
	}

	@Test
	public void test() {
		for (int i=0;i<1000;i++) {              //I set it 1000000 at first, but it can't finish. So in case test can be finished I change it to 1000.
			logger.info("123");
		}
	}
}
