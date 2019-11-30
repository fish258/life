package test.nz.ac.cs.sdc.tutorial85;

import static org.junit.Assert.*;

import javax.xml.soap.SAAJResult;

import org.junit.BeforeClass;
import org.junit.Test;

import nz.ac.massey.cs.sdc.tutorial5.Lecturer;
import nz.ac.massey.cs.sdc.tutorial5.Student;

public class TestStudent {
	Student stu1 = new Student(1, "Peter", "Parker");
	Student stu2 = new Student(1, "Peter", "Parker");
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals(true,stu1.equals(stu2));
	}
	@Test
	public void test2() {
		Student stu3 = null;
		assertEquals(false, stu1.equals(stu3));
	}
	@Test
	public void test3() {
		stu1.setId(2);
		assertEquals(false,stu1.equals(stu2));
	}
	@Test
	public void test4() {
		stu1.setFirstName("Mary");
		assertEquals(false, stu1.equals(stu2));
	}
	@Test
	public void test5() {
		stu1.setName("Osborne");
		assertEquals(false, stu1.equals(stu2));
	}
	//  ¡ü test lecturer equals ¡ü
	@Test
	public void test6() {
		assertEquals(true, stu1.hashCode()==stu2.hashCode());
		stu1.setFirstName("Henry");
		assertEquals(false,stu1.hashCode()==stu2.hashCode());
	}

}
