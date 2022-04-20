package testNG_fw.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import testNG_fw.constant.FrameworkConstants;


public final class DataProviderUtils {
	private DataProviderUtils() {}
	
	private static List<Map<String, String>> list = new ArrayList<>();
	
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testname = m.getName();
		if(list.isEmpty()) { // to optimize 
			System.out.println("------- readin data ------");
			list = ExcelUtils.getTestDetails(FrameworkConstants.DATASHEET_DATA);
		}
		
		List<Map<String, String>> sublist = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) 
					&& list.get(i).get("execute").equalsIgnoreCase("yes")) {
				sublist.add(list.get(i));
			}
		}
		return sublist.toArray();
		
	}

}
