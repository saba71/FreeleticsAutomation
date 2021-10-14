package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperMethods;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By _acceptCookiesBtn = By.xpath("//button/span[text()='Accept all cookies']");
    private By _trainingHeadingLink = By.xpath("//div[@data-cy='nav-bar-main']/div/ul/li/a[text()='Training']");
    private By _careersLink = By.xpath("//footer/div/ul/li/ul/li/a/span[text()='Careers']");

    public void acceptCookies(){
        driver.findElement(_acceptCookiesBtn).click();
    }

//    public void clickOnTrainingHeadingLink(){
//        driver.findElement(_trainingHeadingLink).click();
//    }


    public CareersPage clickCareersLink(){
        HelperMethods _helperMethods = new HelperMethods(driver);
        _helperMethods.waitForElement(_careersLink);
        driver.findElement(_careersLink).click();
        return new CareersPage(driver);
    }


}



