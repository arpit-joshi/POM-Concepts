package com.lojack.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lojack.qa.base.TestBase;

public class ChangePassword extends TestBase {

	
	LoginPage lp= new LoginPage();
	
	@FindBy(name="ctl00$OperationsContent$id1$txtCurrentPassword")
	WebElement currentPassword;
	
	@FindBy(name="ctl00$OperationsContent$id1$txtNewPassword")
	WebElement newPassword;
	
	@FindBy(name="ctl00$OperationsContent$id1$txtConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="ctl00$OperationsContent$id1$btnSave")
	WebElement submit;
	
	public ChangePassword()
	{
	PageFactory.initElements(driver, this); //initializing all the above elements in driver		
	}
	

	
	public void incorrectCurrentPassword(){
		lp.login(prop.getProperty("user"), prop.getProperty("password"));
		if (driver.getCurrentUrl().equalsIgnoreCase("https://mitwebdev.lojack.com/User/ChangePassword.aspx")) {
		
		currentPassword.sendKeys("lojack123");
		newPassword.sendKeys("diaspark");
		confirmPassword.sendKeys("dispark");
		submit.click();
	}
		
	}
}


