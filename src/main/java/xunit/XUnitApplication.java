package main.java.xunit;

import main.java.xunit.testcase.TestResult;
import main.java.xunit.testcase.TestSuite;
import test.java.xunit.TestCaseTest;

public class XUnitApplication {

    public static void main(String[] args) {
        TestSuite suite = TestCaseTest.suite();
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println(result.getSummary());

        TestSuite suite2 = new TestSuite();
        suite2.add(new TestCaseTest("templateMethodTest"));
        suite2.add(suite);
        TestResult result2 = new TestResult();
        suite2.run(result2);
        System.out.println(result2.getSummary());
    }

}
