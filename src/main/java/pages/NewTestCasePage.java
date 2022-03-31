package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTestCasePage {

    private WebDriver driver;
    private By titleField = By.name("title");
    private By descriptionField = By.xpath("//textarea[@name='description' and @placeholder='Description']");
    private By expectedResultField = By.name("expected_result");
    private By testStepField = By.id("step-0");
    private By addTestStepButton = By.linkText("Add Test Step");
    private By automatedSwitch = By.cssSelector("label.switch div");
    private By submitButton = By.cssSelector("div.submit-button button");

    public NewTestCasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void setDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void setExpectedResult(String expectedResult) {
        driver.findElement(expectedResultField).sendKeys(expectedResult);
    }

    public void setTestStep(String testStep) {
        driver.findElement(testStepField).sendKeys(testStep);
    }

    public void addTestStep() {
        driver.findElement(addTestStepButton).click();
    }

    public void clickAutomatedSwitch() {
        driver.findElement(automatedSwitch).click();
    }

    public TestCasesPage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return new TestCasesPage(driver);
    }

}
