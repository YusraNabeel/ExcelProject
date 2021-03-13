package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlreader = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName= exlreader.getCellData("LoginInfo", "UserName", 2);
	String password= exlreader.getCellData("LoginInfo", "Password", 2);
	String fullName = exlreader.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlreader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlreader.getCellData("AddContactInfo", "Email", 2);
	String phone = exlreader.getCellData("AddContactInfo", "Phone", 2);
	String address = exlreader.getCellData("AddContactInfo", "Address", 2);
	String city = exlreader.getCellData("AddContactInfo", "City", 2);
	String country = exlreader.getCellData("AddContactInfo", "Country", 2);
	String state = exlreader.getCellData("AddContactInfo", "State", 2);
	String zip = exlreader.getCellData("AddContactInfo", "Zip", 2);
	
	
	@Test
	public void validUserShouldBeAbleToCreateCustomer() throws InterruptedException {
		
		driver= BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver,LoginPage.class);
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.ClickButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardHeader();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();
	
		
	AddCustomerPage addCustomerPage = PageFactory.initElements(driver,AddCustomerPage.class);
	
	addCustomerPage.insetFullname(fullName);
	
	addCustomerPage.insertCompanyName(companyName);
	addCustomerPage.insertEmail(email);
	addCustomerPage.enterPhoneNumber(phone);
	addCustomerPage.enterAddress(address);
	addCustomerPage.entercity(city);
	addCustomerPage.enterState(state);
	addCustomerPage.enterZipcode(zip);
	addCustomerPage.insertCountryName(country);
	addCustomerPage.clickSaveButton();
	addCustomerPage.Listcustomers();
	addCustomerPage.verifyEnteredNameandDelete();
	addCustomerPage.DeleteCustomerConfarmationButton();
	
	}
}
