package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]")
	WebElement DashboardHeader;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a")
	WebElement CustomerField;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement AddCustomerField;

	/*
	 * public void validateDashboardHeader() {
	 * 
	 * 
	 * waitForElement(driver, 3, DashboardHeader );
	 * //Assert.assertEquals("Dashboard page not found", "Dashboard",
	 * DashboardHeader.getText()); Assert.assertEquals(DashboardHeader.getText(),
	 * "Dashboard", "Dashboard page not found"); }
	 */

	private void waitForElement(WebDriver driver2, int i, WebElement dashboardHeader2) {
		// TODO Auto-generated method stub
		Assert.assertEquals(DashboardHeader.getText(), "Dashboard", "Dashboard page not found");

	}

	public void clickOnCustomerButton() {
		CustomerField.click();
	}

	public void clickOnAddCustomerButton() {

		waitForElement(driver, 3, AddCustomerField);
		AddCustomerField.click();
	}

	public void validateDashboardHeader() {
		// TODO Auto-generated method stub
		
	}
}
