import static org.junit.Assert.*;

import org.junit.Test;

public class EqualityCheckTestCase {
	FullTimeEmployee employee1 = new FullTimeEmployee("Dave", 1200.61);
	FullTimeEmployee employee2 = new FullTimeEmployee("Mark", 850.20);
	FullTimeEmployee employee3 = new FullTimeEmployee("Dave", 1200.61);
	FullTimeEmployee employee4 = new FullTimeEmployee("Smith", 1600.88);
		
	@Test
	public void testMain() {
		assertEquals("Same object should always be equal",true, employee1.equals(employee1));
		assertEquals("Objects with different values of instance variables should be false",false, employee1.equals(employee2));	
		assertEquals("Objects with equal values of attributes should be true",true, employee1.equals(employee3));
		assertEquals("Objects with Non Null references compared with null should be false", false, employee1.equals(null));
	}

}
