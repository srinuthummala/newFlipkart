package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Utility;

public class HomePage extends TestBase {
	public static Logger log = Utility.getLogger(HomePage.class);
	
	@FindBy(xpath="//div[@class='noprint']//table//tr//td[4]/a/i")
	WebElement btnLogout;
	
	@FindBy(xpath="//div[@id='navmenu']//li/a[text()='Companies']")
	WebElement ddCompanies;
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
	
	
}