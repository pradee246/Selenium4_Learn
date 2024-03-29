package basicSession;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://youtu.be/K2BRKgZgYPs?list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH

public class Session3_Waits {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		/*
		* What are waits
		Functions in selenium to make webdriver wait for a specific time or for some condition to be true

		Why waits are required in Automation Testing

		Sometimes the automation script is faster than the browser loading time or objects render time on browser - no such element
		Different elements may load at different time interval
		Se webdriver script and browser events may not be synchronous at all times

		* Types of waits
		implicit
		explicit
		fluent

		** Implicit Wait
		Useful when there is some gap in loading time of the web page and web elements
		An implicit wait makes WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately available

		default setting is 0 (disabled)
		Once set, the implicit wait is set for the entire life of the session
		Polling frequency  - 500 ms
		*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD", Keys.ENTER);
		
		// ** Explicit Wait
		//Useful when there you need to wait until some condition is met
		//Makes WebDriver to wait until a certain condition is true

	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
		/*
		alert is present
		element exists
		element is visible
		title contains
		title is
		element staleness
		visible text

		Polling frequency  - 500 ms

		Warning: 
		Mixing implicit and explicit waits can cause unpredictable wait times
		E.g.
		Implicit wait = 10 sec
		Explicit wait = 15 sec
		could cause a timeout to occur after 25 seconds.

		** Fluent Wait

		similar to Explicit wait, i.e. wait for a certain duration until a condition is met
		Differences

		Polling frequency - can change as per need
		Ignore Exception - in case element is not found, can ignore any exception like �NoSuchElement� exception etc.

		*/
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(10)) 
									.pollingEvery(Duration.ofSeconds(1)) 
									.ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
