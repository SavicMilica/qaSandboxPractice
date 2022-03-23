package common;

import apimethods.LoginAPI;
import data.models.login.LoginRequest;
import data.providers.LoginData;

public class LoginToken {

    public static String login() {
        LoginRequest loginRequest = LoginData.prepareLoginData();
        return LoginAPI.login(loginRequest).getToken();
    }
}
