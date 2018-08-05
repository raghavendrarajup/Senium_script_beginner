package config;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeClass;

import testData.Constants;
import utility.ExcelUtils;


public class Browsers{
	
  /*Below method is for changing the time */	
	public static WebDriver driver;
	
	static String driverPath = Constants.ChromeDrivepath;
	

	public WebDriver getDriver() {
		return driver;
	}

	private String setDriver(String browserType, String SuiteType) throws Exception  {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(SuiteType);
			break;
		case "firefox":
			driver = initFirefoxDriver(SuiteType);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(SuiteType);
		}
	  return browserType;
	}

	private static WebDriver initChromeDriver(String SuiteType) throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		String username = System.getProperty("user.name");
		String userProfile= "C:\\Users\\"+username+"\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Default";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir="+userProfile);
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(Constants.ClearTripURL);
		return driver;
	 }
	
	private static WebDriver initFirefoxDriver(String SuiteType) throws Exception {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.navigate().to(Constants.ClearTripURL);
		 return driver;
	}
	
@Parameters({"browserType", "SuiteType"})
@BeforeClass
	public void initializeTestBaseSetup(String browserType, String SuiteType) throws Exception 
		{
	      
			try {
				setDriver(browserType, SuiteType);
				} 
			catch (Exception e) 	
				{
				System.out.println("Error....." + e.getStackTrace());
				}
		}
	
	@AfterClass
	public WebDriver tearDown() {
		driver.quit();
		return driver;
	}
	
}