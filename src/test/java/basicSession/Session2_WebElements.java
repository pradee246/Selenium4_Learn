package basicSession;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://youtu.be/jb-5_QZpZk0?list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH

public class Session2_WebElements {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		// -- Locating single & multiple elements
		//Locate element using any of its unique properties
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ABCD", Keys.ENTER);

		//Locate multiple elements
		driver.navigate().to("https://trytestingthis.netlify.app/");
		List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
		  
		  for(WebElement element : options) {
		   System.out.println(element.getText());
		  }

		// -- Elements Selector Strategies
		/*
		*ID : using ID property of the element
		*Name : using Name property of the element
		*Link Text : using the visible text value of an anchor element
		*Partial Link Text : using the partial value of visible text of an anchor element
		*Class name : using Class name property of the element
		*Tag name : using Tag name property of the element
		*CSS Selectors : using a CSS selector with available properties
		*XPath : using XPath expression with available properties
		*/
		// - Tips on using Selectors

		//ID : use ID if available, unique and consistent

		//CSS Selectors : If unique ID�s not available

		//XPath : If CSS Selectors can�t be used

		//keep your locators as compact and readable as possible
		//traversing the DOM structure is an expensive operation,
		//the more you can narrow the scope of your search, the better

		// -- Selenium 4 - Relative Locators
		/*
		The findElement method accepts a new method with(By) which returns a RelativeLocator
		above
		below
		toLeftOf
		toRightOf
		near
		*/
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		// Finding the password box above login button
		WebElement passwordTextBox = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton));
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
