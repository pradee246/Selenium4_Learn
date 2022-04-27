package testNG_fw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import testNG_fw.base.BasePage;
import testNG_fw.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {
	
//	public OrangeHRMLoginPage(WebDriver driver) {
//		super(driver);
//	}

	public OrangeHRMLoginPage load() {
		load("/");
		return this;
	}
	private final By txtUsername = By.id("txtUsername");
	private final By txtPassword = By.id("txtPassword");
	private final By btnLogin = By.id("btnLogin");

	public OrangeHRMLoginPage enterUserName(String username) {
		sendKeys(txtUsername, username, WaitStrategy.VISIBLE, "UserNmae");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(txtPassword, password, WaitStrategy.NONE, "Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(btnLogin, WaitStrategy.CLICKABLE, "Login button");
		return new OrangeHRMHomePage();
	}
	

}
