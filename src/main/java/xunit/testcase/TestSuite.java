package main.java.xunit.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSuite implements Test {

    List<Test> tests = new ArrayList<>();

    public TestSuite() {
    }

    public TestSuite(final Class<? extends TestCase> testClass) {
        Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.getAnnotation(main.java.xunit.annotation.Test.class) != null)
                .forEach(method -> {
                    try {
                        add(testClass.getConstructor(String.class).newInstance(method.getName()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void add(final Test test) {
        tests.add(test);
    }

    public void run(final TestResult result) {
        tests.forEach(test -> test.run(result));
    }
}
