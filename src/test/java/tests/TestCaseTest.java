package tests;

import apimethods.TestCaseAPI;
import asserts.TestCaseAssert;
import common.TestBase;
import constants.KeyParameters;
import data.models.testcase.*;
import data.models.testcase.errors.ApiError;
import data.models.testcase.errors.ApiRequiredFieldError;
import data.models.testcase.errors.TestStepError;
import data.providers.TestCaseData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseTest extends TestBase {

    @BeforeTest
    public void deleteAllTestCases() {
        TestCaseAPI.deleteAllTestCasesIfListNotEmpty(TestBase.token);
    }

    @Test
    public void verifyCanCreateTestCase() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse actualResponse = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCase(testCaseRequest);
        TestCaseAssert.createTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test(dataProvider = "prepareTestCaseWithError", dataProviderClass = TestCaseData.class)
    public void verifyCannotCreateTestCaseWithoutRequiredField(CreateTestCaseRequest testCaseRequest, ApiRequiredFieldError expectedError) {
        ApiRequiredFieldError actualError = TestCaseAPI.createTestCaseWithError(TestBase.token, testCaseRequest);
        TestCaseAssert.createTestCaseWithoutRequiredField(actualError, expectedError);
    }

    @Test(dataProvider = "prepareTestCaseWithDifferentNumberOfCharacters", dataProviderClass = TestCaseData.class)
    public void verifyCanCreateTestCaseWithDifferentNumberOfCharacters(CreateTestCaseRequest testCaseRequest) {
        TestCaseResponse actualResponse = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCase(testCaseRequest);
        TestCaseAssert.createTestCaseWithDifferentNumberOfCharacters(actualResponse, expectedResponse);
    }

    @Test
    public void verifyCannotAddTestStepWithMoreThan300Characters() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestStepData();
        TestStepError actualError = TestCaseAPI.createTestCaseWithTestStepError(TestBase.token, testCaseRequest).getStepErrors().get(0);
        TestStepError expectedError = TestStepError.parseStepError(KeyParameters.TEST_STEP_ID, "Test step can not have more than 300 characters (301)");
        TestCaseAssert.createTestStepWithMoreThan300Characters(actualError, expectedError);
    }

    @Test
    public void verifyCanCreateTestCaseWithoutDescription() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseDataWithoutDescription();
        TestCaseResponse actualResponse = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCase(testCaseRequest);
        TestCaseAssert.createTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void verifyCannotCreateTestCaseWithSameTitle() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseAPI.createTestCase(TestBase.token, testCaseRequest);
        ApiRequiredFieldError actualError = TestCaseAPI.createTestCaseWithError(TestBase.token, testCaseRequest);
        ApiRequiredFieldError expectedError = ApiRequiredFieldError.parseTitleError("Test case name already exist");
        TestCaseAssert.createTestCaseWithTwoSameTitles(actualError, expectedError);
    }

    @Test
    public void verifyCannotCreateTestCaseWith51TestSteps() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseDataWithVariousNumberOfTestSteps(51);
        TestCaseResponse actualResponse = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCase(testCaseRequest);
        TestCaseAssert.createTestCaseWith51TestSteps(actualResponse, expectedResponse);
    }

    @Test
    public void verifyCanCreateTestCaseWithLessThan51TestSteps() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseDataWithVariousNumberOfTestSteps(50);
        TestCaseResponse actualResponse = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCase(testCaseRequest);
        TestCaseAssert.createTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void verifyListOfTestCases() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse createdCase = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse actualResponse = TestCaseAPI.getTestCaseFromList(TestBase.token, createdCase.getId());
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCaseWithId(testCaseRequest, createdCase.getId());
        TestCaseAssert.compareTestCaseWithId(actualResponse, expectedResponse);
    }

    @Test
    public void verifyCanUpdateTestCase() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse createdCase = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        EditTestCaseRequest testCaseRequestUpdate = TestCaseData.prepareTestCaseDataForUpdate(null);
        TestCaseResponse actualResponse = TestCaseAPI.updateTestCase(TestBase.token, testCaseRequestUpdate, createdCase.getId()).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseEditedTestCase(testCaseRequestUpdate, createdCase.getId());
        TestCaseAssert.compareTestCaseWithId(actualResponse, expectedResponse);
    }

    @Test
    public void verifyDeleteTestCase() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        List<TestCaseResponse> createdCase = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest);
        TestCaseAPI.deleteTestCase(TestBase.token, createdCase.get(0).getId());
        ApiError actualError = TestCaseAPI.getTestCaseWithError(TestBase.token, createdCase.get(0).getId());
        ApiError expectedError = ApiError.parseError("Test case not found");

        TestCaseAssert.deleteTestCase(actualError, expectedError);
    }

    @Test
    public void verifyDeleteSuccessMessage() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        List<TestCaseResponse> createdCase = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest);
        DeleteTestCaseResponse actualResponse = TestCaseAPI.deleteTestCase(TestBase.token, createdCase.get(0).getId());
        DeleteTestCaseResponse expectedResponse = DeleteTestCaseResponse.parseDeleteSuccess("Test case successfully removed");
        TestCaseAssert.DeleteSuccessMessage(actualResponse, expectedResponse);
    }

}
