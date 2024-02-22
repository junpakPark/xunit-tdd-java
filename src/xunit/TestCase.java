package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    protected final String name;

    public TestCase(final String name) {
        this.name = name;
    }

    public TestResult run() {
        setUp();

        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        tearDown();

        return new TestResult();
    }

    // 아래 메서드들은 모든 테스트 케이스에서 동일한 이름을 사용하기 때문에 SuperClass에 위치시킨다.
    public void setUp() {
    }

    public void tearDown() {
    }
}
