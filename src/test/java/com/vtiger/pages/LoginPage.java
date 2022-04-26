package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.CommonFunctions;

public class LoginPage {
	
	// Page object Model   >> design pattern
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	WebElement tb_username;
	
	@FindBy(name="user_password")
	WebElement tb_password;
	
	@FindBy(name="Login")
	WebElement btn_Login;
	
	public void login(String userid, String pwd)
	{		
		CommonFunctions.entervalue(driver,tb_username, userid);
		CommonFunctions.entervalue(driver,tb_password, pwd);
		CommonFunctions.ClickElement(driver,btn_Login);
	}
	
	public void enterusername(String userid) {
		CommonFunctions.entervalue(driver,tb_username, userid);
	}
	
	public void enterpassword(String pwd) {
		CommonFunctions.entervalue(driver,tb_password, pwd);
	}
	
	public void clickloginbutton() {
		CommonFunctions.ClickElement(driver,btn_Login);
	}
	
	public boolean username_display() {
		return tb_username.isDisplayed();
	}

}
