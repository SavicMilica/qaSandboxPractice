package tests;

import constants.KeyParameters;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewTestCasePage;
import pages.TestCasesPage;

public class CreateTestCaseTests extends SeleniumTestCaseTests {

    @Test
    public void verifyCanCreateTestCase() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(KeyParameters.EMAIL);
        loginPage.setPassword(KeyParameters.PASSWORD);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        Thread.sleep(2000);
        TestCasesPage testCasesPage = dashboardPage.clickTestCaseCard();
        NewTestCasePage newTestCasePage = testCasesPage.clickNewTestCaseButton();
        Thread.sleep(2000);
        newTestCasePage.setTitle(KeyParameters.TITLE);
        newTestCasePage.setDescription(KeyParameters.DESCRIPTION);
        newTestCasePage.setExpectedResult(KeyParameters.EXPECTED_RESULT);
        newTestCasePage.setTestStep(KeyParameters.TEST_STEP);
        newTestCasePage.clickAutomatedSwitch();
        newTestCasePage.clickSubmitButton();
    }
}
