package tests;

import constants.KeyParameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTests extends SeleniumTestCaseTests {

    @Test
    public void verifySuccessfulLogin() {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(KeyParameters.EMAIL);
        loginPage.setPassword(KeyParameters.PASSWORD);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        Assert.assertNotNull(dashboardPage, "dashboard is null");

    }
}
