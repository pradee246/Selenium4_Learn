package basicSession;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * https://youtu.be/HjYEjKWSbe8
 */

public class Session1_2_BrowserActions {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// -- timeout 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		
		//1. Open a web page
		driver.get("https://google.com");
		driver.navigate().to("https://selenium.dev");

		//2. Get current url
		driver.getCurrentUrl();

		//3. Get title
		driver.getTitle();

		//4. Forward | Back | Refresh
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		//5. Switching windows
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().window(originalWindow);

		//6. Open new window and switch to the window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://gmail.com");
		Thread.sleep(3000);
		
		//7. Open new tab and switch to the tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://bing.com");
		
		//8. Closing browser
		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
