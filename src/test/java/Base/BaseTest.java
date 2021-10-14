package Base;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import java.io.IOException;


public class BaseTest {
   private WebDriver driver;
    protected HomePage homePage;

   @BeforeClass
   public void setUp() throws IOException, ParseException {
       System.setProperty("webdriver.chrome.driver", "resources/ChromeDriver.exe");
       driver = new ChromeDriver(getChromeOptions());
       homePage = new HomePage(driver);
       Home();

       driver.manage().window().maximize();
       System.out.println(driver.getTitle());
   }

   @BeforeMethod
   public void Home() {
       driver.get("https://www.freeletics.com/en/");
   }

   @AfterClass
   public void tearDown(){
       driver.quit();
   }


   private ChromeOptions getChromeOptions(){
       ChromeOptions options = new ChromeOptions();
       options.getVersion();
       return options;
   }
}
