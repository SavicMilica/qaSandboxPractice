package tests;

import apimethods.TestCaseAPI;
import asserts.TestCaseAssert;
import common.TestBase;
import data.models.testcase.ApiError;
import data.models.testcase.CreateTestCaseRequest;
import data.models.testcase.EditTestCaseRequest;
import data.models.testcase.TestCaseResponse;
import data.providers.TestCaseData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestCaseTest extends TestBase {

    @BeforeTest
    public void deleteAllTestCases() {
        TestCaseAPI.deleteAllTestCases(TestBase.token);
    }

    @Test
    public void verifyCanCreateTestCase() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
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
        TestCaseAssert.getTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void verifyCanUpdateTestCase() {
        CreateTestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse createdCase = TestCaseAPI.createTestCase(TestBase.token, testCaseRequest).get(0);
        EditTestCaseRequest testCaseRequestUpdate = TestCaseData.prepareTestCaseDataForUpdate(null);
        TestCaseResponse actualResponse = TestCaseAPI.updateTestCase(TestBase.token, testCaseRequestUpdate, createdCase.getId()).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseEditedTestCase(testCaseRequestUpdate, createdCase.getId());
        TestCaseAssert.updateTestCaseAssert(actualResponse, expectedResponse);
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
