package data.models.testcase;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiRequiredFieldError implements Serializable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("expected_result")
    @Expose
    private String expectedResult;
    @SerializedName("test_steps")
    @Expose
    private String testSteps;
    private final static long serialVersionUID = -7199131548809179334L;

    public ApiRequiredFieldError() {
    }

    public ApiRequiredFieldError(String title, String expectedResult, String testSteps) {
        super();
        this.title = title;
        this.expectedResult = expectedResult;
        this.testSteps = testSteps;
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

    public String getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(String testSteps) {
        this.testSteps = testSteps;
    }
    public static ApiRequiredFieldError parseError(String title, String expectedResult, String testSteps) {
        ApiRequiredFieldError apiRequiredFieldError = new ApiRequiredFieldError();
        apiRequiredFieldError.setTitle(title);
        apiRequiredFieldError.setExpectedResult(expectedResult);
        apiRequiredFieldError.setTestSteps(testSteps);
        return apiRequiredFieldError;
    }

    public static ApiRequiredFieldError parseTitleError(String titleError) {
        ApiRequiredFieldError apiRequiredFieldError = new ApiRequiredFieldError();
        apiRequiredFieldError.setTitle(titleError);
        return apiRequiredFieldError;
    }

}
