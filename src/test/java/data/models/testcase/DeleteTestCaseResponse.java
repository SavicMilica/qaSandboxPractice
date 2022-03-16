package data.models.testcase;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteTestCaseResponse implements Serializable {
    @SerializedName("success")
    @Expose
    private String success;
    private final static long serialVersionUID = 3373658939480677548L;

    public DeleteTestCaseResponse() {
    }

    public DeleteTestCaseResponse(String success) {
        super();
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public static DeleteTestCaseResponse parseDeleteSuccess(String success) {
        DeleteTestCaseResponse apiDeleteSuccess = new DeleteTestCaseResponse();
        apiDeleteSuccess.setSuccess(success);
        return apiDeleteSuccess;
    }

}
