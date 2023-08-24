package org.iitwforce.automation.uclidmmpBabita;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoAddService  extends BaseClass
{

	@Test(description="Add new service type")
	public void TC_001_Add_Service_Type() throws InterruptedException
	{
		launchBrowser("https://openmrs.org/demo/");

		driver.findElement(By.xpath("//span[contains(text(),'Enter the OpenMRS 2 Demo')]")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
	
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
		driver.findElement(By.xpath("//button[@class='confirm appointment-type-label right']")).click();
	    driver.findElement(By.id("name-field")).clear();
	    driver.findElement(By.id("name-field")).sendKeys("MentalHealth4");
        driver.findElement(By.id("duration-field")).sendKeys("100");
        Thread.sleep(2000);
        driver.findElement(By.id("save-button")).click();
       String expectedName = "MentalHealth4";
       String expectedDuration = "100";
       String actualName = driver.findElement(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr[1]/td[1]")).getText();
    		String actualDuration = driver.findElement(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr[2]/td[1]")).getText();

    		System.out.println( actualName);
    		System.out.println(actualDuration);
    					
    		SoftAssert sa = new SoftAssert();
    		sa.assertEquals(actualName, expectedName);
    		sa.assertEquals(actualDuration, expectedDuration);

        
	}
	
	@Test(description="Delete service type")
	public void TC_002_Delete_Service_Type() throws InterruptedException
	{
		launchBrowser("https://openmrs.org/demo/");
		String expectedName ="MentalHealth4";

		driver.findElement(By.xpath("//span[contains(text(),'Enter the OpenMRS 2 Demo')]")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
		
		List<WebElement> namesElements = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		List<String> names = new ArrayList<String>();
		
		boolean bdeleted = false;
		
		for(WebElement namesElement : namesElements) {
			names.add(namesElement.getText());
		}
		
		for (String name : names)
		{
			if(name.equals(expectedName) )
			{
				driver.findElement(By.xpath("//span/i[@id='appointmentschedulingui-delete-"+name+"']")).click();
				WebElement btnDelete =  driver.findElement(By.xpath("//div[@class='simplemodal-wrap']//button[@class='confirm right'][contains(text(),'Yes')]"));
				btnDelete.click();
				bdeleted = true;
				break;
			}				
		}	
		
		String nextButton = driver.findElement(By.id("appointmentTypesTable_next")).getAttribute("class");
		
		while(!nextButton.contains("disabled"))
		{
			driver.findElement(By.id("appointmentTypesTable_next")).click();
			namesElements = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
			
			for(WebElement namesElement : namesElements) {
				names.add(namesElement.getText());
			}
			
			for (String name : names)
			{
				if(name.equals(expectedName)&& bdeleted==false)
				{
					driver.findElement(By.xpath("//span/i[@id='appointmentschedulingui-delete-"+name+"']")).click();
					Thread.sleep(1000);
					driver.switchTo().activeElement();
					WebElement btnDelete =  driver.findElement(By.xpath("//div[@class='simplemodal-wrap']//button[@class='confirm right'][contains(text(),'Yes')]"));
					btnDelete.click();
					bdeleted = true;					
					break;
				}				
			}	
			nextButton = driver.findElement(By.id("appointmentTypesTable_next")).getAttribute("class");					
		}
		
		String actualName ="";
		for (String name : names)
		{
			if(name.equals(expectedName) && bdeleted==false)
			{
				actualName = expectedName;
				driver.findElement(By.xpath("//span/i[@id='appointmentschedulingui-delete-"+name+"']")).click();
				WebElement btnDelete =  driver.findElement(By.xpath("//div[@class='simplemodal-wrap']//button[@class='confirm right'][contains(text(),'Yes')]"));
				btnDelete.click();
				break;
			}
			else
			{
				actualName= "";
			}			
		}	
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualName, expectedName);
		
		//String displaycount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		
	}
	
}
