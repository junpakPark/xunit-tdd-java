package xunit;

public class XUnitTest {

    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run(); // 테스트 간 격리를 위하여 별도의 객체로 실행

    }

}
