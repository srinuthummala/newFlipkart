package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Utility;

public class HomePage extends TestBase {
	public static Logger log = Utility.getLogger(HomePage.class);
	
	@FindBy(xpath="//span[contains(text(),'Srinu')]")
	WebElement lnkUser;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement txtSearch;
	
	@FindBy(xpath="//a[@title='Companies']/following-sibling::ul/li/a[@title='New Company']")
	WebElement optoinNewCompany;
	@FindBy(xpath="//a[@title='Companies']/following-sibling::ul/li/a[@title='Combined Form']")
	WebElement optoinCombinedForm;
	@FindBy(xpath="//a[@title='Companies']/following-sibling::ul/li/a[@title='Full Search Form']")
	WebElement optoinFullSearchForm;
	
	
	@FindBy(xpath="//div[@id='navmenu']//li/a[text()='Contacts']")
	WebElement ddContacts;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement ddDeals;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement lnkNewDeal;
	
	@FindBy(xpath="//a[@title='Products']")
	WebElement lnkProducts;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUserLoggedIn() {
		return lnkUser.isDisplayed();
	}
	
	public void searchForProduct(String name) {
		setText(txtSearch, name);
		txtSearch.sendKeys(Keys.ENTER);
	}
}
