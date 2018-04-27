package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//@FindBy()
	
	@FindBy(xpath = "//td[contains(text(),'User: Abhishek Sinha')]")
	WebElement userNameLabel; 
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newCreateDeal;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLinks;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContacts;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
		
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public boolean verifyUserNameLabel(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
		
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		contactsLink.click();
		//Thread.sleep(2000);
		newContacts.click();
		//
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(newContacts));
		
		
	}
	public boolean verifyDealsLinkLabel(){
		return dealsLink.isDisplayed();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewDeals(){
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dealsLink.click();
		newCreateDeal.click();
		
	}
	public TasksPage clickOnTasksLink(){
		taskLinks.click();
		return new TasksPage();
	}

}
