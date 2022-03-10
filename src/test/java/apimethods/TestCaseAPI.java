package apimethods;

import common.RestAssuredMethods;
import constants.ApiEndpoints;
import data.models.common.EmptyClass;
import data.models.testcase.TestCaseRequest;
import common.GsonSetup;
import data.models.testcase.TestCaseRequestEdit;
import data.models.testcase.TestCaseResponse;
import java.util.List;

public class TestCaseAPI {
    public static List<TestCaseResponse> createTestCase(String accessToken, TestCaseRequest testCaseRequest) {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.post(accessToken, testCaseRequest, ApiEndpoints.TEST_CASE),
                        TestCaseResponse[].class);
    }

    public static TestCaseResponse getTestCase(String accessToken, Integer testCaseId) {
        return GsonSetup.convertJsonToClass
                (RestAssuredMethods.get(accessToken, ApiEndpoints.testCaseEndpoint(testCaseId)), TestCaseResponse.class);
    }

    public static ApiError getTestCaseWithError(String accessToken, Integer testCaseId) {
        return GsonSetup.convertErrorResponse
                (RestAssuredMethods.get(accessToken, ApiEndpoints.testCaseEndpoint(testCaseId)), ApiError.class);
    }

    public static List<TestCaseResponse> getAllTestCases(String accessToken) {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.get(accessToken, ApiEndpoints.TEST_CASE), TestCaseResponse[].class);
    }

    public static List<TestCaseResponse> updateTestCase(String accessToken, TestCaseRequestEdit testCaseRequest, Integer testCaseId) {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.put(accessToken, testCaseRequest, ApiEndpoints.testCaseEndpoint(testCaseId)), TestCaseResponse[].class);
    }

    public static EmptyClass deleteTestCase(String accessToken, Integer testCaseId) {
        return GsonSetup.convertJsonToClass
                (RestAssuredMethods.delete(accessToken, ApiEndpoints.testCaseEndpoint(testCaseId)), EmptyClass.class);
    }



    public static void deleteAllTestCases() {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(token);
        for(int i = 0; i < testCaseResponseList.size(); i++) {
            deleteTestCase(token, testCaseResponseList.get(i).getId());
        }
    }

    public static List<TestCaseResponse> createNewTestCaseInEmptyList(String accessToken, TestCaseRequest testCaseRequest) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(accessToken);
        if (!testCaseResponseList.isEmpty()) {
            deleteAllTestCases();
        }
        return createTestCase(accessToken, testCaseRequest);
    }

    public static TestCaseResponse createTestCaseAndGetTestCase(String accessToken, TestCaseRequest testCaseRequest) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(accessToken);
        Integer testCaseId;
        if(testCaseResponseList.isEmpty()) {
             testCaseId = createTestCase(accessToken, testCaseRequest).get(0).getId();
        } else {
             testCaseId = testCaseResponseList.get(0).getId();
        }
        return getTestCase(accessToken, testCaseId);
    }

    public static TestCaseResponse getTestCaseFromList(String accessToken, Integer testCaseId) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(accessToken);
        for(int i = 0; i <testCaseResponseList.size(); i++) {
            if(testCaseResponseList.get(i).getId().equals(testCaseId)) {
                return testCaseResponseList.get(i);
            }
        }
        return null;
    }

    public static List<TestCaseResponse> updateTestCase(String accessToken, TestCaseRequest testCaseRequestCreate,
                                                        TestCaseRequestEdit testCaseRequestUpdate) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(accessToken);
        Integer testCaseId;
        if(testCaseResponseList.isEmpty()) {
            testCaseId = createTestCase(accessToken, testCaseRequestCreate).get(0).getId();
            testCaseRequestUpdate.setTestcaseId(testCaseId);
        } else {
            testCaseId = testCaseResponseList.get(0).getId();
            testCaseRequestUpdate.setTestcaseId(testCaseId);
        }
        return updateTestCase(accessToken, testCaseRequestUpdate, testCaseId);

    }

    public static void deleteTestCaseInTheList(String accessToken, TestCaseRequest testCaseRequest) {
        List<TestCaseResponse> testCaseResponseList = getAllTestCases(accessToken);
        Integer testCaseId;
        if(testCaseResponseList.isEmpty()) {
            testCaseId = createTestCase(accessToken, testCaseRequest).get(0).getId();
        } else {
            testCaseId = testCaseResponseList.get(0).getId();
        }
        deleteTestCase(accessToken, testCaseId);
    }

    //TODO kreiraj metodu koja briše sve test caseve ako lista nije prazna
    //TODO kreiraj metodu koja kreira Test case ukoliko lista nije prazna
}
