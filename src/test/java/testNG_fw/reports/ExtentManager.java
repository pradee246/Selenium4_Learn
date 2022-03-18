package testNG_fw.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	static ExtentTest getExtentTest() {
		ExtentTest test = extentTest.get();
		if(Objects.isNull(test)) {
			ReportExtents.createTest("Debuging Test");
			return extentTest.get();
		}else {
			return test;
		}
		 
	}
	
	static void unload() {
		extentTest.remove();
	}

}
