package Home;

import Base.BaseTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ApplicationFormPage;
import pages.CareersPage;
import pages.JobDescriptionPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.*;

public class HomePageTest extends BaseTest {

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("D:\\freeletics_test\\src\\main\\java\\data\\data.json"));

    public HomePageTest() throws IOException, ParseException {
    }

    @Test
    public void TestUserNavigatesToApplicationFormPage() {

        String titleOfJob = (String) jsonObject.get("jobTitle");
        String locationOfJob = (String) jsonObject.get("jobLocation");

        homePage.acceptCookies();
        CareersPage careersPage = homePage.clickCareersLink();
        careersPage.clickOpenPositionBtn();
        JobDescriptionPage jobDescription  = careersPage.clickQAPositionLink();
        String jobTitle = jobDescription.getJobTileText();
        String jobLocation = jobDescription.getJobLocation();
        int jobResponsibilitiesCount = jobDescription.getNumberOfJobResponsibilities();
        int jobProfilesCount = jobDescription.getNumberOfProfileInYourProfileSection();

        assertTrue(jobTitle.contains(titleOfJob), "QA Engineer Title did not display in Job Title");
        assertTrue(jobLocation.contains(locationOfJob), "Munich did not display in Location");
        assertTrue(jobDescription.isJobDescriptionDisplayed(), "Job Description did not display on page");
        assertTrue(jobDescription.isJobResponsibilitiesTitleDisplayed(), "Job Responsibilities title did not display on page");
        assertEquals(jobResponsibilitiesCount,9,"Job Responsibilities count is not equal to 9");

        assertTrue(jobDescription.isYourProfileTitleDisplayed(), "Your Profile title did not display on page");
        assertEquals(jobProfilesCount,9,"Job Profiles count is not equal to 9");

        ApplicationFormPage applicationFormPage = jobDescription.clickApplyNowBtn();
        applicationFormPage.switchToNewWindow();
        assertTrue(applicationFormPage.isSubmitYourApplicationTitleDisplayed(), "Submit your Application page did not display");
    }

}
