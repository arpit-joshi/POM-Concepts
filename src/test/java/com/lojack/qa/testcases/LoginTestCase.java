package com.lojack.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lojack.qa.base.TestBase;
import com.lojack.qa.pages.Dashboard;
import com.lojack.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginTestCase extends TestBase {
	
	public LoginTestCase() {
		super();
	}
	
	LoginPage lp;
	Dashboard dp;
	
	@BeforeMethod
	public void setUp() {
		initialize();
		lp=new LoginPage();
		//dp = new Dashboard();
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
	String title=lp.validateLoginPageTitle();
	Assert.assertEquals(title, "LoJack"); //compairing actual result with expected
	
	}
	
	@Test (priority=2)
	public void loginPagelogoTest() {
    boolean flag=lp.validateLojackLogo();
	Assert.assertTrue(flag); //if flag is true assertion will pass
	}
	
	
	@Test (priority=3)
	public void blankLoginTest() {
		lp.loginWithoutUserType(prop.getProperty("blankuser"), prop.getProperty("blankpassword"));
		Assert.assertEquals(lp.alertMessage(), "- Please enter user name."  + '\n' + "- Please enter your password." + '\n' + "- Please select user type.");
		System.out.println(lp.alertMessage());
	}
	
	
	@Test (priority=4)
	public void incorrectUserLoginTest() {
		lp.login(prop.getProperty("wronguser"), prop.getProperty("password"));
		Assert.assertEquals(lp.errorMessage(), "Unable to login. Invalid User name or password.");
		//Assert.assertEquals(lp.errorMessage(), "Unable to login. Invalid User name or password.", "Error message do not match");
	}
	
	@Test (priority=5)
	public void incorrectPasswordLoginTest() {
		lp.login(prop.getProperty("user"), prop.getProperty("wrongpassword"));
		Assert.assertEquals(lp.errorMessage(),"Unable to login. Invalid User name or password.");
	}
	
	@Test (priority=6)
	public void blankUserLoginTest() {
		lp.login(prop.getProperty("blankuser"), prop.getProperty("password"));
		Assert.assertEquals(lp.alertMessage(),"- Please enter user name." +'\n');
		System.out.println(lp.alertMessage());
	}

	@Test (priority=7)
	public void blankPasswordLoginTest() {
		lp.login(prop.getProperty("user"), prop.getProperty("blankpassword"));
		System.out.println(lp.alertMessage());
		Assert.assertEquals(lp.alertMessage(),"- Please enter your password." +'\n');
		
	}
	
	@Test (priority=8)
	public void correctcredentialsLoginTest() {
		lp.login(prop.getProperty("user"), prop.getProperty("password"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://mitwebdev.lojack.com/User/Dashboard.aspx");	
	}
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
	
	
}
