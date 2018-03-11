package pages;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="//ul[contains(@class, 'col-11-12 _1PBbw8')]/li[1]")
	WebElement lnkSearchedItemLink;
	
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
		log.info("performin mouse hover");
		Actions action= new Actions(driver);
		action.moveToElement(txtSearch).perform();
		log.info("clicking on link");
		action.moveToElement(lnkSearchedItemLink).click().perform();
		log.info("clicked on search item");
		//log.info("text is placed in seach box and clicking enter");
		//txtSearch.sendKeys(Keys.ENTER);
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
	
	public void windowHandle() {
		log.info("parent window finding");
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows =driver.getWindowHandles();
		log.info("set of windows opend by driver"+allWindows.size());
		for(String window : allWindows) {
			if(!parentWindow.equals(window)) {
				log.info("switching to child window");
				driver.switchTo().window(window);
				if(driver.getTitle().contains("Moto E3 Power")) {
					log.info("switched req window");
					break;
				}
			}
		}
	}
}
