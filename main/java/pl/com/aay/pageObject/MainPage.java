package pl.com.aay.pageObject;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

//@At("http://automationpractice.com\\..*")
public class MainPage extends CommonPage {

    private final By searchInput = By.id("search_query_top");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By cart = By.xpath("//b[text()='Cart']");

    public  MainPage(WebDriver driver){
        super(driver);
    }

    public void openMainPage (){
        selenium.openWebSite("http://automationpractice.com");
    }

    public void searchObject (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(searchInput), TIMEOUT);
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(searchButton), TIMEOUT);
        selenium.findBy(searchInput).sendKeys("TEST");
        selenium.findBy(searchButton).click();
    }

    public void goToCart (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(cart), TIMEOUT);
        selenium.findBy(cart).click();
    }

}
