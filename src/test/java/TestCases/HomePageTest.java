package TestCases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;

public class HomePageTest extends TestBase {
public static Logger log = Utility.getLogger(LoginPageTest.class);

	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		 super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage= new LoginPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("userid"),prop.getProperty("password"));	
	}
	
	@Test
	public void verifyProductSearch() {
		homePage.searchForProduct("moto e3");
		homePage.selectProductFromResults("White");
	}
	

}
