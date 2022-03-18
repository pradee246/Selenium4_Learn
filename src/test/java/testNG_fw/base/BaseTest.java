package testNG_fw.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testNG_fw.factory.DriverManager;
import testNG_fw.reports.ReportExtents;

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

	// ------ Report ------ 
	@BeforeSuite
	public void reportStartup() {
		ReportExtents.initReports();
	}

	@AfterSuite
	public void reportTearDown() throws IOException {
		ReportExtents.flushReport();
	}
	
}
