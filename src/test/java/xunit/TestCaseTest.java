package test.java.xunit;

import main.java.xunit.annotation.Test;
import main.java.xunit.testcase.Assert;
import main.java.xunit.testcase.TestCase;
import main.java.xunit.testcase.TestResult;
import main.java.xunit.testcase.TestSuite;
import main.java.xunit.testcase.WasRun;

public class TestCaseTest extends TestCase {

    public TestCaseTest(final String name) {
        super(name);
    }

    public static TestSuite suite() {
        return new TestSuite(TestCaseTest.class);
    }

    @Test
    public void templateMethodTest() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    @Test
    public void resultTest() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    @Test
    public void failedResultFormattingTest() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void failedResultTest() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void suiteTest() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testBrokenMethod"));
        TestResult result = new TestResult();
        testSuite.run(result);
        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }

}
