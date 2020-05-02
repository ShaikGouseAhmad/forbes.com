package com.forbes.webpages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.forbes.utilities.BaseClass;

public class ForbesAdvisor {

	@FindBy(linkText="Advisor")
	private WebElement clickonAdvisor;
	
	
	@FindBy(className="header__search")
	private WebElement clickonsearch;
	@FindBy(className="search-modal__input")
	private WebElement Typesearchbar;
	
	@FindBy(className="landing-url-text")
	private WebElement labelAdvisor;
	

	public ForbesAdvisor()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	 public void clickonLinkAdvisor()
	    
		{
			clickonAdvisor.click();
		}
 
 public String getColor()
 {
	String color = labelAdvisor.getCssValue("color");
	return color; 
	
 }
 
 
 public void clickonsearchs()
 {
	 clickonsearch.click();
 }
public void enterInSearch(String name) {
	// TODO Auto-generated method stub
	Typesearchbar.sendKeys(name);
}
public String checkLabel()
{
	 if(labelAdvisor.isDisplayed())
	 {
		 return "is lable";
	 }
	 
	 else{
	return "is not label";
	 }
	 
	}
       public String checkAdpresent()
     {
	if(BaseClass.driver.getPageSource().contains("//div[@style='height: auto;']"))
	{
    return "is present";
	}
else
{

  EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
  File f1=efw.getScreenshotAs(OutputType.FILE);
  String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
  String format = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
  File f2=new File(format);
try {
	FileUtils.copyFile(f1,f2);
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
}
return "is not present";
}
	
	}
       public String subLabel()
   	{
   		if(BaseClass.driver.getPageSource().contains("Money Advice, News And Product Reviews From A Name You Trust"))
   		{
   	    return "sublabel present";
   		}
            else
            {
   	    return "sublabel not present";
   	    
            }
	
   }
	 
}
       
