package clyderide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    @Test
    void testYoungDriverMultiplier() {
        Driver d = new Driver("A", 20, 0);
        assertEquals(0.6, d.experienceScore(), 0.0001);
    }

    @Test
    void testYoungDriverBoundary24() {
        Driver d = new Driver("B", 24, 1);
        assertEquals(0.4, d.experienceScore(), 0.0001);
    }

    @Test
    void testAge25Boundary() {
        Driver d = new Driver("C", 25, 0);
        assertEquals(1.0, d.experienceScore(), 0.0001);
    }

    @Test
    void testElderlyMultiplier() {
        Driver d = new Driver("D", 80, 0);
        assertEquals(0.8, d.experienceScore(), 0.0001);
    }

    @Test
    void testComplaintReduction() {
        Driver d = new Driver("E", 30, 3);
        assertEquals(0.4, d.experienceScore(), 0.0001);
    }

    @Test
    void testMinimumScoreZero() {
        Driver d = new Driver("F", 18, 20);
        assertEquals(0.0, d.experienceScore(), 0.0001);
    }
}