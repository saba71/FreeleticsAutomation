package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperMethods;

public class CareersPage {
    private WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By _openPositionBtn = By.cssSelector("#SectionHero a[role=\"button\"]");
    private By _qaPositionLink = By.xpath("//div[@id='product-engineering']/div/ul/li/a[text()='QA Engineer (m/f/d) - Remote or Munich']");


    public void clickOpenPositionBtn(){
        HelperMethods _helperMethods = new HelperMethods(driver);
        _helperMethods.waitForElement(_openPositionBtn);
        driver.findElement(_openPositionBtn).click();
    }
    public JobDescriptionPage clickQAPositionLink(){
        HelperMethods _helperMethods = new HelperMethods(driver);
        _helperMethods.waitForElement(_qaPositionLink);
        driver.findElement(_qaPositionLink).click();
        return new JobDescriptionPage(driver);
    }


}



