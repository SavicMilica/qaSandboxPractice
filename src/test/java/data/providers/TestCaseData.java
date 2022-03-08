package data.providers;

import data.models.testcase.TestCaseRequest;
import data.models.testcase.TestCaseRequestEdit;
import data.models.testcase.TestStepRequest;

import java.util.ArrayList;
import java.util.List;


public class TestCaseData {

    public static TestCaseRequest prepareTestCaseData() {
        TestCaseRequest testCaseRequest = new TestCaseRequest();
        testCaseRequest.setTitle("This is title");
        testCaseRequest.setDescription("This is description");
        testCaseRequest.setExpectedResult("This is expected result");

        List<TestStepRequest> testStepList = new ArrayList<>();
        TestStepRequest testStep = new TestStepRequest();
        testStep.setValue("Test step value");
        testStep.setId(1);
        testStepList.add(testStep);
        testCaseRequest.setTestSteps(testStepList);

        testCaseRequest.setAutomated(false);

        return testCaseRequest;
    }

    public static TestCaseRequestEdit prepareTestCaseDataForUpdate(Integer testcaseId) {
        TestCaseRequestEdit testCaseRequestEdit = new TestCaseRequestEdit();
        testCaseRequestEdit.setTitle("This is updated title");
        testCaseRequestEdit.setDescription("This is updated description");
        testCaseRequestEdit.setExpectedResult("This is updated expected result");

        List<TestStepRequest> testStepList = new ArrayList<>();
        TestStepRequest testStep = new TestStepRequest();
        testStep.setValue("Test step value - updated");
        testStep.setId(1);
        testStepList.add(testStep);
        testCaseRequestEdit.setTestSteps(testStepList);

        testCaseRequestEdit.setAutomated(false);
        testCaseRequestEdit.setCandidateScenarioId(446);
        testCaseRequestEdit.setTestcaseId(testcaseId);

        return testCaseRequestEdit;
    }

}
