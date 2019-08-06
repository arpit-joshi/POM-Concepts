package com.lojack.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lojack.qa.base.TestBase;
import com.lojack.qa.pages.Dashboard;
import com.lojack.qa.pages.LoginPage;
import com.lojack.qa.util.LoginData;

public class DataDrivenLoginTestCase extends TestBase {

	public DataDrivenLoginTestCase()  {
		super();
	}
	
	LoginPage lp;
	Dashboard dp;
	String sheetname="credentials";
	@BeforeMethod
	
	public void setUp() {
		initialize();
		lp=new LoginPage();
		//dp = new Dashboard();
	}
	
	@DataProvider
	public Object [][] getTestData() {
	Object data[][]=LoginData.getTestData(sheetname);
	return data;
	}
	
	@Test (priority=1, dataProvider="getTestData")
	public void validateCredentials (String userName, String password) {
		lp.login(userName, password);
	}
}
