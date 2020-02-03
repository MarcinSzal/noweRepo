package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class FacebookPage extends CommonPage {

    private final By facebook = By.xpath("//h4[text()='Follow us on Facebook']");
    private final By comeVisit = By.xpath("//h3[text()='Come Visit Us']");
    private final By callUs = By.xpath("//h3[text()='Call Us']");

    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    public void clickFacebook (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(facebook),TIMEOUT);
        selenium.findBy(facebook).click();
    }

    public void clickComeVisit (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(comeVisit),TIMEOUT);
        selenium.findBy(comeVisit).click();
    }

    public void clickCallUsLocator(){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(callUs),10);
        selenium.findBy(callUs).click();
    }
}
