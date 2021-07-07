 package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'User: hamza cherfaoui')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactsLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public ContactPage clickOnContactsLink() {
		 contactsLink.click();
		 return new ContactPage();
	}
	public DealsPage clinkOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
		
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(newContactsLink).build().perform();
		newContactsLink.click();
		
	}
	
	

}
