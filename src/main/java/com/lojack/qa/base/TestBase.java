package com.lojack.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.lojack.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		
		try {
			prop=new Properties();
			FileInputStream io = new FileInputStream
					("C:\\Users\\arpit1.joshi\\eclipse-workspace\\POMConcepts\\src\\main\\java\\com\\lojack\\qa\\config\\config.properties");
		   prop.load(io);
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initialize() {
		String browsername=prop.getProperty("browser");
		String url=prop.getProperty("url"); //copy url
		//System.setProperty("webdriver.chrome.driver",prop.getProperty(chromeDriver));
		System.setProperty("webdriver.chrome.driver","D:\\Selenium JARS\\New folder\\chromedriver.exe");
	    driver=new ChromeDriver();
	    //weblistener
	    e_driver=new EventFiringWebDriver(driver);
	    eventListener=new WebEventListener(); //eventListener is object of class WebEventListener
	    e_driver.register(eventListener); //registering eventListener object with event firing webdriver object
	    driver=e_driver; //assigning e_driver to main driver
	    
	    
	    driver.manage().window().maximize(); //to maximize window
		driver.manage().deleteAllCookies(); //to delete cookies and caches
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(url); //load url
	}
	
}
