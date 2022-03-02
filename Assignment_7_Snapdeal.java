package week4.day2.Assignment;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_7_Snapdeal 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		WebElement mens_fashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions action=new Actions(driver);
		action.moveToElement(mens_fashion).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String sport_shoe_count_men = driver.findElement(By.xpath("//div[@id='content_wrapper']/div[9]/div[2]/div[2]/div[3]/span")).getText();
		System.out.println("The mens sports shoe =>>"+sport_shoe_count_men+" are available");
		WebElement trainingShoe = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		action.moveToElement(trainingShoe).perform();
		action.click(trainingShoe).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div[2]/div[3]/div[2]/div/i")).click();
		WebElement sort = driver.findElement(By.xpath("(//li[@class='search-li'])[1]"));
		action.moveToElement(sort).perform();
		action.click(sort).perform();
		Thread.sleep(2000);
		String mrp1 = driver.findElement(By.xpath("(//div[@class='product-desc-rating '])[1]/a/div/div/span[2]")).getAttribute("display-price");
		int price1=Integer.parseInt(mrp1);
		String mrp2 = driver.findElement(By.xpath("(//div[@class='product-desc-rating '])[2]/a/div/div/span[2]")).getAttribute("display-price");
		int price2=Integer.parseInt(mrp2);
		if(price1<price2)
		{
			System.out.println("sorted successfully");
		}
		else
		{
			System.out.println("sorted successfully");
		}
		
		WebElement color =driver.findElement(By.xpath("(//label[@for='Color_s-Navy'])/span"));
		action.moveToElement(color).perform();
		action.click(color).perform();
		String title = driver.getTitle();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
		Thread.sleep(2000);
		WebElement startRange = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
		action.click(startRange).sendKeys("900").perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		Thread.sleep(2000);
		WebElement endRange = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		action.click(endRange).sendKeys("1200").perform();
		
		Thread.sleep(2000);
		WebElement go = driver.findElement(By.xpath("//div[contains(text(),'GO')]"));
		action.moveToElement(go).perform();
		action.click(go).perform();
		String title2 = driver.getTitle();
		if(title.equalsIgnoreCase(title2))
		{
			System.out.println("filtered");
		}
		else
		{
			System.out.println("not filtered");
		}
		
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		action.moveToElement(product).perform();
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		String price = driver.findElement(By.xpath("(//div[@class='lfloat'])/div[2]/span")).getText();
		System.out.println("The cost is Rs."+price);
		String offer = driver.findElement(By.xpath("(//div[@class='lfloat'])/div[2]/span[2]")).getText();
		System.out.println("The offer is "+offer);
		WebElement element = driver.findElement(By.id("bx-slider-qv-image-panel"));
		LocalDateTime date=LocalDateTime.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		String name=date.format(format);
		File source=element.getScreenshotAs(OutputType.FILE);
		File destination=new File("./src/main/resources/snapshot/" + name + ".png");
		FileUtils.copyFile(source, destination);
		driver.quit();
	}
}
