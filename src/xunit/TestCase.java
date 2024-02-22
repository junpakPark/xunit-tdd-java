package xunit;

import java.lang.reflect.Method;

public class TestCase implements Test {
    protected final String name;

    public TestCase(final String name) {
        this.name = name;
    }

    public void run(final TestResult result) {
        result.testStarted();
        setUp();

        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (Exception e) {
            result.testFailed();
        }

        tearDown();
    }

    // 아래 메서드들은 모든 테스트 케이스에서 동일한 이름을 사용하기 때문에 SuperClass에 위치시킨다.
    public void setUp() {
    }

    public void tearDown() {
    }
}
