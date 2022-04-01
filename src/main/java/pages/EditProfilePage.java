package pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditProfilePage {

    private WebDriver driver;
    private By dropdown = By.name("career_status_id");
    private By submitButton = By.xpath("//button[text()='Submit']");

    private By inputField = By.xpath("//input[@name='image']");
    private By uploadButton = By.xpath("//button[text()='Upload']");

    private By alertUploadSuccessful = By.xpath("//div[text()='✔ Photo successfully uploaded']");

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    private Select findDropdown() {
        return new Select(driver.findElement(dropdown));
    }

    public void selectDropdownStatus(String option) {
        findDropdown().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropdown().getAllSelectedOptions();
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < selectedElements.size(); i++) {
            stringList.add(selectedElements.get(i).getText());
        }
        return stringList;
    }

    public ProfilePage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return new ProfilePage(driver);
    }

    public void setProfilePicture(String absoluteFilePath) {
        driver.findElement(inputField).sendKeys(absoluteFilePath);
        driver.findElement(uploadButton).click();
    }

    public String findUploadAlert() {
        return driver.findElement(alertUploadSuccessful).getText();
    }

}
