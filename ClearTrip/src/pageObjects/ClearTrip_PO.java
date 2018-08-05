package pageObjects;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import or.ClearTrip_OR;

import com.sun.jna.platform.win32.WinDef.PVOID;

public class ClearTrip_PO extends ClearTrip_OR {
	
	protected static WebDriver driver;	
	
	
	
	public ClearTrip_PO(WebDriver driver)
	 {
	    this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
	
	public void setSelectTrip(String strTripType)
		{
		 WebDriverWait ctwait = new WebDriverWait(driver, 60);
		 switch (strTripType.toLowerCase()) {
		 	case "oneway":
		 	  ctwait.until(ExpectedConditions.elementToBeClickable(oneWayTripRadioBtn));
			  oneWayTripRadioBtn.click();
			  break;
		 	case "round":
		 		ctwait.until(ExpectedConditions.elementToBeClickable(roundTripRadioBtn));
			  roundTripRadioBtn.click();
			  break;
		 	case "multicity":
		 		ctwait.until(ExpectedConditions.elementToBeClickable(mutliCityTripRadioBtn));
		      mutliCityTripRadioBtn.click();
			  break; 
		   }
		 }
	
	public void setFromLocation(String strFromLocation)
	{
	 from_City.clear();
	 from_City.sendKeys(strFromLocation);
	 }
	
	public void setToLocation(String strToLocation)
	{
	 to_City.clear();
	 to_City.sendKeys(strToLocation);
	 }
	
	public void setDepartOn(String date)
	 {
		departDate.click();
		WebElement datepicker = driver.findElement(By.className("calendar"));  
//		List<WebElement> rows=datepicker.findElements(By.tagName("tr"));  
		List<WebElement> columns=datepicker.findElements(By.tagName("td"));
		for (WebElement cell: columns){ 
		if (cell.getText().equals(""+date+"")){  
		 cell.click();   
		break;  
		 }  
		}   
	  }
	
	public void setReturnOn(String date)
	 {
		returnDate.click();
		WebElement datepicker = driver.findElement(By.className("calendar"));  
//		List<WebElement> rows=datepicker.findElements(By.tagName("tr"));  
		List<WebElement> columns=datepicker.findElements(By.tagName("td"));
		for (WebElement cell: columns){ 
		if (cell.getText().equals(""+date+"")){  
		 cell.click();   
		break;  
		 }  
		}   
	  }
	
	public void setSelectTickets(String strAge,String nooftkts)
	{
		
		 switch (strAge.toLowerCase()) {
		 	case "adults":
		 	  Select ticketsAdults = new Select(tickets_Adults);
		 	  ticketsAdults.selectByValue(nooftkts);
			  break;
		 	case "children":
		 	  Select tickets_children = new Select(tickets_Childrens);
		 	 tickets_children.selectByValue(nooftkts);
			  break;
		 	case "multicity":
		      mutliCityTripRadioBtn.click();
			  break; 
		   }
	 }
	
	public void setSearchFlight() throws InterruptedException
	{
	 WebDriverWait ctwait = new WebDriverWait(driver, 60);
	 searchFlightBtn.click();
	 ctwait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loaderContainer")));
	 setSort_Price_block1();
	 setSort_Price_block2();
	 }
	
	public void setSort_Price_block1()
	  {
	   WebDriverWait ctwait = new WebDriverWait(driver, 30);
	   ctwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='colZero leg col12'][@data-leg='1']/div/nav/ul/li[10]/a")));
	   String Classtext = driver.findElement(By.xpath("//*[@class='colZero leg col12'][@data-leg='1']/div/nav/ul/li[10]/a")).getAttribute("class");
	   if(Classtext.contains("current sortAsc"))
	   	  {
		   driver.findElement(By.xpath("//*[@class='colZero leg col12'][@data-leg='1']/div/nav/ul/li[10]/a")).click();
	   	   }
	   driver.findElement(By.xpath("//*[@class='colZero leg col12'][@data-leg='1']/nav/ul/li[2]/div/label/table/tbody[1]/tr[1]/th[1]")).click();
	   }
	
	public void setSort_Price_block2()
	  {
		WebDriverWait ctwait = new WebDriverWait(driver, 30);
		   ctwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='colZero leg col12 last'][@data-leg='2']/div/nav/ul/li[10]/a")));
		   String Classtext = driver.findElement(By.xpath("//*[@class='colZero leg col12 last'][@data-leg='2']/div/nav/ul/li[10]/a")).getAttribute("class");
		   if(Classtext.contains("current sortAsc"))
		   	  {
			   driver.findElement(By.xpath("//*[@class='colZero leg col12 last'][@data-leg='2']/div/nav/ul/li[10]/a")).click();
		   	   }
		   driver.findElement(By.xpath("//*[@class='colZero leg col12 last'][@data-leg='2']/nav/ul/li[2]/div/label/table/tbody[1]/tr[1]/th[1]")).click();
	   }
	
	public void setBookTkt()
		{
		 driver.findElement(By.xpath("/html/body/section[3]/div[2]/section[2]/section/div/form/section[2]/div[3]/div[3]/button")).click();
		 }
	
	
}  	 	