package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.CommonFunctions;

public class HeaderPage {
	WebDriver driver;
	 
	public HeaderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	public void clickLogout()
	{
		CommonFunctions.ClickElement(driver,lnk_logout);
	}
	public void clickNewLead()
	{
		CommonFunctions.ClickElement(driver,lnk_NewLead);
	}

}
