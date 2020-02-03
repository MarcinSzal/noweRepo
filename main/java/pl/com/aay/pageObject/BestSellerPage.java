package pl.com.aay.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;


public class BestSellerPage extends pl.com.aay.pageObject.CommonPage {

    private final By bestSeller = By.xpath("//a[text()='Best Sellers']");
    private final By addToCart = By.xpath("//span[text()='Add to cart']");

    public BestSellerPage(WebDriver driver) {
        super(driver);
    }

    public void openBestSeller (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(bestSeller),TIMEOUT);
        selenium.findBy(bestSeller).click();
    }

    public void addToCart (){
        selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(addToCart),TIMEOUT);
        selenium.findBy(addToCart).click();
    }

}
