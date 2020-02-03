package pl.com.aay.seleniumEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumEngine {

	protected WebDriver driver;
	protected Actions actions;
	protected WaitForElement wait;
	
	public SeleniumEngine (WebDriver driver){
		this.driver=driver;
		actions = new Actions(driver);
		wait = new WaitForElement ();
	}

	// Metody ustawiające zmienne prywatne
	public WebDriver getWebDriver (){
		return driver;
	}

	public WaitForElement getWaitForElement (){
		return wait;
	}

	public Actions getAction (){
		return actions;
	}

	public WebElement findBy (By by){
		return driver.findElement(by);
	}

	public List<WebElement> findBys(By by){
		return driver.findElements(by);
	}

	// metody drivera
	public void driverQuit (){
		driver.quit();
	}
	
	public void openWebSite (String url){
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public String getUrl (){
		return driver.getCurrentUrl();
	}
	
	public void refresh (){
		driver.navigate().refresh(); 
	}
	
	public void back (){
		driver.navigate().back(); 
	}
	
	public void forward (){
		driver.navigate().forward();
	}

	// operacje na obiekcie select
	public void selectByText (WebElement element, String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement element, Integer index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// metody klasy Action
	public void contentClick (WebElement element){
		actions.contextClick(element).perform();
	}
	
	public void doubleClick (WebElement element){
		actions.doubleClick(element).perform();
	}
	
	public void clickAndHold (WebElement element){
		actions.clickAndHold(element).perform();
	}
	
	public void moveTo (WebElement element){
		actions.moveToElement(element).perform();
	}
	
	public void dragAndDrop (WebElement elementSource, WebElement elementTarget){
		actions.dragAndDrop(elementSource, elementTarget).build().perform();
	}
	
	public void dragAndDrop (WebElement element){
		actions.dragAndDropBy(element, 30, 0).build().perform();
	}
	
	public void dragAndDrop (WebElement element, int x, int y){
		actions.dragAndDropBy(element, x, y).build().perform();
	}
	
}
