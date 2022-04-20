package testNG_fw.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testNG_fw.base.BaseTest;
import testNG_fw.reports.ExtentLogger;
import testNG_fw.reports.ReportExtents;
import testNG_fw.utils.ExcelUtils;

@Listeners(testNG_fw.listener.Listener.class)	

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
		
		List<Map<String, String>> data = ExcelUtils.getTestDetails("DATA");
		System.out.println(data);
		
		ExtentLogger.pass("This is pass step2");
		ExtentLogger.fail("This is fail step2");
		ExtentLogger.skip("This is skip step2");

	}
	


}
