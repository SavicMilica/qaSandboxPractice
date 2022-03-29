package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.DashboardPage;
import pages.HomePage;
import pages.ProfilePage;

public class SeleniumTestCaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected DashboardPage dashboardPage;

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-sandbox.ni.htec.rs");

        homePage = new HomePage(driver);
//        dashboardPage = new DashboardPage(driver);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
