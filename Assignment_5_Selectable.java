package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_5_Selectable 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/selectable");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[1]"));
		WebElement element2 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[2]"));
		WebElement element3 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[3]"));
		WebElement element4 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[4]"));
		WebElement element5 = driver.findElement(By.xpath("//ol[@id=\"selectable\"]/li[5]"));
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3).click(element4).click(element5).keyUp(Keys.CONTROL).perform();
	}
}
