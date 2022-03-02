package week4.day2.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1_MergeContact 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]/a")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();
		Set<String> win=driver.getWindowHandles();
		List<String> list=new ArrayList<String>(win);
		String Second_Win=list.get(1);
		driver.switchTo().window(Second_Win);
		driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> win1=driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(win1);
		String Second_Win1=list1.get(1);
		driver.switchTo().window(Second_Win1);
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		System.out.println("\nThe Title is :\n"+driver.getTitle());
	}
}
