package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(id="title")
	WebElement title;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(name="contact_lookup")
	WebElement primaryContact;
	@FindBy(name="amount")
	WebElement amount;
	@FindBy(xpath="//input[@type='submit']")
	WebElement save;
	
	
	
	
	// Initializing the Page Factory
	public DealsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Method to verify the Deals Label
	public boolean verifyDealsLabel(){
		return dealsLink.isDisplayed();
	}
	
	public void createNewDeal(String titlename, String comp, String pricontact, String amt){
		title.sendKeys(titlename);
		company.sendKeys(comp);
		primaryContact.sendKeys(pricontact);
		amount.sendKeys(amt);
		save.click();
			
	}
	
	
	

}
