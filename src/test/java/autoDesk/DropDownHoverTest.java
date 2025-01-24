package autoDesk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDownHoverTest 
{
	
	@Test
	public void dropDownMethod()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\AUTOMATION_TESTING_2024\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		WebElement lgnBtn = driver.findElement(By.id("submitButton"));
		lgnBtn.click();
		
		Actions act = new Actions(driver);
		WebElement dropDown = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		act.moveToElement(dropDown).perform();
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		act.moveToElement(signOut).click().perform();
	}

}

