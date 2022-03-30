package assignment.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import assignment.factory.DriverManager;


public class BaseTest {

	protected WebDriver driver;

	@Parameters("browser")
	//    @BeforeMethod
	@BeforeClass
	public void startDriver(@Optional("chrome") String browser){
		driver = new DriverManager().intializeDriver(browser);
	}

	//    @AfterMethod
	@AfterClass
	public void quitDriver(){
		driver.quit();
	}

	
}
