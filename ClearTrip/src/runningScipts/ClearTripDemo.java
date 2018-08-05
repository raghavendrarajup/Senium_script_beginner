package runningScipts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testData.Constants;
import testScripts.Demo.ClearTrip_script;
import udf.UDF;
import config.Browsers;

public class ClearTripDemo extends Browsers{
	WebDriver driver;
 
@Test(priority=1)
  public void ClearTrip_ScenarioOne() throws Exception
	{
	 ClearTrip_script ct = new ClearTrip_script(driver);
	 ct.ClearTripScripts();
	 }


@BeforeClass
  public void setup()
    {
	 driver = getDriver();
     }

@AfterClass
public void teardown() throws IOException
	{	   
	 driver = tearDown();
	}
}
