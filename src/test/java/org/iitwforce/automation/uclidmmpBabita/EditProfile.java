package org.iitwforce.automation.uclidmmpBabita;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfile extends BaseClass {
	
	@Test(description="Validate the Edit Profile")
	public void TC_007_validate_Edit_Profile() throws InterruptedException
	{
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		driver.findElement(By.id("Ebtn")).click();
		
		//set a new value for FirstName textbox
		
		driver.findElement(By.id("fname")).clear();
		String expected = randomString("IITWMFname");
		driver.findElement(By.id("fname")).sendKeys(expected);
		driver.findElement(By.id("Sbtn")).click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		String actual = driver.findElement(By.id("fname")).getAttribute("value");
	
		Assert.assertEquals(actual, expected);
		
		
	}	

//HashMap Method
	@Test(description="Validate the Edit Profile")
	public void TC_008_validate_Edit_Profile() throws InterruptedException
	{
		HashMap<String, String> ExpectedHMap = new HashMap<String, String>();
		HashMap<String, String> ActualHMap = new HashMap<String, String>();
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		driver.findElement(By.id("Ebtn")).click();
		
		//set a new value for FirstName textbox
		driver.findElement(By.id("fname")).clear();
		String expectedFName = randomString("IITWMFname");
		ExpectedHMap.put("FName", expectedFName);
		driver.findElement(By.id("fname")).sendKeys(expectedFName);
		
		
		//set a new value for LastName textbox
		driver.findElement(By.id("lname")).clear();
		String expectedLName = randomString("IITWMLname");
		ExpectedHMap.put("LName", expectedLName);
		driver.findElement(By.id("lname")).sendKeys(expectedLName);
			

		//set a new value for Licence textbox
		driver.findElement(By.id("licn")).clear();
		String expectedLicence = "12345678";
		ExpectedHMap.put("Licn", expectedLicence);
		driver.findElement(By.id("licn")).sendKeys(expectedLicence);
		
		//Click on save button
		driver.findElement(By.id("Sbtn")).click();
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		String actualFName = driver.findElement(By.id("fname")).getAttribute("value");
		ActualHMap.put("FName", actualFName);
	
		String actualLName = driver.findElement(By.id("lname")).getAttribute("value");
		ActualHMap.put("LName", actualLName);
		
		String actualLicence = driver.findElement(By.id("licn")).getAttribute("value");
		ActualHMap.put("Licn", actualLicence);
	
		Assert.assertEquals(ActualHMap, ExpectedHMap);
		
		
	}	
	public static String randomString(String s)
	{		
		Random rand = new Random();
		
		char Uppercasech = (char)(65+rand.nextInt(26));
		char Lowercasech = (char)(97+rand.nextInt(26));
	    return s + Uppercasech+Lowercasech;
	}
	
}
