package asserts;

import data.models.testcase.errors.ApiRequiredFieldError;
import data.models.testcase.DeleteTestCaseResponse;
import data.models.testcase.errors.ApiError;
import data.models.testcase.TestCaseResponse;
import data.models.testcase.errors.TestStepError;
import data.models.testcase.teststep.TestStepResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestCaseAssert {

    public static void createTestCaseAssert(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual test case is null");
        }
        if (actualResponse.getTestSteps() == null) {
            Assert.fail("Actual test step is null");
        }
        if (actualResponse.getTestSteps().size() != expectedResponse.getTestSteps().size()) {
            Assert.fail("The number of test steps is not the same in actual and expected responses");
        }
        softAssert.assertNotNull(actualResponse.getId(), "id is null");
        softAssert.assertNotNull(actualResponse.getCandidateId(), "candidate id is null");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");
        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "automated didn't match");
        softAssert.assertNotNull(actualResponse.getCandidateScenarioId(), "candidate scenario id is null");

        List<TestStepResponse> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getId(), "test step id is null");
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getTestcaseId(), "test case id in test step is null");
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(),
                    "test steps didn't match");
        }
    softAssert.assertAll();
    }

    public static void compareTestCaseWithId(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual test case is null");
        }
        if (actualResponse.getTestSteps() == null) {
            Assert.fail("Actual test step is null");
        }
        if (actualResponse.getTestSteps().size() != expectedResponse.getTestSteps().size()) {
            Assert.fail("The number of test steps is not the same in actual and expected responses");
        }
        softAssert.assertEquals(actualResponse.getId(), expectedResponse.getId(), "id didn't match");
        softAssert.assertNotNull(actualResponse.getCandidateId(), "candidate id is null");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");
        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "automated didn't match");
        softAssert.assertNotNull(actualResponse.getCandidateScenarioId(), "candidate scenario id is null");

        List<TestStepResponse> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getId(), "test step id is null");
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getTestcaseId(), "test case id in test step is null");
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(), "test steps didn't match");
        }
        softAssert.assertAll();
    }

    public static void deleteTestCase(ApiError actualError, ApiError expectedError) {
        SoftAssert softAssert = new SoftAssert();
        if (actualError == null) {
            Assert.fail("Actual error is null");
        }
        softAssert.assertEquals(actualError.getError(), expectedError.getError(), "error message is not the same");
        softAssert.assertAll();
    }

    public static void DeleteSuccessMessage(DeleteTestCaseResponse actualResponse, DeleteTestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getSuccess(), expectedResponse.getSuccess(), "success message didn't match");
        softAssert.assertAll();
    }

    public static void createTestCaseWithoutRequiredField(ApiRequiredFieldError actualError, ApiRequiredFieldError expectedError) {
        SoftAssert softAssert = new SoftAssert();
        if (actualError == null) {
            Assert.fail("Actual error is null");
        }
        softAssert.assertEquals(actualError.getTitle(), expectedError.getTitle(), "title error message is not the same");
        softAssert.assertEquals(actualError.getExpectedResult(), expectedError.getExpectedResult(), "expected result error message is not the same");
        softAssert.assertEquals(actualError.getTestSteps(), expectedError.getTestSteps(), "test step error message is not the same");
        softAssert.assertAll();
    }

    public static void createTestCaseWithTwoSameTitles(ApiRequiredFieldError actualError, ApiRequiredFieldError expectedError) {
        SoftAssert softAssert = new SoftAssert();
        if(actualError == null) {
            Assert.fail("There is no actual error");
        }
        softAssert.assertEquals(actualError.getTitle(), expectedError.getTitle(), "error message is not the same");
        softAssert.assertAll();
    }

    public static void createTestStepWithMoreThan300Characters(TestStepError actualError, TestStepError expectedError) {
        SoftAssert softAssert = new SoftAssert();
        if(actualError == null) {
            Assert.fail("There is no actual error");
        }
        softAssert.assertEquals(actualError.getError(), expectedError.getError(), "error message is not the same");
        softAssert.assertEquals(actualError.getId(), expectedError.getId(), "id didn't match");
        softAssert.assertAll();
    }

    public static void createTestCaseWith51TestSteps(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual test case is null");
        }
        if (actualResponse.getTestSteps().size() == 51) {
            Assert.fail("There are more than 50 test steps");
        }
        if (actualResponse.getTestSteps().size() != expectedResponse.getTestSteps().size()) {
            Assert.fail("The number of test steps is not the same in actual and expected responses");
        }
        softAssert.assertNotNull(actualResponse.getId(), "id is null");
        softAssert.assertNotNull(actualResponse.getCandidateId(), "candidate id is null");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");
        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "automated didn't match");
        softAssert.assertNotNull(actualResponse.getCandidateScenarioId(), "candidate scenario id is null");

        List<TestStepResponse> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getId(), "test step id is null");
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getTestcaseId(), "test case id in test step is null");
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(),
                    "test steps didn't match");
        }
        softAssert.assertAll();
    }

    public static void createTestCaseWithDifferentNumberOfCharacters(TestCaseResponse actualResponse, TestCaseResponse expectedResponse) {
        SoftAssert softAssert = new SoftAssert();
        if (actualResponse == null) {
            Assert.fail("Actual test case is null");
        }
        if (actualResponse.getTestSteps() == null) {
            Assert.fail("Actual test step is null");
        }
        if (actualResponse.getTestSteps().size() != expectedResponse.getTestSteps().size()) {
            Assert.fail("The number of test steps is not the same in actual and expected responses");
        }

        if (actualResponse.getTitle().length() > 255) {
            Assert.fail("Title has more than 255 characters");
        }

        if (actualResponse.getDescription().length() > 1000) {
            Assert.fail("Description has more than 1000 characters");
        }

        if (actualResponse.getExpectedResult().length() > 255) {
            Assert.fail("Expected result has more than 255 characters");
        }

        if (actualResponse.getTestSteps().size() > 300) {
            Assert.fail("Test step has more than 300 characters");
        }
        softAssert.assertNotNull(actualResponse.getId(), "id is null");
        softAssert.assertNotNull(actualResponse.getCandidateId(), "candidate id is null");
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title didn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result didn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description didn't match");
        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "automated didn't match");
        softAssert.assertNotNull(actualResponse.getCandidateScenarioId(), "candidate scenario id is null");

        List<TestStepResponse> testStepRequestList = expectedResponse.getTestSteps();
        for(int i = 0; i < testStepRequestList.size(); i++) {
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getId(), "test step id is null");
            softAssert.assertNotNull(actualResponse.getTestSteps().get(i).getTestcaseId(), "test case id in test step is null");
            softAssert.assertEquals(actualResponse.getTestSteps().get(i).getValue(), expectedResponse.getTestSteps().get(i).getValue(),
                    "test steps didn't match");
        }
        softAssert.assertAll();
    }
}
