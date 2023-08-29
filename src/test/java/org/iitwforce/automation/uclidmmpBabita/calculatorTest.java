package org.iitwforce.automation.uclidmmpBabita;

import org.testng.Assert;
import org.testng.annotations.Test;

public class calculatorTest {

	@Test
	public void validateAdd()
	{
		calculator cal = new calculator();
		int actual = cal.add(2,6);
		int expected = 8;
		Assert.assertEquals(actual, expected);
	}
}
