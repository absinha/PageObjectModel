package com.crm.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealpage;
	String sheetName = "DealsTestData";
	
	
	public DealsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		dealpage = homepage.clickOnDealsLink();
				
	}
	
	@Test(priority=1,enabled=true)
	public void verifyDealsLabelTest(){
		homepage.verifyDealsLinkLabel();
	}
		
	@DataProvider
	public Object[][] getCRMDealData(){
		Object data[][] = testutil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMDealData")
	public void createNewDealTest(String titname, String cname, String pcontact, String amut) throws Exception{
		homepage.clickOnNewDeals();
		Thread.sleep(2000);
		dealpage.createNewDeal(titname,cname,pcontact,amut);		
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
	
	
	
	

}
