package test.nz.ac.massey.cs.sdc.assign1.s17140713;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import nz.ac.massey.cs.sdc.assign1.s17140713.MemAppender;
import nz.ac.massey.cs.sdc.assign1.s17140713.VelocityLayout;

public class StressTest2 {
	ArrayList l = new ArrayList(); 
	public VelocityLayout vlyt = new VelocityLayout("@c@n@d@m@p@t");
	MemAppender mem = MemAppender.getMemAppender(vlyt,10000000,l);
	Logger logger = Logger.getLogger("1");


	@Before
	public void setUp() throws Exception {
		logger.addAppender(mem);
	}

	@Test
	public void test() {
		for (int i=0;i<100000;i++) {
			logger.info("123");
		}
	}
}
