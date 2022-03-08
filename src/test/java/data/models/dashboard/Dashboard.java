package data.models.dashboard;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import data.models.dashboard.profile.ProfileResponse;

public class Dashboard implements Serializable {
    @SerializedName("profile")
    @Expose
    private ProfileResponse profile;
    @SerializedName("finished")
    @Expose
    private Finished finished;
    @SerializedName("scenario")
    @Expose
    private Scenario scenario;
    private final static long serialVersionUID = 3477199244825590608L;

    public Dashboard() {
    }

    public Dashboard(ProfileResponse profile, Finished finished, Scenario scenario) {
        super();
        this.profile = profile;
        this.finished = finished;
        this.scenario = scenario;
    }

    public ProfileResponse getProfile() {
        return profile;
    }

    public void setProfile(ProfileResponse profile) {
        this.profile = profile;
    }

    public Finished getFinished() {
        return finished;
    }

    public void setFinished(Finished finished) {
        this.finished = finished;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

}
