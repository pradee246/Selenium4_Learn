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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.youtube.com/watch?v=okGp6T3sSVw&list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH&index=7

public class Session7_WebElementStrategies {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*
		-- How to find element:
		findElement()
		driver.findElement(By.name("q"));
		 */

		driver.get("https://trytestingthis.netlify.app/");
		// Get all the elements available with tag name 'select'
		List<WebElement> elements = driver.findElements(By.tagName("select"));

		for (WebElement element : elements) {
			System.out.println("Paragraph text:" + element.getText());
		}


		// -- How to get element from element:
		driver.get("http://www.google.com");
		WebElement searchForm = driver.findElement(By.tagName("form"));
		// from the above element find the child element
		WebElement searchBox = searchForm.findElement(By.name("q"));
		searchBox.sendKeys("selenium");



		/*
		-- How to get active element:
		activeElement()
		 */

		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("webElement");
		// Get attribute of current active element
		String attr = driver.switchTo().activeElement().getAttribute("title");
		System.out.println(attr);

		/*
		-- How to get element tagname, text, css:
		getTagName()
		getText()
		getCssValue()
		 */

		driver.get("http://www.google.com");
		WebElement ele = driver.findElement(By.name("q"));
		//returns TagName of the element
		String sTag = ele.getTagName();
		String sText = ele.getText();
		String sCSSValue = ele.getCssValue("color");
		
		System.out.println(String.format("Tag: %s | Text: %s | CSS: %s", sTag, sText, sCSSValue));
		
		/*
		 * How to check element is Enabled | is Selected: 
		 * isEnabled() 
		 * isSelected()
		 */
		
		driver.findElement(By.name("---")).isEnabled();
		driver.findElement(By.xpath("---")).isSelected();


		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
