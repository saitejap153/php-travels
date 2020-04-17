package com.cts.tests;
import org.testng.annotations.Test;

import com.cts.pages.Homepage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest1 {
	WebDriver driver;
	Homepage hp;
  @Test
  public void f() {
	 
	  hp=new Homepage(driver);
  }
  @Test (dependsOnMethods = {"f"})
  public void f1() throws InterruptedException
  {
	  hp.account();
	  Thread.sleep(2000);
	  hp.deals();
	  hp.cart();
  }
  @Test (dependsOnMethods = {"f1"})
  public void f2()
  {
	  String rupee = hp.money();
	  System.out.println(rupee);
	  String euro1[] = rupee.split(" ");
	  String value = euro1[1];
      System.out.println(value);
	  int j = Integer.parseInt(value);
	  System.out.println(j);
	  Assert.assertFalse(j>100 && j<250);
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:/Users/lenovo/eclipse-workspace/DomesticFlightBooking/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("https://www.phptravels.net/home");
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
	 
  }

}
