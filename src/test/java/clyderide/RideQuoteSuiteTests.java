package clyderide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RideQuoteSuiteTests {

    @Test
    void testUnusableVehicleFareZero() {
        Vehicle v = new Vehicle("Ford", "Fiesta", 0, 2010);
        RideQuote rq = new RideQuote(v, 10);
        assertEquals(0.0, rq.calculateFare(), 0.0001);
    }
}