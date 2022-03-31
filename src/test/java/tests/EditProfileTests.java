package tests;

import constants.KeyParameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EditProfilePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.List;

public class EditProfileTests extends SeleniumTestCaseTests {

    @Test
    public void verifySuccessfulEditProfile() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(KeyParameters.EMAIL);
        loginPage.setPassword(KeyParameters.PASSWORD);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        Thread.sleep(2000);
        ProfilePage profilePage = dashboardPage.clickProfileCard();
        EditProfilePage editProfilePage = profilePage.clickEditProfileButton();
        Thread.sleep(2000);

        editProfilePage.setProfilePicture("C:\\Users\\Milica\\Desktop\\qasandbox\\picture.jpg");
        Thread.sleep(2000);

        editProfilePage.selectDropdownStatus(KeyParameters.DROPDOWN_OPTION);
        List<String> selectedOptions = editProfilePage.getSelectedOptions();

        Thread.sleep(2000);
        editProfilePage.clickSubmitButton();

        Assert.assertEquals(editProfilePage.findUploadAlert(), "✔ Photo successfully uploaded", "upload message is not the same");
        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        Assert.assertTrue(selectedOptions.contains(KeyParameters.DROPDOWN_OPTION), "Option not selected");
    }

}
