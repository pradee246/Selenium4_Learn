package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.youtube.com/watch?v=okGp6T3sSVw&list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH&index=5

public class Session5_Proxy {

	public static void main(String[] args) throws InterruptedException, IOException {

		
		/*
		Proxy server acts as an intermediary for requests between a client and a server
		* Capture network traffic
		* Mock backend calls made by the website
		* Access a website under corporate restrictions/policies
		*/

		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		//proxy.setHttpProxy("localhost:8080"); 
		proxy.setSslProxy("localhost:8080");

		ChromeOptions options = new ChromeOptions();
		options.setCapability("proxy", proxy);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
