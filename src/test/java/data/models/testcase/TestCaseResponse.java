package data.models.testcase;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestCaseResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("candidate_id")
    @Expose
    private Integer candidateId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("expected_result")
    @Expose
    private String expectedResult;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("automated")
    @Expose
    private Boolean automated;
    @SerializedName("candidate_scenario_id")
    @Expose
    private Integer candidateScenarioId;
    @SerializedName("test_steps")
    @Expose
    private List<TestStepRequest> testSteps = null;
    private final static long serialVersionUID = 587829184973605849L;

    public TestCaseResponse() {
    }

    public TestCaseResponse(Integer id, Integer candidateId, String title, String expectedResult, String description, Boolean automated, Integer candidateScenarioId, List<TestStepRequest> testSteps) {
        super();
        this.id = id;
        this.candidateId = candidateId;
        this.title = title;
        this.expectedResult = expectedResult;
        this.description = description;
        this.automated = automated;
        this.candidateScenarioId = candidateScenarioId;
        this.testSteps = testSteps;
    }

    public static TestCaseResponse parseFullTestCaseResponse(TestCaseRequest testCaseRequest) {
        TestCaseResponse testCaseResponse = new TestCaseResponse();
        testCaseResponse.setTitle(testCaseRequest.getTitle());
        testCaseResponse.setDescription(testCaseRequest.getDescription());
        testCaseResponse.setExpectedResult(testCaseRequest.getExpectedResult());
        testCaseResponse.setTestSteps(testCaseRequest.getTestSteps());
        testCaseResponse.setAutomated(testCaseRequest.getAutomated());
        return testCaseResponse;
    }

    public static TestCaseResponse parseFullTestCaseResponseForUpdate(TestCaseRequestEdit testCaseRequest) {
        TestCaseResponse testCaseResponse = new TestCaseResponse();
        testCaseResponse.setId(testCaseRequest.getTestcaseId());
        testCaseResponse.setTitle(testCaseRequest.getTitle());
        testCaseResponse.setDescription(testCaseRequest.getDescription());
        testCaseResponse.setExpectedResult(testCaseRequest.getExpectedResult());
        testCaseResponse.setTestSteps(testCaseRequest.getTestSteps());
        testCaseResponse.setAutomated(testCaseRequest.getAutomated());
        return testCaseResponse;
    }

    public static TestCaseResponse parseCreatedTestCaseResponse(List<TestCaseResponse> createdCase, Integer id) {
        TestCaseResponse testCaseResponse = new TestCaseResponse();
        testCaseResponse.setId(id);
        testCaseResponse.setTitle(createdCase.get(0).getTitle());
        testCaseResponse.setDescription(createdCase.get(0).getDescription());
        testCaseResponse.setExpectedResult(createdCase.get(0).getExpectedResult());
        testCaseResponse.setTestSteps(createdCase.get(0).getTestSteps());
        testCaseResponse.setAutomated(createdCase.get(0).getAutomated());
        return testCaseResponse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAutomated() {
        return automated;
    }

    public void setAutomated(Boolean automated) {
        this.automated = automated;
    }

    public Integer getCandidateScenarioId() {
        return candidateScenarioId;
    }

    public void setCandidateScenarioId(Integer candidateScenarioId) {
        this.candidateScenarioId = candidateScenarioId;
    }

    public List<TestStepRequest> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(List<TestStepRequest> testSteps) {
        this.testSteps = testSteps;
    }
}