package pl.com.aay.pageObject;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.com.aay.seleniumEngine.SeleniumEngine;

public class ContactUsPage extends CommonPage {

	private final By subject = By.id("id_contact");
	private final By email = By.id("email");
	private final By messeges = By.id("message");
	private final By order = By.id("id_order");
	private final By send = By.xpath("//button[@type='submit']");
	private final By alert = By.xpath("//p[@class='alert alert-success']");
	private final By banner = By.xpath("//img[@alt='My Store']");

    public ContactUsPage (WebDriver driver){
    	super(driver);
	}

	public void enterTopic (){
		selenium.getWaitForElement().waitForElementToBeClickable(selenium.getWebDriver(), selenium.findBy(subject), TIMEOUT);
		selenium.selectByValue(selenium.findBy(subject), "1");
	}
    
    public void sendEmailToContact (){
		selenium.findBy(email).sendKeys("test@test.pl");
    }

	public void enterOrder (){
		selenium.findBy(order).sendKeys("Order");
	}

    public void enterMessage (){
		selenium.findBy(messeges).sendKeys("Prosze o kontakt");
	}

	public void sendMessege () {
		selenium.findBy(send).click();
	}

	public void checkAlert (){
		selenium.getWaitForElement().waitForElementToBeVisible(selenium.getWebDriver(), selenium.findBy(alert), TIMEOUT);
    	System.out.println(selenium.findBy(alert).getText());
	}

	public void clickBanner (){
		selenium.getWaitForElement().waitForElementToBeVisible(selenium.getWebDriver(), selenium.findBy(banner), TIMEOUT);
		System.out.println(selenium.findBy(banner).getText());
	}
    
}
