package test.nz.ac.cs.sdc.tutorial85;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import nz.ac.massey.cs.sdc.tutorial5.Lecturer;

public class TestLecturer {
	Lecturer lec1 = new Lecturer(1, "Michael", "Scofield");
	Lecturer lec2 = new Lecturer(1, "Michael", "Scofield");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	@Test
	public void test1() {
		assertEquals(true,lec1.equals(lec2));
	}
	@Test
	public void test2() {
		Lecturer lec3 = null;
		assertEquals(false, lec1.equals(lec3));
	}
	@Test
	public void test3() {
		lec1.setId(2);
		assertEquals(false,lec1.equals(lec2));
	}
	@Test
	public void test4() {
		lec1.setFirstName("Bill");
		assertEquals(false, lec1.equals(lec2));
	}
	@Test
	public void test5() {
		lec1.setName("Osborne");
		assertEquals(false, lec1.equals(lec2));
	}
	//  ¡ü test lecturer equals ¡ü
	@Test
	public void test6() {
		assertEquals(true, lec1.hashCode()==lec2.hashCode());
		lec1.setFirstName("Alice");
		assertEquals(false,lec1.hashCode()==lec2.hashCode());
	}
}
