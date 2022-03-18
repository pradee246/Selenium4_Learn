package testNG_fw.listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testNG_fw.reports.ExtentLogger;
import testNG_fw.reports.ReportExtents;

public class Listener implements ITestListener, ISuiteListener{
	/**
	 * This method is invoked before the SuiteRunner starts.
	 * @param suite The suite
	 */
	@Override
	public void onStart(ISuite suite) {
		ReportExtents.initReports();
	}

	/**
	 * This method is invoked after the SuiteRunner has run all the tests in the suite.
	 * @param suite The suite
	 */
	@Override
	public void onFinish(ISuite suite) {
		try {
			ReportExtents.flushReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ReportExtents.createTest(result.getMethod().getMethodName());
	}

	/**
	 * Invoked each time a test succeeds.
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SUCCESS
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is PASS");
	}

	/**
	 * Invoked each time a test fails.
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#FAILURE
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+ " is FAIL");
	}

	/**
	 * Invoked each time a test is skipped.
	 * @param result <code>ITestResult</code> containing information about the run test
	 * @see ITestResult#SKIP
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is SKIP");
	}


}
