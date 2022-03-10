package tests;

import apimethods.TestCaseAPI;
import asserts.TestCaseAssert;
import common.TestBase;
import data.models.testcase.TestCaseRequest;
import data.models.testcase.TestCaseRequestEdit;
import data.models.testcase.TestCaseResponse;
import data.providers.TestCaseData;
import org.testng.annotations.Test;

import java.util.List;


public class TestCaseTest extends TestBase {

    List<TestCaseResponse> createdCase;

    @Test
    public void verifyCanCreateTestCase() {
        TestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse actualResponse = TestCaseAPI.createNewTestCaseInEmptyList(TestBase.token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseFullTestCaseResponse(testCaseRequest);
        TestCaseAssert.createTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void verifyListOfTestCases() {
        createdCase = TestCaseAPI.createTestCase(TestBase.token, TestCaseData.prepareTestCaseData());
        TestCaseResponse actualResponse = TestCaseAPI.getTestCaseFromList(TestBase.token, createdCase.get(0).getId());
        TestCaseResponse expectedResponse = TestCaseResponse.parseTestCase(createdCase.get(0));
        TestCaseAssert.getTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void verifyCanUpdateTestCase() {
        TestCaseRequest testCaseRequestCreate = TestCaseData.prepareTestCaseData();
        TestCaseRequestEdit testCaseRequestUpdate = TestCaseData.prepareTestCaseDataForUpdate(null);
        TestCaseResponse actualResponse = TestCaseAPI.updateTestCase(TestBase.token, testCaseRequestCreate, testCaseRequestUpdate).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseFullTestCaseResponseForUpdate(testCaseRequestUpdate);
        TestCaseAssert.updateTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void verifyDeleteTestCase() {
        TestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        createdCase = TestCaseAPI.createNewTestCaseInEmptyList(TestBase.token, testCaseRequest);
        TestCaseAPI.deleteTestCase(TestBase.token, createdCase.get(0).getId());
        ApiError actualError = TestCaseAPI.getTestCaseWithError(TestBase.token);
        ApiError expectedError = ApiError.parseError("Test case not found");
    }

    @Test
    public void deleteAllTestCases() {
        TestCaseAPI.deleteAllTestCases(TestBase.token);
    }

}
