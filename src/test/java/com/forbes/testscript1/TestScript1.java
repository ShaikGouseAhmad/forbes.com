package com.forbes.testscript1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.forbes.utilities.BaseClass;
import com.forbes.webpages.Forbes;
import com.forbes.webpages.ForbesAdvisor;
import com.forbes.webpages.WorldsBillionaires;

public class TestScript1 extends BaseClass{
	
	@Test
	public void testTestScript1() throws InterruptedException
	{
		Forbes fr=new Forbes();
		WorldsBillionaires wb=new WorldsBillionaires();
		ForbesAdvisor fa=new ForbesAdvisor();
		fr.displayadtoppage();
		log.info("*****************take ScreenShot ad of Forbes page***********");
		fr.clickonLinkBillionaires();
		if(driver.getTitle().contains("Worlds Billionaires"))
		{
			EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
			File f1=efw.getScreenshotAs(OutputType.FILE);
			String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
			String format = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
			File f2=new File(format);
			try {
				FileUtils.copyFile(f1,f2);
				log.info("*****************take ScreenShot title of WorldsBillionaires page***********");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
		}
			else if (driver.getTitle().contains("Worlds Billionaire"))
			{
				System.out.println("title not match");
			}
			else
			{
				System.out.println("no title present");
			}
		wb.displayadtoppage();
		log.info("*****************take ScreenShot ad of WorldsBillionaires page***********");
		
		
		
		
		fa.clickonLinkAdvisor();
		if(driver.getTitle().contains("Forbes Advisor"))
		{
			EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
			File f1=efw.getScreenshotAs(OutputType.FILE);
			String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
			String format = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
			File f2=new File(format);
			try {
				FileUtils.copyFile(f1,f2);
				log.info("*****************take ScreenShot title of Advisor page***********");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
		}
			else if (driver.getTitle().contains("Forbes Advisors"))
			{
				System.out.println("title not match");
			}
			else
			{
				System.out.println("no title present");
			}
		String s = fa.checkLabel();
		System.out.println(s);
		log.info("*****************check label Advisor page***********");
		String sf = fa.subLabel();
		System.out.println(sf);
		log.info("*****************check sublabel Advisor page***********");
		String sa = fa.checkAdpresent();
		System.out.println(sa);
		log.info("*****************check ad in Advisor page***********");
		String color = fa.getColor();
		System.out.println(color);
		log.info("*****************get color of Advisor page***********");
		
	    fa.clickonsearchs();
	    log.info("*****************click on search icon***********");
	    if(driver.getTitle().contains("Forbes Advisor"))
		{
			EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
			File f1=efw.getScreenshotAs(OutputType.FILE);
			String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
			String format = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
			File f2=new File(format);
			try {
				FileUtils.copyFile(f1,f2);
				log.info("*****************take ScreenShot title of Advisor page***********");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		}
		}
			else if (driver.getTitle().contains("Forbes Advisors"))
			{
				System.out.println("title not match");
			}
			else
			{
				System.out.println("no title present");
			}
		fa.enterInSearch("apple"+Keys.ENTER);
		log.info("*****************enter data in search bar***********");
		Thread.sleep(2000);
		EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
		File f1=efw.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date());
		String format = System.getProperty("user.dir")+"//ScreenShot//"+date+".jpg";
		File f2=new File(format);
		try {
			FileUtils.copyFile(f1,f2);
			log.info("*****************take ScreenShot title of Advisor page***********");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    
		
	}
		
	
	
	   if(driver.getTitle().contains("Forbes Search"))
			{
				
				System.out.println("results passed");	
			}
				else
				{
					System.out.println("result failed");
				}

}
}