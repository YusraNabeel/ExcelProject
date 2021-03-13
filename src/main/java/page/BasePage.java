package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	
	protected int randomGenerator(int boundryNumber) {
		Random rnd =new Random();
		int randomNumber = rnd.nextInt(boundryNumber);
		return randomNumber;
	}
	
	protected void selectDropDown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		 sel.selectByVisibleText(visibleText);
		
	}
}
