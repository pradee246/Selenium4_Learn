package basicSession;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
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

//https://www.youtube.com/watch?v=okGp6T3sSVw&list=PLhW3qG5bs-L_8bwNnMHdJ1Wq5M0sUmpSH&index=4

public class Session4_PopUp_Alerts {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert box text: "+ text);
		// Accept alert
		alert.accept();
		if(driver.getPageSource().contains("You successfully clicked an alert")) System.out.println("Successfully clicked on alert");
		
		// Dismiss alert
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		
		// Enter text to alert input field
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Automation Step by Step");
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}
}
