package clyderide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverSuiteTests {

    @Test
    void testYoungDriverMultiplier() {
        Driver d = new Driver("A", 20, 0);
        assertEquals(0.6, d.experienceScore(), 0.0001);
    }
}
