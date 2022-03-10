package data.models.testcase.teststep;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestStepResponse implements Serializable {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("testcase_id")
        @Expose
        private Integer testcaseId;
        @SerializedName("value")
        @Expose
        private String value;
        private final static long serialVersionUID = -8535212670403933767L;

        public TestStepResponse() {
        }

        public TestStepResponse(Integer id, Integer testcaseId, String value) {
            super();
            this.id = id;
            this.testcaseId = testcaseId;
            this.value = value;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getTestcaseId() {
            return testcaseId;
        }

        public void setTestcaseId(Integer testcaseId) {
            this.testcaseId = testcaseId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
}
