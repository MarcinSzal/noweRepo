package pl.com.aay.seleniumEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
	
    private static final int DEFAULT_TIMEOUT = 30;

    public  void waitForBrowserReady(WebDriver driver, Integer timeout) {
        if(timeout==null){
            timeout = DEFAULT_TIMEOUT;
        }
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        driverWait.until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    public boolean waitForElementToBeClickable(WebDriver driver, WebElement element, int timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean waitForElementToBeVisible(WebDriver driver, WebElement element, int timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean waitForElementToBeVisibleAndClickable(WebDriver driver, WebElement element, int timeInSeconds) {
    	boolean wait=false;
    	wait=waitForElementToBeVisible( driver,  element,  timeInSeconds);
    	wait=waitForElementToBeClickable ( driver,  element,  timeInSeconds);
    	return wait;
    }
    
    public boolean waitForElementToBeVisibleAndClick(WebDriver driver, WebElement element, int timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void waitForElementsSizeEquals(WebDriver driver,
                                                ArrayList<WebElement> elements,
                                                Integer expectedCount,
                                                Integer timeout) {
    	
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            wait.until(driver1 -> {
                try {
                    return elements.size()==expectedCount;
                } catch (Exception ignore) { }
                return false;
            });
        } catch (TimeoutException ignore) { }
    }

    public void waitForElementAttachDOM(WebDriver driver, String xpath, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery((timeout*1000)/6, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            wait.until(driver1 -> driver1.findElement(By.xpath(xpath)));
        } 
        catch (TimeoutException ignore) {
        }
    }

    public void waitForOptionInSelect(WebDriver driver, Select select, String expectedOptionText, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery((timeout*1000)/10, TimeUnit.MILLISECONDS) //TODO: param pollingEvery?
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        final String[] optionsInSelect = new String[1];
        try {
            wait.until(driver1 -> {
                try {
                    for(WebElement option: select.getOptions()){
                        optionsInSelect[0] = String.join(",", option.getText());
                        if (option.getText().equalsIgnoreCase(expectedOptionText)) {
                            return option;
                        }
                    }
                } catch (Exception ignore) { }
                return false;
            });
        } catch (TimeoutException ignore) {
        }
    }
    
    public void waitForOptionsIsNotEmpty(WebDriver driver, Select select, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery((timeout*1000)/10, TimeUnit.MILLISECONDS) //TODO: param pollingEvery?
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            wait.until(driver1 -> {
                try {
                    return select.getOptions().size()>0;
                } catch (Exception ignore) { }
                return false;
            });
        } catch (TimeoutException ignore) {
        }
    }


    public void waitForElementLoad(WebDriver driver, Method methodReturnWebElement, int timeout) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS) //TODO: param pollingEvery?
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            wait.until(driver1 -> {
                try {
                    return methodReturnWebElement.invoke(null, driver1);
                } catch (InvocationTargetException | IllegalAccessException ignore) { }
                return false;
            });
        } catch (TimeoutException ignore) {
        }
    }

    public void waitForElementUnLoad(WebDriver driver, WebElement webElement, int timeout) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery((timeout*1000)/10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        try {
            wait.until(driver1 -> {
                try {
                    webElement.isDisplayed();
                    return false;
                } catch (WebDriverException ignore) {
                    return true;
                }
            });
        } catch (TimeoutException ignore) {
        }
    }

    public void waitForElementContainsText(WebDriver driver, WebElement element, String text, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery((timeout*1000)/10, TimeUnit.MILLISECONDS) //TODO: param pollingEvery?
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            wait.until(driver1 -> {
                try {
                    return element.getText().contains(text);
                } catch (Exception ignore) { }
                return false;
            });
        } catch (TimeoutException ignore) { }
    }

    public void waitForElementNotContainsText(WebDriver driver, WebElement element, String text, int timeout) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery((timeout*1000)/10, TimeUnit.MILLISECONDS) //TODO: param pollingEvery?
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        try {
            wait.until(driver1 -> {
                try {
                    return !element.getText().contains(text);
                } catch (Exception ignore) { }
                return false;
            });
        } catch (TimeoutException ignore) { }
    }

    /*public boolean waitForElementToBeInvisible(WebDriver driver, WebElement element, int timeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/

    public void waitForNewWindow(WebDriver driver, int windowsBefore) {
        waitForNewWindow(driver, windowsBefore, 5);
    }

    public static void waitForNewWindow(WebDriver driver, int windowsBefore, int timeout) {
        ExpectedCondition<Boolean> windowCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getWindowHandles().size() == windowsBefore + 1;
            }
        };

        WebDriverWait waitForWindow = new WebDriverWait(driver, timeout);
        waitForWindow.until(windowCondition);
    }
    public void waitForURLchange(WebDriver driver, String prevUrl, int timeout) {
        ExpectedCondition<Boolean> windowCondition = driver1 -> {
            try {
                return !driver1.getCurrentUrl().equalsIgnoreCase(prevUrl);
            } catch (UnhandledAlertException ex) {
                return false;
            }
        };

        WebDriverWait waitForWindow = new WebDriverWait(driver, timeout);
        waitForWindow.until(windowCondition);
    }

    public void waitForAlertAccept(WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public Alert waitForAlert(WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    public boolean isAlertPresent(WebDriver driver) {
        return isAlertPresent(driver, 5);
    }
    
    public boolean isAlertPresent(WebDriver driver, int timeout) {
        try {
            waitForAlert(driver, timeout);
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
