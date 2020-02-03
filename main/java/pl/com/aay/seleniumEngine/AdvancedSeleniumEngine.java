package pl.com.aay.seleniumEngine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pl.com.aay.testData.model.Login;
import pl.com.aay.testData.model.Registration;

public class AdvancedSeleniumEngine extends SeleniumEngine {

	public AdvancedSeleniumEngine (WebDriver driver){
		super(driver);
	}

	public void checkBox (WebElement checkBox, String  element){
		WebElement checkBoxElement = checkBox.findElement(By.xpath("(//input[@type='checkbox'])["+element+"]"));
		checkBoxElement.click();
	}
	
	public void closeModalWindow (WebElement window) throws InterruptedException{
		wait.waitForElementToBeVisible(driver, window, 5);
		WebElement closeButton = window.findElement(By.xpath("//p[text()='Close']"));
		closeButton.click();
	}
	
	public void scrollPage (){
		JsExecutor js = new JsExecutor (getWebDriver());
		js.scrollPageJs("300");

	}
	
	public void toIFrame (WebElement frame){
		try {
			driver.switchTo().frame(frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + frame + e.getStackTrace());
		}
		driver.switchTo().defaultContent();
	}
	
	public void alertAccept (WebElement alertButton){
		alertButton.click();
		Alert alert = wait.waitForAlert(driver, 5);
		alert.accept();
	}
	
	public void alertConfirm (WebElement alertButton){
		alertButton.click();
		Alert alert = wait.waitForAlert(driver, 5);
		alert.dismiss();
	}
	
	public void alertPrompt (WebElement alertButton){
		alertButton.click();
		Alert alert = wait.waitForAlert(driver, 5);
		alert.sendKeys("TEST");
		alert.accept();
	}
	
	public void newBrowserTab (WebElement newTab ){
		newTab.click();
		String Tab1 = driver.getWindowHandle();
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		if (!availableWindows.isEmpty()) { 
			driver.switchTo().window(availableWindows.get(0));
			driver.switchTo().window(availableWindows.get(1));
		}
	}
	
	public void keyCtrlAction (WebElement key){
		actions.keyDown(key,Keys.LEFT_CONTROL).build().perform();
		actions.keyDown(key,Keys.LEFT_CONTROL).build().perform();
	}

	public void tooltip (WebElement tooltip){
		wait.waitForElementToBeClickable(driver, tooltip, 3);
		System.out.println("title" + tooltip.getAttribute("title"));
		tooltip.click();
		System.out.println("title" + tooltip.getAttribute("title"));
	}
	
	public void slider (WebElement slider){
		dragAndDrop(slider);
	}

	public void notificationMessages (WebElement messagesButton, WebElement messages){
		messagesButton.click();
		wait.waitForElementToBeVisible(getWebDriver(), messages, 3);
		System.out.println("Notification text: "+messages.getText());
	}
	
	public void uploadFile (WebElement upload, WebElement uploadButton){
		String path= "C:\\Users\\mariusz\\Desktop\\TestTest.java";
		upload.sendKeys(path);
		uploadButton.click();
	}
	
	public void downloadFile (WebElement download){
		download.click();
		actions.keyDown(Keys.ENTER).build().perform();
	}
	
	public void resizable (WebElement resizableElement){
		dragAndDrop(resizableElement, 100, 0);
	}
	
}
