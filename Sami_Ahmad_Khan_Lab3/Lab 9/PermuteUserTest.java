//JUNIT TEST CASE
import static org.junit.Assert.*;

import org.junit.Test;

public class PermuteUserTest {

	@Test
	public void testPermute() 
	{
		//Tests with the input "abc"
		
		String output = String.format("abc\nacb\nbac\nbca\ncab\ncba\n");
		assertEquals(output, PermuteUser.permute("abc"));
		
		//Tests with the input 1234
		
		output = String.format("1234\n1243\n1324\n1342\n1423\n1432\n2134\n2143\n2314\n2341\n2413\n2431\n3124\n3142\n3214\n3241\n3412\n3421\n4123\n4132\n4213\n4231\n4312\n4321\n");
		assertEquals(output, PermuteUser.permute("1234"));
		
		
		//Tests with the input  "wzyx"
		
		output = String.format("wzyx\nwzxy\nwyzx\nwyxz\nwxzy\nwxyz\nzwyx\nzwxy\nzywx\nzyxw\nzxwy\nzxyw\nywzx\nywxz\nyzwx\nyzxw\nyxwz\nyxzw\nxwzy\nxwyz\nxzwy\nxzyw\nxywz\nxyzw\n");
		assertEquals(output, PermuteUser.permute("wzyx"));
		
		//Tests with the input  "abbc"
		
		output = String.format("abbc\nabcb\nabbc\nabcb\nacbb\nacbb\nbabc\nbacb\nbbac\nbbca\nbcab\nbcba\nbabc\nbacb\nbbac\nbbca\nbcab\nbcba\ncabb\ncabb\ncbab\ncbba\ncbab\ncbba\n");
		assertEquals(output, PermuteUser.permute("abbc"));
	}

}
