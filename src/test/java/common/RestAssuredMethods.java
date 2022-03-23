package common;

import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredMethods {

    public static Response postWithoutToken(Object body, String apiEndpoint) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).body(json).when().post(apiEndpoint).then().extract().response();
    }

//    public static Response post(String token, Object body, String apiEndpoint) {
//        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
//        return given().contentType(ContentType.JSON).header(KeyParameters.AUTHORIZATION, "Bearer" + token)
//                .body(json).when().post(apiEndpoint).then().extract().response();
//    }

    public static Response post(String token, Object body, String apiEndpoint) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).auth().oauth2(token)
                .body(json).when().post(apiEndpoint).then().extract().response();
    }

    public static Response get(String token, String apiEndpoint) {
        return given().contentType(ContentType.JSON).auth().oauth2(token).when().get(apiEndpoint).then().extract().response();
    }

    public static Response put(String token, Object body, String apiEndpoint) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().contentType(ContentType.JSON).auth().oauth2(token)
                .body(json).when().put(apiEndpoint).then().extract().response();
    }

    public static Response delete(String token, String apiEndpoint) {
        return given().contentType(ContentType.JSON).auth().oauth2(token).when().delete(apiEndpoint).then().extract().response();
    }
}
