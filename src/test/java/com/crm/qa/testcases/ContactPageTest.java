package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	String sheetName="contacts";
	
	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	
	}
	@Test(priority=1)
	public void verifyContactPageLabel() {
		Assert.assertTrue(contactPage.VerifyContactLabel());
	}
	@Test(priority=2)
	public void selectContactTest() {
		contactPage.selectContactByName("test2 test2");
		
	}
	@Test(priority=3)
	public void selectMultipleContactTest() {
		contactPage.selectContactByName("test2 test2");
		contactPage.selectContactByName("ui uiii");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	//@Test(priority=4,)
	//
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName, String company) {
		homePage.clickOnNewContactLink();
	//	contactPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		//contactPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		
	
		contactPage.createNewContact(title, firstName, lastName, company);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
