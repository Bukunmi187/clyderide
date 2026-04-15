package clyderide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleSuiteTests {

    @Test
    void testVehicleClassOutOfRange() {
        Vehicle v = new Vehicle("Tesla", "Model S", 0, 2020);
        assertEquals(100, v.vehicleRating());
    }
}