package billingperiod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BillingPeriodTest {
    private final LocalDate date;
    private final BillingPeriod.Id expectedId;

    public BillingPeriodTest(LocalDate date, BillingPeriod.Id expectedId) {
        this.date = date;
        this.expectedId = expectedId;
    }

    @Parameterized.Parameters(name = "Billing period of {0} is {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {LocalDate.of(2018, 1, 1), BillingPeriod.idOf(2018, 1)},
                {LocalDate.of(2018, 1, 6), BillingPeriod.idOf(2018, 2)},
                {LocalDate.of(2018, 2, 1), BillingPeriod.idOf(2018, 6)},
                {LocalDate.of(2018, 2, 3), BillingPeriod.idOf(2018, 7)}
        });
    }

    @Test
    public void shouldCalculateBillingPeriodCorrectly() {
        BillingPeriod billingPeriod = BillingPeriod.ofDate(date);
        assertEquals(expectedId, billingPeriod.getId());
    }
}