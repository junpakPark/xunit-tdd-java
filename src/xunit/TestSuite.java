package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

    List<WasRun> tests = new ArrayList<>();

    public void add(final WasRun test) {
        tests.add(test);
    }

    public void run(final TestResult result) {
        tests.forEach(test -> test.run(result));
    }
}
