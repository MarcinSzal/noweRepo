package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class FooterPage extends CommonPage {

    private final By categories = By.xpath("//h4[text()='Categories']");
    private final By information = By.xpath("//h4[text()='Information']");
    private final By myAccount = By.xpath("//h4[text()='My account']");
    private final By storeInformation = By.xpath("//h4[text()='Store information']");

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void openCategories(){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(categories),TIMEOUT);
        selenium.findBy(categories).click();
    }

    public void openInformation (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(information),TIMEOUT);
        selenium.findBy(information).click();
    }

    public void openAccountLocator (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(myAccount),TIMEOUT);
        selenium.findBy(myAccount).click();
    }

    public void openstoreInformationL(){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(storeInformation),TIMEOUT);
        selenium.findBy(storeInformation).click();
    }
}
