package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By testCaseCard = By.xpath("//div[@class='main']//descendant::a[@href='/testcases']");
    private By profileCard = By.xpath("//div[@class='card-grid']//descendant::a[1]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateTestCasePage clickTestCaseCard() {
        driver.findElement(testCaseCard).click();
        return new CreateTestCasePage(driver);
    }

    public ProfilePage clickProfileCard() {
        driver.findElement(profileCard).click();
        return new ProfilePage(driver);
    }
}
