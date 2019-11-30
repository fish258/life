package nz.ac.massey.cs.pp.tutorial4.id17140713;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nz.ac.massey.cs.pp.tutorial4.SimpleList;
import nz.ac.massey.cs.pp.tutorial4.SimpleListTests;

public class MySimpleListTests extends SimpleListTests {
	@Before 
	public void setup() {
		this.list =  new MySimpleList();
	}
}
