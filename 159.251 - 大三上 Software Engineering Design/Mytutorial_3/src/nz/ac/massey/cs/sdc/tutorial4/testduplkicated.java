package nz.ac.massey.cs.sdc.tutorial4;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class testduplkicated {
	int a = 1;
	

	@Test
	public void test() {
		a=2;
		assertEquals(2,a);
	}
	@Test
	public void test1() {
		assertEquals(2,a);
	}
}
