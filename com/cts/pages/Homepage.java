package com.cts.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='dropdown dropdown-currency']/a")
	WebElement currency;
	
	@FindBy(xpath="//div[@class='dropdown-menu-inner']/a[@data-code='11']")
	WebElement eur;
	
	@FindBy(xpath="//ul/li[2]/a[@class='text-center flights ']")
	WebElement flights;
	
	@FindBy(xpath="//div[@id='s2id_location_from']")
	WebElement from;
	
	@FindBy(xpath="//*[@id=\"select2-drop\"]/div/input")
	WebElement lax;
	
	@FindBy(xpath="//div[@id='s2id_location_to']")
	WebElement to;
	
	@FindBy(xpath="//div[@id='select2-drop']/div/input")
	WebElement dfw;

	@FindBy(xpath="//*[@id=\"FlightsDateStart\"]")
	WebElement calender;
	
	/*@FindBy(xpath="//div[@id=\"datepickers-container\"]/div[8]/nav/div[2]")
	WebElement month;

	@FindBy(xpath="//div[@id='datepickers-container']/div[8]/div/div/div[2]/div[24]")
	WebElement date;*/

	@FindBy(xpath="//div[@class='col-xs-12 col-md-12']/button[@class='btn-primary btn btn-block']")
	WebElement search;
	
	public Homepage(WebDriver d)
	{
		 driver=d;
	     PageFactory.initElements(driver,this);
	     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	     driver.manage().window().maximize();
	}
	public void account() throws InterruptedException
	{
		currency.click();
		eur.click();
		Thread.sleep(2000);
		flights.click();
	}
	public void deals() throws InterruptedException
	{
		
		from.click();
		lax.sendKeys("LAX");
		Thread.sleep(2000);
		lax.sendKeys(Keys.ENTER);
	}
	public void cart() throws InterruptedException
	{
		String day = "21";
		String beforexpath = "//*[@id='datepickers-container']/div[8]/div/div[1]/div[2]/div[";
		to.click();
		dfw.sendKeys("DFW");
		Thread.sleep(2000);
		dfw.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		calender.click();
		
		for(int i=4;i<=35;i++)
		{
			String date1 = driver.findElement(By.xpath(beforexpath+i+"]")).getText();
			if(date1.equals(day))
			{
				driver.findElement(By.xpath(beforexpath+i+"]")).click();
				break;
			}
		}
		search.submit();
	}
	public String money() 
	{
		String euro = driver.findElement(By.xpath("//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/div/p[1]/strong")).getText();
		return euro;
	}
	
	
	
	
	////*[@id="datepickers-container"]/div[8]/div/div[1]/div[2]/div[24]
	////*[@id="datepickers-container"]/div[8]/div/div[1]/div[2]/div[25]
	//*[@id="datepickers-container"]/div[8]/div/div[1]/div[2]/div[31]
	
	
	
	
	
	
	
	
}
