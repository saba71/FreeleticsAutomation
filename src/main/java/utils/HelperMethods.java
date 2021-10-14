package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperMethods {

    private WebDriver driver;

    public HelperMethods(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElement(By element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    public void scrollToElement(By element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        WebElement elementToScroll = driver.findElement(element);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",elementToScroll);
    }




}
