package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class EditProfilePage {

    private WebDriver driver;
    private By dropdown = By.name("career_status_id");
    private By submitButton = By.xpath("//button[text()='Submit']");

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
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

    private Select findDropdown() {
        return new Select(driver.findElement(dropdown));
    }

    public ProfilePage clickSubmitButton() {
        driver.findElement(submitButton).click();
        return new ProfilePage(driver);
    }
}
