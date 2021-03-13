package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

@FindBy(how = How.XPATH , using = "//input[@id='account']")
WebElement FullName;
@FindBy(how = How.XPATH , using = "//select[@id='cid']")
WebElement Company;
@FindBy(how = How.XPATH , using = "//input[@id='email']")
WebElement EmailAddress;
@FindBy(how = How.XPATH , using = "//input[@id='phone']")
WebElement PhoneNumber;
@FindBy(how = How.XPATH , using = "//input[@id='address']")
WebElement Address;
@FindBy(how = How.XPATH , using = "//input[@id='city']")
WebElement City ;
@FindBy(how = How.XPATH , using = "//input[@id='state']")
WebElement State ;
@FindBy(how = How.XPATH , using = "//input[@id='zip']")
WebElement Zipcode ;
@FindBy(how = How.XPATH , using = "//select[@id='country']") 
WebElement Country ;
@FindBy(how = How.XPATH , using = "//button[@id='submit']") 
WebElement Save ;
@FindBy(how = How.XPATH, using = "//a[@id='activity']") 
WebElement Customer_Activity;


@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]")
WebElement List_Customer;

@FindBy(how = How.XPATH, using = "//body/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")
WebElement Addcustomer_button_onList_CustomerPage;


@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
WebElement DeleteConfirmationButton;

String enterFullName;
public void insetFullname(String userName) throws InterruptedException {
	 int genNum = randomGenerator(999);
	 Thread.sleep(2000);
	 enterFullName = userName + genNum;
	 FullName.sendKeys(enterFullName);
	 
 }

 public void insertCompanyName(String companyName) {
	 selectDropDown(Company, companyName);
 }

 public void insertEmail(String email) throws InterruptedException {
	 int genNum = randomGenerator(999);
	 Thread.sleep(2000);
	  EmailAddress.sendKeys(genNum + email );
 }
 
 public void enterPhoneNumber(String number) throws InterruptedException {
	 int genNum = randomGenerator(999);
	 Thread.sleep(2000);
	 PhoneNumber.sendKeys(genNum + number);
 }
 public void enterAddress(String add) throws InterruptedException {
	 int genNum = randomGenerator(999);
	 Thread.sleep(2000);
	 Address.sendKeys(genNum + add);
 }
 public void entercity(String cityName) {
	 int genNum = randomGenerator(999);
	 City.sendKeys(genNum + cityName);
 }
 public void enterState(String stateName) {
	 int genNum = randomGenerator(999);
	 State.sendKeys(genNum + stateName);
 }
 public void enterZipcode(String zipcodeNum) {
	 int genNum = randomGenerator(999);
	 Zipcode.sendKeys(genNum + zipcodeNum);
 }
 public void insertCountryName(String countryName) {
	 selectDropDown(Country, countryName);
 }

public void clickSaveButton() {
	Save.click();
}
 
public void Listcustomers() throws InterruptedException {
	Thread.sleep(3000);
	List_Customer.click();
}
public void verifyEnteredNameandDelete() {
	  
	  //only row 1,2,3,4 down in dynamic path is changing so we will concatinate the 
	  //path and make a loop by for loop and call it 'i'.
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[  +  i  +  ]/td[3]    concatinating here
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
		
String before = "//tbody/tr["; String after = "]/td[3]";

for (int i = 1; i <= 10; i++) { 
	  String name = driver.findElement(By.xpath(before + i + after)).getText(); // }
//these down 2 lines are create to deal with dynamic table
//	  System.out.println(name);
//Assert.assertEquals(name, enterFullName , "does not exist");
if (name.contains(enterFullName)) {
driver.findElement(By.xpath("//tbody/tr[" + i +
		  "]/td[3]/following-sibling::td[4]/a[2]")).click();

} 
}}


public void DeleteCustomerConfarmationButton() throws InterruptedException { 
	  Thread.sleep(2000);
	  DeleteConfirmationButton.click(); }

}


