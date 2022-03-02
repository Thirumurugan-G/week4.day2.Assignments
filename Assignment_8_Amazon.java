package week4.day2.Assignment;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_8_Amazon 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//	1.Load the uRL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		//	2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//	3.Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[3]")).getText();
		
		//	4. Print the number of customer ratings for the first displayed product
		String ratings = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Total Rating count is : "+ratings);
		
		//	5. click on the stars 
		driver.findElement(By.xpath("(//a[@role='button'])[3]")).click();
		
		//	6. Get the percentage of ratings for the 5 star.
		System.out.print("Rating =>> "+driver.findElement(By.xpath("//div[@id='a-popover-content-2']/div/div/div/div[1]/span")).getText());
		
		//	7. Click the first text link of the first image
		driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();
		
		//	8. Take a screen shot of the product displayed
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windowHandles);
		driver.switchTo().window(win.get(1));
		WebElement element = driver.findElement(By.id("imgTagWrapperId"));
		LocalDateTime date=LocalDateTime.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		String name=date.format(format);
		File source=element.getScreenshotAs(OutputType.FILE);
		File destination=new File("./src/main/resources/snapshot/" + name + ".png");
		FileUtils.copyFile(source, destination);
		
		//	9. Click 'Add to Cart' button
		driver.findElement(By.id("submit.add-to-cart")).click();
		
		//	10. Get the cart subtotal and verify if it is correct.
		WebElement webElement = driver.findElement(By.xpath("//div[@id=\"attach-added-to-cart-message\"]/div[1]/div[2]/div[1]/div[1]/span[2]"));
		String subTotal = webElement.getText();
		
		if(subTotal.equalsIgnoreCase(price))
		{
			System.out.println("Cart Sub Total Verified");
		}
		else
		{
			System.out.println("The Cart SubTotal is not matched");
		}
	}
}
