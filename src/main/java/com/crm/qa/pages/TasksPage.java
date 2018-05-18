package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="completion")
	WebElement completion;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement save;
	
	
	public TasksPage(){
		PageFactory.initElements(driver, this);
	}
		
	public void createNewTask(){
		title.sendKeys("Mr.");
		completion.sendKeys("30");
		save.click();
		
		
		
	}
	

}
