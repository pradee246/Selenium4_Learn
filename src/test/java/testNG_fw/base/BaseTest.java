package testNG_fw.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import testNG_fw.factory.Driver;
import testNG_fw.factory.DriverManager;
import testNG_fw.reports.ReportExtents;

public class BaseTest {

	//protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	//@BeforeClass
	public void startDriver(@Optional("chrome") String browser){
		Driver.intializeDriver(browser);
		//driver = DriverManager.getDriver();
	}

	@AfterMethod
	//@AfterClass
	public void quitDriver(){
		Driver.quitDriver();
	}

	// ------ Report ------ 
	//	@BeforeSuite
	//	public void reportStartup() {
	//		ReportExtents.initReports();
	//	}
	//
	//	@AfterSuite
	//	public void reportTearDown() throws IOException {
	//		ReportExtents.flushReport();
	//	}


}
