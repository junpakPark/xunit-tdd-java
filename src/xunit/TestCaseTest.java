package xunit;

public class TestCaseTest extends TestCase {

    public TestCaseTest(final String name) {
        super(name);
    }

    public static TestSuite suite() {
        return new TestSuite(TestCaseTest.class);
    }

    public void testTemplateMethod() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    public void testResult() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    public void testFailedResultFormatting() {
        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult result = new TestResult();
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    public void testSuite() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testMethod"));
        testSuite.add(new WasRun("testBrokenMethod"));
        TestResult result = new TestResult();
        testSuite.run(result);
        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }

}
