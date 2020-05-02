package com.forbes.utilities;

import java.io.File;
import java.io.FileInputStream;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {

		public static WebDriver driver;
		FileInputStream fis;
		Properties p1;
		public static Logger log;
		@BeforeTest
		public void openBrowser() throws IOException
		{
			log=LogManager.getLogger(BaseClass.class);
			 String browser = "chrome";
			if(browser.equals("chrome"))
			{
			String path = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",path);
			driver=new ChromeDriver();
			String path2 = System.getProperty("user.dir")+"//App.Properties";
			fis=new FileInputStream(path2);
			p1=new Properties();
			p1.load(fis);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(p1.getProperty("url"));
			log.info("*****************Open Chrome Browser Successfully************************");
			
			if(driver.getTitle().contains("Forbes"))
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
					log.info("*****************take ScreenShot title of forbes*****************");
			}
			}
				else if (driver.getTitle().contains("Forbe"))
				{
					System.out.println("title not match");
				}
				else
				{
					System.out.println("no title present");
				}
			}
			else if (browser.equals("firefox"))
			{
			{
			String pathr = System.getProperty("user.dir")+"//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",pathr);
			driver=new ChromeDriver();
			String pathe= System.getProperty("user.dir")+"//App.Properties";
			fis=new FileInputStream(pathe);
			p1=new Properties();
			p1.load(fis);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(p1.getProperty("url"));
			log.info("*****************Open Firefox Browser Successfully************************");

			if(driver.getTitle().contains("Forbes"))
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
					log.info("*****************take ScreenShot title of forbes*****************");
					
			}
			}
				else if (driver.getTitle().contains("Forbe"))
				{
					System.out.println("title not match");
				}
				else
				{
					System.out.println("no title present");
				}
			}
			
			
			}
}
	   @AfterTest
	   public void  closeBrowser()
	   {
		   driver.close();
		   log.info("*****************Close Browser************************");
	   }
	}

