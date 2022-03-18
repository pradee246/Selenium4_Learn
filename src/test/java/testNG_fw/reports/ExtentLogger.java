package testNG_fw.reports;

public class ExtentLogger {

	private ExtentLogger(){}
	
	public static void pass(String msg) {
		ExtentManager.getExtentTest().pass(msg);
	}
	
	public static void fail(String msg) {
		ExtentManager.getExtentTest().fail(msg);
	}
	
	public static void skip(String msg) {
		ExtentManager.getExtentTest().skip(msg);
	}
}
