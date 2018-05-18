package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement crmLogo;
	
	// Initializing the Page Objects
	public LoginPage(){							//  loginpage construcotr
		PageFactory.initElements(driver, this);	//  Page Factory is initialized using page PageFactory.initElements and this means pointing to current class object
	}
	
	// Actions
	public String validateLoginPageTitle(){
		String title =driver.getTitle();
		return title;
	}
	public boolean validatedLoginPageCRMLogo(){
		boolean logo = crmLogo.isDisplayed();
		return logo;
	}
	public HomePage login(String usrname, String pwd){
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginBtn.click();
		return new HomePage();
	}

}
