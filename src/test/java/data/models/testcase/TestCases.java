package data.models.testcase;

import java.util.List;

public class TestCases {
    private List<TestCaseResponse> testCases;

    public TestCases() {

    }

    public TestCases(List<TestCaseResponse> testCases) {
        this.testCases = testCases;
    }

    public List<TestCaseResponse> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCaseResponse> testCases) {
        this.testCases = testCases;
    }
}
