package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactPage;
	String sheetName = "Sheet1";
	
	
	public ContactPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homepage.clickOnContactsLink();
	}
		
	@Test(priority=1)
	public void verifyContactLabelTest(){
		Assert.assertTrue(contactPage.verifyContactLabel());
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		System.out.println(data);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData") //	
	public void createNewContactTest(String Title, String fname, String lname, String company) throws Exception{
		
		homepage.clickOnNewContact();
		//contactPage.createNewContact("Mr.", "abhishek", "sinha", "google");
		contactPage.createNewContact(Title,fname,lname,company);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
