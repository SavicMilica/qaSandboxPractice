package data.models.testcase;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import data.models.testcase.teststep.TestStepRequest;

public class CreateTestCaseRequest implements Serializable {
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
    private final static long serialVersionUID = -7555516253994603840L;

    public CreateTestCaseRequest() {
    }

    public CreateTestCaseRequest(String title, String description, String expectedResult, List<TestStepRequest> testSteps,
                                 Boolean automated) {
        super();
        this.title = title;
        this.description = description;
        this.expectedResult = expectedResult;
        this.testSteps = testSteps;
        this.automated = automated;
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

}