package testNG_fw.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import testNG_fw.base.BasePage;
import testNG_fw.enums.WaitStrategy;


public final class OrangeHRMHomePage extends BasePage{

//	public OrangeHRMHomePage(WebDriver driver) {
//		super(driver);
//	}

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.CLICKABLE, "Welcome link");
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3)); // Alternate of Thread.sleep and to avoid exception handling of Thread.sleep
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout");
		return new OrangeHRMLoginPage();
	}

}
