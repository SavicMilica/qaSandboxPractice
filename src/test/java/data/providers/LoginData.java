package data.providers;

import constants.KeyParameters;
import data.models.login.LoginRequest;

public class LoginData {

    public static LoginRequest prepareLoginData() {
        return new LoginRequest(KeyParameters.EMAIL, KeyParameters.PASSWORD);
    }
}
