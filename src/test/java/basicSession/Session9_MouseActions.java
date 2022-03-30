package basicSession;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://youtu.be/pqdCIMhrN40?list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH

public class Session9_MouseActions {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*
		-- moveToElement
		-- clickAndHold
		 */
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement boxA = driver.findElement(By.xpath("//li[text()='A']")); 
		WebElement boxD = driver.findElement(By.xpath("//li[text()='D']")); 
		
		Actions action = new Actions(driver);
		action.moveToElement(boxA);
		action.clickAndHold();
		action.moveToElement(boxD, 50,50);
		action.release().perform();
		
		/*
		-- dragAndDrop
		 */
		//action.dragAndDrop(boxA, boxD).perform();
		
		/*
		-- contextClick = RightClick
		 */
		action.contextClick(boxD).perform();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
