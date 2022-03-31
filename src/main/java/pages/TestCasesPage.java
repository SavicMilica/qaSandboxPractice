package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {

    private WebDriver driver;
    private By newTestCaseButton = By.xpath("//span//a[@href='/new-testcase']");
    private By previewField = By.xpath("//div[contains(@class, 'single-preview')]");
    private By closeButton = By.xpath("//button[text()='Close']");
    private By previewTitleText = By.className("preview-card-modal-title-value");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewTestCasePage clickNewTestCaseButton() {
        driver.findElement(newTestCaseButton).click();
        return new NewTestCasePage(driver);
    }

    public void clickPreviewTestCase() {
        driver.findElement(previewField).click();
    }

    public String getPreviewTitleText() {
        return driver.findElement(previewTitleText).getText();
    }

    public TestCasesPage clickCloseButton() {
        driver.findElement(closeButton).click();
        return new TestCasesPage(driver);
    }

}
