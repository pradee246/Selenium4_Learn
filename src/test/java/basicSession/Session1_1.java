package basicSession;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * https://youtu.be/HjYEjKWSbe8
 
 * Setting the browser
 * Add Time out
 * Closing the browser
 */

public class Session1_1 {

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		// -- Using Webdriver manager
		//WebDriverManager.chromedriver().driverVersion("92.0").setup(); -- Provide a specific version of driver version
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		// -- timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));  
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// -- close
		driver.close();
		driver.quit();
		
	}

}
