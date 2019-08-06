package com.lojack.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lojack.qa.base.TestBase;
import com.lojack.qa.pages.ChangePassword;
import com.lojack.qa.pages.LoginPage;

public class ChangePasswordTestCase extends TestBase {

	public ChangePasswordTestCase() {
		super();
	}
	
	LoginPage lp;
	ChangePassword cp;
	
	@BeforeMethod
	public void setUp() {
		initialize();
		lp=new LoginPage();
		cp=new ChangePassword();
	}
	
	
	@Test
	public void passwordMatchTest() {
		//lp.login(prop.getProperty("user"), prop.getProperty("password"));
		cp.incorrectCurrentPassword();
		
	}
}
