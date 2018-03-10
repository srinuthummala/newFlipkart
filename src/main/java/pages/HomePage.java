package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
		log.info("setting text into search box");
		setText(txtSearch, name);
		log.info("text is placed in seach box and clicking enter");
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public void selectProductFromResults(String productColor) {
		log.info("getiing list of all products");
		List<WebElement> products =driver.findElements(By.xpath("//a[contains(text(),'Moto E3 Power')]"));
		for(WebElement product: products) {
			log.info("looking for product");
			if(product.getAttribute("title").contains(productColor)) {
				product.click();
				log.info("got the product and clicked");
				break;
			}
			
		}
	}
}
