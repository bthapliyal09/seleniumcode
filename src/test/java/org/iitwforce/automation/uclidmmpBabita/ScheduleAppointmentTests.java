package org.iitwforce.automation.uclidmmpBabita;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointmentTests extends BaseClass {

	@Test(description="Validate the schedule appointment for a doctor")
	public void TC_001_validate_book_appointment() throws InterruptedException
	{
		MMPLiabrary mmpLib = new MMPLiabrary(driver);
		mmpLib.launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");	 
		mmpLib .Login();
		mmpLib.NavigateToModule("Schedule Appointment");
		HashMap<String,String> expectedHMap = mmpLib.bookAppointment();
		HashMap<String,String> actualHMap =mmpLib.fetchPatientPortalDetails();
		Assert.assertEquals(actualHMap, expectedHMap);
	}
		
	
	@Test(description="Validate the schedule appointment for a doctor")
	public void TC_006_validate_book_appointment() throws InterruptedException
	{
		launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		//(//button[@id='opener'])[4]
		driver.findElement(By.xpath("//h4[contains(.,'Charlie')]/ancestor::ul/following-sibling::button")).click();
		
		driver.switchTo().frame("myframe");
		String expectedDate = "08/23/2023";
		driver.findElement(By.id("datepicker")).sendKeys(expectedDate);

		WebElement timeWE = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled','disabled')",timeWE);
		
		Select timeSelect = new Select(timeWE);
		timeSelect.selectByValue("12Pm");
	
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sym")));
		symWE.sendKeys("Fever and Cold");
		
		
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualDate, expectedDate);
		sa.assertAll();
	}
		
		@Test(description="Validate the schedule appointmnet for a Time")
		public void TC_007_ScheduleBooking_Time()
		{
			launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
			driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
			driver.findElement(By.xpath("//h4[contains(.,'Charlie')]/ancestor::ul/following-sibling::button")).click();
					
			driver.switchTo().frame("myframe");
			String expectedDate = "08/30/2023";
			String expectedTime="10Am";
			
			driver.findElement(By.id("datepicker")).sendKeys(expectedDate);
			WebElement timeWE = driver.findElement(By.id("time"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].removeAttribute('disabled','disabled')",timeWE);
				
			Select timeselect = new Select(timeWE);
			timeselect.selectByValue("10Am");
			
			driver.findElement(By.id("ChangeHeatName")).click();
			driver.switchTo().defaultContent();
					
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	
			WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sym")));
			symWE.sendKeys("Headache");
			
			driver.findElement(By.cssSelector("input[value='Submit']")).click();
			
			String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
			
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actualTime, expectedTime);
			sa.assertAll();		
		}
		
		@Test(description="Validate the schedule appointmnet for a Sym")
		public void TC_008_ScheduleBooking_Sym()
		{
			launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
			driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
			driver.findElement(By.xpath("//h4[contains(.,'Charlie')]/ancestor::ul/following-sibling::button")).click();
					
			driver.switchTo().frame("myframe");
			String expectedDate = "08/26/2023";
			String expectedSym = "Headache";
			
			driver.findElement(By.id("datepicker")).sendKeys(expectedDate);
			WebElement timeWE = driver.findElement(By.id("time"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].removeAttribute('disabled','disabled')",timeWE);
				
			Select timeselect = new Select(timeWE);
			timeselect.selectByValue("10Am");
			
			driver.findElement(By.id("ChangeHeatName")).click();
			driver.switchTo().defaultContent();
					
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sym")));
			symWE.sendKeys("Headache");
			
			driver.findElement(By.cssSelector("input[value='Submit']")).click();
			
			String actualsym= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
			
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actualsym, expectedSym);
			sa.assertAll();		
		}
			
	
		@Test(description="Validate the schedule appointmnet for a Doc")
		public void TC_009_ScheduleBooking_Doc()
		{
			launchBrowser("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			driver.findElement(By.id("username")).sendKeys("ria1");
			driver.findElement(By.id("password")).sendKeys("Ria12345");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
			driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
			driver.findElement(By.xpath("//h4[contains(.,'Beth')]/ancestor::ul/following-sibling::button")).click();
					
			driver.switchTo().frame("myframe");
			String expectedDate = "08/26/2023";
			String expectedDoc = "Beth";
			
			driver.findElement(By.id("datepicker")).sendKeys(expectedDate);
			WebElement timeWE = driver.findElement(By.id("time"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].removeAttribute('disabled','disabled')",timeWE);
				
			Select timeselect = new Select(timeWE);
			timeselect.selectByValue("11Am");
			
			driver.findElement(By.id("ChangeHeatName")).click();
			driver.switchTo().defaultContent();
					
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sym")));
			symWE.sendKeys("Headache");
			
			driver.findElement(By.cssSelector("input[value='Submit']")).click();
			
			String actualDoc= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
			
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actualDoc, expectedDoc);
			sa.assertAll();		
		}
}
