package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataProvider {
	BaseTestSetup ConfigProp = new BaseTestSetup();
	static Fillo fillo=new Fillo(); 
	
	public static HashMap<String, String> extractExcelData(String ScenarioName,HashMap<String, String> excelHashMapValues) throws FilloException, IOException
	{
		//TestDataFilePath
		Connection connection=fillo.getConnection(SetupPropertiesLoader.getProperty("TestDataFilePath", "config.properties"));
		String sheetname= SetupPropertiesLoader.getProperty("TestDataSheet", "config.properties");
		//TestDatasheetpath
		String strQuery="Select * from "+sheetname+" where ScenarioName='" +ScenarioName +"'";
		Recordset recordset=connection.executeQuery(strQuery);
		while(recordset.next())
		{
			ArrayList<String> ColCollection = recordset.getFieldNames();
			int Iter;
			int size = ColCollection.size();
			for (Iter=0 ; Iter<= (size-1) ; Iter++)
			{
				String ColName = ColCollection.get(Iter);
				System.out.println("Scenario = "+ ScenarioName+ "Header is :" + ColName);
				String ColValue = recordset.getField(ColName);
				System.out.println("Scenario = "+ ScenarioName+ "Value is :" + ColValue);
				//HashMap<String, String> excelHashMapValues = new HashMap <String, String>();
				excelHashMapValues.put(ColName, ColValue);				
			}
		}
		recordset.close();
		connection.close();
		return excelHashMapValues;
	}
	


	public void insertExcelData(String ScenarioName, String key, String value) throws Exception
	{
		Properties ConfigObj = ConfigProp.LoadConfigProperties();
		Connection connection=fillo.getConnection(ConfigObj.getProperty("TestDataFilePath"));
		String sheetname= ConfigObj.getProperty("TestDataSheet");
		String strQuery="Update "+sheetname+" Set "+key+"='"+value+"' where ScenarioName='" +ScenarioName +"'";
		connection.executeUpdate(strQuery);
		connection.close();
	}
	
	public void insertExcelData(String ScenarioName, String key, String Sheetname, String value) throws Exception
	{
		Properties ConfigObj = ConfigProp.LoadConfigProperties();
		Connection connection=fillo.getConnection(ConfigObj.getProperty("TestDataFilePath"));
		String strQuery="Update "+Sheetname+" Set "+key+"='"+value.replaceAll("'", "")+"' where ScenarioName='" +ScenarioName +"'";
		connection.executeUpdate(strQuery);
		connection.close();
		
		
	}

}



