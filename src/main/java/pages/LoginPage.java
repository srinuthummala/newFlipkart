package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Utility;

public class LoginPage extends TestBase {
	public static Logger log = Utility.getLogger(LoginPage.class);

	
	@FindBy(xpath="//span[contains(text(), 'Enter Email')]/../parent::div/input")
	WebElement txtUsername;
	
	@FindBy(xpath="//span[contains(text(), 'Enter Password')]/../parent::div/input")
	WebElement txtPassword;
	
	@FindBy(xpath="//span[contains(text(), 'Login')]/parent::button")
	WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	 
	
	public HomePage login(String uname, String pass) {
		
		log.info("**********started login functionality***************");
		log.info("entering username :  "+uname);
		setText(txtUsername, uname);
		log.info("entering password :  "+pass);
		setText(txtPassword, pass);
		click(btnLogin);
		log.info("************* login functionality done *****************");

		return new HomePage();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
