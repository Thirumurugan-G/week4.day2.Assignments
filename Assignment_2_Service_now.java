package week4.day2.Assignment;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2_Service_now 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev99115.service-now.com");
		driver.switchTo().frame("gsft_main");
		//	https://dev99115.service-now.com
		//	https://dev99115.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=MoCGCmir1r3H
		//	Username: admin
		//Thread.sleep(2000);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		//	Current password: MoCGCmir1r3H
		//new password: Admin123@
		driver.findElement(By.id("user_password")).sendKeys("Admin123@");
		 driver.findElement(By.id("sysverb_login")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> win=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(win);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//td/a")).click();
		driver.switchTo().window(list.get(0));
	
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys("Caller value added");
		String incident_No=driver.findElement(By.id("incident.number")).getAttribute("value");
		//INC0010003
		driver.findElement(By.id("sysverb_insert")).click();
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incident_No,Keys.ENTER);
		String search=driver.findElement(By.xpath("(//td/a)[2]")).getText();
		if(search.equalsIgnoreCase(incident_No))
		{
			System.out.println("\nIncident created Succesfully\n");
			LocalDateTime date=LocalDateTime.now();
			DateTimeFormatter format=DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			String s=date.format(format);
			String name=s+incident_No;
			TakesScreenshot capture=(TakesScreenshot)driver;
			File source=capture.getScreenshotAs(OutputType.FILE);
			File destination=new File("./src/main/resources/snapshot/" + name + ".png");
			FileUtils.copyFile(source, destination);
		}
		else
		{
			System.out.println("Incident not created");
		}
		driver.quit();
		 
	}
}
