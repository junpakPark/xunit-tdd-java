package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test{

    List<Test> tests = new ArrayList<>();

    public void add(final Test test) {
        tests.add(test);
    }

    public void run(final TestResult result) {
        tests.forEach(test -> test.run(result));
    }
}
