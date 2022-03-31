package tests;

import constants.KeyParameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TestCasesPage;

public class PreviewTestCaseTest extends SeleniumTestCaseTests {

    @Test
    public void verifyPreviewTestCaseShowTestCaseDetails() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(KeyParameters.EMAIL);
        loginPage.setPassword(KeyParameters.PASSWORD);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        Thread.sleep(2000);
        TestCasesPage testCasesPage = dashboardPage.clickTestCaseCard();
        Thread.sleep(2000);
        testCasesPage.clickPreviewTestCase();
        Thread.sleep(2000);
        Assert.assertEquals(testCasesPage.getPreviewTitleText(), KeyParameters.TITLE, "title is not the same");
        Thread.sleep(2000);
        testCasesPage.clickCloseButton();

    }
}
