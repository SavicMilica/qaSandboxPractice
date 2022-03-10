package common;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    public static String token;

    @BeforeSuite(alwaysRun = true)
    public static void setupBaseUrl() {
        RestAssured.baseURI = "https://qa-sandbox.ni.htec.rs";
        token = LoginToken.login();
    }
}
