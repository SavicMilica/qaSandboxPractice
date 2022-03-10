package data.models.testcase;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiError implements Serializable {
    @SerializedName("error")
    @Expose
    private String error;
    private final static long serialVersionUID = 9046254078513033475L;
    public ApiError() {
    }

    public ApiError(String error) {
        super();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static ApiError parseError(String error) {
        ApiError apiError = new ApiError();
        apiError.setError(error);
        return apiError;
    }
}
