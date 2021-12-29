package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.youtube.com/watch?v=okGp6T3sSVw&list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH&index=6

public class Session6_PageLoadingStrategies {

	public static void main(String[] args) throws InterruptedException, IOException {

		/*
		Page Loading Strategies
 		NORMAL
 		EAGER
 		NONE
		 */

		/*
		--Normal
		waits for the entire page to be loaded
		Selenium webdriver waits until the *load event fire* is returned

		//By default normal is set to browser if none is provided
		 */

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


		/*
		--Eager
		waits until the initial HTML document has been completely loaded and parsed
		discards loading of stylesheets, images and subframes
		Selenium webdriver waits until the *DOMContentLoaded event fire* is returned
		 */

		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

		/*
		--None 
		 When set to none Selenium WebDriver only waits until the initial page is downloaded
		 */

		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");

		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
