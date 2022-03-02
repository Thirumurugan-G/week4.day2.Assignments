package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_3_Frames_Examples 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().defaultContent();
		WebElement frame1=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input")).sendKeys("Frame-Examples");
		WebElement frame3=driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		WebElement frame2=driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("animals")).sendKeys("Avatar");
		Thread.sleep(3000);
		driver.quit();
	}
}
