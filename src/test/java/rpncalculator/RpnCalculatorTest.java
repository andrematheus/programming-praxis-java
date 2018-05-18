package rpncalculator;

import org.junit.Assert;
import org.junit.Test;

public class RpnCalculatorTest {
    @Test
    public void checkSiteExample() {
        RpnCalculator doubleCalculator = new RpnCalculator();
        doubleCalculator.evaluate("19 2.14 + 4.5 2 4.3 / - *");
        Assert.assertEquals(doubleCalculator.top(), 85.2974, 0.0001);
    }
}