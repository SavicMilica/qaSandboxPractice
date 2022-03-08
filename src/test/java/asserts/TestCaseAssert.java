package asserts;

import data.models.testcase.TestCaseResponse;
import data.models.testcase.TestStepRequest;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestCaseAssert {

    public static void createTestCaseAssert(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(actualResponse.getId(), "id is null");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");

        List<TestStepRequest> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(), "test steps didn't match");
        }
    softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "boolean didn't match");
    softAssert.assertAll();
    }

    public static void getTestCaseAssert(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "id didn't match");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");

        List<TestStepRequest> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(), "test steps didn't match");
        }

        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "boolean didn't match");
        softAssert.assertAll();
    }

    public static void updateTestCaseAssert(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "id didn't match");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");

        List<TestStepRequest> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(), "test steps didn't match");
        }

        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "boolean didn't match");
        softAssert.assertEquals(actualResponse.getCandidateScenarioId(), Integer.valueOf(446), "scenario id didn't match");
        softAssert.assertAll();
    }
}
