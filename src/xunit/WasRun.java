package xunit;

public class WasRun extends TestCase {

    public String log;

    public WasRun(final String name) {
        super(name);
    }

    @Override
    public void setUp() {
        log = "setUp";
    }

    public void testMethod() {
        log += " testMethod";
    }
}
