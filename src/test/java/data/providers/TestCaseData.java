package data.providers;

import constants.KeyParameters;
import data.models.testcase.CreateTestCaseRequest;
import data.models.testcase.EditTestCaseRequest;
import data.models.testcase.teststep.TestStepRequest;

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

}
