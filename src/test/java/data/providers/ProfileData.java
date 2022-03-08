package data.providers;

import data.models.dashboard.profile.ProfileRequest;

public class ProfileData {
    public static ProfileRequest prepareProfile() {
        return new ProfileRequest("This is biography", null, null, null);
    }
}
