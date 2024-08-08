package AutomationQA2.AutomationDemo2;

import org.testng.annotations.Test;
import org.testng.Assert;

public class SampleTest {

	@Test
	    public void testMethod() {
	        int a = 5;
	        int b = 10;
	        int sum = a + b;
	        Assert.assertEquals(sum, 15, "Sum should be 15");
	}

}
