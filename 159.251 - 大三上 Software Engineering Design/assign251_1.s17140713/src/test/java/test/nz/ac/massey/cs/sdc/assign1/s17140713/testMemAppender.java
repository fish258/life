package test.nz.ac.massey.cs.sdc.assign1.s17140713;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Before;
import org.junit.Test;

import nz.ac.massey.cs.sdc.assign1.s17140713.MemAppender;
import nz.ac.massey.cs.sdc.assign1.s17140713.VelocityLayout;

public class testMemAppender {
	ArrayList l1 = new ArrayList(); 
	public VelocityLayout vlyt = new VelocityLayout("@c@n@d@m@p@t");
	MemAppender mem1 = MemAppender.getMemAppender(vlyt, 2, l1);
	Logger logger1 = Logger.getLogger("1");
	
	@Before
	public void setup() {
		logger1.addAppender(mem1);
		mem1.clear();
		} 
	
	@Test
	public void testAdd() {
		logger1.error("fstMsg");
		logger1.info("secMsg");                     //add two logs
	
		List nowlist = mem1.getCurrentLogs();
		LoggingEvent e1 = (LoggingEvent) nowlist.get(0);
		LoggingEvent e2 = (LoggingEvent) nowlist.get(1);     
		
		assertEquals("fstMsg",e1.getMessage());
		assertEquals("ERROR",e1.getLevel().toString());
		assertEquals("secMsg",e2.getMessage());
	}
	@Test
	public void testMax() {
		logger1.error("fstMsg");
		logger1.info("secMsg");                      //add two logs
		
		List nowlist = mem1.getCurrentLogs();
		LoggingEvent e1 = (LoggingEvent) nowlist.get(0);
		assertEquals("ERROR-fstMsg",e1.getLevel().toString()+"-"+e1.getMessage());
		assertEquals(2,nowlist.size());
		
		logger1.warn("3rdMsg");
		LoggingEvent e2 = (LoggingEvent) nowlist.get(0);    //get the updated first object
		assertEquals(2,nowlist.size());                    
		assertEquals("INFO-secMsg",e2.getLevel().toString()+"-"+e2.getMessage());
		assertEquals(1,mem1.getDiscardedLogCount());
	}
	@Test
	public void testVelocityLayout() {
		List nowlist = mem1.getCurrentLogs();
		logger1.warn("^-^");
		LoggingEvent e1 = (LoggingEvent) nowlist.get(0);
		assertEquals(e1.getLoggerName()+"/n"+e1.toString()+e1.getMessage().toString()+e1.getLevel().toString()+e1.getThreadName(),vlyt.format(e1).toString());
	}

}

