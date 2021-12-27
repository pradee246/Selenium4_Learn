package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * https://youtu.be/HjYEjKWSbe8
 */

public class Session1_3_FramesWindows {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// -- timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		
		// -- 9. Frames
		
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		//Locate and Switch
		WebElement iframe = driver.findElement(By.name("packageFrame"));
		driver.switchTo().frame(iframe);

		//Using id or name
		driver.switchTo().frame("classFrame");

		//Using index
		driver.switchTo().frame(1);

		//Return to top level window
		driver.switchTo().defaultContent();
		
		
		// -- 10. Window management - Size

		//Get width & height
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		//Store dimensions & query later
		Dimension size = driver.manage().window().getSize();
		int width1 = size.getWidth();
		int height1 = size.getHeight();

		//Set window size
		driver.manage().window().setSize(new Dimension(800, 600));

		// -- 10. Window management - Position

		//Access x and y dimensions individually
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();


		//Store dimensions & query later
		Point position = driver.manage().window().getPosition();
		int x1 = position.getX();
		int y1 = position.getY();

		//Move the window to the top left of the primary monitor
		driver.manage().window().setPosition(new Point(0, 0));

		// -- 10. Window management

		// maximize window
		driver.manage().window().maximize();

		// minimize window
		driver.manage().window().minimize();
		  
		// fullscreen
		driver.manage().window().fullscreen();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
