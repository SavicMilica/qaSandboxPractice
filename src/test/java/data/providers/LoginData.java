package data.providers;

import data.models.login.LoginRequest;

public class LoginData {

    public static LoginRequest prepareLoginData() {
        return new LoginRequest("milosnajdanovic@yahoo.com", "test123");
    }
}
