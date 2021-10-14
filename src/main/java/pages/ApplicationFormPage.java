package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.HelperMethods;

public class ApplicationFormPage {
    private WebDriver driver;

    public ApplicationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private By _submitYourApplicationTitle = By.xpath("//form//h4[text() = 'Submit your application']");


    public void switchToNewWindow(){
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public Boolean isSubmitYourApplicationTitleDisplayed(){
        HelperMethods _helperMethods = new HelperMethods(driver);
        _helperMethods.waitForElement(_submitYourApplicationTitle);
        Boolean _display = driver.findElement(_submitYourApplicationTitle).isDisplayed();
        return _display;
    }

}



