package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By testCaseCard = By.xpath("//a[@href='/testcases' and @class='card ']");
    private By profileCard = By.xpath("//a[@href='/profile' and @class='card ']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestCasesPage clickTestCaseCard() {
        driver.findElement(testCaseCard).click();
        return new TestCasesPage(driver);
    }

    public ProfilePage clickProfileCard() {
        driver.findElement(profileCard).click();
        return new ProfilePage(driver);
    }
}
