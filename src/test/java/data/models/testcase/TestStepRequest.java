package data.models.testcase;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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