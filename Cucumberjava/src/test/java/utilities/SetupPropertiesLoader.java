package utilities;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SetupPropertiesLoader {

	private static Properties properties = null;
	private static Logger Log = LogManager.getLogger(SetupPropertiesLoader.class.getName());
	@SuppressWarnings("unused")
	private enum propertyFiles
	{
		directory, roles 
		}
	

	
	/**
	 * This method is to initialize the properties file
	* 
	* @throws Throwable
	* 
	*/
	
	/**
	 * 
	 * @param filename
	 */
		
	private static void configReader(String propertyFiles)
	{
		@SuppressWarnings("unused")
		File f = new File(".");
		properties = new Properties();
		String File_location=System.getProperty("user.dir");
		try {
				properties.load(new BufferedReader(new FileReader(""+File_location+"/src/test/resources/PropertiesList/config.properties")));
		} catch (Exception e) {
			System.out.println("No property file found");
			Log.error("No property file found"+" :"+e.getMessage());;
		}
	}
	/**
	 * This method is to get the value from properties file based on the key
	* @param key
	 * @throws  
	* @throws Throwable
	*/
	public static String getProperty(String propertName, String propertyFiles)
	{
		configReader(propertyFiles);
		String propertyValue = properties.getProperty(propertName);
		if (propertyValue == null) {
			System.out.println("No value for given property name:"
					+ propertName + "Please fill-in the properties file");
		}
		return propertyValue;
	}
}
