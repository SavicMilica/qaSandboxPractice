package data.models.testcase.errors;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestStepError implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("error")
    @Expose
    private String error;
    private final static long serialVersionUID = -368599059767677639L;
    public TestStepError() {
    }

    public TestStepError(Integer id, String error) {
        super();
        this.id = id;
        this.error = error;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static TestStepError parseStepError(Integer testStepId, String error) {
        TestStepError testStepError = new TestStepError();
        testStepError.setId(testStepId);
        testStepError.setError(error);
        return testStepError;
    }

}
