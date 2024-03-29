package main.java.xunit.testcase;

public class TestResult {

    private int runCount = 0;
    private int errorCount = 0;

    public void testStarted() {
        runCount++;
    }

    public void testFailed() {
        errorCount++;
    }

    public String getSummary() {
        return runCount + " run, " + errorCount + " failed";
    }
}
