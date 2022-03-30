package assignment.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {

	/*
    Note : Keep this minimal, avoid added lots of methods
	 */

	protected WebDriver driver;
	private WebDriverWait wait;

	private String sBaseURL = "https://askomdch.com";

	public BasePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
	}

	protected void load(String sEndPoint){
		driver.get(sBaseURL+sEndPoint);
	}

	public String getURL() {
		Object val = "";
		do {
			val = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState"));
//			System.out.println("---------- : "+ val.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { 	e.printStackTrace(); }
		}
		while(!("complete".equalsIgnoreCase(val.toString())));
		return driver.getCurrentUrl();
	}

	protected WebDriverWait getWebDriverWait(long l){
		return new WebDriverWait(driver, Duration.ofSeconds(l));
	}

	protected WebElement waitVisibilityOfElement(By by){
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected WebElement waitElementToBeClickable(By by){
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	// Actions 
	protected void _sendKeys(By by, String value, String elementName) {
		waitVisibilityOfElement(by).sendKeys(value);
	}

	protected void _click(By by, String elementName) {
		waitElementToBeClickable(by).click();
	}

	protected String _getText(By by, String elementName) {
		String val = waitVisibilityOfElement(by).getText();
		return val;
	}
}
