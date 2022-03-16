package data.models.testcase.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestStepErrors implements Serializable {
    @SerializedName("stepErrors")
    @Expose
    private List<TestStepError> stepErrors = null;
    private final static long serialVersionUID = -7252136390739272371L;


    public TestStepErrors() {
    }

    public TestStepErrors(List<TestStepError> stepErrors) {
        super();
        this.stepErrors = stepErrors;
    }

    public List<TestStepError> getStepErrors() {
        return stepErrors;
    }

    public void setStepErrors(List<TestStepError> stepErrors) {
        this.stepErrors = stepErrors;
    }

//    public static TestStepErrors parseStepError(Integer testStepId, String error) {
//        TestStepErrors testStepErrors = new TestStepErrors();
//
//        List<TestStepError> stepErrors = new ArrayList<>();
//        TestStepError testStepError = new TestStepError();
//        testStepError.setId(testStepId);
//        testStepError.setError(error);
//        stepErrors.add(testStepError);
//
//        testStepErrors.setStepErrors(stepErrors);
//
//        return testStepErrors;
//    }

}
