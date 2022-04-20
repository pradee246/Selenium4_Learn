package testNG_fw.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;

import testNG_fw.factory.DriverManager;

public class ExtentLogger {

	private ExtentLogger(){}

	public static void pass(String msg) {
		ExtentManager.getExtentTest().pass(msg);
	}
	
	public static void info(String msg) {
		ExtentManager.getExtentTest().info(msg);
	}

	public static void fail(String msg) {
		ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
	}
	
	public static void fail(String msg, boolean captureScreen) {
		String highlight = String.format("%s" + msg + "%s", "<mark>", "</mark>"); // highlighting with yellow background
		String highlight2 = String.format("%s" + msg + "%s", "<span class='badge white-text red'>", "</span>"); // using the class internally used by Extent report
		String highlight3 = String.format("%s" + msg + "%s", "<span style='color:Tomato;'>", "</span>"); //Setting custom color
		ExtentManager.getExtentTest().fail(highlight2, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
	}

	public static void skip(String msg) {
		ExtentManager.getExtentTest().skip(msg);
	}

	private static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
}
