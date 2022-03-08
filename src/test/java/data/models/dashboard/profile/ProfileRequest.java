package data.models.dashboard.profile;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ProfileRequest implements Serializable {
    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("career_status_id")
    @Expose
    private Integer careerStatusId;
    @SerializedName("city_id")
    @Expose
    private Object cityId;
    @SerializedName("github_username")
    @Expose
    private String githubUsername;
    private final static long serialVersionUID = 2776104959047252065L;

    public ProfileRequest() {
    }

    public ProfileRequest(String biography, Integer careerStatusId, Object cityId, String githubUsername) {
        super();
        this.biography = biography;
        this.careerStatusId = careerStatusId;
        this.cityId = cityId;
        this.githubUsername = githubUsername;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getCareerStatusId() {
        return careerStatusId;
    }

    public void setCareerStatusId(Integer careerStatusId) {
        this.careerStatusId = careerStatusId;
    }

    public Object getCityId() {
        return cityId;
    }

    public void setCityId(Object cityId) {
        this.cityId = cityId;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }
}