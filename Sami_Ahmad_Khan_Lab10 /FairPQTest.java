import static org.junit.Assert.*;

import org.junit.Test;


public class FairPQTest {
	
	FairPQ<Student> pq1 = new FairPQ<Student>();
	FairPQ<Student> pq2 = new FairPQ<Student>();
	FairPQ<Student> pq3 = new FairPQ<Student>();
	
	@Test
	public void testBasedOnGPA()
	{
		pq1.add(new Student("abc 3.0"));
		pq1.add(new Student("def 4.0"));
		pq1.add(new Student("ghi 3.0"));
		pq1.add(new Student("jkl 3.5"));
		
		assertEquals("abc 3.0", pq1.remove().toString());
		assertEquals("ghi 3.0", pq1.remove().toString());
		assertEquals("jkl 3.5", pq1.remove().toString());
		assertEquals("def 4.0", pq1.remove().toString());
				
	}
	
	@Test
	public void testBasedOnName()
	{
		pq2.add(new Student("ghi 3.0"));
		pq2.add(new Student("def 3.0"));
		pq2.add(new Student("xyz 3.0"));
		pq2.add(new Student("abc 3.0"));
		
		assertEquals("ghi 3.0", pq2.remove().toString());
		assertEquals("def 3.0", pq2.remove().toString());
		assertEquals("xyz 3.0", pq2.remove().toString());
		assertEquals("abc 3.0", pq2.remove().toString());
				
	}
	
	@Test
	public void testBasedOnNameAndGPA()
	{
		pq3.add(new Student("abc 4.0"));
		pq3.add(new Student("def 4.0"));
		pq3.add(new Student("abc 3.5"));
		pq3.add(new Student("jkl 3.5"));
		
		assertEquals("abc 3.5", pq3.remove().toString());
		assertEquals("jkl 3.5", pq3.remove().toString());
		assertEquals("abc 4.0", pq3.remove().toString());
		assertEquals("def 4.0", pq3.remove().toString());
				
	}
	

}
