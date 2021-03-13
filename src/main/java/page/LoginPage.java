package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	

		//element library
		WebDriver driver;
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		//WebElement Username_Element = driver.findElement(By.xpath("//input[@id='username']"));
		//By Username_Field = By.xpath("//input[@id='username']");
		@FindBy(how = How.XPATH, using ="//input[@id='username']")
		WebElement Username;
		@FindBy(how = How.XPATH, using ="//input[@id='password']") 
		WebElement Password;
		@FindBy(how= How.XPATH, using ="//button[@class='btn btn-success block full-width']")
		WebElement Login;
		
		public void enterUsername(String username) {
			Username.sendKeys(username);
		}
		
		public void enterPassword(String password) {
			Password.sendKeys(password);
		}
		
		public void ClickButton() {
			Login.click();
			
		}
	}

