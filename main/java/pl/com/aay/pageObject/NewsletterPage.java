package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class NewsletterPage extends CommonPage {

    private final By emailInput = By.id("newsletter-input");
    private final By emailButton = By.xpath("//button[@name='submitNewsletter']");
    private final By alert = By.xpath("//p[@class='alert alert-success']");

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    public void sendEmailNewsletter(){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(emailInput), TIMEOUT);
        selenium.findBy(emailInput).sendKeys("test@test.pl");
    }

    public void sendNewsletter (){
        selenium.findBy(emailButton).click();
    }

    public void checkNewletterPage (){
        System.out.println(selenium.findBy(alert).getText());
    }
}
