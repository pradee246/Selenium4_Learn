package testNG_fw.constant;

import testNG_fw.enums.ConfigProperties;
import testNG_fw.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
	}
	
	public static final long DEFAULT_WEBDRIVERWAIT = 20;
	
	private static final String RESOURCESEPATH = System.getProperty("user.dir")+"/src/test/resources";

	public static final String CONFIG_FILEPATH = RESOURCESEPATH+"/config/config.properties";
	public static final String JSONCONFIG_FILEPATH = RESOURCESEPATH+"/config/config.json";
	public static final String TESTEXCEL_FILEPATH = RESOURCESEPATH+"/data/TestCases.xlsx";
	
	public static final String DATASHEET_DATA = "DATA";
	
	private static final String EXTENTSREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-report/";
	
	
	private static String extentReportFilePath="";
	
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isBlank()) {
			setExtentReportFilePath();
		}
		return extentReportFilePath;
	}

	private static void setExtentReportFilePath() {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			extentReportFilePath = EXTENTSREPORTFOLDERPATH + "/"+System.currentTimeMillis()+"/index.html";
		}else {
			extentReportFilePath = EXTENTSREPORTFOLDERPATH + "index.html";
		}
	}



	
}
