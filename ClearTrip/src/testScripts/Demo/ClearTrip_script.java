/**
* Smartdrive Login testcases
* @author Shankar
* @Date = ‘5th August 2015”
*/

package testScripts.Demo;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.Browsers;
import testData.Constants;
import udf.UDF;
import utility.ExcelUtils;

public class ClearTrip_script extends UDF{
  public ClearTrip_script(WebDriver driver) 
    {
	 super(driver);
	} 

  public void ClearTripScripts() throws Exception
    {
	 
	 /** Test Data inputs File **/		
	  ExcelUtils.setExcelFile(Constants.Test_InputFileName, "ClearTrip");
	  String strTripType = ExcelUtils.getCellData(1, 2);
	  String strFromLocation = ExcelUtils.getCellData(2, 2); 
	  String strToLocation = ExcelUtils.getCellData(3, 2); 
	  String Depart_date = ExcelUtils.getCellData(4, 2); 
	  String Return_Date = ExcelUtils.getCellData(5, 2);


	  try {
		   SearchFlight(strTripType, strFromLocation, strToLocation, Depart_date, Return_Date);
		   BookTicket();
		   int Verification = VerifyDetailsInItineraryPage();
		   if(Verification==1)
		   {
		   System.out.println("###### Test Case is Pass ########");
		   } else 
		   		{
			   	 System.out.println("********* Test Case is Fail ************");
		   		 }
	  	   } catch (Exception e) 
	  			{
	  		     System.out.println("********* Test Case is Fail *************");
	  			 }
    
     } 
 }
