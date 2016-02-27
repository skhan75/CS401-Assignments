import static org.junit.Assert.*;

import org.junit.Test;

public class ExponentialIterativeTest {

	@Test
	public void test() {
		assertEquals(1, ExponentialIterative.power(0,0));
		assertEquals(1, ExponentialIterative.power(1,1));
		assertEquals(16, ExponentialIterative.power(4,2));
		assertEquals(729, ExponentialIterative.power(9,3));
		assertEquals(25, ExponentialIterative.power(-5, 2));
	}
}
