package test;

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

//https://youtu.be/q8sl0YUrl_I?list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH

public class Session8_KeyboardActions {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*
		-- How to simulate keyboard typing:
		sendKeys()
		 */
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER); // Hit enter key

		
		/*
		-- How to simulate pressing key combination
		keyDown()
		keyUp()
		clear()
		 */

		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		
		Actions action = new Actions(driver);
		driver.get("http://www.google.com");
		WebElement search = driver.findElement(By.name("q"));
		action.keyDown(Keys.SHIFT).sendKeys(search,"selenium").
				keyUp(Keys.SHIFT).sendKeys(search, " selenium").build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.name("q")).clear();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
