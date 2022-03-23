package apimethods;

import common.GsonSetup;
import common.RestAssuredMethods;
import constants.ApiEndpoints;
import data.models.login.LoginResponse;
import data.models.login.LoginRequest;

public class LoginAPI {
    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonSetup.convertJsonToClass
                (RestAssuredMethods.postWithoutToken(loginRequest, ApiEndpoints.LOGIN),
                        LoginResponse.class);
    }
}
