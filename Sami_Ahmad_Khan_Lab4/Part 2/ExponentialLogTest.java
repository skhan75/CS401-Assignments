import static org.junit.Assert.*;

import org.junit.Test;

public class ExponentialLogTest {

	@Test
	public void test() {
		assertEquals(1, ExponentialLog.power(0,0));
		assertEquals(1, ExponentialLog.power(1,1));
		assertEquals(16, ExponentialLog.power(4,2));
		assertEquals(729, ExponentialLog.power(9,3));
		assertEquals(25, ExponentialLog.power(-5, 2));
	}
}
