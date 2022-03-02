package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_5_Resizeable 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/resizable");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("(//div[@id='resizable'])/div[3]"));
		Actions act=new Actions(driver);
		act.clickAndHold(element).moveByOffset(60, 60).release().perform();
	}
}
