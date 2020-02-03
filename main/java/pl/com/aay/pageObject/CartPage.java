package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class CartPage extends CommonPage {

	private final By alert = By.xpath("//p[@class='alert alert-warning']");

	public CartPage(WebDriver driver){
		super(driver);
	}
	
	public void checkAllertCart (){
		selenium.getWaitForElement().waitForElementToBeVisible(selenium.getWebDriver(), selenium.findBy(alert), TIMEOUT);
		System.out.println("ALERT TEXT: "+selenium.findBy(alert).getText());
	}

}
