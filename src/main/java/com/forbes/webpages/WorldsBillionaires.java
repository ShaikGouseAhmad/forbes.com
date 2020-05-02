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

public class WorldsBillionaires {
	
	@FindBy(xpath="//div[@style='height: auto;']")
	private WebElement adtoppage;
	
	
	
	
	public WorldsBillionaires()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void displayadtoppage()
	{
		
		if (adtoppage.isDisplayed())
		{
			EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
			File f1=efw.getScreenshotAs(OutputType.FILE);
			String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
			String path = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
			File f2=new File(path);
			try {
				FileUtils.copyFile(f1,f2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
		}
		
		
	}
		
	}
	
	}
