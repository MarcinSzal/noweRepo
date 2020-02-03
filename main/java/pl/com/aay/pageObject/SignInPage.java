package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

import pl.com.aay.seleniumEngine.SeleniumEngine;

public class SignInPage extends CommonPage {

	private final By email = By.id("email_create");
	private final By createAccount = By.id("SubmitCreate");
	
	public SignInPage (WebDriver driver){
		super(driver);
	}
	
	public void createAccount (){
		selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(email), TIMEOUT);
		selenium.findBy(email).sendKeys("test@test.pl");
		selenium.findBy(createAccount).click();
	}

}
