package nz.ac.massey.cs.sdc.tutorial6.websitebuilder;

import org.junit.Before;

public class StressTestWebSiteBuilder1 extends AbstractStressTestWebSiteBuilder {

	@Before
	public void setUp() throws Exception {
		super.setUp();
		builder = new WebSiteBuilder1();
	}

}
