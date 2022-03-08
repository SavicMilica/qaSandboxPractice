package apimethods;

import common.GsonSetup;
import common.RestAssuredMethods;
import constants.ApiEndpoints;
import data.models.testcase.TestCaseRequest;
import data.models.testcase.TestStepRequest;
import data.models.testcase.TestStepResponse;


import java.util.List;

import static common.TestBase.token;

public class TestStepAPI {
    public static TestStepResponse createTestStep(TestCaseRequest testStepRequest) {
        return GsonSetup.convertJsonToClass
                (RestAssuredMethods.post(token, testStepRequest, ApiEndpoints.TEST_CASE), TestStepResponse.class);
    }

    public static List<TestStepResponse> getAllTestSteps() {
        return GsonSetup.parseSuccessResponseAsListToModel
                (RestAssuredMethods.get(token, ApiEndpoints.TEST_CASE), TestStepResponse[].class);
    }
}
