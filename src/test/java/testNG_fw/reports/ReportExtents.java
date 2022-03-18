package testNG_fw.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportExtents {
	
	private ReportExtents() {}
	
	private static ExtentReports extent;
	//private static ExtentTest test;
	
	public static void initReports() {
		System.out.println("Initialize Extent report");
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
			extent.attachReporter(spark);
			
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Extent Report - Title");
			spark.config().setReportName("Automation Test Report");
		}
	}
	
	public static void flushReport() throws IOException {
		System.out.println("Flush Extent report");
		if(!Objects.isNull(extent)) {
			extent.flush();
			// Optional : If reports needs to be opened automatically
			Desktop.getDesktop().browse(new File("target/spark.html").toURI());
			ExtentManager.unload();
		}
	}

	public static void createTest(String tesCasetName) {
		ExtentTest test = extent.createTest(tesCasetName);
		System.out.println("<<<<<<<<<<<< STARTED TC: " +tesCasetName + " >>>>>>>>>>>>>>>");
		ExtentManager.setExtentTest(test);
	}
	
	public static void createTest(String tesCasetName, String Author, String Category, String Device) {
		ExtentTest test = extent.createTest(tesCasetName).assignAuthor(Author).assignCategory(Category).assignDevice(Device);
		ExtentManager.setExtentTest(test);
	}
}
