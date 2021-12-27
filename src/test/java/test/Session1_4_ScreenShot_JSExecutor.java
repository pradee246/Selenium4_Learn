package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * https://youtu.be/HjYEjKWSbe8
 */

public class Session1_4_ScreenShot_JSExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// -- timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		driver.get("https://google.com");
		
		// - 11. Screenshots

		//Take screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./image.png"));

		//Take element screenshot
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File scrFile1 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./image1.png"));

		// - 12. JavaScript

		//Create JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Get return value from script
		WebElement button =driver.findElement(By.name("btnI"));
		String text = (String) js.executeScript("return arguments[0].innerText", button);

		//JavaScript to click element
		js.executeScript("arguments[0].click();", button);

		//Execute JS directly
		js.executeScript("console.log('hello world')");

		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
