package data.models.testcase;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestCaseRequestEdit {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expected_result")
    @Expose
    private String expectedResult;
    @SerializedName("test_steps")
    @Expose
    private List<TestStepRequest> testSteps = null;
    @SerializedName("automated")
    @Expose
    private Boolean automated;
    @SerializedName("candidate_scenario_id")
    @Expose
    private Integer candidateScenarioId;
    @SerializedName("testcaseId")
    @Expose
    private Integer testcaseId;
    private final static long serialVersionUID = -907532978306528376L;

    public TestCaseRequestEdit() {
    }

    public TestCaseRequestEdit(String title, String description, String expectedResult, List<TestStepRequest> testSteps, Boolean automated, Integer candidateScenarioId, Integer testcaseId) {
        super();
        this.title = title;
        this.description = description;
        this.expectedResult = expectedResult;
        this.testSteps = testSteps;
        this.automated = automated;
        this.candidateScenarioId = candidateScenarioId;
        this.testcaseId = testcaseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public List<TestStepRequest> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(List<TestStepRequest> testSteps) {
        this.testSteps = testSteps;
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

    public Integer getTestcaseId() {
        return testcaseId;
    }

    public void setTestcaseId(Integer testcaseId) {
        this.testcaseId = testcaseId;
    }

}

