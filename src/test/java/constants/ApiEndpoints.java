package constants;

public class ApiEndpoints {

    public static final String TEST_CASE = "/api/candidate/testcases/";
    public static final String LOGIN = "/api/candidate/login";
    public static final String PROFILE = "/api/candidate/profile";
    public static final String DASHBOARD = "/api/candidate/dashboard";

    public static String testCaseEndpoint(Integer testCaseId) {
        return TEST_CASE + testCaseId;
    }



}
