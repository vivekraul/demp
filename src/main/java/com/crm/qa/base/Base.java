package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.util;

public class Base {
public static WebDriver driver;
public static Properties prop;

public Base() throws IOException {
	prop=new Properties();

	FileInputStream fi = new FileInputStream("Y:\\seleniumpractice\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	
	prop.load(fi);
}
public static void initialize() {
	String browser=prop.getProperty("browsername");
	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "Y://tools//chromedriver.exe");
		driver=new ChromeDriver();
	}else if(browser.equals("ff")) {
		System.setProperty("webdriver.gecko.driver", "Y://tools//geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(util.page_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(util.imp_timeout, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
}
