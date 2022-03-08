//package apimethods;
//
//import common.GsonSetup;
//import common.RestAssuredMethods;
//import common.TestBase;
//import constants.ApiEndpoints;
//import data.models.profile.Profile;
//import data.models.dashboard.profile.ProfileRequest;
//
//public class ProfileAPI {
//    public static Profile createProfile(ProfileRequest profileRequest) {
//        return GsonSetup.convertJsonToClass
//                (RestAssuredMethods.post(TestBase.token, profileRequest, ApiEndpoints.PROFILE), Profile.class);
//    }
//}
