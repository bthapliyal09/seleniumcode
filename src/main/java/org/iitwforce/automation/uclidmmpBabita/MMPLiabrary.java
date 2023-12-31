package org.iitwforce.automation.uclidmmpBabita;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMPLiabrary {

	WebDriver driver;
	public MMPLiabrary(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Login()
	{
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		
	}
	
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	
	public void NavigateToModule(String moduleName )
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
		
	}
	
	public HashMap<String, String>bookAppointment()
	{
		HashMap<String, String> expectedHMap  = new HashMap<String, String>();
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		
		String doctorName ="Charlie";
		expectedHMap.put("doctor", doctorName);
		
		//(//button[@id='opener'])[4]
		driver.findElement(By.xpath("//h4[contains(.,'"+doctorName+"')]/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		//Date Picker Logic 
		driver.findElement(By.id("datepicker")).click();

		String expectedDate =  AppLibrary.getfutureDate(300);//30/03/2024
		String actualYear= driver.findElement(By.className("ui-datepicker-year")).getText();//2023
		
		while(!(actualYear.equals(expectedDate.split("/")[2])))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualYear= driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println(actualYear);			
			System.out.println(expectedDate);			
		}
		
		String actualMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		while(!(actualMonth.equals(expectedDate.split("/")[1])))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actualMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
			System.out.println( actualMonth);			
			System.out.println( expectedDate);
		}
		
		System.out.println(actualYear);
		System.out.println(actualMonth);
		
		driver.findElement(By.linkText(expectedDate.split("/")[0])).click();

		expectedDate = AppLibrary.getfutureDate(300,"MM/dd/YYYY");
		expectedHMap.put("date", expectedDate);

		WebElement timeWE = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled','disabled')",timeWE);

		Select timeSelect = new Select(timeWE);
		expectedHMap.put("time", "12Pm");
		timeSelect.selectByValue("12Pm");
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement symWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sym")));
		symWE.sendKeys("Fever and Cold");
		expectedHMap.put("sym","Fever and Cold");

		driver.findElement(By.cssSelector("input[value='Submit']")).click();

		return expectedHMap;


	}
	public HashMap<String, String> fetchPatientPortalDetails()
	{
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		actualHMap.put("date",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText());
		actualHMap.put("time",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText() );
		actualHMap.put("sym",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText());
		actualHMap.put("doctor", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText());
		return actualHMap;
	}
}

