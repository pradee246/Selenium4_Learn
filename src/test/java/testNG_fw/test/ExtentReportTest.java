package testNG_fw.test;

import testNG_fw.base.BaseTest;
import testNG_fw.pages.HomePage;
import testNG_fw.reports.ExtentLogger;
import testNG_fw.reports.ExtentManager;
import testNG_fw.reports.ReportExtents;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportTest extends BaseTest{

	@Test
	void extentReporTest1() throws IOException{
		ReportExtents.createTest("ExtentReportTest Sample1");
		
		
		ExtentLogger.pass("This is pass step1");
		ExtentLogger.fail("This is fail step1");
		ExtentLogger.skip("This is skip step1");
		

	}
	
	
	@Test
	void extentReporTest2() throws IOException{
		ReportExtents.createTest("ExtentReportTest Sample2", "Trainer", "Smoke Test" , "Windows");
		
		
		ExtentLogger.pass("This is pass step2");
		ExtentLogger.fail("This is fail step2");
		ExtentLogger.skip("This is skip step2");
		

	}
	


}
