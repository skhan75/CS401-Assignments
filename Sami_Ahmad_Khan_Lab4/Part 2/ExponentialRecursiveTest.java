import static org.junit.Assert.*;

import org.junit.Test;

public class ExponentialRecursiveTest {

	@Test
	
	public void test() {
		assertEquals(1, ExponentialRecursive.power(0,0));
		assertEquals(1, ExponentialRecursive.power(1,1));
		assertEquals(16, ExponentialRecursive.power(4,2));
		assertEquals(729, ExponentialRecursive.power(9,3));
		assertEquals(25, ExponentialRecursive.power(-5, 2));
		//fail("Not yet implemented");
	}

}
