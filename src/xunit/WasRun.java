package xunit;

public class WasRun extends TestCase {

    public boolean wasRun;

    public WasRun(final String name) {
        super(name);
    }

    public void testMethod() {
        wasRun = true;
    }

}
