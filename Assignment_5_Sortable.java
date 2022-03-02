package week4.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_5_Sortable 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/sortable");
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("//ul[@id=\"sortable\"]/li[1]"));
		WebElement element2 = driver.findElement(By.xpath("//ul[@id=\"sortable\"]/li[2]"));
		WebElement element3 = driver.findElement(By.xpath("//ul[@id=\"sortable\"]/li[3]"));
		WebElement element5 = driver.findElement(By.xpath("//ul[@id=\"sortable\"]/li[5]"));
		WebElement element6 = driver.findElement(By.xpath("//ul[@id=\"sortable\"]/li[6]"));
		WebElement element7 = driver.findElement(By.xpath("//ul[@id=\"sortable\"]/li[7]"));
		Actions action=new Actions(driver);
		action.dragAndDrop(element5, element1).dragAndDrop(element6, element2).dragAndDrop(element7, element3).perform();
	}
}
