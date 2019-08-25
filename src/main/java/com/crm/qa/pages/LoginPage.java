package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

public LoginPage() throws IOException {
		PageFactory.initElements(driver, LoginPage.class);
		// TODO Auto-generated constructor stub
	}
@FindBy(name="username")
WebElement username;
@FindBy(name="password")
WebElement password;
@FindBy(xpath="//input[@type='submit']")
WebElement loginbtn;
@FindBy(xpath="//a[text()='Sign Up']")
WebElement signupbtn;
@FindBy(xpath="//img[@class='img-responsive']")
WebElement crmlogo;

public String validateLoginTitle() {
	return driver.getTitle();
}
public boolean verifyCrmLogo() {
	return crmlogo.isDisplayed();
}
public SignUpPage verifySignUpButton() {
	signupbtn.click();
return new SignUpPage();
}
public HomePage verifyLogIn(String un,String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.submit();
	return new HomePage();
}




}
