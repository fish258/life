package test.nz.ac.massey.cs.sdc.taxcalculator;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import nz.ac.massey.cs.sdc.taxcalculator.IncomeTaxCalculator;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Use parameterised tests to create tests quickly from data table.
 * @author jens dietrich
 */

@RunWith(value = Parameterized.class)
public class IncomeTaxCalculatorBatchTests {
	
	private IncomeTaxCalculator calculator = null;
	
	private double income = 0.0;
	private double expectedIncomeTax = 0.0;
	
	public IncomeTaxCalculatorBatchTests(double income, double expectedIncomeTax) {
		super();
		this.income = income;
		this.expectedIncomeTax = expectedIncomeTax;
	}
	
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { 
			   { 0,0}, 
			   { 10000,1050.0 } ,
			   { 20000,2520.0 } ,
			   { 30000,4270.0 } ,
			   { 40000,6020.0 } ,
			   { 50000,8020.0 } ,
			   { 60000,11020.0 } ,
			   { 70000,14020.0 } ,
			   { 80000,17320.0 } ,
			   { 90000,20620.0 } ,
			   { 100000,23920.0 } 
		   
	   };
	   return Arrays.asList(data);
	 }
	 
	
	@Before 
	public void setup() {
		calculator = new IncomeTaxCalculator();
	}
	@After 
	public void tearDown() {
		calculator = null;
	}

	@Test
	public void test() {
		double tax = calculator.calculateIncomeTax(this.income);
		assertEquals(this.expectedIncomeTax,tax,0.01);
	}

}
