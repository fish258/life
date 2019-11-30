package nz.ac.massey.cs.sdc.tutorial6.websitebuilder;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AbstractStressTestWebSiteBuilder {
	
	protected WebSiteBuilder builder = null;
	private List<Student> students = null;
	private int STUDENT_COUNT = 100000;
	private int REPEAT_COUNT = 1000;

	public void setUp() throws Exception {
		// 10 s startup delay to facilitate profiling with VisualVM or JConsole
		Thread.sleep(10000);
		
		students = new ArrayList<Student>();
		for (int i=0;i<STUDENT_COUNT;i++) {
			students.add(StudentFactory.createRandomStudent());
		}
	}

	@Test
	public void test() {
		for (int i=0;i<REPEAT_COUNT;i++) {
			builder.buildWebSite(students);
		}
		assertTrue(true);
	}

}
