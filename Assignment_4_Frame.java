package week4.day2.Assignment;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_4_Frame 
{
	public static void main(String[] args) throws Exception 
	{	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/frame.html");
	
		//frame1
		WebElement frame1=driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(frame1);
		System.out.println("frame 1");
		WebElement element=driver.findElement(By.xpath("//button"));
		LocalDateTime date=LocalDateTime.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		String name=date.format(format);
		File source=element.getScreenshotAs(OutputType.FILE);
		File destination=new File("./src/main/resources/snapshot/" + name + ".jpg");
		FileUtils.copyFile(source, destination);
		driver.findElement(By.xpath("//button")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		//frame2 and frame3 
		Thread.sleep(2000);
		WebElement frame2=driver.findElement(By.xpath("(//iframe)[2]"));
		driver.switchTo().frame(frame2);
		System.out.println("frame 2");
		List<WebElement> list=driver.findElements(By.tagName("iframe"));
		WebElement frame3=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame3);
		System.out.println("frame 3");
		WebElement element1 = driver.findElement(By.id("Click1"));
		LocalDateTime date1=LocalDateTime.now();
		DateTimeFormatter format1=DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		String name1=date1.format(format1);
		File source1=element1.getScreenshotAs(OutputType.FILE);
		File destination1=new File("./src/main/resources/snapshot/" + name1 + ".jpg");
		FileUtils.copyFile(source1, destination1);
		driver.findElement(By.id("Click1")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//frame4 and frame5
		WebElement frame4= driver.findElement(By.xpath("(//iframe)[3]"));
		driver.switchTo().frame(frame4);
		System.out.println("frame 4");
		List<WebElement> list2=driver.findElements(By.tagName("iframe"));
		WebElement frame5 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame5);
		System.out.println("frame 5");
		
		driver.switchTo().defaultContent();
		
		List<WebElement> list3 = driver.findElements(By.tagName("iframe"));
		int frames=list.size()+list2.size()+list3.size();
		System.out.println("The no.of frames is : "+frames);
		driver.close();
	}
}
