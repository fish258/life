package test.nz.ac.massey.cs.sdc.assign1.s17140345;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.junit.Test;

import nz.ac.massey.cs.sdc.assign1.s17140345.VelocityLayout;

public class TestVelocityLayout {

	@Test
	public void test1() {
		System.out.println("test with ConsoleAppender: ");
		Logger logger = Logger.getLogger("test1");
		logger.addAppender(
				new ConsoleAppender(
						new VelocityLayout("Category: @{c} @{n}ToString: @{d} @{n}Message: @{m} @{n}Priority: @{p}@{n}Thread: @{t}@{n}")));
		logger.info("test1");
	}
	
	@Test
	public void test2() throws IOException {
		Logger logger_2 = Logger.getLogger("test2");
		logger_2.addAppender(
				new FileAppender(
						new VelocityLayout("Category: @{c} @{n}ToString: @{d} @{n}Message: @{m} @{n}Priority: @{p}@{n}Thread: @{t}@{n}"), "file_log.txt"));
//		write the log into the file 'file_log.txt'
		logger_2.info("test2");
	}

}
