package logica;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for logica");
		//$JUnit-BEGIN$
		suite.addTestSuite(GameTest.class);
		suite.addTestSuite(PlayerTest.class);
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(ShipTest.class);
		//$JUnit-END$
		return suite;
	}

}
