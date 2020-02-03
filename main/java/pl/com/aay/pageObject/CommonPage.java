package pl.com.aay.pageObject;

import net.thucydides.core.pages.Pages;
import org.openqa.selenium.WebDriver;
import pl.com.aay.seleniumEngine.SeleniumEngine;
import net.serenitybdd.core.*;
import net.serenitybdd.jbehave.annotations.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CommonPage extends PageObject {

    protected final static int TIMEOUT = 10;

    SeleniumEngine selenium = new SeleniumEngine (getDriver());

    public CommonPage (WebDriver driver){
        super(driver);
    }
}
