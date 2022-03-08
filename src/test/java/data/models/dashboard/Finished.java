package data.models.dashboard;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Finished implements Serializable {
    @SerializedName("testcases")
    @Expose
    private Integer testcases;
    @SerializedName("projects")
    @Expose
    private Integer projects;
    @SerializedName("reports")
    @Expose
    private Boolean reports;
    private final static long serialVersionUID = -1238458636788016027L;

    public Finished() {
    }

    public Finished(Integer testcases, Integer projects, Boolean reports) {
        super();
        this.testcases = testcases;
        this.projects = projects;
        this.reports = reports;
    }

    public Integer getTestcases() {
        return testcases;
    }

    public void setTestcases(Integer testcases) {
        this.testcases = testcases;
    }

    public Integer getProjects() {
        return projects;
    }

    public void setProjects(Integer projects) {
        this.projects = projects;
    }

    public Boolean getReports() {
        return reports;
    }

    public void setReports(Boolean reports) {
        this.reports = reports;
    }

}
