package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HelperMethods;

import java.util.List;

public class JobDescriptionPage {
    private WebDriver driver;

    public JobDescriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By _jobTitle = By.xpath("//section/div/h1[@itemprop='title']");
    private By _jobLocation = By.xpath("//section//p/span[@itemprop='jobLocation']");
    private By _jobDescriptionTxt = By.xpath("//section[@itemprop='description']");

    private By _jobResponsibilitiesTitle = By.xpath("//section[@itemprop='responsibilities']");
    private By _numberOfJobResponsibilities = By.xpath("//section[@itemprop='responsibilities']/ul/li");

    private By _yourProfileTitle = By.xpath("//section[@itemprop='experienceRequirements']//h2[text() = 'Your profile']");
    private By _numberOfProfileInYourProfileSection = By.xpath("//section[@itemprop='experienceRequirements']//ul/li");


    private By _applicationSection = By.id("SectionApplication");
    private By _applyNowBtn = By.xpath("//section[@id='SectionApplication']//a/span[text() = 'Apply now']");


    public String getJobTileText(){
        HelperMethods _helperMethods = new HelperMethods(driver);
        _helperMethods.waitForElement(_jobTitle);
        return driver.findElement(_jobTitle).getText();
    }
    public String getJobLocation(){
        return driver.findElement(_jobLocation).getText();
    }
    public Boolean isJobDescriptionDisplayed(){
        Boolean _display = driver.findElement(_jobDescriptionTxt).isDisplayed();
        return _display;
    }
    public Boolean isJobResponsibilitiesTitleDisplayed(){
        Boolean _display = driver.findElement(_jobResponsibilitiesTitle).isDisplayed();
        return _display;
    }

    public int getNumberOfJobResponsibilities(){
        List<WebElement> _listAllJobResponsibilities = driver.findElements(_numberOfJobResponsibilities);
        int _countOfResponsibilities = _listAllJobResponsibilities.size();
        System.out.println("Total Count of Responsibilities is = " + _countOfResponsibilities);
        return _countOfResponsibilities;
    }

    public Boolean isYourProfileTitleDisplayed(){
        Boolean _display = driver.findElement(_yourProfileTitle).isDisplayed();
        return _display;
    }

    public int getNumberOfProfileInYourProfileSection(){
        List<WebElement> _listAllProfiles = driver.findElements(_numberOfProfileInYourProfileSection);
        int _countOfProfiles = _listAllProfiles.size();
        System.out.println("Total Count of Profiles is = " + _countOfProfiles);
        return _countOfProfiles;
    }

    public ApplicationFormPage clickApplyNowBtn(){
        HelperMethods _helperMethods = new HelperMethods(driver);
        _helperMethods.scrollToElement(_applicationSection);
        driver.findElement(_applyNowBtn).click();
        return new ApplicationFormPage(driver);
    }




}



