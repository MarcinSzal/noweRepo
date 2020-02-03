package pl.com.aay.steps;

import static org.junit.Assert.fail;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.annotations.Step;
import pl.com.aay.pageObject.ContactUsPage;
import pl.com.aay.pageObject.MainPage;
import pl.com.aay.pageObject.NewsletterPage;
import pl.com.aay.pageObject.SmallMenuPage;


public class MainSteps extends ScenarioSteps {

	MainPage mainPage;
	SmallMenuPage smallMenuPage;
	ContactUsPage contactUsPage;
	NewsletterPage newsletterPage;

	@Step
	public void openMainPage()
	{
		mainPage.openMainPage();
	}

	@Step
	public void openContact()
	{
		smallMenuPage.openContactUs();
	}

	@Step
	public void enterTopic()
	{
		contactUsPage.sendEmailToContact();
	}

	@Step
	public void enterEmail()
	{
		contactUsPage.sendEmailToContact();
	}

	@Step
	public void enterOrder()
	{
		contactUsPage.enterOrder();
	}

	@Step
	public void enterMessage()
	{
		contactUsPage.enterMessage();
	}

	@Step
	public void sendMessage()
	{
		contactUsPage.sendMessege();
	}

	@Step
	public void checkAlert()
	{
		contactUsPage.checkAlert();
	}

	@Step
	public void bannerClick()
	{
		contactUsPage.clickBanner();
	}

	@Step
	public void enterNewsletter()
	{
		newsletterPage.sendEmailNewsletter();
	}

	@Step
	public void sendNewsletter()
	{
		newsletterPage.sendNewsletter();
	}

	@Step
	public void checkNewsletter()
	{

	}

	@Step
	public void closeWebDriver()
	{
		//
	}
	
}
