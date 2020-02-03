package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class SmallMenuPage extends CommonPage {

    private final By banner = By.xpath("//img[@class='img-responsive']");
    private final By contactUs = By.xpath("//a[text()='Contact us']");
    private final By signIn = By.xpath("//a[contains(text(),'Sign in')]");

    public SmallMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickBunner (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(banner), TIMEOUT);
        selenium.findBy(banner).click ();
    }

    public void openContactUs (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(contactUs), TIMEOUT);
        selenium.findBy(contactUs).click();
    }

    public void openSignIn (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(signIn), TIMEOUT);
        selenium.findBy(signIn).click();
    }
}
