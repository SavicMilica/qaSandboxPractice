package data.providers;

import constants.KeyParameters;
import data.models.testcase.ApiRequiredFieldError;
import data.models.testcase.CreateTestCaseRequest;
import data.models.testcase.EditTestCaseRequest;
import data.models.testcase.teststep.TestStepRequest;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;


public class TestCaseData {

    public static CreateTestCaseRequest prepareTestCaseData() {
        CreateTestCaseRequest testCaseRequest = new CreateTestCaseRequest();
        testCaseRequest.setTitle(KeyParameters.TITLE);
        testCaseRequest.setDescription(KeyParameters.DESCRIPTION);
        testCaseRequest.setExpectedResult(KeyParameters.EXPECTED_RESULT);

        List<TestStepRequest> testStepList = new ArrayList<>();
        TestStepRequest testStep = new TestStepRequest();
        testStep.setValue(KeyParameters.TEST_STEP);
        testStep.setId(KeyParameters.TEST_STEP_ID);
        testStepList.add(testStep);
        testCaseRequest.setTestSteps(testStepList);

        testCaseRequest.setAutomated(false);

        return testCaseRequest;
    }

    public static CreateTestCaseRequest prepareTestCaseDataWithoutDescription() {
        CreateTestCaseRequest testCaseRequest = new CreateTestCaseRequest();
        testCaseRequest.setTitle(KeyParameters.TITLE);
        testCaseRequest.setDescription("");
        testCaseRequest.setExpectedResult(KeyParameters.EXPECTED_RESULT);

        List<TestStepRequest> testStepRequestList = new ArrayList<>();
        TestStepRequest testStepRequest = new TestStepRequest();
        testStepRequest.setId(KeyParameters.TEST_STEP_ID);
        testStepRequest.setValue(KeyParameters.TEST_STEP);
        testStepRequestList.add(testStepRequest);
        testCaseRequest.setTestSteps(testStepRequestList);

        testCaseRequest.setAutomated(true);

        return testCaseRequest;
    }

    public static EditTestCaseRequest prepareTestCaseDataForUpdate(Integer testcaseId) {
        EditTestCaseRequest testCaseRequestEdit = new EditTestCaseRequest();
        testCaseRequestEdit.setTitle(KeyParameters.TITLE_UPDATE);
        testCaseRequestEdit.setDescription(KeyParameters.DESCRIPTION_UPDATE);
        testCaseRequestEdit.setExpectedResult(KeyParameters.EXPECTED_RESULT_UPDATE);

        List<TestStepRequest> testStepList = new ArrayList<>();
        TestStepRequest testStep = new TestStepRequest();
        testStep.setValue(KeyParameters.TEST_STEP_UPDATE);
        testStep.setId(KeyParameters.TEST_STEP_ID);
        testStepList.add(testStep);
        testCaseRequestEdit.setTestSteps(testStepList);

        testCaseRequestEdit.setAutomated(false);
        testCaseRequestEdit.setCandidateScenarioId(KeyParameters.CANDIDATE_SCENARIO_ID);
        testCaseRequestEdit.setTestcaseId(testcaseId);

        return testCaseRequestEdit;
    }



    @DataProvider(name = "prepareTestCase")
    public static Object[][] prepareTestCase() {
        List<TestStepRequest> testStepList = new ArrayList<>();
        TestStepRequest testStep = new TestStepRequest();
        testStep.setValue(KeyParameters.TEST_STEP);
        testStep.setId(KeyParameters.TEST_STEP_ID);
        testStepList.add(testStep);

        return new Object[][] {
                {new CreateTestCaseRequest(null, KeyParameters.DESCRIPTION, KeyParameters.EXPECTED_RESULT, testStepList, false),
                        new ApiRequiredFieldError("Title is required", null, null)
                },

                {new CreateTestCaseRequest(KeyParameters.TITLE, KeyParameters.DESCRIPTION, null, testStepList, false),
                new ApiRequiredFieldError(null, "Expected result is required", null)
                },

                {new CreateTestCaseRequest(KeyParameters.TITLE, KeyParameters.DESCRIPTION, KeyParameters.EXPECTED_RESULT, new ArrayList<>(), false),
                new ApiRequiredFieldError(null, null, "There must be at least one test step")},

                {new CreateTestCaseRequest(null, null, null, new ArrayList<>(), false),
                        new ApiRequiredFieldError("Title is required", "Expected result is required", "There must be at least one test step")}
        };
    }

}
