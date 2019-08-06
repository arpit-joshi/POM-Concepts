/*
 * 
 * @author arpit joshi
 *
 */
package com.lojack.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lojack.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory  object repository
	
	@FindBy(name="txtUserId")
	@CacheLookup           // adding element into cache memory
	WebElement username; // variables
	
	@FindBy(name="txtPassword")
	@CacheLookup          // adding element into cache memory
	WebElement password;// variables

	@FindBy(name="ddlUserType")
	@CacheLookup		// adding element into cache memory
	WebElement select;// variables
	
	@FindBy(name="btnLogin")
	@CacheLookup		// adding element into cache memory
	WebElement loginButton;// variables
	
	@FindBy(xpath="//a[@class='login_logo']")
	@CacheLookup		// adding element into cache memory
	WebElement imglogo;// variables
	
	@FindBy(id="divError")
	@CacheLookup			// adding element into cache memory
	WebElement errorLabel;// variables
	
	public LoginPage()
{
PageFactory.initElements(driver, this); //initializing all the above elements in driver, this=elements of this class		
}
	//String errorMessage=errorLabel.getText();
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLojackLogo() {
		return imglogo.isDisplayed();            // to verify if logo is displayed or not
	}
	
	public String errorMessage() {
		String errorMessage=errorLabel.getText();
		return errorMessage;
	}
	
	public String alertMessage() {
		Alert alert=driver.switchTo().alert();
		String alertMessage=alert.getText();
		//alert.accept();
		return alertMessage;
		
	}
	
	public Dashboard login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Select userType=new Select(select);
		//select.click();
		userType.selectByVisibleText("Other");
		
		loginButton.click();
		
		return new Dashboard();
	}
		
	

	public void loginWithoutUserType(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//Select userType=new Select(select);
		//select.click();
		//userType.selectByVisibleText("--Select--");
		
		loginButton.click();
		
		//return new Dashboard();
		
	}
		
		
	
	}
 