package test.nz.ac.massey.cs.sdc.assign1.s17140345;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nz.ac.massey.cs.sdc.assign1.s17140345.MemAppender;
import nz.ac.massey.cs.sdc.assign1.s17140345.VelocityLayout;

public class TestMemAppender {
	private MemAppender ma;
	
	@Before
	public void setup(){
		ma = MemAppender.getInstance(new ArrayList<LoggingEvent>());
		ma.setMaxSize(2);
		ma.setLayout(new VelocityLayout("@{c} @{d} @{m} @{n}@{p}@{t}@{n}"));
	}
	
	@After
	public void teardown() {
		ma.clear();
		ma = null;
	}
	
	@Test
	public void testAppender() {
		System.out.println("################################################");
		System.out.println("test MemAppender and VelocityLayout: ");
		System.out.println("################################################");
		Logger logger = Logger.getLogger("test");
//		ConsoleAppender with PatternLayout for comparing
		logger.addAppender(new ConsoleAppender(new PatternLayout("%c %d %m %n%p %t%n")));
//		MemAppender with VelocityLayout
		System.out.println("logging information: (expect 'test 2' and 'test 3' in getCurentLogs())");
		logger.addAppender(ma);
		logger.debug("test 1");
		logger.debug("test 2");
		logger.debug("test 3");
		System.out.println("\nLoggingEvents in getCurrentLogs():");
		for(LoggingEvent event:ma.getCurrentLogs()) {
			System.out.println("" + event.getLoggerName()+" " + event.toString() +" "+ event.getMessage() + "\n" + event.getLevel() +" "+ event.getThreadName());
		}
	}
	
	@Test
//	test the list returned by getCurrentLogs() is not modifiable
	public void testUnmodifiable() {
		Logger logger_2 = Logger.getLogger("testUnmodifiable");
		logger_2.addAppender(ma);
		logger_2.info("test 1");
		logger_2.info("test 2");
		List<LoggingEvent> storage = ma.getCurrentLogs();
		try {
			LoggingEvent event = storage.get(0); 
//			modify the result of .getCurrentLogs()
			ma.getCurrentLogs().add(event);
		} catch (UnsupportedOperationException e) {
//			compare the class of exception because the details of the exception is unknown
			assertEquals(new UnsupportedOperationException().getClass(), e.getClass());
		}
	}
	
	@Test
	public void testDiscardedLogCount() {
		Logger logger_3 = Logger.getLogger("testDiscrdedLogCount");
		logger_3.addAppender(ma);
		for(int i=0;i<200;i++) {
			logger_3.info("test");
		}
//		total number of logs(200) - maximum size(2) = discarded log count(198)
		assertEquals(198L, ma.getDiscardedLogCount());
	}

}
