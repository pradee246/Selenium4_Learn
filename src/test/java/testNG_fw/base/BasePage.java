package testNG_fw.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import testNG_fw.constant.FrameworkConstants;
import testNG_fw.enums.ConfigProperties;
import testNG_fw.enums.WaitStrategy;
import testNG_fw.factory.DriverManager;
import testNG_fw.reports.ExtentLogger;
import testNG_fw.utils.PropertyUtils;

import java.time.Duration;

public class BasePage {

    /*
    Note : Keep this minimal, avoid added lots of methods
     */

    private String sBaseURL =PropertyUtils.get(ConfigProperties.URL);// "https://askomdch.com";

//    public BasePage(WebDriver driver){
//        this.driver = driver;
//        wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
//    }

    protected WebDriverWait getWebDriverWait(long l){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(l));
    }

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
		WebElement e=null;
		if(waitStrategy == WaitStrategy.CLICKABLE) {
			e = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.DEFAULT_WEBDRIVERWAIT))
			.until(ExpectedConditions.elementToBeClickable(by));
		}else if(waitStrategy == WaitStrategy.VISIBLE) {
			e = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.DEFAULT_WEBDRIVERWAIT))
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}else if(waitStrategy == WaitStrategy.PRESENCE) {
			e = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.DEFAULT_WEBDRIVERWAIT))
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}else if(waitStrategy == WaitStrategy.NONE) {
			e = DriverManager.getDriver().findElement(by);
		}
		return e;
	}

    // ------------------ Actions ---------------------
    protected void load(String sEndPoint){
    	DriverManager.getDriver().get(sBaseURL+sEndPoint);
        ExtentLogger.info("Navigated to: "+sBaseURL+sEndPoint);
    }
    
    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
    	WebElement e = performExplicitWait(by, waitStrategy);
		e.sendKeys(value);
    	ExtentLogger.info(value+ " is entered in the element: "+elementName+" (" + by.toString() +")");
    }
    
    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
    	WebElement e = performExplicitWait(by, waitStrategy);
		e.click();
		ExtentLogger.info("Clicked the element: "+elementName+" (" + by.toString() +")");
    }
    
    protected String getText(By by, WaitStrategy waitStrategy, String elementName) {
    	WebElement e = performExplicitWait(by, waitStrategy);
    	String val = e.getText();
    	ExtentLogger.info(val+ " is returned from the element: "+elementName+" (" + by.toString() +")");
    	return val;
    }
    
    public String getPageTitle() {
    	String val = DriverManager.getDriver().getTitle();
    	ExtentLogger.info("Title is returned: "+ val);
		return val;
	}
}
