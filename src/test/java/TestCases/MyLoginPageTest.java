package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;



public class MyLoginPageTest extends TestBase {
	public static Logger log = Utility.getLogger(MyLoginPageTest.class);

	
	LoginPage loginPage;
	HomePage homePage;
	
	public MyLoginPageTest() {
		 super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage= new LoginPage();
		homePage = new HomePage();
		
	}
	
	@Test
	public void verifyLogin() {
		log.info("======started verify login test method==========");
		loginPage.login(prop.getProperty("userid"),prop.getProperty("password"));
		Assert.assertTrue(homePage.isUserLoggedIn());
		log.info("user successfully logged in");
		log.info("=======verify login test method completed==========");

	}
	
	@AfterMethod
	public void quit() {
		driver.close();
	}

}
