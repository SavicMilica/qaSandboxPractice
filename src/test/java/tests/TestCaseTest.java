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
    public void createTestCase() {
        TestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse actualResponse = TestCaseAPI.createTestCase(token, testCaseRequest).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseFullTestCaseResponse(testCaseRequest);
        TestCaseAssert.createTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void getCreatedTestCase() {
        createdCase = TestCaseAPI.createTestCase(token, TestCaseData.prepareTestCaseData());
        TestCaseResponse actualResponse = TestCaseAPI.getCreatedTestCase(createdCase.get(0).getId());
        TestCaseResponse expectedResponse = TestCaseResponse.parseCreatedTestCaseResponse(createdCase, createdCase.get(0).getId());
        TestCaseAssert.getTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void getTestCaseFromTheList() {
        TestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseResponse actualResponse = TestCaseAPI.getTestCaseFromTheList(testCaseRequest);
    }

    @Test
    public void getAllTestCases() {
        List<TestCaseResponse> testCaseResponseList = TestCaseAPI.getAllTestCases(token);
        System.out.println(testCaseResponseList);
    }

    @Test
    public void updateTestCase() {
        TestCaseRequest testCaseRequestCreate = TestCaseData.prepareTestCaseData();
        TestCaseRequestEdit testCaseRequestUpdate = TestCaseData.prepareTestCaseDataForUpdate(null);
        TestCaseResponse actualResponse = TestCaseAPI.updateTestCase(testCaseRequestCreate, testCaseRequestUpdate).get(0);
        TestCaseResponse expectedResponse = TestCaseResponse.parseFullTestCaseResponseForUpdate(testCaseRequestUpdate);
        TestCaseAssert.updateTestCaseAssert(actualResponse, expectedResponse);
    }

    @Test
    public void deleteTestCase() {
        TestCaseRequest testCaseRequest = TestCaseData.prepareTestCaseData();
        TestCaseAPI.deleteTestCaseInTheList(testCaseRequest);
        List<TestCaseResponse> testCaseResponseList = TestCaseAPI.getAllTestCases(token);
    }

    @Test
    public void deleteAllTestCases() {
        TestCaseAPI.deleteAllTestCases();
    }

}
