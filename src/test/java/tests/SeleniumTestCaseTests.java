package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class SeleniumTestCaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-sandbox.ni.htec.rs");

        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void getFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot screenshot =((TakesScreenshot) driver);
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
            File fileDestination = new File("C:\\Users\\Milica\\Desktop\\test.png");
            Files.move(screenshotFile, fileDestination);
        }
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
