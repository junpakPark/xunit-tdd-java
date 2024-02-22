package xunit;

public class WasRun extends TestCase {

    public boolean wasRun;
    public boolean wasSetUp;
    public String log;

    public WasRun(final String name) {
        super(name);
    }

    @Override
    public void setUp() {
        wasSetUp = true;
        log = "setUp";
    }

    public void testMethod() {
        wasRun = true;
        log += " testMethod";
    }
}
