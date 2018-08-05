package udf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.ClearTrip_PO;

public class UDF extends ClearTrip_PO{
	 static String flightName1;
	 static String Duration1;
	 static String Timings1;
	 static String flightName2;
	 static String Duration2;
	 static String Timings2;
	 
	public UDF(WebDriver driver) 
	  {
		super(driver);
	   }

   /* Search Flight by giving valid inputs */
		public void SearchFlight(String strTripType,String strFromLocation, String strToLocation, String Departdate, String Returndate) throws InterruptedException
		  {
		   this.setSelectTrip(strTripType);
		   this.setFromLocation(strFromLocation);
		   this.setToLocation(strToLocation);
		   this.setDepartOn(Departdate);
		   this.setReturnOn(Returndate);
		   this.setSelectTickets("adults", "2");
		   this.setSelectTickets("children", "2");
		   this.setSearchFlight();
	 	   }
		 
		 public void BookTicket()
		   {
			this.setSort_Price_block1();
		    flightName1 = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[2]/div[1]/div/strong")).getText();
			Duration1 = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[2]/div[1]/div/small[3]")).getText();
			Timings1 = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[2]/div[1]/div/small[2]/span")).getText();
		
			System.out.println("flightName1 = "+flightName1);
			System.out.println("Duration1 = "+Duration1);
			System.out.println("Timings1 = "+Timings1);
		
			this.setSort_Price_block2();
			
			flightName2 = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[2]/div[2]/div/strong")).getText();
			Duration2 = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[2]/div[2]/div/small[3]")).getText();
			Timings2 = driver.findElement(By.xpath("//*[@id='flightForm']/section[2]/div[3]/div[2]/div[2]/div/small[2]/span")).getText();
		
			System.out.println("flightName2 = "+flightName2);
			System.out.println("Duration2 = "+Duration2);
			System.out.println("Timings2 = "+Timings2);
			
			this.setBookTkt();
		    }
		
		 public int VerifyDetailsInItineraryPage()
		   {
			 String Flightone = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div[1]/div[3]/div/div/div[1]/ul/li[1]/div[2]/span")).getText();
			 
			 String FlightReturn = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div[1]/div[3]/div/div/div[2]/ul/li[1]/div[2]/span")).getText();
			 
			 if(Flightone.contains(flightName1) && FlightReturn.contains(flightName2))
			 {
			 return 1;
			 }
			 return 0;
		   }

}