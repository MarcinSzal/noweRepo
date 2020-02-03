package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class PopularPage extends CommonPage {

    private final By popular = By.xpath("//a[text()='Popular']");
    private final By addToCart = By.xpath("//button[@name='submitNewsletter']");

    public PopularPage(WebDriver driver) {
        super(driver);
    }

    public void openPopular(){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(popular), TIMEOUT);
        selenium.findBy(popular).click();
    }

    public void addToCart (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(addToCart), TIMEOUT);
        selenium.findBy(addToCart).click();
    }
}
