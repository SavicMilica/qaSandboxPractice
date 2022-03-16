package data.providers;

import common.RandomStringGenerator;
import constants.KeyParameters;
import data.models.testcase.errors.ApiRequiredFieldError;
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

    public static CreateTestCaseRequest prepareTestCaseDataWithVariousNumberOfTestSteps(Integer testStepNumber) {
        CreateTestCaseRequest testCaseRequest = new CreateTestCaseRequest();
        testCaseRequest.setTitle(KeyParameters.TITLE);
        testCaseRequest.setDescription(KeyParameters.DESCRIPTION);
        testCaseRequest.setExpectedResult(KeyParameters.EXPECTED_RESULT);

        testCaseRequest.setTestSteps(TestStepRequest.createListOfTestSteps(testStepNumber));

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

    public static CreateTestCaseRequest prepareTestStepData() {
        CreateTestCaseRequest testCaseRequest = new CreateTestCaseRequest();
        testCaseRequest.setTitle(KeyParameters.TITLE);
        testCaseRequest.setDescription(KeyParameters.DESCRIPTION);
        testCaseRequest.setExpectedResult(KeyParameters.EXPECTED_RESULT);

        List<TestStepRequest> testStepListWith301Characters = new ArrayList<>();
        TestStepRequest testStep301Characters = new TestStepRequest();
        testStep301Characters.setValue(RandomStringGenerator.createRandomStringAlphabeticWithLen(301));
        testStep301Characters.setId(KeyParameters.TEST_STEP_ID);
        testStepListWith301Characters.add(testStep301Characters);
        testCaseRequest.setTestSteps(testStepListWith301Characters);

        testCaseRequest.setAutomated(false);

        return testCaseRequest;
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
                        new ApiRequiredFieldError("Title is required",null,  null, null)},

                {new CreateTestCaseRequest(KeyParameters.TITLE, KeyParameters.DESCRIPTION, null, testStepList, false),
                new ApiRequiredFieldError(null, null, "Expected result is required", null)},

                {new CreateTestCaseRequest(KeyParameters.TITLE, KeyParameters.DESCRIPTION, KeyParameters.EXPECTED_RESULT, new ArrayList<>(), false),
                new ApiRequiredFieldError(null, null, null, "There must be at least one test step")},

                {new CreateTestCaseRequest(null, null, null, new ArrayList<>(), false),
                        new ApiRequiredFieldError("Title is required", null, "Expected result is required", "There must be at least one test step")},

                {new CreateTestCaseRequest(RandomStringGenerator.createRandomStringAlphabeticWithLen(256), KeyParameters.DESCRIPTION, KeyParameters.EXPECTED_RESULT, testStepList, false),
                        new ApiRequiredFieldError("Title can not have more than 255 character (256)", null, null, null)},

                {new CreateTestCaseRequest(KeyParameters.TITLE, RandomStringGenerator.createRandomStringAlphabeticWithLen(1001), KeyParameters.EXPECTED_RESULT, testStepList, false),
                        new ApiRequiredFieldError(null, "Description can not have more than 1000 character (1001)", null, null)},

                {new CreateTestCaseRequest(KeyParameters.TITLE, KeyParameters.DESCRIPTION, RandomStringGenerator.createRandomStringAlphabeticWithLen(256), testStepList, false),
                        new ApiRequiredFieldError(null, null, "Expected result can not have more than 255 characters (256)", null)}
        };
    }

}
