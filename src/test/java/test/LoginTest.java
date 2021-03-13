package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlreader = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName= exlreader.getCellData("LoginInfo", "UserName", 2);
	String password= exlreader.getCellData("LoginInfo", "Password", 2);
	
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver= BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
	loginpage.enterUsername(userName);
	loginpage.enterPassword(password);
	loginpage.ClickButton();
	
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	dashboardPage.validateDashboardHeader();
	
	BrowserFactory.tearDown();
	}
}
