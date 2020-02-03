package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class MenuPage extends CommonPage {

    private final By women = By.xpath("//a[text()='Women']");
    private final By dresses = By.xpath("//a[text()='Dresses']");
    private final By tshirt = By.xpath("//a[text()='T-shirts']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void openAllMenu () {
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(women), TIMEOUT);
        selenium.findBy(women).click();
    }
}
