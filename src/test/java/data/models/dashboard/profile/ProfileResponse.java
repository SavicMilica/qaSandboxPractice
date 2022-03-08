package data.models.dashboard.profile;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("img")
    @Expose
    private Object img;
    @SerializedName("city_id")
    @Expose
    private Object cityId;
    @SerializedName("github_username")
    @Expose
    private String githubUsername;
    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("career_status_id")
    @Expose
    private Integer careerStatusId;
    @SerializedName("career_status")
    @Expose
    private CareerStatus careerStatus;
    @SerializedName("city")
    @Expose
    private Object city;
    private final static long serialVersionUID = -1006965432806969265L;

    public ProfileResponse() {
    }

    public ProfileResponse(Integer id, String firstName, String lastName, String email, Object img, Object cityId, String githubUsername, String biography, Integer careerStatusId, CareerStatus careerStatus, Object city) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.img = img;
        this.cityId = cityId;
        this.githubUsername = githubUsername;
        this.biography = biography;
        this.careerStatusId = careerStatusId;
        this.careerStatus = careerStatus;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
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

    public CareerStatus getCareerStatus() {
        return careerStatus;
    }

    public void setCareerStatus(CareerStatus careerStatus) {
        this.careerStatus = careerStatus;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }
}