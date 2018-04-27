package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	/*@FindBy(name="title")
	WebElement title;*/
	@FindBy(id = "first_name")
	WebElement first_name;
	@FindBy(id = "surname")
	WebElement surname;
	@FindBy(name = "client_lookup")
	WebElement company;
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement save;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel(){
		return contactslabel.isDisplayed();
	}
	
	public void createNewContact(String titlevalue, String firstname, String lastname, String comp){
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(titlevalue);
		first_name.sendKeys(firstname);
		surname.sendKeys(lastname);
		company.sendKeys(comp);
		save.click();
			
	}
	
	

}
