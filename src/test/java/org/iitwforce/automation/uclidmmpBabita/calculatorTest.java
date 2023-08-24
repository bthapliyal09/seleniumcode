package org.iitwforce.automation.uclidmmpBabita;

import org.testng.Assert;
import org.testng.annotations.Test;

public class calculatorTest {

	@Test
	public void validateAdd()
	{
		calculator cal = new calculator();
		int actual = cal.add(2,3);
		int expected = 5;
		Assert.assertEquals(actual, expected);
	}
}
