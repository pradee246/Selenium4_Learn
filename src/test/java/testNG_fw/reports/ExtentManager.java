package testNG_fw.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static void unload() {
		extentTest.remove();
	}

}
