package testNG_fw.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import testNG_fw.factory.DriverManager;

public class ExtentLogger {

	private ExtentLogger(){}

	public static void pass(String msg) {
		ExtentManager.getExtentTest().pass(msg);
	}

	public static void fail(String msg) {
		//ExtentManager.getExtentTest().fail(msg).addScreenCaptureFromBase64String(getBase64Image().concat(msg));
		ExtentManager.getExtentTest().fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
	}

	public static void skip(String msg) {
		ExtentManager.getExtentTest().skip(msg);
	}

	private static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
}
