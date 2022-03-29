package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTestCasePage {
    private WebDriver driver;
    private By newTestCaseButton = By.linkText("New Test Case");

    public CreateTestCasePage(WebDriver driver) {
        this.driver = driver;
    }

    public NewTestCasePage clickNewTestCaseButton() {
        driver.findElement(newTestCaseButton).click();
        return new NewTestCasePage(driver);
    }
}
