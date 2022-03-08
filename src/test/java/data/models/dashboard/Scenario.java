package data.models.dashboard;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scenario implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("scenario")
    @Expose
    private String scenario;
    @SerializedName("scenario_plain")
    @Expose
    private String scenarioPlain;
    @SerializedName("exam_type")
    @Expose
    private Integer examType;
    @SerializedName("testcase_count")
    @Expose
    private Integer testcaseCount;
    @SerializedName("automated_count")
    @Expose
    private Integer automatedCount;
    @SerializedName("report_count")
    @Expose
    private Integer reportCount;
    @SerializedName("office_id")
    @Expose
    private Integer officeId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    private final static long serialVersionUID = 8070298978388200442L;

    public Scenario() {
    }

    public Scenario(Integer id, String title, String scenario, String scenarioPlain, Integer examType, Integer testcaseCount, Integer automatedCount, Integer reportCount, Integer officeId, Integer userId) {
        super();
        this.id = id;
        this.title = title;
        this.scenario = scenario;
        this.scenarioPlain = scenarioPlain;
        this.examType = examType;
        this.testcaseCount = testcaseCount;
        this.automatedCount = automatedCount;
        this.reportCount = reportCount;
        this.officeId = officeId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getScenarioPlain() {
        return scenarioPlain;
    }

    public void setScenarioPlain(String scenarioPlain) {
        this.scenarioPlain = scenarioPlain;
    }

    public Integer getExamType() {
        return examType;
    }

    public void setExamType(Integer examType) {
        this.examType = examType;
    }

    public Integer getTestcaseCount() {
        return testcaseCount;
    }

    public void setTestcaseCount(Integer testcaseCount) {
        this.testcaseCount = testcaseCount;
    }

    public Integer getAutomatedCount() {
        return automatedCount;
    }

    public void setAutomatedCount(Integer automatedCount) {
        this.automatedCount = automatedCount;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
