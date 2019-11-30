package test.nz.ac.cs.sdc.tutorial85;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import nz.ac.massey.cs.sdc.tutorial5.Lecturer;

public class TestMap {
	Lecturer lec1 = new Lecturer(1, "Michael", "Scofield");
	Lecturer lec2 = new Lecturer(1, "Michael", "Scofield");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}
	// test1 is for hashMap
	@Test
	public void test1() {
		Map<Lecturer, Integer> test1 = new HashMap<Lecturer, Integer>();
		test1.put(lec1,1);
		Object a = test1.get(lec2);
		assertEquals(1,a);
	}
	// test2 is for IdentityHashMap
	@Test
	public void test2() {
		Map<Lecturer, Integer> test2 = new IdentityHashMap<Lecturer, Integer>();
		test2.put(lec1, 2);
		Object b = test2.get(lec2);                // b should be null rather than 2.
		assertEquals(2,b);
	}

}
