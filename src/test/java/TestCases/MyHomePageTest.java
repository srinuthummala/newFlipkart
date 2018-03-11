package TestCases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;

public class MyHomePageTest extends TestBase {
public static Logger log = Utility.getLogger(MyHomePageTest.class);

	LoginPage loginPage;
	HomePage homePage;
	
	public MyHomePageTest() {
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
		homePage.windowHandle();
	}
	
	@AfterMethod
	public void quit() {
		driver.close();
	}

}
