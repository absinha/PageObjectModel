package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	TasksPage taskpage;
	
	public TasksPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		taskpage = homepage.clickOnTasksLink();
					
	}
		
	@Test
	public void createNewTaskTest() throws Exception{
		homepage.clickOnNewTasks();
		taskpage.createNewTask();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}
	
	

}
