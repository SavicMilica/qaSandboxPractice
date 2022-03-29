package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;
    private By editProfileButton = By.linkText("Edit Profile");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public EditProfilePage clickEditProfileButton() {
        driver.findElement(editProfileButton).click();
        return new EditProfilePage(driver);
    }

}
