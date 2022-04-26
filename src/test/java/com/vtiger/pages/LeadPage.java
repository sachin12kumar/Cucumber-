package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.vtiger.utilities.CommonFunctions;

public class LeadPage extends HeaderPage {

	public LeadPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button123")
	WebElement btn_save;
	
	public void createLeadWithMandatoryFields(String lname,String comp)
	{
		CommonFunctions.entervalue(driver, tb_lastname, lname);
		CommonFunctions.entervalue(driver, tb_company, comp);
		CommonFunctions.ClickElement(driver, btn_save);
		
	}
}
