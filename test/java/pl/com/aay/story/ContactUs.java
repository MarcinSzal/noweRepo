package pl.com.aay.story;


import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import pl.com.aay.steps.MainSteps;


public class ContactUs {

	@Managed
	public WebDriver webdriver;

	@Steps
	private MainSteps mainSteps;
	
	@Given("Wchodze na stronę głowna")
	public void openMainPage()
	{
		mainSteps.openMainPage();
	}
	
	
	@When("Klikam przycisk kontakt")
	public void clickContact  ()
	{
		mainSteps.openContact();
	}

	@When("Wybieram temat")
	public void enterTopic ()
	{
		mainSteps.enterEmail();
	}

	@When("Wpisuje adres email")
	public void enterEmail ()
	{
		mainSteps.enterEmail();
	}

	@When("Wpisuje order references")
	public void enterOrderReference ()
	{
		mainSteps.enterOrder();
	}

	@When("Wpisuje wiadomość")
	public void enterMessage ()
	{
		mainSteps.enterEmail();
	}

	@When("Wysylam wiadomość")
	public void sendMessege ()
	{
		mainSteps.sendMessage();
	}

	@When("Sprawdzam komunikat")
	public void checkAllert ()
	{
		mainSteps.checkAlert();
	}

	@When("Klikam w baner my store")
	public void clickOnBanner ()
	{
		mainSteps.bannerClick();
	}

	@When("Wpisuje adres email w newsletter")
	public void enterNewsletterMail ()
	{
		mainSteps.enterNewsletter();
	}

	@When("Klikam wyślij newsletter")
	public void sendNewsletter()
	{
		mainSteps.sendNewsletter();
	}
	
	
	@Then("Sprawdzam komunikat newsletter")
	public void checkNewsletterAlert ()
	{
		mainSteps.checkNewsletter();
	}
}
