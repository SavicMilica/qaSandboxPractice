package apimethods;

import common.RestAssuredMethods;
import constants.ApiEndpoints;
import data.models.testcase.TestCaseRequest;
import common.GsonSetup;
import data.models.testcase.TestCaseRequestEdit;
import data.models.testcase.TestCaseResponse;

import java.util.List;

import static common.TestBase.token;

public class TestCaseAPI {
    public static List<TestCaseResponse> createTestCase(String token, TestCaseRequest testCaseRequest) {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.post(token, testCaseRequest, ApiEndpoints.TEST_CASE),
                        TestCaseResponse[].class);
    }

    public static TestCaseResponse getTestCase(String token, Integer testCaseId) {
        return GsonSetup.convertJsonToClass
                (RestAssuredMethods.get(token, ApiEndpoints.testCaseEndpoint(testCaseId)), TestCaseResponse.class);
    }

    public static List<TestCaseResponse> getAllTestCases(String token) {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.get(token, ApiEndpoints.TEST_CASE), TestCaseResponse[].class);
    }

    public static List<TestCaseResponse> updateTestCase(String token, TestCaseRequestEdit testCaseRequest, Integer testCaseId) {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.put(token, testCaseRequest, ApiEndpoints.testCaseEndpoint(testCaseId)), TestCaseResponse[].class);
    }

    public static EmptyClass deleteTestCase(String token, Integer testCaseId) {
        return GsonSetup.convertJsonToClass
                (RestAssuredMethods.delete(token, ApiEndpoints.testCaseEndpoint(testCaseId)), EmptyClass.class);
    }

    public static EmptyClass getTestCaseWithError(String token, Integer testCaseId) {
        return GsonSetup.convertErrorResponse
                (RestAssuredMethods.get(token, ApiEndpoints.testCaseEndpoint(testCaseId)), EmptyClass.class);
    }

    public static void deleteAllTestCases() {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        for(int i = 0; i < testCaseResponseList.size(); i++) {
            deleteTestCase(token, testCaseResponseList.get(i).getId());
        }
    }

    public static List<TestCaseResponse> createNewTestCaseInEmptyList(TestCaseRequest testCaseRequest) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        if(testCaseResponseList.isEmpty()) {
            return createTestCase(token, testCaseRequest);
        } else {
            deleteAllTestCases();
            return createTestCase(token, testCaseRequest);
        }
    }

    public static TestCaseResponse getTestCaseFromTheList(TestCaseRequest testCaseRequest) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        if(testCaseResponseList.isEmpty()) {
            Integer testCaseId = createTestCase(token, testCaseRequest).get(0).getId();
            return getTestCase(token, testCaseId);
        } else {
            Integer testCaseId = testCaseResponseList.get(0).getId();
            return getTestCase(token, testCaseId);
        }
    }

    public static TestCaseResponse getCreatedTestCase(Integer testCaseId) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        for(int i = 0; i <testCaseResponseList.size(); i++) {
            if(testCaseResponseList.get(i).getId().equals(testCaseId)) {
                return testCaseResponseList.get(i);
            }
        }
        return null;
    }

    public static List<TestCaseResponse> updateTestCase(TestCaseRequest testCaseRequestCreate, TestCaseRequestEdit testCaseRequestUpdate) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        if(testCaseResponseList.isEmpty()) {
            Integer testCaseId = createTestCase(token, testCaseRequestCreate).get(0).getId();
            testCaseRequestUpdate.setTestcaseId(testCaseId);
            return updateTestCase(token, testCaseRequestUpdate, testCaseId);
        } else {
            Integer testCaseId = testCaseResponseList.get(0).getId();
            testCaseRequestUpdate.setTestcaseId(testCaseId);
            return updateTestCase(token, testCaseRequestUpdate, testCaseId);
        }
    }

    public static void deleteTestCaseInTheList(TestCaseRequest testCaseRequest) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        if(testCaseResponseList.isEmpty()) {
            Integer testCaseId = createTestCase(token, testCaseRequest).get(0).getId();
            deleteTestCase(token, testCaseId);
        } else {
            Integer testCaseId = testCaseResponseList.get(0).getId();
            deleteTestCase(token, testCaseId);
        }
    }
}
