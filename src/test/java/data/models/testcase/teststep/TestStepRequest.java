package data.models.testcase.teststep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import common.RandomStringGenerator;
import constants.KeyParameters;

public class TestStepRequest implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("value")
    @Expose
    private String value;
    private final static long serialVersionUID = 648127063715482391L;

    public TestStepRequest() {
    }

    public TestStepRequest(Integer id, String value) {
        super();
        this.id = id;
        this.value = value;
    }

    public static List<TestStepRequest> createListOfTestSteps(Integer numberOfSteps) {
        List<TestStepRequest> testStepRequestList = new ArrayList<>();
        TestStepRequest testStepRequest = new TestStepRequest();
        for(int i = 0; i < numberOfSteps; i++) {
            testStepRequest.setId(i);
            testStepRequest.setValue(KeyParameters.TEST_STEP);
            testStepRequestList.add(testStepRequest);
        }
        return testStepRequestList;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}