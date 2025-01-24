package Practise;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedFrameTest 
{
	
	@Test
	public void nestedFrameTest()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");
		
		
		WebElement switchTodrpdwn = driver.findElement(By.linkText("SwitchTo"));
		Actions act = new Actions(driver);
		act.moveToElement(switchTodrpdwn).perform();
		WebElement element = driver.findElement(By.linkText("Frames"));
		act.click(element).perform();
		
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Abhishek");
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(frame);
		System.out.println("done 1");
		WebElement nestedFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html' and @style='float: left;height: 250px;width: 400px']"));
		driver.switchTo().frame(nestedFrame);
		System.out.println("done 2");
		driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5' and @style='margin-top: 150px']/child::input[@type='text']")).sendKeys("Kelusker");
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Single Iframe ")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
