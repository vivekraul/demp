package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class LogInTest extends Base {
	LoginPage loginpage;
	SignUpPage signuppage;
HomePage homepage;
	public LogInTest() throws IOException {
	super();
}
@BeforeMethod
public void setup() throws IOException {
	initialize();
	loginpage=new LoginPage();
}
@Test
public void loginPageTitleTest() {
	String title=loginpage.validateLoginTitle();
	String realtitle="CRMPRO  - CRM software for customer relationship management, sales, and support.";
	Assert.assertEquals(title, realtitle,"title not matched");
}
@Test
public void crmLogoTest() {
	boolean flag=loginpage.verifyCrmLogo();
	Assert.assertTrue(flag);
}
@Test
public void signUpLinkTest() {
	signuppage=loginpage.verifySignUpButton();
}
@Test
public void loginTest() {
	homepage=loginpage.verifyLogIn(prop.getProperty("username"), prop.getProperty("password"));
}





@AfterMethod
public void tearDown() {
	driver.quit();
}
}
