package testNG_fw.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import testNG_fw.constant.FrameworkConstants;
import testNG_fw.enums.ConfigProperties;


public class PropertyUtils {

	private PropertyUtils() {}
	
	private static Properties prop = new Properties();
	private static final Map<String, String> propMap = new HashMap<>();
	
	static {
		try {
			prop.load(new FileInputStream(FrameworkConstants.CONFIG_FILEPATH));
		
			// Adding all the properties to Hashmap
			for(Object key: prop.keySet()) {
				propMap.put(key.toString(), prop.get(key).toString().trim());
			}
			 // -- OR by using lambda 	
			// prop.entrySet().forEach(entry -> propMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));
		} catch (Exception e) {
			throw new RuntimeException("Error in loading config property file" + e.getLocalizedMessage(), e);
		}
	}
	
	public static String getValue(ConfigProperties key) {
		// Check if no value is returned || Check if the key is null
		if(Objects.isNull(key) || Objects.isNull(prop.getProperty(key.name().toLowerCase()))) {
			throw new RuntimeException("Key: '"+key.name().toLowerCase() +"' is not found check in the config.properties file");
		}
		return prop.getProperty(key.name().toLowerCase());
	}

	// Alternate option to get value through MAP useful if there are lot of values to be fetched from config multiple time 
	public static String get(ConfigProperties key) {
		// Check if the key is null || Check if no value is returned
		if(Objects.isNull(key) || Objects.isNull(propMap.get(key.name().toLowerCase()))) {
			throw new RuntimeException("Key: '"+key.name().toLowerCase() +"' is not found check in the config.properties file");
		}
		return propMap.get(key.name().toLowerCase());
	}
	


}
