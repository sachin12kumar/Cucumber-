package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.utilities.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {
	public static WebDriver driver;
	public static Properties prop;
	public static Map<String,List<String>> data;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	
	
	public void launchApp() throws Exception
	{
		//createReport();
		readproperties();
		//data=readdata();
		if(prop.getProperty("browser").equals("chrome"))
        {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
        }
		else if(prop.getProperty("browser").equals("firefox"))
        {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
        }
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("GLobalTimeOut"))));
	}
	
	
	public void closeApp()
	{
		driver.quit();
	}
	
	public void readproperties() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/globalconfig.properties");
		prop.load(fis);
		
	}
	
	public Map<String,List<String>> readdata()
	{
		Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx");
		int rowcount = xr.getRowCount("Sheet1");
		int colmcount = xr.getColumnCount("Sheet1");
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=2;i<=rowcount;i++)
		{
			String tcname = xr.getCellData("Sheet1", "TCName", i).trim();
			List<String> lst = new ArrayList<String>();
			for(int j=1;j<=colmcount;j++)
			{
				String d = xr.getCellData("Sheet1", j, i).trim();
				lst.add(d);
			}
			map.put(tcname, lst);
		}
		
		return map;
	}
	
	public void createReport() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
	}

}

